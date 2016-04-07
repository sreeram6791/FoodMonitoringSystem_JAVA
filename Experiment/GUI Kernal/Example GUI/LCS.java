/*
 * Author: 13844768
 * Created: 01 April 2003 02:48:18 PM
 * Modified: 01 April 2003 02:48:18 PM
 */

import java.awt.*;
	
public class LCS
{
	protected static int[][] L;
	protected static int w,h;
	protected static String S;
	
	public static String get(char[] a, char[] b){
		w = a.length;
		h = b.length;
		L = new int[w+1][h+1];
		for (int loop = 0; loop <= w; loop++){
			L[loop][0] = 0;
		}
		for (int loop = 0; loop <= h; loop++){
			L[0][loop] = 0;
		}
		
		for(int i = 1; i <= w; i++){
			for(int j = 1; j <= h; j++){
				if (a[i-1] == b[j-1]){
					L[i][j] = L[i-1][j-1]+1;
				} else
				{
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}
		int i = w;
		int j = h;
		S = "";
		while ((i > 0)&&(j>0)) {
			if (a[i-1] == b[j-1]) {
				S = a[i-1] + S;
				i--;
				j--;
			} else {
				if (L[i][j-1] > L[i-1][j]){
					j--;
				} else {
					i--;
				}
			}
		}
		return S;
	}

}
