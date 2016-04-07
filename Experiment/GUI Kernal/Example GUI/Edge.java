/*
 * Author: 13844768
 * Created: 02 April 2003 03:14:11 AM
 * Modified: 02 April 2003 03:14:11 AM
 */


public class Edge extends DecorablePosition
{
	protected Object elem;
	
	public Edge(Object o){
		elem = o;
	}	
	
	public Object element(){
		return elem;
	}

}
