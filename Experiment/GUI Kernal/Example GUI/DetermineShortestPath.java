/*
 * Author: 13844768
 * Created: 04 April 2003 12:10:58 AM
 * Modified: 04 April 2003 12:10:58 AM
 */


public class DetermineShortestPath extends Dijkstra
{	
	public DetermineShortestPath(){
	}
	
	public double weight(Edge e){
		return ((Double)e.element()).doubleValue();
	}	

}
