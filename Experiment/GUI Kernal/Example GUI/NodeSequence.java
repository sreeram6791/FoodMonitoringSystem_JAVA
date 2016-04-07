/*
 * Author: Domino
 * Created: 03/13/2003 13:48:39
 * Modified: 03/13/2003 13:48:39
 */
public class NodeSequence extends NodeList implements Sequence
{
	protected void checkRank(int rank) throws BoundryViolationException{
		if (rank < 0||rank >=numElts) throw new BoundryViolationException("Rank " + rank + " is out of bounds");
	}
	
	public Position atRank(int rank){
		DNode node;
		checkRank(rank);
		if (rank < size()/2){
			node = header.getNext();
			for (int i = 0; i < rank; i++)
				node = node.getNext();
		} 
		else {
			node = tailer.getPrev();
			for (int i = 1; i < size()-rank; i++)
				node = node.getPrev();
		}
		return node;
	}
	
	public Object elemAtRank(int r){
		Position p = atRank(r); 
		return p.element();
	}
	
	public int rankOf(Position p){
		DNode node;
		node = header.getNext();
		int i = 0;
		while ((i < size())&&(node != p)) {
			node = node.getNext();
			i++;
		} 
		if (node == p) 
			return i;
		else 
			return -1;		
	}
	
	public void insertAtRank(int rank, Object element) throws BoundryViolationException{
		if (rank == size())
			insertLast(element);
		else {
			checkRank(rank);
			insertBefore(atRank(rank),element);
		}
	}
	
	public Object removeAtRank(int rank) throws BoundryViolationException{
		checkRank(rank);
		return remove(atRank(rank));
	}
	
	public Object replaceAtRank(int rank, Object element) throws BoundryViolationException{
		checkRank(rank);
		return replaceElement(atRank(rank),element);
	}
	
}
