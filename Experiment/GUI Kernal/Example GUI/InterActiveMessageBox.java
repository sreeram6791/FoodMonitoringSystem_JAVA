import java.awt.*;

public class InterActiveMessageBox extends MessageBox implements DoObject{
	protected InterActiveMessageBox Other;
	public InterActiveMessageBox(int x,int y,int w, int h){
		super(x,y,w,h); 	
	}
		
	public void setOther(InterActiveMessageBox other){
		Other = other;
	}
	
	public void Update(Graphics g){
		StandardShapes.bevelIn(g,StartX,StartY,Width,Height,Color.white);
		Shape s = g.getClip();
		g.setClip(StartX,StartY,Width,Height);
		
		PositionIterator PI;
		
		int TotalHeight = getTotalHeight();
		int dy = getOffset(TotalHeight);

		PI = L.positions();
		int y = 0;
		while (PI.hasNext()){
			Position p = PI.getNext();
			component cmp = (component)p.element();
			if (cmp.Active){
				cmp.StartX = StartX+5;
				cmp.StartY = StartY - dy + y*16;
				cmp.Update(g);
				y++;
			}			
		}
		
		if (TotalHeight > Height) PB.Update(g);
		g.setClip(s);
	}
	
	public int getTotalHeight(){
		int TotalHeight = 0;
		PositionIterator PI = L.positions();
		while (PI.hasNext()){
			Position p = PI.getNext();
			component cmp = (component)p.element();
			if (cmp.Active){
				TotalHeight += 16;
			}			
		}
		return TotalHeight;
	}
	
	public int getOffset(int TotalHeight){
		int dy = 0;
		if (TotalHeight > Height) {
			PB.setScale(((double)Height)/TotalHeight);
			dy = (int)((TotalHeight-Height)*(((double)(PB.Scale.StartY-PB.StartY-PB.PBw-1))/((double)(PB.Height-2*PB.PBw-3-PB.Scale.Height))));
		}
		return dy;
	}
	
	public void addMessage(Item i){
		L.insertLast(new component(i,Width-4,16));
		getOffset(getTotalHeight());
		PB.Scale.StartY = PB.StartY+PB.Height-PB.PBw-2-PB.Scale.Height;
	}
	
	public void MouseClick(int x, int y){
		PositionIterator PI = L.positions();
		while (PI.hasNext()){
			Position p = PI.getNext();
			component cmp = (component)p.element();
			if (cmp.Active) cmp.MouseClick(x,y);
		}		
	}
	
	public void MousePress(int x, int y){
		PB.handle(new MousePressMsg(x,y));
	}
	
	public void MouseRelease(int x, int y){
		PB.handle(new MouseReleaseMsg(x,y));
	}

	public void MouseDown(int x, int y){
		PB.handle(new MouseDragMsg(x,y));
	}
	
	public void run(){
		PositionIterator PI;
		PI = L.positions();
		while (PI.hasNext()){
			Position p = PI.getNext();
			component cmp = (component)p.element();
			if (cmp == FilterOptions.Selected){
				Other.addMessage(((component)L.remove(p)).getItem());
			}			
		}
	}

	public PositionIterator positions(){
		return L.positions();
	}
}