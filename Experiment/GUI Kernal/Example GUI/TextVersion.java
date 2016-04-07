/*
 * Author: 13844768
 * Created: 03 April 2003 01:56:57 PM
 * Modified: 03 April 2003 01:56:57 PM
 */


public class TextVersion
{
	public static void main(String[] args){
		if (args.length == 0) {
 			start("FARSTDBWCFG", "AGFDFRGRGST");
		} else if (args.length == 2) {
			start(args[0], args[1]);
		} else
			System.out.println("Wrong number of arguments.");
	}
	
	public static void discardDuplicates(NodeList N){
		if (!N.isEmpty()){
			Comparator C = new lexicographicComparator();
			Position p = N.first();
			Position temp;
			while (p != N.last()){
				temp = N.after(p);
				while (true){
					String ta = (String)p.element();
					String tb = (String)temp.element();					
					if (C.isEqual(ta,tb)) {
						Position t = N.before(temp);
						System.out.println("Duplicate (" + (String)temp.element() + ") was removed");
						N.remove(temp);
						temp = t;						
					}
					if (temp == N.last())
						break;
					temp = N.after(temp);					
				}
				if (p == N.last())
						break;
				p = N.after(p);
			}
		}
	}
	
	public static void start(String a, String b){
		NodeList L = Traverse.all(a,b);
		discardDuplicates(L);
		System.out.println();
		
		Graph G = Construct.CreateGraph(L);
		System.out.println();
		
		Vertex startV  = Construct.sV;
		Vertex middleV = Construct.mV;
		NodeStack N;
		if (G.numVertices() < 2) {
			System.out.println("There are no vertices in the Graph, no path can be found");
			N = new NodeStack();
		} else {	
			N = ShortestPath.get(G,startV,middleV);
		}	
		System.out.println();
		
		RBTree RBT = Construct.CreateRedBlackTree(N);
		System.out.println();
		
		PrintTextBinaryTree PBT = new PrintTextBinaryTree();
		PBT.execute(RBT.getTree());
		System.out.println();
	}

}
