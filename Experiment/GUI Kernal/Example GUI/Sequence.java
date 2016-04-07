/*
 * Author: Domino
 * Created: 03/13/2003 14:11:34
 * Modified: 03/13/2003 14:11:34
 */

interface Sequence extends List,Vector 
{ 
	public Position atRank(int rank) throws BoundryViolationException;
	public int rankOf(Position position) throws BoundryViolationException;	

}
