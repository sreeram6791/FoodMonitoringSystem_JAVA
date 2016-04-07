/*
 * Author: Domino
 * Created: 03/13/2003 17:01:20
 * Modified: 03/13/2003 17:01:20
 */

public class LinkedQueue implements Queue
{
	private int numElem;
	private Node front,back;
	
	public LinkedQueue(){
		numElem = 0;
		front = back = null;
	}
	
	public int size() { 
		return numElem;
	}
	
	public boolean isEmpty(){
		return (numElem == 0);
	}
 
	public Object front() throws QueueEmptyException{
		if (isEmpty()) throw new QueueEmptyException("Cannot look at front. The Queue is empty");
		return front.getElement();
	}

	public void enqueue(Object O){
		Node n = new Node(O,null);
		if (size() == 0) 
			front = n;
		else
			back.setNext(n);
		back = n;
		numElem++;
	}

	public Object dequeue() throws QueueEmptyException{
		if (isEmpty()) throw new QueueEmptyException("The Queue is empty, nothing to dequeue");
		Object o = front.getElement();
		front = front.getNext();
		numElem--;
		if (isEmpty()) back = null;
		return o;
	}
}
