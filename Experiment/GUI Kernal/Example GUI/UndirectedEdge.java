/*
 * Author: 13844768
 * Created: 02 April 2003 03:23:55 AM
 * Modified: 02 April 2003 03:23:55 AM
 */


public class UndirectedEdge extends Edge
{
	protected Vertex[] endPoint;
	
	public UndirectedEdge(Object O){
		super(O);
		endPoint = new Vertex[2];
	}
	
	public void setEndPoints(Vertex v, Vertex w){
		endPoint[0] = v;
		endPoint[1] = w;
	}
	
	public Vertex[] getEndPoints(){
		return endPoint;
	}
}
