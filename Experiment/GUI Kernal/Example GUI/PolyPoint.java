/*
 * Author: 13844768
 * Created: 01 April 2003 01:28:08 PM
 * Modified: 01 April 2003 01:28:08 PM
 */


public class PolyPoint
{
	public static Matrix create(double x, double y, double z){
		Matrix temp = new Matrix(1,3);
		temp.setElem(0,0,x);
		temp.setElem(0,1,y);
		temp.setElem(0,2,z);
		return temp;
	}
	
	public static Matrix create(double x, double y){
		Matrix temp = new Matrix(1,2);
		temp.setElem(0,0,x);
		temp.setElem(0,1,y);
		return temp;
	}

}
