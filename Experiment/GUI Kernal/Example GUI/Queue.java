/*
 * Author: 13844768
 * Created: 10 April 2003 09:32:06 PM
 * Modified: 10 April 2003 09:32:06 PM
 */

public interface Queue
{
	public int size();
	public boolean isEmpty();
	public Object front() throws QueueEmptyException;
	public void enqueue(Object O);
	public Object dequeue() throws QueueEmptyException;
}
