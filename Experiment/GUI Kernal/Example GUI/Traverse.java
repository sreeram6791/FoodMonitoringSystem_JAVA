/*
 * Author: Domino
 * Created: 03/13/2003 17:44:58
 * Modified: 03/13/2003 17:44:58
 */


public class Traverse
{
	
	public static void DisplayInfo(String a, String b, String lcs){
		System.out.println("==========================================================");
		System.out.println("String A = ["+a+"]");
		System.out.println("String B = ["+b+"]");		
		System.out.println("Longest common subsequence: "+lcs);
	}
	
	public static void DisplayList(NodeList NL){
	}
	
	public static NodeList all(String A, String B){
		NodeList toReturn = new NodeList();
		if (A.length() > B.length()) {
			String S = A;
			A = B;
			B = S;
		}
		char[] cA = A.toCharArray();
		char[] cB = B.toCharArray();
		char t1,t2;
		int Loop = 0;
		String Lcs;
		while (Loop <= (cA.length+1)/2) {
			A = new String(cA);
			B = new String(cB);
			Lcs = LCS.get(cA,cB);	
			if (Lcs != "")
				toReturn.insertLast(Lcs);
			DisplayInfo(A,B,Lcs);
			DisplayList(toReturn);
			
			t1 = cA[cA.length-2];
			t2 = cA[cA.length-1];
			for (int i = (cA.length-1); i > 1; i--){
				cA[i] = cA[i-2];
			}
			cA[0] = cB[cB.length-2];
			cA[1] = cB[cB.length-1];
			for (int i = (cB.length-1); i > 1 ; i--){
				cB[i] = cB[i-2];
			}
			cB[0] = t1;
			cB[1] = t2;	
			
			Loop++;
		}	
		return toReturn;
	}
}
