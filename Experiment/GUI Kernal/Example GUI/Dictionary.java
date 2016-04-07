/*
 * Author: Domino
 * Created: 03/15/2003 14:26:41
 * Modified: 03/15/2003 14:26:41
 */


public interface Dictionary
{
	public int size();	
	public boolean isEmpty();
//	public Iterator elements();
//	public Iterator keys();
	public Object findElement(Object k);
//	public Iterator findAllElements(Object k);
	public void insertItem(Object k, Object e);
	public Object removeElement(Object k);
//	public Iterator removeAllElements(Object k);
}
