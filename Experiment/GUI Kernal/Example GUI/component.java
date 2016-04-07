/*
 * Author: 13844768
 * Created: 14 April 2003 12:54:48 PM
 * Modified: 14 April 2003 12:54:48 PM
 */
import java.awt.*;

public class component extends GUIBlankObject
{
	protected Item I;
		
	public component(Item i,int w,int h){
		super(0,0,w,h-1);
		I = i;
	}
	
	public Item getItem(){
		return I;
	}
	
	public void Update(Graphics g){
		if (FilterOptions.Selected == this){
			g.setColor(Color.lightGray);
			g.fillRect(StartX,StartY,Width,Height);
		} 
		g.setColor(Color.black);
		g.drawString((String)I.element(),StartX+5,StartY+12);
	}
	
	public void MouseClick(int x, int y){
		if (GSM.inside(x,y,StartX,StartY,StartX+Width,StartY+Height)){
			FilterOptions.Selected = this;
		}
	}

}
