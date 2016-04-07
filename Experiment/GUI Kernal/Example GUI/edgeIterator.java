/*
 * Author: 13844768
 * Created: 02 April 2003 03:37:31 AM
 * Modified: 02 April 2003 03:37:31 AM
 */


public class edgeIterator
{
	protected NodeList L;
	
	public edgeIterator(){
		L = new NodeList();
	}
	
	public void insert(Edge e){
		L.insertLast(e);
	}
	
	public boolean hasNext(){
		return !L.isEmpty();
	}
	
	public Edge getNext(){
		return (Edge)(L.remove(L.last()));
	}

}
