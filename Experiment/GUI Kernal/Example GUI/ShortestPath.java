/*
 * Author: 13844768
 * Created: 03 April 2003 03:40:24 PM
 * Modified: 03 April 2003 03:40:24 PM
 */


public class ShortestPath
{
	public static void DisplayLink(Vertex v, Edge e){
		System.out.println( "<-" + (String)v.element() );
	}
	
	public static NodeStack get(Graph G, Vertex v, Vertex w){
		System.out.println("The shortest path between :" + (String)v.element());
		System.out.println("                           " + (String)w.element());
		NodeStack N = new NodeStack();
		DetermineShortestPath Path = new DetermineShortestPath();
		Path.execute(G,v);
		Vertex temp = w;
		realComparator RC = new realComparator();
		DisplayLink(temp,null);
		while ((temp != null)&&(temp != v)) {
			N.push(temp);
			edgeIterator E = temp.edges();
			Edge e = null;
			Edge t;
			Vertex z;
			double d,dx;
			while (E.hasNext()){
				t = E.getNext();
				d = ((Double)t.element()).doubleValue();
				z = G.opposite(temp,t);
				dx = ((Double)temp.get(Dijkstra.Distance)).doubleValue() - ((Double)z.get(Dijkstra.Distance)).doubleValue();
				if (RC.isEqual(t.element(),new Double(dx))){
					if (e != null) System.out.println("Warning. There are more than one shortest path. Randomly choosing one");					
					e = t;
				}
			}
			if (e == null){
				temp = null;
				while (!N.isEmpty()){
					N.pop();
				}
				System.out.println("Warning! There is no possible path between the Vertices!");
			}else{
				temp = G.opposite(temp,e);			
				DisplayLink(temp,e);
			}
		}	
		
		if (!N.isEmpty())
			N.push(v);
		return N;
	}

}
