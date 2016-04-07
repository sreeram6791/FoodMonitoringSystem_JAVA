/*
 * Author: Domino
 * Created: 03/15/2003 14:19:22
 * Modified: 03/15/2003 14:19:22
 */


public class RBTItem extends Item
{
	private boolean isRed;
	
	public RBTItem(Object k, Object elem, boolean color){
		super(k,elem);
		isRed = color;
	}
	
	public boolean isRed(){
		return isRed;
	}
	
	public void makeRed(){
		isRed = true;
	}
	
	public void makeBlack(){
		isRed = false;
	}
	
	public void setColor(boolean color){
		isRed = color;
	}
	
}

