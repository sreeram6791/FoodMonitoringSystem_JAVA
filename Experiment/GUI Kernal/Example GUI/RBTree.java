/*
 * Author: Domino
 * Created: 03/15/2003 14:27:04
 * Modified: 03/15/2003 14:27:04
 */


public class RBTree extends BinarySearchTree implements Dictionary
{
	static boolean Red = true;
	static boolean Black = false;
	
	public RBTree(Comparator C){
		super(C);
		T = new RestructurableNodeBinaryTree();
	}
	
	public void insertItem(Object key, Object element) throws InvalidKeyException {
		super.insertItem(key,element);
		Position posZ = actionPos;
		T.replaceElement(posZ, new RBTItem(key,element,Red));
		if (T.isRoot(posZ))
			setBlack(posZ);
		else 
			remedyDoubleRed(posZ);
	}
		
	protected void remedyDoubleRed(Position posZ){
		Position posV = T.parent(posZ);
		if (T.isRoot(posV))
			return;
		if (!isPosRed(posV))
			return;
		if (!isPosRed(T.sibling(posV))) {
			posV = ((RestructurableNodeBinaryTree)T).restructure(posZ);
			setBlack(posV);
			setRed(T.leftChild(posV));
			setRed(T.rightChild(posV));			
		} else {
			setBlack(posV);
			setBlack(T.sibling(posV));
			Position posU = T.parent(posV);
			if (T.isRoot(posU))
				return;
			setRed(posU);
			remedyDoubleRed(posU);
		}
	}
	
	public void setBlack(Position p){
		((RBTItem)(((BTNode)p).element())).makeBlack();
	}
	
	public void setRed(Position p){
		((RBTItem)(((BTNode)p).element())).makeRed();
	}
	
	public boolean isPosRed(Position p){
		if (((BTNode)p).element() == null){
			return false;
		}
		return ((RBTItem)(((BTNode)p).element())).isRed();

	}
	
	public boolean isPosBlack(Position p){
		if (((BTNode)p).element() == null){
			return true;
		}
		return (((RBTItem)(((BTNode)p).element())).isRed() == false);
	}

}