/*
 * Author: 13844768
 * Created: 03 April 2003 06:34:36 PM
 * Modified: 03 April 2003 06:34:36 PM
 */


public class SortedSequencePriorityQueue implements PriorityQueue
{
	protected Sequence S = new NodeSequence();
	protected Comparator C;
	
	protected Object key(Position p){
		return ((Item)p.element()).key();
	}
	
	protected Object elem(Position p){
		return ((Item)p.element()).element();
	}
	
	protected Object elem(Object I){
		return ((Item)I).element();
	}
	
	public SortedSequencePriorityQueue(Comparator c) {
		C = c;
	}
	
	public int size(){
		return S.size();
	}
	
	public boolean isEmpty(){
		return S.isEmpty();
	}
	
	public void insertItem(Object k, Object e) throws InvalidKeyException{
		if (!C.isComparable(k)){
			throw new InvalidKeyException("The key is not comparable");
		} else if (S.isEmpty()){
			S.insertFirst(new Item(k,e));
		} else if (C.isGreaterThan(k,key(S.last()))){
			S.insertAfter(S.last(), new Item(k,e));
		} else {
			Position cur = S.first();
			while (C.isGreaterThan(k,key(cur))){
				cur = S.after(cur);
			}
			S.insertBefore(cur, new Item(k,e));			
		}
	}
	
	public Object minElement(){
		return ((Item)S.first().element()).element();
	}
	
	public Object minKey(){
		return ((Item)S.first().element()).key();
	}
	
	public Object removeMin() throws EmptyContainerException{
		if (!S.isEmpty()){
			return elem(S.remove(S.first()));
		}
		throw new EmptyContainerException("The priority queue is empty");
	}
	
	protected Locator locInsert(Item2 locItem) throws InvalidKeyException{
		Position p,cur;
		Object k = locItem.key();
		if (!C.isComparable(k)){
			throw new InvalidKeyException("The key cannot be compared");
		} else 
			if (S.isEmpty())
				p = S.insertFirst(locItem);
			else if (C.isGreaterThan(k,key(S.last())))
				p = S.insertAfter(S.last(),locItem);
			else {
				cur = S.first();
				while (C.isGreaterThan(k,key(cur)))
					cur = S.after(cur);
				p = S.insertBefore(cur,locItem);
			}
		locItem.setPosition(p);
		return (Locator)locItem;				
	}
	
	protected Item2 locRemove(Locator l){
		S.remove( ((Item2)l).position() );
		return (Item2)l;
	}
	
	public Locator min() throws EmptyContainerException {
		if (S.isEmpty())
			throw new EmptyContainerException("Priority queue is empty");
		else 
			return (Locator)S.first().element();
	}
	
	public Locator insert(Object k, Object e) throws InvalidKeyException{
		Item2 locItem = new Item2(k,e,null);
		return locInsert(locItem);		
	}
	
	public void remove(Locator l){
		locRemove(l);
	}
	
	public Object replaceElement(Locator l, Object e){
		Object oldElem = ((Item2)l).element();
		((Item2)l).setElement(e);
		return oldElem;
	}
	
	public Object replaceKey(Locator l, Object k) throws InvalidKeyException{
		Item2 locItem = locRemove(l);
		Object oldKey = ((Item2)l).key();
		locItem.setKey(k);
		locInsert(locItem);
		return oldKey;		
	}
	
}
