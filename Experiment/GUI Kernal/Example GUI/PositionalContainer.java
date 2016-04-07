/*
 * Author: Domino
 * Created: 03/15/2003 16:40:23
 * Modified: 03/15/2003 16:40:23
 */


public interface PositionalContainer extends InspectablePositionalContainer
{
	public void swapElements(Position v, Position w);
	public Object replaceElement(Position v, Object O);
}
