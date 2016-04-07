/*
 * Author: 13844768
 * Created: 02 April 2003 07:55:35 PM
 * Modified: 02 April 2003 07:55:35 PM
 */


public class PrintTextBinaryTreeInOutput extends EulerTour
{
	
	public Object execute(BinaryTree t){
		tree = t;
		RBTAnim.Output.addMessage("[=- Binary Tree -=]");
		eulerTour(t.root());
		return null;
	}
	
	protected void visitExternal(Position p){
		visitLeft(p);
	}
	
	protected void visitLeft(Position p){
		String S = "";
		for (int i=0; i < depth(p); i++){
			S += "   ";
		}
		S += "-> ";
		if ((Item)p.element() != null) {
			S += (String)((Item)p.element()).element();
			if (((RBTItem)p.element()).isRed())
				S += " [Red]";
			else
				S += " [Black]";
		}
		else 
			S += "(External node)";
			
		RBTAnim.Output.addMessage(S);
	}
	
	protected int depth(Position p){
		if (tree.isRoot(p))
			return 0;
		else 
			return 1 + depth(tree.parent(p));
	}

}
