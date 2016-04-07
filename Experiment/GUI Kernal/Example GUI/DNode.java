/*
 * Author: Domino
 * Created: 03/13/2003 15:54:58
 * Modified: 03/13/2003 15:54:58
 */

class DNode implements Position
{
	private DNode prev,next;
	private Object element;
	
	public DNode(DNode newPrev, DNode newNext, Object elem){
		prev = newPrev;
		next = newNext;
		element =  elem;
	}
	
	public Object element() throws InvalidPositionException{
		if ((prev == null)&&(next == null)) throw new InvalidPositionException("Position is not in a list");
		return element;
	}
	
	public DNode getNext() {
		return next;
	}
	
	public DNode getPrev() {
		return prev;
	}
	
	public void setNext(DNode newNext){
		next = newNext;
	}
	
	public void setPrev(DNode newPrev){
		prev = newPrev;
	}
	
	public void setElement(Object newElement){
		element = newElement;
	}

}
