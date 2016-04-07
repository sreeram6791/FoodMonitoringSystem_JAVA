/*
 * Author: 13844768
 * Created: 02 April 2003 07:55:35 PM
 * Modified: 02 April 2003 07:55:35 PM
 */


public abstract class EulerTour
{
	protected InspectableBinaryTree tree;
	
	public Object execute(BinaryTree t){
		tree = t;
		return null;
	}
	
	protected void eulerTour(Position p){
		if (tree.isExternal(p)){
			visitExternal(p);
		} else {
			visitLeft(p);
			eulerTour(tree.leftChild(p));
			visitBelow(p);
			eulerTour(tree.rightChild(p));
			visitRight(p);
		}
	}
	
	protected void visitExternal(Position p){}
	
	protected void visitLeft(Position p){}
	
	protected void visitRight(Position p){}
	
	protected void visitBelow(Position p){}

}
