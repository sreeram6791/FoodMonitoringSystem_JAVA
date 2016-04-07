/*
 * Author: 13844768
 * Created: 08 April 2003 06:26:03 PM
 * Modified: 08 April 2003 06:26:03 PM
 */
import java.awt.*;

public class GUIImage extends GUIObject
{
	protected int StartX,StartY;
	protected String FileName;
	protected Image I;
	
	public GUIImage(int x, int y, String S){
		Active = true;
		next = null;
		StartX = x;
		StartY = y;
		FileName = S;
		I = TrafficHandler.Source.getImage(TrafficHandler.Source.getCodeBase(),S);
	}

	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Active){
			if (Msg instanceof UpdateMsg) {
				Update(((UpdateMsg)Msg).Context);
			}
		}
	}

	public void Update(Graphics g){
		if (I == null){
			g.drawString("File not found",StartX,StartY);
		} else {
			g.drawImage(I,StartX,StartY,TrafficHandler.Source);
		}
	}



}
