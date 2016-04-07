/*
 * Author: Domino
 * Created: 03/13/2003 14:15:49
 * Modified: 03/13/2003 14:15:49
 */

public interface List
{
	public int size();
	public boolean isEmpty();
	public boolean isFirst(Position p) throws InvalidPositionException;
	public boolean isLast(Position p) throws InvalidPositionException;
	public Position first() throws EmptyContainerException;
	public Position last() throws EmptyContainerException;
	public Position before(Position P) throws InvalidPositionException,BoundryViolationException;
	public Position after(Position P) throws InvalidPositionException,BoundryViolationException;
	public Position insertBefore(Position p,Object element) throws InvalidPositionException;
	public Position insertAfter(Position p,Object element) throws InvalidPositionException;
	public Position insertFirst(Object element);
	public Position insertLast(Object element);
	public Object remove(Position p) throws InvalidPositionException;
	public Object replaceElement(Position p, Object element) throws InvalidPositionException; 
	public void swapElements(Position a, Position b) throws InvalidPositionException;	
}
