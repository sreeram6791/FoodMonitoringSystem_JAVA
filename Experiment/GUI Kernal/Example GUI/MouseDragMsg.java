/*
 * Author: 13844768
 * Created: 09 April 2003 10:36:07 PM
 * Modified: 09 April 2003 10:36:07 PM
 */

public class MouseDragMsg extends Message {
	public int x;
	public int y;
	
	public MouseDragMsg(int X, int Y){
		x = X;
		y = Y;
	}
	
}