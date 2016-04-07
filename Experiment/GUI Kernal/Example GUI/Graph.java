/*
 * Author: 13844768
 * Created: 02 April 2003 01:05:45 AM
 * Modified: 02 April 2003 01:05:45 AM
 */

public class Graph implements InspectableGraph
{
	protected NodeList Edges,Vertices;
	
	public Graph(){
		Edges = new NodeList();
		Vertices = new NodeList();
	}
	
	public int numVertices(){
		return Vertices.size();
	}
	
	public int numEdges(){
		return Edges.size();
	}
	
	public vertexIterator vertices(){
		vertexIterator V = new vertexIterator();
		if (!Vertices.isEmpty()){
			Position P = Vertices.first();
			do {
				V.insert((Vertex)P.element());
				P = Vertices.after(P);
			} while (P != Vertices.last());
			V.insert((Vertex)P.element());
		}		
		return V;
	}
	
	public edgeIterator edges(){
		edgeIterator E = new edgeIterator();
		if (!Edges.isEmpty()){
			Position P = Edges.first();
			do {
				E.insert((Edge)P.element());
				P = Edges.after(P);
			} while (P != Edges.last());
			E.insert((Edge)P.element());
		}		
		return E;
	}
	
	public Vertex aVertex(){
		return (Vertex)((Vertices.first()).element());
	}
	
	public int degree(Vertex v){
		return v.undirectedEdges;
	}
	
	public vertexIterator adjacentVertices(Vertex v){
		edgeIterator E = v.edges();
		vertexIterator V = new vertexIterator();
		while (E.hasNext()){
			Edge t = E.getNext();
			if (t instanceof UndirectedEdge) {
				Vertex[] tv = ((UndirectedEdge)t).getEndPoints();
				if (tv[0] == v) {
					V.insert(tv[1]);
				} else {
					V.insert(tv[0]);
				}
			}
		}
		return V;
	}
	
	public edgeIterator incidentEdges(Vertex v){
		return v.edges();
	}
	
	public Vertex[] endVertices(Edge e){
		if (e instanceof UndirectedEdge) {
			return ((UndirectedEdge)e).getEndPoints();
		}
		throw new InvalidEdgeException("Wrong type of edge was given");
	}
	
	public Vertex opposite(Vertex v, Edge e){
		if (e instanceof UndirectedEdge) {
			Vertex[] tv = ((UndirectedEdge)e).getEndPoints();
			if (tv[0] == v) {
				return tv[1];
			} else {
				return tv[0];
			}
		}
		throw new InvalidEdgeException("Wrong type of edge was given");
	}
	
	public boolean areAdjacent(Vertex v, Vertex w){
		edgeIterator E = v.edges();
		while (E.hasNext()) {
			Edge e = E.getNext();
			if (e instanceof UndirectedEdge) {
				Vertex[] tv = ((UndirectedEdge)e).getEndPoints();
				if (((tv[0] == v)&&(tv[1] == w)) || ((tv[1] == v)&&(tv[0] == w))) {
					return true;
				}
			} else {
				throw new InvalidEdgeException("Wrong type of edge was given");
			}
		}
		return false;
	}
	
	public edgeIterator directedEdges(){ 
		return new edgeIterator(); 
	}
	
	public edgeIterator undirectedEdges(){ 
		return new edgeIterator(); 
	}
	
	public Vertex destinaton(Edge e) throws InvalidEdgeException{
		return null;
	}
	
	public Vertex origin(Edge e) throws InvalidEdgeException{
		return null;
	}
	
	public boolean isDirected(Edge e) {
		return (e instanceof DirectedEdge);
	}
	
	public int inDegree(Vertex v) {
		return v.inEdges;
	}
	
	public int outDegree(Vertex v){
		return v.outEdges;
	}
	
	public edgeIterator inIncidentEdges(Vertex v){ 
		return new edgeIterator(); 
	}
	
	public edgeIterator outIncidentEdges(Vertex v){
		return new edgeIterator(); 
	}
	
	public vertexIterator inAdjacentVertices(Vertex v){
		return new vertexIterator(); 		
	}
	
	public vertexIterator outAdjacentVertices(Vertex v){
		return new vertexIterator(); 
	}
	
	public Edge insertEdge(Vertex v, Vertex w, Object o){
		UndirectedEdge e = new UndirectedEdge(o);
		e.setEndPoints(v,w);
		Position P = Edges.insertLast(e);
		v.insert(e);
		w.insert(e);
		return e;		
	}
	
	public Edge insertDirectedEdge(Vertex v, Vertex w, Object o){
		DirectedEdge e = new DirectedEdge(o);
		return e;		
	}
	
	public Vertex insertVertex(Object o){
		Vertex v = new Vertex(o);
		Vertices.insertLast(v);
		return v;
	}
	
	protected Position findPosition(NodeList L,Object o) {
		if (!L.isEmpty()){
			Position p = L.first();
			while (!L.isLast(p)) {
				if ( p.element() == o ) return p;
				p = L.after(p);
			}
			if ( p.element() == o ) return p;			
		}
		return null;
	}
	
	public void removeVertex(Vertex v){
		edgeIterator I = v.edges();
		while (I.hasNext()){
			removeEdge(I.getNext());
		}
		Position P = findPosition(Vertices,v);
		Vertices.remove(P);
	}
	
	public void removeEdge(Edge e){
		if (e instanceof UndirectedEdge) {
			Vertex[] tv = ((UndirectedEdge)e).getEndPoints();
			tv[0].remove(e);
			tv[2].remove(e);
		}		
		Position P = findPosition(Edges,e);
		Edges.remove(P);
	}
	
	public void makeUndirected(Edge e){
	}
	
	public void reverseDirection(Edge e) throws InvalidEdgeException{
	}
	
	public void setDirectionFrom(Edge e, Vertex v) throws InvalidEdgeException{
	}
	
	public void setDirectionTo(Edge e, Vertex v) throws InvalidEdgeException{
	}
	
}
