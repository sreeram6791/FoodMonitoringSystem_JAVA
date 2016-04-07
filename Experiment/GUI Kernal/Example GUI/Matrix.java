/*
 * Author: 13844768
 * Created: 17 April 2003 04:19:28 PM
 * Modified: 17 April 2003 04:19:28 PM
 */


public class Matrix
{
	private int   		Vect,Col;
	private double[][] 	M;

	public Matrix(int vect, int col){
		Vect = vect;
		Col = col;
		M = new double[vect][col];		
	}
	
	public int getWidth(){
		return Vect;
	}
	
	public int getHeight(){
		return Col;
	}
	
	public void setElem(int V,int C, double Value) throws InvalidMatrixDimentionException {
		if (!GSM.inside(V,C,0,0,Vect,Col))	throw new InvalidMatrixDimentionException("The element ("+V+","+C+") that you want to set is out of bounds");
		M[V][C] = Value;
	}

	public double replaceElem(int V,int C, double Value) throws InvalidMatrixDimentionException {
		if (!GSM.inside(V,C,0,0,Vect,Col))	throw new InvalidMatrixDimentionException("The element ("+V+","+C+") that you want to replace is out of bounds");
		double t = M[V][C];
		M[V][C] = Value;
		return t;
	}
	
	public double getElem(int V,int C) throws InvalidMatrixDimentionException {
		if (!GSM.inside(V,C,0,0,Vect,Col))	throw new InvalidMatrixDimentionException("The element ("+V+","+C+") that you want to get is out of bounds");
		return M[V][C];
	}
	
	public Matrix multiplyWith(Matrix x){
		if (Vect != x.getHeight()) throw new InvalidMatrixDimentionException("The Matrixes cannot be multiplied (Wrong dimention)");
		int newWidth 	= x.getWidth();
		int newHeight 	= Col;
		Matrix temp = new Matrix(newWidth,newHeight);
		for (int yloop = 0; yloop < newHeight; yloop++) {
			for (int xloop = 0; xloop < newWidth; xloop++) {
				double sum = 0;
				for (int loop = 0; loop < Vect; loop++){
					sum += M[loop][yloop]*x.getElem(xloop,loop);
				}
				temp.setElem(xloop,yloop,sum);
			}
		}
		
		return temp;
	}
	
	public static Matrix identityMatrix(int dimentions){
		Matrix temp = new Matrix(dimentions,dimentions);
		for (int i = 0; i < dimentions; i++) temp.setElem(i,i,1);
		return temp;		
	}
	
	
}
