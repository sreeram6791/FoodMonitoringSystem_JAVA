import java.awt.*;

public class GUISquare extends GUIObject {
  	protected int StartX,StartY,Width,Height;
	protected Color Col;
		
  	public GUISquare(int X, int Y, int W, int H, Color C){
    	Active = true;
    	next = null; 
		StartX = X;
		StartY = Y;
		Width = W;
		Height = H;
		Col = C;
  	}

  	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Msg instanceof UpdateMsg) {
			Update(((UpdateMsg)Msg).Context);
		}
	}
	
	public void Update(Graphics g){
		g.setColor(Col);
		g.fillRect(StartX,StartY,Width,Height);
	}
}