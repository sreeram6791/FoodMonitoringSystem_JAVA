/*
 * Author: Domino
 * Created: 03/15/2003 14:32:08
 * Modified: 03/15/2003 14:32:08
 */


public class RestructurableNodeBinaryTree extends LinkedBinaryTree
{
	public RestructurableNodeBinaryTree(){
		super();
	}
	
	public Position restructure(Position p){
		Position z,v,u;
		z = p;
		v = parent(z);
		u = parent(v);
		
		new GetActiveNodes(this,z,v,u);
		
		BTNode a,c;

		a = new BTNode(GetActiveNodes.ActiveNodes[0],(BTNode)u,GetActiveNodes.children[0],GetActiveNodes.children[1]);
		c = new BTNode(GetActiveNodes.ActiveNodes[2],(BTNode)u,GetActiveNodes.children[2],GetActiveNodes.children[3]);
		
		GetActiveNodes.children[0].setParent(a);
		GetActiveNodes.children[1].setParent(a);
		GetActiveNodes.children[2].setParent(c);
		GetActiveNodes.children[3].setParent(c);
		
		((BTNode)u).setLeft(a);
		((BTNode)u).setRight(c);
		
		replaceElement(u,GetActiveNodes.ActiveNodes[1]);
		
		return u;
	}

}
