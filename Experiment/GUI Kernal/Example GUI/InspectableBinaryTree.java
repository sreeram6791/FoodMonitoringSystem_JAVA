/*
 * Author: Domino
 * Created: 03/15/2003 16:30:00
 * Modified: 03/15/2003 16:30:00
 */


public interface InspectableBinaryTree extends InspectableTree
{
	public Position leftChild(Position p);
	public Position rightChild(Position p);
	public Position sibling(Position p);
}
