/*
 * Author: Domino
 * Created: 03/13/2003 17:44:58
 * Modified: 03/13/2003 17:44:58
 */
import java.awt.*;

public class GfxTraverse
{
	protected String a,b;
	protected int StartX,StartY,vdist,Loop,posA,posB;
	protected Limiter Lim = new Limiter(1);
	public boolean finished,animating,fading;
	protected Color col;
	
	public GfxTraverse(String A, String B){
		if (A.length() > B.length()) {
			String S = A;
			A = B;
			B = S;
		}
		a = A;
		b = B;
		Loop = 0;
		finished = false;
		animating = true;
		LCSAnim.SysM.addMessage("Starting traverse");
		StartX = 20;
		StartY = 210;
		vdist = 60;
		col = Color.white;
		fading = false;
		posA = 0;
		posB = 0;
	}
	
	protected Color fade(Color C){
		int r = Math.max(0,C.getRed());
		int g = Math.max(0,C.getGreen()-30);
		int b = Math.max(0,C.getBlue()-30);
		return new Color(r,g,b);
	}
	
	protected Color lighten(Color C){
		int r = Math.min(255,C.getRed()+25);
		int g = Math.min(255,C.getGreen()+25);
		int b = Math.min(255,C.getBlue()+25);
		return new Color(r,g,b);
	}
	
	protected void Displaylink(String a, String b, String lcs, Graphics g){
		if ((fading) && (col.equals(Color.white))){
			animating = false;
			fading = false;
		}
		if (Lim.canIgo()){
			if (!fading){
				col = fade(col);
				if (col.equals(Color.red)){
					fading = true;
					if (lcs.length() != 0){
						LCSAnim.L.insertLast(lcs);
						if (!LCSAnim.discardDuplicates(LCSAnim.L)) {						
							LCSAnim.MBox.addMessage(lcs);
						}
					}	
				}
			} else {
				col = lighten(col);
			}
		}
		g.setColor(Color.white);
		g.drawString(a,StartX,StartY);
		g.drawString(b,StartX,StartY+vdist);
		String tempA = a;
		String tempB = b;
		int indexA,indexB;
		for (int i = lcs.length()-1; i >= 0; i--){
			char c = lcs.charAt(i);
			
			indexA = tempA.lastIndexOf(c);
			tempA = tempA.substring(0,indexA+1);
			indexB = tempB.lastIndexOf(c);
			tempB = tempB.substring(0,indexB+1);
			g.setColor(col);
			g.drawString(tempA,StartX,StartY);
			g.drawString(tempB,StartX,StartY+vdist);
			posA = StartX + GSM.getPixelLength(g,tempA)-4;
			posB = StartX + GSM.getPixelLength(g,tempB)-4;
			
			if (fading){
				g.setColor(Color.gray);
				g.drawLine(posA,StartY+4,posB,StartY+vdist-14);
			}
			
			g.setColor(Color.white);
			if (indexA != 0){
				tempA = tempA.substring(0,indexA);
				g.drawString(tempA,StartX,StartY);				
			}
			if (indexB != 0){
				tempB = tempB.substring(0,indexB);
				g.drawString(tempB,StartX,StartY+vdist);				
			}
		}
		
	}
	
	public void Progress(Graphics g){
		if (animating) {
			Displaylink(a,b,LCS.get(a.toCharArray(),b.toCharArray()),g);
		} else {
			if (Loop < (a.length()+1)/2){
				char[] cA = a.toCharArray();
				char[] cB = b.toCharArray();
				char t1,t2;
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
				a = new String(cA);
				b = new String(cB);
				Loop++;
				animating = true;
			} else {
				finished = true;
			}
		}
	}
	
}
