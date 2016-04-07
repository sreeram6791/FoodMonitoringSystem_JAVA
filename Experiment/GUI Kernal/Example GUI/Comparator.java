/*
 * Author: Domino
 * Created: 03/15/2003 14:31:41
 * Modified: 03/15/2003 14:31:41
 */


public interface Comparator
{
	public boolean isLessThan(Object a, Object b) throws InvalidKeyException;
	
	public boolean isLessOrEqualTo(Object a, Object b) throws InvalidKeyException;
	
	public boolean isEqual(Object a, Object b) throws InvalidKeyException;
	
	public boolean isGreaterThan(Object a, Object b) throws InvalidKeyException;
	
	public boolean isGreaterThanOrEqualTo(Object a, Object b) throws InvalidKeyException;
	
	public boolean isComparable(Object a);
}
