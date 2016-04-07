/*
 * Author: 13844768
 * Created: 02 April 2003 03:23:55 AM
 * Modified: 02 April 2003 03:23:55 AM
 */


public class DirectedEdge extends Edge
{
	protected Vertex source, destination;
	
	public DirectedEdge(Object O){
		super(O);
	}
	
	public void setSource(Vertex v){
		source = v;
	}
	
	public void setDestination(Vertex v){
		destination = v;
	}
	
	public Vertex getSource(){
		return source;
	}
	
	public Vertex getDestination(){
		return destination;
	}

}
