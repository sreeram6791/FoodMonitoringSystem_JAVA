/*
 * Author: 13844768
 * Created: 03 April 2003 06:34:36 PM
 * Modified: 03 April 2003 06:34:36 PM
 */


public interface PriorityQueue
{
	public int size();
	public boolean isEmpty();
	public void insertItem(Object k, Object e);
	public Object minElement();
	public Object minKey();
	public Object removeMin();
	public Locator min();
	public Locator insert(Object k, Object e);
	public void remove(Locator l);
	public Object replaceElement(Locator l, Object e);
	public Object replaceKey(Locator l, Object k);
	
		
}
