import java.awt.*;

public class GraphAnim extends GUIBlankObject implements DoObject{
	protected Util Contents = new Util();
	protected boolean started,finished,balanced;
	protected GUIButton proceed,cancel,HideShow;
	public static Graph G = new Graph();
	public static NodeStack Shortest;
	public static MessageBox Output;
	public static Object OnShortestPath = new Object();
	public static Object Static = new Object();
	public static Vertex SelectedVertex;
	public static boolean show;
	protected Vertex startV,middleV;
	protected GUIRender Space;
	protected static final double k = 0.5;
	protected static final double scale = 300;
	protected Limiter L = new Limiter(2);
	
	
	public GraphAnim(int x,int y,int w, int h){
		super(x,y,w,h);
		SelectedVertex = null;
		Active = false;
		started = false;
		finished = false;
		balanced = false;
		
		Output = new MessageFrame(x+10,y+h-160,w-320,150,"Output");
		Contents.insert(Output);
		Contents.insert(new GUIFrame(x+w-300,y+h-160,290,120,"Vertext details"));
		
		Space = new GUIRender(x+10,y+10,w-20,h-170);
		Space.Axis.setState(false);
		Contents.insert(Space);
		
		
		HideShow = new GUIButton(x+w-300,y+h-30,100,20,"Show Weights"); 
		HideShow.setAction(this);
		HideShow.Active = true;
		show = false;
		Contents.insert(HideShow);
		proceed = new GUIButton(x+w-130,y+h-30,60,20,"Next");
		proceed.setAction(new ProceedCommand(this));
		proceed.Active = false;
		Contents.insert(proceed);
		cancel = new GUIButton(x+w-60,y+h-30,60,20,"Cancel");
		cancel.setAction(new Deactivate(this));
		Contents.insert(cancel);	
		
	}
	
	protected void Reshape(){
		balanced = true;
		vertexIterator V = G.vertices();
		while (V.hasNext()){
			Vertex thisVertex = V.getNext();
			PolyVertex pv = (PolyVertex)thisVertex.get(PolyVertex.Source);
			int oldx,oldy,oldz;
			oldx = pv.x;
			oldy = pv.y;
			oldz = pv.z;
			if (thisVertex.has(Static)){
				pv.x = 0;
				pv.y = 0;
				pv.z = 0;					
			} else {
				double Fx = 0;
				double Fy = 0;
				double Fz = 0;
				boolean noCompute = false;
				edgeIterator E = thisVertex.edges();
				while (E.hasNext()){
					Edge t = E.getNext();				
					Vertex endV = GraphAnim.G.opposite(thisVertex,t);
					
					PolyVertex endPV = (PolyVertex)endV.get(PolyVertex.Source);
					double orig = scale*Math.sqrt(((Double)t.element()).doubleValue()); 
					double length = Math.sqrt((pv.x - endPV.x)*(pv.x - endPV.x)+(pv.y - endPV.y)*(pv.y - endPV.y)+(pv.z - endPV.z)*(pv.x - endPV.z));
					double F = k*(orig - length); 
					Fx += F*((pv.x - endPV.x)/length);
					Fy += F*((pv.y - endPV.y)/length);
					Fz += F*((pv.z - endPV.z)/length);
					if (!GSM.inside((int)length,0,30,0,180,0))
						noCompute = true;					
				}
				if (!noCompute){
					pv.x += (int)Fx*0.01;
					pv.y += (int)Fy*0.01;
					pv.z += (int)Fz*0.01;
				}
			}
			if ((oldx != pv.x)||(oldy != pv.y)||(oldz != pv.z))
				balanced = false;
		}
	}
	
	protected void updateDisplay(Graphics g){
		Space.Render();
	}
	
	protected void progressOneStep(Graphics g){
		if (!started){
			started = true;
			G = GfxConstruct.CreateGraph(LCSAnim.L);
			GfxConstruct.sV.set(Static,Static);
			vertexIterator V = G.vertices();
			while (V.hasNext()){
				Vertex temp = V.getNext();
				PolyVertex pv = new PolyVertex(temp);
				Space.insertObject(pv);
				Contents.insert(pv);
			}
		} else { 
			if (!finished){
				if (L.canIgo()){
					Reshape();
				}
				updateDisplay(g);
				if (balanced) {
					Vertex startV  = GfxConstruct.sV;
					Vertex middleV = GfxConstruct.mV;
					if (G.numVertices() < 2) {
						Output.addMessage("There are no vertices in the Graph, no path can be found");
						Shortest = new NodeStack();
					} else {	
						Shortest = GfxShortestPath.get(G,startV,middleV);
					}
					Space.Render();
					finished = true;
				} 
				proceed.Active = true;
			}			
		}
	}
	
	public void Update(Graphics g){
		if (Active) progressOneStep(g);
		Contents.reverseBroadcast(new UpdateMsg(g));
		if (SelectedVertex == null){
			g.drawString("Click on a vertex to view its details.",StartX+Width-290,StartY+Height-120);
		} else {
			g.drawString("Vertext " + (String)SelectedVertex.element()+" has been selected.",StartX+Width-290,StartY+Height-120);
			if (SelectedVertex.has(OnShortestPath)){
				g.drawString("This vertex is on the shortest path.",StartX+Width-290,StartY+Height-100);
			}			
		}
	}
	
	public void MousePress(int x, int y){
		Contents.Broadcast(new MousePressMsg(x,y));
	}
	
	public void MouseClick(int x, int y){
		Contents.Broadcast(new MouseClickMsg(x,y));
		Space.Render();
	}
	
	public void MouseRelease(int x, int y){
		Contents.Broadcast(new MouseReleaseMsg(x,y));
	}
	
	public void MouseDown(int x, int y){
		Contents.Broadcast(new MouseDragMsg(x,y));
	}
	
	public void run(){
		show = !show;
		if (show) HideShow.setName("Hide Weights");
		else HideShow.setName("Show Weights");
	}
	
}