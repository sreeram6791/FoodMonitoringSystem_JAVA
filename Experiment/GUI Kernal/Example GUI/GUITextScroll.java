import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class GUITextScroll extends GUIObject {
  	protected int StartX,StartY,Width,Height;
	public Util Contents = new Util(); 
	protected TextTransision TextTr;
		
  	public GUITextScroll(int X, int Y, int W, int H){
    	Active = true;
    	next = null; 
		StartX = X;
		StartY = Y;
		Width = W;
		Height = H;
		TextTr = new TextTransision(X,Y,W,H);
  	}
 
  	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Active == true){
			if (Msg instanceof UpdateMsg) {
				update(((UpdateMsg)Msg).Context);
			} 
		}
	}	
		
	public void update(Graphics g){
		TextTr.update(g);
	}
}