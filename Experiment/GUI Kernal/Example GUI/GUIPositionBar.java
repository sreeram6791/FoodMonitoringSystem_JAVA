/*
 * Author: 13844768
 * Created: 13 April 2003 06:40:19 PM
 * Modified: 13 April 2003 06:40:19 PM
 */

import java.awt.*;

public class GUIPositionBar extends GUIBlankObject{
	public static final int PBw = 16;
	protected int FullHeight,oldY;
	public GUIButton Up,Down,Scale;
	protected boolean dragging;	
	
	public GUIPositionBar(int x,int y,int h){
		super(x,y,PBw,h);
		Up = new GUIButton(x,y,PBw,PBw,"");
		Down = new GUIButton(x,y+h-PBw,PBw,PBw,"");
		FullHeight = h-2*PBw-2;
		Scale = new GUIButton(x,y+PBw+1,PBw,FullHeight,"");
	}
	
	public void setScale(double s){
		if (s < 1) {
			if (s*FullHeight > 5){
				Scale.Height = (int)(s*FullHeight);
			} else
				Scale.Height = 5;
		}
	}
	
	public void Update(Graphics g){
		g.setColor(new Color(192,192,192));
		g.fillRect(StartX,StartY+PBw,PBw,FullHeight+1);
		Up.Update(g);
		Down.Update(g);
		Scale.Update(g);
		g.setColor(Color.black);
		
		int k = 3;
		int[] x = new int[3];
		x[0] = StartX + k-1;
		x[1] = StartX + Width/2;
		x[2] = StartX + Width-k;
		int[] y = new int[3];
		y[0] = StartY + Width - k-3;
		y[1] = StartY + k + 2;
		y[2] = StartY + Width - k-3;		
		g.fillPolygon(x,y,3);
		x[0] = StartX + k+1;
		x[1] = StartX + Width/2-1;
		x[2] = StartX + Width-k-1;
		y[0] = StartY + Height - Width + k+3;
		y[1] = StartY + Height - k-3;
		y[2] = StartY + Height - Width + k+3;		
		g.fillPolygon(x,y,3);
		
	}
	
	public void MousePress(int x, int y){
		if (GSM.inside(x,y,StartX,StartY,StartX+Width,StartY+Height)){
			dragging = true;
			oldY = y;
		}
		if (GSM.inside(x,y,StartX,StartY,StartX+Width,StartY+PBw)){
			if (GSM.inside(0,Scale.StartY-2,0,StartY+PBw+1,0,StartY+Height-PBw-2-Scale.Height)){
				Scale.StartY += -2;
			} else if ((Scale.StartY-2) < (StartY+PBw+1)){
				Scale.StartY = StartY+PBw+1;
			}
		} else if (GSM.inside(x,y,StartX,StartY+Height-PBw,StartX+Width,StartY+Height)){
			if (GSM.inside(0,Scale.StartY+2,0,StartY+PBw+1,0,StartY+Height-PBw-2-Scale.Height)){
				Scale.StartY += 2;
			} else if ((Scale.StartY+2) > (StartY+Height-PBw-2-Scale.Height)){
				Scale.StartY = StartY+Height-PBw-2-Scale.Height;
			}
		}
	}
	
	public void MouseRelease(int x, int y){
		dragging = false;
	}
	
	public void MouseDown(int x, int y){
		int dy = y-oldY;
		if (dragging) {
			if (GSM.inside(x,y,StartX,/*StartY+PBw+1*/Scale.StartY,StartX+Width,Scale.StartY+Scale.Height/*StartY+Height-PBw-2*/)){
				if (GSM.inside(0,Scale.StartY+dy,0,StartY+PBw+1,0,StartY+Height-PBw-2-Scale.Height)){
					Scale.StartY = Scale.StartY+dy;
				} else if ((Scale.StartY+dy) > (StartY+Height-PBw-2-Scale.Height)){
					Scale.StartY = StartY+Height-PBw-2-Scale.Height;					
				} else if ((Scale.StartY+dy) < (StartY+PBw+1)){
					Scale.StartY = StartY+PBw+1;
				}
			} 
			oldY = y;
		}
	}
	
}
