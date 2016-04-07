/*
 * Author: Domino
 * Created: 03/13/2003 17:01:20
 * Modified: 03/13/2003 17:01:20
 */


public class NodeStack
{
	private int numElem;
	private StackElem anchor;
	
	public NodeStack(){
		numElem = 0;
		anchor = null;
	}
	
	public int size() { 
		return numElem;
	}
	
	public boolean isEmpty(){
		return (numElem == 0);
	}
 
	public Object top() throws StackEmptyException{
		if (numElem == 0) 
			throw new StackEmptyException("Stack is empty");
		else 
			return anchor.element;
	}
	
	public void push (Object element){
		StackElem n = new StackElem(anchor, element);
		anchor = n;
		numElem++;
	}

	public Object pop() throws StackEmptyException{
		if (isEmpty()) 
			throw new StackEmptyException("Stack is empty");
		else {
			Object o = top();
			anchor = anchor.next;
			numElem--;
			return o;
		}
					
	}

}
