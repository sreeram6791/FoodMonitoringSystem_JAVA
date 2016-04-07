/*
 * Author: Domino
 * Created: 03/13/2003 17:01:51
 * Modified: 03/13/2003 17:01:51
 */


public class StackElem
{
	public StackElem next;
	public Object element;
	
	public StackElem(StackElem newNext, Object Elem){
		next = newNext;
		element = Elem;
	}

}
