/*
 * Author: Domino
 * Created: 03/13/2003 14:39:15
 * Modified: 03/13/2003 14:39:15
 */

public class NodeList implements List
{
	protected int numElts;
	protected DNode header,tailer;
	
	public NodeList() {
		numElts = 0;
		header = new DNode(null,null,null);
		tailer = new DNode(header, null,null);
		header.setNext(tailer);
	}
	
	protected DNode checkPosition(Position p) throws InvalidPositionException{
		if (p == null)
			throw new InvalidPositionException("null position passed to NodeList");
		if (p == header) 
			throw new InvalidPositionException("The header node is not a valid position");
		if (p == tailer)
			throw new InvalidPositionException("the tailer node is not a valid position");
		try {
			DNode temp = (DNode)p;
			if ((temp.getPrev() == null)||(temp.getNext() == null))
				throw new InvalidPositionException("Position does not belong to a valid NodeList");
			return temp;
		} catch (ClassCastException e) { throw new InvalidPositionException("Position is of wrong type for this container");
		}
	}
	
	public int size(){
		return numElts;
	}
	
	public boolean isEmpty(){
		return (numElts < 1);
	}
	
	public boolean isFirst(Position p) throws InvalidPositionException {
		DNode v = checkPosition(p);
		return v.getPrev() == header;
	}	
	
	public boolean isLast(Position p) throws InvalidPositionException {
		DNode v = checkPosition(p);
		return v.getNext() == tailer;
	}
	
	public Position first() throws EmptyContainerException {
		if (isEmpty()) throw new EmptyContainerException("List is empty");
		return header.getNext();
	}
	public Position last() throws EmptyContainerException {
		if (isEmpty()) throw new EmptyContainerException("List is empty");
		return tailer.getPrev();
	}
	
	public Position before(Position p) throws InvalidPositionException,BoundryViolationException {
		DNode v = checkPosition(p);
		DNode prev = v.getPrev();
		if (prev == header) throw new BoundryViolationException("Cannot advance past the beginning of the list");
		return prev;
	}
	
	public Position after(Position p) throws InvalidPositionException,BoundryViolationException {
		DNode v = checkPosition(p);
		DNode next = v.getNext();
		if (next == tailer) throw new BoundryViolationException("Cannot advance past the end of the list");
		return next;
	}
	
	public Position insertBefore(Position p, Object element) throws InvalidPositionException{
		DNode v = checkPosition(p);
		numElts++;
		DNode newNode = new DNode(v.getPrev(),v,element);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
		return newNode;
	}
	
	public Position insertAfter(Position p, Object element) throws InvalidPositionException{
		DNode v = checkPosition(p);
		numElts++;
		DNode newNode = new DNode(v,v.getNext(),element);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
		return newNode;
	}
	
	public Position insertFirst(Object element) {
		numElts++;
		DNode newNode = new DNode(header,header.getNext(),element);
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		return newNode;
	}
	
	public Position insertLast(Object element) {
		numElts++;
		DNode newNode = new DNode(tailer.getPrev(),tailer,element);
		tailer.getPrev().setNext(newNode);
		tailer.setPrev(newNode);
		return newNode;
	}
	
	public Object remove(Position p) throws InvalidPositionException{
		DNode v = checkPosition(p);
		numElts--;
		DNode vPrev = v.getPrev();
		DNode vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		Object vElem = v.element();
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}
	
	public Object replaceElement(Position p, Object element) throws InvalidPositionException{
		DNode v = checkPosition(p);
		Object oldElt = v.element();
		v.setElement(element);
		return oldElt;
	}
	
	public void swapElements(Position a, Position b) throws InvalidPositionException {
		DNode pA = checkPosition(a);
		DNode pB = checkPosition(b);
		Object temp = pA.element();
		pA.setElement(pB.element());
		pB.setElement(temp);
	}
	
	public PositionIterator positions(){
		PositionIterator PI = new PositionIterator();
		if (!isEmpty()){
			Position p = last();
			int c = 0;
			do {
				if (c != 0) p = before(p);
				c++;
				PI.insert(p);
			} while (!isFirst(p));
		}
		return PI;
	}
	
}
