/*
 * Author: 13844768
 * Created: 17 April 2003 03:42:58 PM
 * Modified: 17 April 2003 03:42:58 PM
 */
import java.awt.*;
import java.awt.image.*;

class GUIRender extends GUIObject {
	protected int StartX,StartY,Width,Height,lastX,lastY;
	protected Matrix DimentionConverter,MatrixRotateX,MatrixRotateY,MatrixRotateZ,conv;
	protected int CenterX,CenterY;
	protected Image Img;
	public Graphics BkG;
	protected double RotateX,RotateY,RotateZ;
	protected Object RenderMode;
	public static Object WireFrame = new Object();
	public static Object Solid     = new Object();
	public static Object Textured  = new Object();	
	public static PolyObject Axis;
	protected NodeList Objects = new NodeList();
	protected boolean Dragged;
	
	public GUIRender(int X, int Y,int W, int H){
		Active = true;
		next = null;
		StartX = X;
		StartY = Y;
		Width = W;
		Height = H;
		CenterX = W/2;
		CenterY = H/2;
		RotateX = 0;
		RotateY = 0;
		RotateZ = 0;
		Dragged = false;
		MatrixRotateX = new Matrix(3,3);
		MatrixRotateY = new Matrix(3,3);
		MatrixRotateZ = new Matrix(3,3);
		setDimentionConverter();
		Img = TrafficHandler.Source.createImage(W,H);
		BkG = Img.getGraphics();
		BkG.setColor(Color.black);
		BkG.fillRect(0,0,Width,Height);
		BkG.setColor(Color.white);
		BkG.drawString("3D Render Object. Copyright: Johnathan Lodder",10,20);
		BkG.drawRect(0,0,Width-1,Height-1);
		RenderMode = WireFrame;
		Axis = new RenderAxis();
		insertObject(Axis);
		Render();
	}
	
	public void insertObject(PolyObject O){
		Objects.insertFirst(O);
	}
	
	public int getCenterX() { return CenterX; }
	
	public int getCenterY() { return CenterY; }
	
	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Active) {
			if (Msg instanceof UpdateMsg) {
				Update(((UpdateMsg)Msg).Context);
			} else if (Msg instanceof MouseDragMsg) {
				int X = ((MouseDragMsg)Msg).x;
				int Y = ((MouseDragMsg)Msg).y;
				if (GSM.inside(X,Y,StartX,StartY,StartX+Width,StartY+Height)){
					if (Dragged){
						rotateZ(((double)(X-lastX))*0.005);	
						rotateX(((double)(Y-lastY))*-0.005);
						rotateY(((double)(Y-lastY))*-0.005);
						
						lastX = X;
						lastY = Y;
						Render();
					}
				}
			} else if (Msg instanceof MousePressMsg) {
				int X = ((MousePressMsg)Msg).x;
				int Y = ((MousePressMsg)Msg).y;
				if (GSM.inside(X,Y,StartX,StartY,StartX+Width,StartY+Height)){
					Dragged = true;
					lastX = X;
					lastY = Y;
				}
			} else if (Msg instanceof MouseReleaseMsg) {
				Dragged = false;
			}
		}
	}
	
	public void Update(Graphics g){
		g.drawImage(Img, StartX, StartY, (ImageObserver)TrafficHandler.Source);		
	}
	
	public void Render(){
		BkG.setColor(Color.black);
		BkG.fillRect(0,0,Width,Height);
		setDimentionConverter();
		setRotate();
		Matrix Rotator = MatrixRotateZ.multiplyWith(MatrixRotateY.multiplyWith(MatrixRotateX));
		conv = DimentionConverter.multiplyWith(Rotator);
		
		if (!Objects.isEmpty()){
			SortedSequencePriorityQueue Obj = new SortedSequencePriorityQueue(new dimentionalComparator());
			PositionIterator PI = Objects.positions();
			while (PI.hasNext()) {
				Position p = PI.getNext();
				PolyObject P = (PolyObject)p.element();
				Obj.insertItem(Rotator.multiplyWith(P.getCenterPoint()),P);
			}
			
			while (!Obj.isEmpty()){
				PolyObject t = (PolyObject)Obj.removeMin();				
				if      (RenderMode == WireFrame) t.RenderWireFrame(this);
				else if (RenderMode == Solid)     t.RenderSolid(this);
				else if (RenderMode == Textured)  t.RenderTextured(this);
			}
		}			
	}
	
	public void rotateX(double d){
		RotateX += d;
	}
	
	public void rotateY(double d){
		RotateY += d;
	}
	
	public void rotateZ(double d){
		RotateZ += d;
	}
	
	protected void setDimentionConverter(){
		Matrix temp = new Matrix(3,2);
		temp.setElem(0,0,Math.sqrt(3)/2);
		temp.setElem(1,0,-1*Math.sqrt(3)/2);
		temp.setElem(2,0,0);		
		temp.setElem(0,1,0.5);
		temp.setElem(1,1,0.5);
		temp.setElem(2,1,1);
		DimentionConverter = temp;
	}
	
	protected void setRotate(){
		MatrixRotateX.setElem(0,0,1);
		MatrixRotateX.setElem(1,0,0);
		MatrixRotateX.setElem(2,0,0);
		MatrixRotateX.setElem(0,1,0);
		MatrixRotateX.setElem(1,1,Math.cos(RotateX));
		MatrixRotateX.setElem(2,1,Math.sin(-1*RotateX));
		MatrixRotateX.setElem(0,2,0);
		MatrixRotateX.setElem(1,2,Math.sin(RotateX));
		MatrixRotateX.setElem(2,2,Math.cos(RotateX));
		
		MatrixRotateY.setElem(0,0,Math.cos(RotateY));
		MatrixRotateY.setElem(1,0,0);
		MatrixRotateY.setElem(2,0,Math.sin(-1*RotateY));
		MatrixRotateY.setElem(0,1,0);
		MatrixRotateY.setElem(1,1,1);
		MatrixRotateY.setElem(2,1,0);
		MatrixRotateY.setElem(0,2,Math.sin(RotateY));
		MatrixRotateY.setElem(1,2,0);
		MatrixRotateY.setElem(2,2,Math.cos(RotateY));
		
		MatrixRotateZ.setElem(0,0,Math.cos(RotateZ));
		MatrixRotateZ.setElem(1,0,Math.sin(-1*RotateZ));
		MatrixRotateZ.setElem(2,0,0);
		MatrixRotateZ.setElem(0,1,Math.sin(RotateZ));
		MatrixRotateZ.setElem(1,1,Math.cos(RotateZ));
		MatrixRotateZ.setElem(2,1,0);
		MatrixRotateZ.setElem(0,2,0);
		MatrixRotateZ.setElem(1,2,0);
		MatrixRotateZ.setElem(2,2,1);
	}	
	
	public Point convertPoint(Matrix P){
		Matrix point = conv.multiplyWith(P);
		return new Point((int)point.getElem(0,0)+ CenterX, CenterY - (int)point.getElem(0,1));
	}
	
}
