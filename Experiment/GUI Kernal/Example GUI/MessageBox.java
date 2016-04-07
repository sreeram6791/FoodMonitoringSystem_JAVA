import java.awt.*;

public class MessageBox extends GUIBlankObject{
	protected NodeList L;
	protected GUIPositionBar PB;
	
	public MessageBox(int x,int y,int w, int h){
		super(x,y,w,h);
		L = new NodeList();
		int PBw = GUIPositionBar.PBw;
		PB = new GUIPositionBar(x+w-PBw,y,h);  	
	}
	
	public void Update(Graphics g){
		g.setColor(Color.black);
		g.fillRect(StartX,StartY,Width,Height);
		Shape s = g.getClip();
		g.setClip(StartX,StartY,Width,Height);
		
		int TotalHeight = 16*L.size();
		int dy = getOffset(TotalHeight);
		
		g.setColor(Color.white);
		if (!L.isEmpty()){
			Position p = L.first();
			int y = 0;
			do {
				if (y == 0) p = L.first();
				else {
					p = L.after(p);
				}
				y++;
				g.drawString((String)(p.element()),StartX+5,StartY - dy + y*16-4);
			} while (!L.isLast(p));
		}
		if (TotalHeight > Height) PB.Update(g);
		g.setClip(s);
	}
	
	public int getOffset(int TotalHeight){
		int dy = 0;
		if (TotalHeight > Height) {
			PB.setScale(((double)Height)/TotalHeight);
			dy = (int)((TotalHeight-Height)*(((double)(PB.Scale.StartY-PB.StartY-PB.PBw-1))/((double)(PB.Height-2*PB.PBw-3-PB.Scale.Height))));
		}
		return dy;
	}
	
	public void addMessage(String S){
		L.insertLast(S);
		PB.Scale.StartY = PB.StartY+PB.Height-PB.PBw-2-PB.Scale.Height;
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
	
}