/*
 * Author: 13844768
 * Created: 02 April 2003 02:36:47 AM
 * Modified: 02 April 2003 02:36:47 AM
 */


public class Vertex extends DecorablePosition
{
	private Object elem;
	public int inEdges,outEdges,undirectedEdges;
	private NodeList inEdgeList,outEdgeList,undirectedEdgeList;
		
	public Vertex(Object o){
		elem = o;
		inEdgeList = new NodeList();
		outEdgeList = new NodeList();
		undirectedEdgeList = new NodeList();
	}
	
	public edgeIterator edges(){
		edgeIterator E = new edgeIterator();
		if (!undirectedEdgeList.isEmpty()){
			PositionIterator PI = undirectedEdgeList.positions();
			while (PI.hasNext()){
				Position P = PI.getNext();
				E.insert((Edge)P.element());
			}
		}	
		return E;
	}
	
	public Object element(){
		return elem;
	}
	
	public void setElement(Object O){
		elem = O;
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
	
	public void insert(Edge e) throws InvalidEdgeException{
		if (e instanceof DirectedEdge) {
			DirectedEdge de = (DirectedEdge)e;
			if (this == de.getSource()) {
				outEdgeList.insertLast(e);
				outEdges++;
			} else {
				inEdgeList.insertLast(e);
				inEdges++;
			}
		} else if (e instanceof UndirectedEdge) {
			undirectedEdgeList.insertLast(e);
			undirectedEdges++;
		} else throw new InvalidEdgeException("The edge is neither directed or undirected. (Unknown edge type)");
	}
	
	public void remove(Edge e) throws InvalidEdgeException{
		if (e instanceof DirectedEdge) {
			DirectedEdge de = (DirectedEdge)e;
			if (this == de.getSource()) {
				Position P = findPosition(outEdgeList,e);
				if (P != null) {
					outEdgeList.remove(P);
					outEdges--;
				}
			} else {
				Position P = findPosition(inEdgeList,e);
				if (P != null){ 
					inEdgeList.remove(P);
					inEdges--;
				}
			}
		} else if (e instanceof UndirectedEdge) {
			Position P = findPosition(undirectedEdgeList,e);
			if (P != null) {
				undirectedEdgeList.remove(P);
				undirectedEdges--;
			}
			
		} else throw new InvalidEdgeException("The edge is neither directed or undirected. (Unknown edge type)");
	}
	
}
