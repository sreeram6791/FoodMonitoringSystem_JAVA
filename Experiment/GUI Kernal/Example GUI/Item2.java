/*
 * Author: 13844768
 * Created: 03 April 2003 07:11:38 PM
 * Modified: 03 April 2003 07:11:38 PM
 */


public class Item2 extends Item implements Locator
{
	private Position pos;
	
	public Item2(Object k, Object e, Position p){
		super(k,e);
		pos = p;
	}
	
	public Position position(){
		return pos;
	}
	
	public void setPosition(Position p){
		pos = p;
	}
}
