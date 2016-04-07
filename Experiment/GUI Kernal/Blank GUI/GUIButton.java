import java.awt.*;

public class GUIButton extends GUIObject {
  	public int StartX,StartY,Width,Height;
	protected String Str;
	protected DoObject D,MpD;
	protected Color Col,upperLight,upperShadow,bottomLight,bottomShadow,fill;
		
  	public GUIButton(int X, int Y, int W, int H, String S){
    	Active = true;
    	next = null; 
		StartX = X;
		StartY = Y;
		Width = W;
		Height = H;
		Str = S;
		D = null;
		MpD = null;
		Col = Color.black;
		upperLight = new Color(255,255,255);
		upperShadow = new Color(241,239,224);
		fill = new Color(224,221,227);
		bottomLight = new Color(157,157,161);
		bottomShadow = new Color(113,111,100);
  	}

  	public void handle(Message Msg) throws TerminateBroadcastException{
		int MouseX,MouseY;
		if (Active == true) {
			if (Msg instanceof UpdateMsg) {
				Update(((UpdateMsg)Msg).Context);
			} else if (Msg instanceof MouseClickMsg) {
				MouseX = ((MouseClickMsg)Msg).x;
				MouseY = ((MouseClickMsg)Msg).y;
				if (GSM.inside(MouseX,MouseY,StartX,StartY,StartX+Width,StartY+Height)) {
					if (D != null) D.run();
					throw new TerminateBroadcastException("This message was suppose to terminate internally...");
				} 
			} else if (Msg instanceof MouseDragMsg) {
				MouseX = ((MouseDragMsg)Msg).x;
				MouseY = ((MouseDragMsg)Msg).y;
				if (GSM.inside(MouseX,MouseY,StartX,StartY,StartX+Width,StartY+Height)) {
					if (MpD != null) MpD.run();
					throw new TerminateBroadcastException("This message was suppose to terminate internally...");
				} 
			}
		}
	}
	
	public void Update(Graphics g){
		g.setColor(upperLight);		
		g.drawRect(StartX,StartY,Width,Height);
		g.setColor(fill);		
		g.fillRect(StartX+2,StartY+2,Width-4,Height-4);
		g.setColor(upperShadow);		
		g.drawRect(StartX+1,StartY+1,Width-3,Height-3);
		g.setColor(bottomLight);
		g.drawLine(StartX+1,StartY+Height-1,StartX+Width-2,StartY+Height-1);
		g.drawLine(StartX+Width-1,StartY+1,StartX+Width-1,StartY+Height-1);				
		g.setColor(bottomShadow);
		g.drawLine(StartX,StartY+Height,StartX+Width,StartY+Height);
		g.drawLine(StartX+Width,StartY,StartX+Width,StartY+Height);
		
		g.setColor(Col);
		g.drawString(Str,StartX + 5,StartY + ((Height+10)/2));				
	}
	
	public void setAction(DoObject d){
		D = d;
	}
	
	public void setPressDownAction(DoObject d){
		MpD = d;
	}
	
	public void setColor(Color C){
		Col = C;
	}
	
	public void setName(String s){
		Str = s;
	}
}