import java.awt.*;

public class GUItext extends GUIObject {
  	protected int StartX,StartY;
	protected Color Col;
	protected String Str;
		
  	public GUItext(int X, int Y, String S, Color C){
    	Active = true;
    	next = null; 
		StartX = X;
		StartY = Y;
		Str = S;
		Col = C;
  	}
	
	public GUItext(int X, int Y, String S){
		Active = true;
		next = null; 
		StartX = X;
		StartY = Y;
		Str = S;
		Col = Color.white;
	}		
		
	public void set(String S){
		Str = S;		
	}

  	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Msg instanceof UpdateMsg) {
			Update(((UpdateMsg)Msg).Context);
		}
	}
	
	public void Update(Graphics g){
		g.setColor(Col);
		g.drawString(Str,StartX,StartY);
	}
}