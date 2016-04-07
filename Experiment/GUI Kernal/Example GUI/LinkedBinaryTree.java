/*
 * Author: 13844768
 * Created: 02 April 2003 03:31:14 PM
 * Modified: 02 April 2003 03:31:14 PM
 */


public class LinkedBinaryTree implements BinaryTree
{
	private Position root;
	private int size;
	
	public LinkedBinaryTree(){
		root = new BTNode(null,null,null,null);
		size = 1;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public boolean isInternal(Position p){
		return (((BTNode)p).getLeft() != null && ((BTNode)p).getRight() != null);
	}
	
	public boolean isExternal(Position p){
		return (((BTNode)p).getLeft() == null && ((BTNode)p).getRight() == null);
	}
	
	public boolean isRoot(Position p){
		return (p == root());
	}
	
	public Position root(){
		return root;
	}
	
//	public PositionIterator positions(){
//	}
	
	public Position leftChild(Position p){
		return ((BTNode)p).getLeft();
	}
	
	public Position rightChild(Position p){
		return ((BTNode)p).getRight();
	}
	
	public Position sibling(Position p){
		Position P = parent(p);
		Position lc = leftChild(P);
		if (p == lc){
			return rightChild(P);
		} else {
			return lc;
		}
	}
	
	public Position parent(Position p){
		return ((BTNode)p).getParent();
	}
	
	public Object replaceElement(Position p, Object o){
		Object temp = ((BTNode)p).element();
		((BTNode)p).setElement(o);
		return temp;
	}
	
	public void swapElements(Position v, Position w){
		Object temp = w.element();
		((BTNode)w).setElement(v.element());
		((BTNode)v).setElement(temp);
	}
	
	public void expandExternal(Position p){
		if (isExternal(p)){
			((BTNode)p).setLeft(new BTNode(null,(BTNode)p,null,null));
			((BTNode)p).setRight(new BTNode(null,(BTNode)p,null,null));
			size += 2;
		}
	}
	
	public void removeAboveExternal(Position v){
		if (isExternal(v)){
			BTNode p = (BTNode)parent(v);
			BTNode s = (BTNode)sibling(v);
			if (isRoot(p)){
				s.setParent(null);
				root = s;
			} else {
				BTNode g = (BTNode)parent(p);
				if (p == leftChild(g)){
					g.setLeft(s);
				} else {
					g.setRight(s);
				}				
				s.setParent(g);
			}
			size -= 2;
		}
	}
		
}
