/*
 * Author: 13844768
 * Created: 02 April 2003 03:37:31 AM
 * Modified: 02 April 2003 03:37:31 AM
 */


public class vertexIterator
{
	protected NodeList L;
	
	public vertexIterator(){
		L = new NodeList();
	}
	
	public void insert(Vertex v){
		L.insertLast(v);
	}
	
	public boolean hasNext(){
		return !L.isEmpty();
	}
	
	public Vertex getNext(){
		return (Vertex)(L.remove(L.last()));
	}

}
