/*
 * Author: Domino
 * Created: 03/15/2003 14:31:41
 * Modified: 03/15/2003 14:31:41
 */


public class IntegerComparator implements Comparator
{
	public IntegerComparator(){
	}
	
	public boolean isLessThan(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Integer)a).intValue() < ((Integer)b).intValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isLessOrEqualTo(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Integer)a).intValue() <= ((Integer)b).intValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isEqual(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Integer)a).intValue() == ((Integer)b).intValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isGreaterThan(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Integer)a).intValue() > ((Integer)b).intValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isGreaterThanOrEqualTo(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Integer)a).intValue() >= ((Integer)b).intValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isComparable(Object a){
		return (a instanceof Integer);	
	}
}
