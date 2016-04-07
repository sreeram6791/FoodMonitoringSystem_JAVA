/*
 * Author: Domino
 * Created: 03/15/2003 14:31:41
 * Modified: 03/15/2003 14:31:41
 */


public class realComparator implements Comparator
{
	public realComparator(){
	}
	
	public boolean isLessThan(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Double)a).doubleValue() < ((Double)b).intValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isLessOrEqualTo(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Double)a).doubleValue() <= ((Double)b).doubleValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isEqual(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return Math.abs((((Double)a).doubleValue() - ((Double)b).doubleValue())) < 0.0000000001;
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isGreaterThan(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Double)a).doubleValue() > ((Double)b).doubleValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isGreaterThanOrEqualTo(Object a, Object b) throws InvalidKeyException{
		if (isComparable(a) && isComparable(b)){
			return (((Double)a).doubleValue() >= ((Double)b).doubleValue());
		} else throw new InvalidKeyException("The key you want to compare is not of type Integer");
	}
	
	public boolean isComparable(Object a){
		return (a instanceof Double);	
	}
}
