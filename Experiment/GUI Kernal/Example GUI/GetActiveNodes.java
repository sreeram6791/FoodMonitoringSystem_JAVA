/*
 * Author: 13844768
 * Created: 02 April 2003 07:55:35 PM
 * Modified: 02 April 2003 07:55:35 PM
 */
import java.awt.*;

public class GetActiveNodes extends EulerTour
{
	protected int count,anCount,cCount;
	public static RBTItem[] ActiveNodes;
	public static BTNode[] children;
	protected Position z,v,u;
	
	public GetActiveNodes(BinaryTree t, Position Z,Position V,Position U){
		count = 0;		
		anCount = 0;
		cCount = 0;
		z = Z;
		v = V;
		u = U;
		ActiveNodes = new RBTItem[3];
		children = new BTNode[4];
		execute(t);
	}
	
	public Object execute(BinaryTree t){
		super.execute(t);
		eulerTour(t.root());	
		return null;
	}
	
	protected void visitExternal(Position p){
		visitBelow(p);
	}
	
	protected void visitBelow(Position p){
		if ((p == z) || (p == v) || (p == u)){
			ActiveNodes[anCount] = (RBTItem)p.element();
			anCount++;
		} else if ((((BTNode)p).getParent() == z) || (((BTNode)p).getParent() == v) || (((BTNode)p).getParent() == u)){
			children[cCount] = (BTNode)p;
			cCount++;
		}
	}
	
}