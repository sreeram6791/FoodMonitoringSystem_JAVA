/*
 * Author: 13844768
 * Created: 02 April 2003 01:53:34 AM
 * Modified: 02 April 2003 01:53:34 AM
 */


public abstract class DecorablePosition implements Position
{
	protected NodeList L;
	
	public DecorablePosition(){
		L = new NodeList();
	}
	
	protected Item find(Object key) {
		if (!L.isEmpty()){
			Position p = L.first();
			while (!L.isLast(p)) {
				if ( ((Item)p.element()).key() == key ) return (Item)p.element();
				p = L.after(p);
			}
			if ( ((Item)p.element()).key() == key ) return (Item)p.element();			
		}
		return null;
	}
	
	protected Position findPosition(Object key) {
		if (!L.isEmpty()){
			Position p = L.first();
			while (!L.isLast(p)) {
				if ( ((Item)p.element()).key() == key ) return p;
				p = L.after(p);
			}
			if ( ((Item)p.element()).key() == key ) return p;			
		}
		return null;
	}
	
	public boolean has(Object o){
		if (find(o) == null) return false;
		return true;
	}
	
	public Object get(Object key) throws AttributeNotFoundException {	
		Item I = find(key);
		if (I == null) throw new AttributeNotFoundException("The attribute you are looking for does not exist.");
		return I.element();
	}
		
	public void set(Object key, Object value) throws AttributeNotFoundException {	
		L.insertFirst(new Item(key, value));
	}
		
	public void destroy(Object key) throws AttributeNotFoundException{
		Position P = findPosition(key);
		if (P == null) throw new AttributeNotFoundException("The attribute you are looking for does not exist.");
		L.remove(P);
		
	}

}
