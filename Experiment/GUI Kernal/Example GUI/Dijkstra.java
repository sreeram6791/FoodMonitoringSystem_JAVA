/*
 * Author: 13844768
 * Created: 03 April 2003 05:21:38 PM
 * Modified: 03 April 2003 05:21:38 PM
 */


public abstract class Dijkstra
{
	public static final double INFINITE = Double.MAX_VALUE;
	protected InspectableGraph graph;
	public static final Object Distance = new Object();
	protected Object LOC = new Object();
	protected PriorityQueue Q;
	
	public void execute(InspectableGraph G, Vertex source){
		graph = G;
		dijkstraVisit(source);
	}
	
	protected void setDist(Vertex v, double value){
		v.set(Distance, new Double(value));
	}
	
	protected double getDist(Vertex v){
		return ((Double)(v.get(Distance))).doubleValue();
	}
	
	protected abstract double weight(Edge e);
	
	protected void dijkstraVisit(Vertex v){
		Q = new SortedSequencePriorityQueue(new realComparator());
		for (vertexIterator vertices = graph.vertices(); vertices.hasNext();) {
			Vertex u = vertices.getNext();
			double u_dist;
			if (u == v) 
				u_dist = 0;
			else
				u_dist = INFINITE;
			Locator u_loc = Q.insert(new Double(u_dist),u);
			setLoc(u,u_loc);
		}
		while (!Q.isEmpty()){
			Locator u_loc = Q.min();
			Vertex u = getVertex(u_loc);
			double u_dist = getDist(u_loc);
			Q.remove(u_loc);
			setDist(u,u_dist);
			destroyLoc(u);
			if (u_dist == INFINITE)
				continue;
			for (edgeIterator edges = graph.incidentEdges(u); edges.hasNext();){
				Edge e = edges.getNext();
				Vertex z = graph.opposite(u,e);
				if (hasLoc(z)){
					double e_weight = weight(e);
					Locator z_loc = getLoc(z);
					double z_dist = getDist(z_loc);
					if ( (u_dist+e_weight) < z_dist )
						Q.replaceKey(z_loc, new Double(u_dist+e_weight));
				}
			}
		}
		
	}
	
	protected boolean hasLoc(Vertex v){
		return v.has(LOC);
	}
	
	protected Locator getLoc(Vertex v){
		return (Locator)v.get(LOC);
	}

	protected void setLoc(Vertex v, Locator l){
		v.set(LOC,l);
	}
	
	protected void destroyLoc(Vertex v){
		v.destroy(LOC);
	}

	protected Vertex getVertex(Locator l){
		return (Vertex)l.element();
	}

	protected double getDist(Locator l){
		return ((Double)l.key()).doubleValue();
	}
}
