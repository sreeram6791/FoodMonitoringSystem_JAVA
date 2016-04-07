/*
 * Author: 13844768
 * Created: 02 April 2003 04:06:53 PM
 * Modified: 02 April 2003 04:06:53 PM
 */


public class BTNode extends DecorablePosition
{
	private Object elem;
	private BTNode left,right,parent;
	
	public BTNode(Object e, BTNode p, BTNode lc, BTNode rc){
		setElement(e);
		setParent(p);
		setLeft(lc);
		setRight(rc);
	}
	
	public Object element(){
		return elem;
	}
	
	public void setElement(Object o){
		elem = o;
	}
	
	public BTNode getLeft(){
		return left;		
	}
	
	public void setLeft(BTNode n){
		left = n;
	}
		
	public BTNode getRight(){
		return right;		
	}
	
	public void setRight(BTNode n){
		right = n;
	}
	
	public BTNode getParent(){
		return parent;		
	}
	
	public void setParent(BTNode n){
		parent = n;
	}
}
