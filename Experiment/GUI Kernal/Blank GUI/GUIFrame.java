import java.awt.*;

public class GUIFrame extends GUIObject {
	protected static final int chipSize = 3;
	protected int StartX,StartY,Width,Height;
	protected String Str;
	protected static Image topLeft,topRight,bottomLeft,bottomRight,icon,fill,rightFill,top,bottom,left,right;
	
	public GUIFrame(int X, int Y, int W, int H, String S){
		Active = true;
		next = null;
		StartX = X;
		StartY = Y;
		Width = W;
		Height = H;
		Str = S;
		loadImages();
	}
	
	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Msg instanceof UpdateMsg) {
			if (Active == true) {
				Update(((UpdateMsg)Msg).Context);
			}
		}
	}
	
	public void loadImages(){
		topRight 	= TrafficHandler.Source.getImage(TrafficHandler.Source.getCodeBase(),"Images/Frame/topRight.jpg");
		topLeft 	= TrafficHandler.Source.getImage(TrafficHandler.Source.getCodeBase(),"Images/Frame/topLeft.jpg");
		bottomRight	= TrafficHandler.Source.getImage(TrafficHandler.Source.getCodeBase(),"Images/Frame/botomRight.jpg");
		bottomLeft 	= TrafficHandler.Source.getImage(TrafficHandler.Source.getCodeBase(),"Images/Frame/bottomLeft.jpg");
		icon 	 	= TrafficHandler.Source.getImage(TrafficHandler.Source.getCodeBase(),"Images/Frame/icon.jpg");
		rightFill 	= TrafficHandler.Source.getImage(TrafficHandler.Source.getCodeBase(),"Images/Frame/barRight.jpg");

	}
	
	public void Update(Graphics g){
		g.setColor(Color.black);
		g.fillRect(StartX,StartY,Width,Height);
		g.drawImage(topRight,StartX+Width-chipSize+1,StartY,TrafficHandler.Source);
		g.drawImage(topLeft,StartX,StartY,TrafficHandler.Source);
		g.drawImage(bottomRight,StartX+Width-chipSize+1,StartY+Height-chipSize+1,TrafficHandler.Source);
		g.drawImage(bottomLeft,StartX,StartY+Height-chipSize+1,TrafficHandler.Source);
		g.drawImage(icon,StartX+chipSize,StartY+chipSize,TrafficHandler.Source);
		g.drawImage(rightFill,StartX+Width-chipSize+1-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize,TrafficHandler.Source);
		
		int l = 0;
		g.setColor(new Color(22,22,22)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(33,33,33)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(36,36,36)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(40,40,40)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(44,44,44)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(48,48,48)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(50,50,50)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(52,52,52)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(52,52,52)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(50,50,50)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(48,48,48)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(44,44,44)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(40,40,40)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(36,36,36)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(33,33,33)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;
		g.setColor(new Color(22,22,22)); g.drawLine(StartX+chipSize+icon.getWidth(TrafficHandler.Source),StartY+chipSize+l,StartX+Width-chipSize-rightFill.getWidth(TrafficHandler.Source),StartY+chipSize+l); l++;

		l = 0;
		g.setColor(new Color(194,194,194)); g.drawLine(StartX+chipSize,StartY+Height-chipSize+1+l,StartX+Width-chipSize,StartY+Height-chipSize+1+l); l++;
		g.setColor(new Color(168,168,168)); g.drawLine(StartX+chipSize,StartY+Height-chipSize+1+l,StartX+Width-chipSize,StartY+Height-chipSize+1+l); l++;
		g.setColor(new Color(89,89,89));    g.drawLine(StartX+chipSize,StartY+Height-chipSize+1+l,StartX+Width-chipSize,StartY+Height-chipSize+1+l); l++;

		l = 0;
		g.setColor(new Color(194,194,194)); g.drawLine(StartX+chipSize,StartY+l,StartX+Width-chipSize,StartY+l); l++;
		g.setColor(new Color(168,168,168)); g.drawLine(StartX+chipSize,StartY+l,StartX+Width-chipSize,StartY+l); l++;
		g.setColor(new Color(89,89,89));    g.drawLine(StartX+chipSize,StartY+l,StartX+Width-chipSize,StartY+l); l++;
		
		l = 0;
		g.setColor(new Color(194,194,194)); g.drawLine(StartX+l,StartY+chipSize,StartX+l,StartY+Height-chipSize); l++;
		g.setColor(new Color(168,168,168)); g.drawLine(StartX+l,StartY+chipSize,StartX+l,StartY+Height-chipSize); l++;
		g.setColor(new Color(89,89,89));    g.drawLine(StartX+l,StartY+chipSize,StartX+l,StartY+Height-chipSize); l++;
		
		l = 0;
		g.setColor(new Color(194,194,194)); g.drawLine(StartX+Width-chipSize+1+l,StartY+chipSize,StartX+Width-chipSize+1+l,StartY+Height-chipSize); l++;
		g.setColor(new Color(168,168,168)); g.drawLine(StartX+Width-chipSize+1+l,StartY+chipSize,StartX+Width-chipSize+1+l,StartY+Height-chipSize); l++;
		g.setColor(new Color(89,89,89));    g.drawLine(StartX+Width-chipSize+1+l,StartY+chipSize,StartX+Width-chipSize+1+l,StartY+Height-chipSize); l++;
		
		g.setColor(Color.white);
		g.drawString(Str,StartX + 30,StartY + 15);	
	}
}