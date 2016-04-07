/*
 * Author: 13844768
 * Created: 11 April 2003 04:06:42 PM
 * Modified: 11 April 2003 04:06:42 PM
 */

public interface Vector
{
	public Object elemAtRank(int r) throws InvalidVectorException;
	public Object replaceAtRank(int r, Object elem) throws InvalidVectorException;
	public void insertAtRank(int r, Object elem) throws InvalidVectorException;
	public Object removeAtRank(int r) throws InvalidVectorException;
	public int size();
	public boolean isEmpty();
}
