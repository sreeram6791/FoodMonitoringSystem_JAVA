/*
 * Author: 13844768
 * Created: 11 April 2003 01:54:54 PM
 * Modified: 11 April 2003 01:54:54 PM
 */
import java.awt.*;

class StandardShapes
{
	public static void bevelIn(Graphics g,int StartX, int StartY, int Width, int Height,Color c){
		g.setColor(new Color(128,128,128));		
		g.drawRect(StartX,StartY,Width,Height);
		g.setColor(new Color(64,64,64));		
		g.drawRect(StartX+1,StartY+1,Width-2,Height-2);
		g.setColor(new Color(192,192,192));
		g.drawLine(StartX+1,StartY+Height-1,StartX+Width-2,StartY+Height-1);
		g.drawLine(StartX+Width-1,StartY+1,StartX+Width-1,StartY+Height-1);				
		g.setColor(Color.white);
		g.drawLine(StartX,StartY+Height,StartX+Width,StartY+Height);
		g.drawLine(StartX+Width,StartY,StartX+Width,StartY+Height);
		if (c != null){
			g.setColor(c);
			g.fillRect(StartX+2,StartY+2,Width-2,Height-2);
		}
	}

}
