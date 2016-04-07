public class Node{
	private Object element;
	private Node next;
	
	public Node(){
		this(null,null);
	}
	
	public Node(Object e,Node n){
		next = n;
		element = e;
	}
	
	public Object getElement(){
		return element;
	}
	
	public Node getNext(){
		return next;
		
	}
	
	public void setElement(Object e){
		element = e;
	}
	
	public void setNext(Node n){
		next = n;
	}
}