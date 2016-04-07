/*
 * Author: 13844768
 * Created: 02 April 2003 02:03:18 AM
 * Modified: 02 April 2003 02:03:18 AM
 */


public class Item
{
	private Object key,elem;
	
	protected Item(Object k, Object e){
		key = k;
		elem = e;
	}
	
	public Object key() { return key; }
	
	public Object element() { return elem; }
	
	public void setKey(Object k) { key = k; };
	
	public void setElement(Object e) { elem = e; };	
}
