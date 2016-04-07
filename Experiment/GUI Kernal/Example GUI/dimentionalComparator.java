/*
 * Author: Domino
 * Created: 03/15/2003 14:31:41
 * Modified: 03/15/2003 14:31:41
 */


public class dimentionalComparator implements Comparator
{
	public boolean isLessThan(Object a, Object b) throws InvalidKeyException{
		if (!(isComparable(a)&&isComparable(b))) throw new InvalidKeyException("One or more of the keys cannot be compared");
		int x1 = (int)((Matrix)a).getElem(0,0);
		int y1 = (int)((Matrix)a).getElem(0,1);
		int z1 = (int)((Matrix)a).getElem(0,2);		
		int x2 = (int)((Matrix)b).getElem(0,0);
		int y2 = (int)((Matrix)b).getElem(0,1);
		int z2 = (int)((Matrix)b).getElem(0,2);
		
		if (x1 == x2){
			if (y1 == y2){
				if (z1 == z2){
					return false;
				} else return (z1 < z2);
			} else return (y1 < y2);
		} else return (x1 < x2);
	}
	
	public boolean isLessOrEqualTo(Object a, Object b) throws InvalidKeyException{
		return (isLessThan(a,b)||isEqual(a,b));
	}
	
	public boolean isEqual(Object a, Object b) throws InvalidKeyException{
		if (!(isComparable(a)&&isComparable(b))) throw new InvalidKeyException("One or more of the keys cannot be compared");
		int x1 = (int)((Matrix)a).getElem(0,0);
		int y1 = (int)((Matrix)a).getElem(0,1);
		int z1 = (int)((Matrix)a).getElem(0,2);		
		int x2 = (int)((Matrix)b).getElem(0,0);
		int y2 = (int)((Matrix)b).getElem(0,1);
		int z2 = (int)((Matrix)b).getElem(0,2);
		
		return ((x1 == x2)&&(y1 == y2)&&(z1 == z2));
	}
	
	public boolean isGreaterThan(Object a, Object b) throws InvalidKeyException{
		if (!(isComparable(a)&&isComparable(b))) throw new InvalidKeyException("One or more of the keys cannot be compared");
		int x1 = (int)((Matrix)a).getElem(0,0);
		int y1 = (int)((Matrix)a).getElem(0,1);
		int z1 = (int)((Matrix)a).getElem(0,2);		
		int x2 = (int)((Matrix)b).getElem(0,0);
		int y2 = (int)((Matrix)b).getElem(0,1);
		int z2 = (int)((Matrix)b).getElem(0,2);
		
		if (x1 == x2){
			if (y1 == y2){
				if (z1 == z2){
					return false;
				} else return (z1 > z2);
			} else return (y1 > y2);
		} else return (x1 > x2);
	}
	
	public boolean isGreaterThanOrEqualTo(Object a, Object b) throws InvalidKeyException{
		return (isGreaterThan(a,b)||isEqual(a,b));
	}
	
	public boolean isComparable(Object a){
		return ((a instanceof Matrix)&&(((Matrix)a).getHeight() == 3));
	}
}
