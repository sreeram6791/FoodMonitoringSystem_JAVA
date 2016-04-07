import java.awt.*;

public class GUITextBox extends GUIObject {
	protected int StartX,StartY,Width,Height;
	public String Str;
	public Color Col;
	protected boolean blinkOn;
	protected Limiter Q;
	protected Font F;
	protected DoObject finished,tab;
	
	public GUITextBox(int X, int Y, int W, int H){
		Active = true;
		next = null; 
		StartX = X;
		StartY = Y;
		Width = W;
		Height = H;
		Str = "";
		Col = Color.black;
		Q = new Limiter(4);
		blinkOn = true;
		finished = null;
		tab = null;
	}
	
	public void setTab(DoObject d){
		tab = d;
	}
	
	public void setFinished(DoObject d){
		finished = d;
	}
	
	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Msg instanceof UpdateMsg) {
			if (Active == true) {
				Update(((UpdateMsg)Msg).Context);
			}
		} else if (Msg instanceof MouseClickMsg) {
			int MouseX,MouseY;
			MouseX = ((MouseClickMsg)Msg).x;
			MouseY = ((MouseClickMsg)Msg).y;
			if (GSM.inside(MouseX,MouseY,StartX,StartY,StartX+Width,StartY+Height)) {
				TrafficHandler.ActiveTestFrame = this;
			} 
		} else if (Msg instanceof KeyPressMsg) {
			if (TrafficHandler.ActiveTestFrame == this)
				keyPress(((KeyPressMsg)Msg).stream);
		}
	}
	
	public void Update(Graphics g){
		g.setColor(new Color(128,128,128));		
		g.drawRect(StartX,StartY,Width,Height);
		g.setColor(new Color(64,64,64));		
		g.drawRect(StartX+1,StartY+1,Width-2,Height-2);
		g.setColor(new Color(192,192,192));
		g.drawLine(StartX+1,StartY+Height-1,StartX+Width-2,StartY+Height-1);
		g.drawLine(StartX+Width-1,StartY+1,StartX+Width-1,StartY+Height-1);				
		g.setColor(Color.white);
		g.fillRect(StartX+2,StartY+2,Width-2,Height-2);
		g.drawLine(StartX,StartY+Height,StartX+Width,StartY+Height);
		g.drawLine(StartX+Width,StartY,StartX+Width,StartY+Height);
		
		if (TrafficHandler.ActiveTestFrame == this) {
			if (Q.canIgo()){
				blinkOn = !blinkOn;
			}
			if (blinkOn) g.setColor(Color.black);
		}
		int l = g.getFontMetrics().stringWidth(Str);
		if (l > Width-4) {
			Shape s = g.getClip();
			g.setClip(StartX+2,StartY+2,Width-4,Height-4);
			
			g.drawLine(StartX+Width-2,StartY+3,StartX+Width-2,StartY+Height-3);
			g.setColor(Col);
			g.drawString(Str,StartX + Width-2-l,StartY + ((Height+10)/2));		
			
			g.setClip(s);
		} else {
			g.drawLine(StartX+5+l,StartY+3,StartX+5+l,StartY+Height-3);
			g.setColor(Col);
			g.drawString(Str,StartX + 5,StartY + ((Height+10)/2));		
		}
	}
	
	public void keyPress(char c){
		int ascii = (int)c;
		if (ascii == 8){
			if (Str.length() != 0) {
 				Str = Str.substring(0,Str.length()-1);
			}
		} else if (ascii == 9){
			tab.run();
		} else if (ascii == 13){	
			finished.run();
		} else if (GSM.inside(ascii,0,32,0,126,0)){
			Str += c;
		} else if (GSM.inside(ascii,0,161,0,255,0)){
			Str += c;
		}
	}
	
	public String value(){
		return Str;
	}
}