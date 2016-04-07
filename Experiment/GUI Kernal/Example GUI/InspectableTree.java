/*
 * Author: Domino
 * Created: 03/15/2003 16:32:47
 * Modified: 03/15/2003 16:32:47
 */


public interface InspectableTree extends InspectablePositionalContainer
{
	public Position root();
	public Position parent(Position v);
//	public PositionIterator children(Position v);
	public boolean isInternal(Position v);
	public boolean isExternal(Position v);
	public boolean isRoot(Position v); 	

}
