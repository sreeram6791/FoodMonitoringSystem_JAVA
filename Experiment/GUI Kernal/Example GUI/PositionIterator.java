/*
 * Author: 13844768
 * Created: 02 April 2003 03:37:31 AM
 * Modified: 02 April 2003 03:37:31 AM
 */


public class PositionIterator
{
	protected NodeList L;
	
	public PositionIterator(){
		L = new NodeList();
	}
	
	public void insert(Position p){
		L.insertLast(p);
	}
	
	public boolean hasNext(){
		return !L.isEmpty();
	}
	
	public Position getNext(){
		return (Position)(L.remove(L.last()));
	}

}
