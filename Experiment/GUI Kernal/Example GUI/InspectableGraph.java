/*
 * Author: 13844768
 * Created: 02 April 2003 01:05:45 AM
 * Modified: 02 April 2003 01:05:45 AM
 */


public interface InspectableGraph
{
	public int numVertices();
	public int numEdges();
	public vertexIterator vertices();
	public edgeIterator edges();
	
	public Vertex aVertex();
	
	public int degree(Vertex v);
	public vertexIterator adjacentVertices(Vertex v);
	public edgeIterator incidentEdges(Vertex v);
	public Vertex[] endVertices(Edge e);
	public Vertex opposite(Vertex v, Edge e);
	public boolean areAdjacent(Vertex v, Vertex w);
	
	public edgeIterator directedEdges();
	public edgeIterator undirectedEdges();
	public Vertex destinaton(Edge e) throws InvalidEdgeException;
	public Vertex origin(Edge e) throws InvalidEdgeException;
	public boolean isDirected(Edge e);
	
	public int inDegree(Vertex v);
	public int outDegree(Vertex v);
	public edgeIterator inIncidentEdges(Vertex v);
	public edgeIterator outIncidentEdges(Vertex v);
	public vertexIterator inAdjacentVertices(Vertex v);
	public vertexIterator outAdjacentVertices(Vertex v);
	
	public Edge insertEdge(Vertex v, Vertex w, Object o);
	public Edge insertDirectedEdge(Vertex v, Vertex w, Object o);
	public Vertex insertVertex(Object o);
	public void removeVertex(Vertex v);
	public void removeEdge(Edge e);
	public void makeUndirected(Edge e);
	public void reverseDirection(Edge e) throws InvalidEdgeException;
	public void setDirectionFrom(Edge e, Vertex v) throws InvalidEdgeException;
	public void setDirectionTo(Edge e, Vertex v) throws InvalidEdgeException;

}
