/*
 * Author: 13844768
 * Created: 13 April 2003 04:09:00 PM
 * Modified: 13 April 2003 04:09:00 PM
 */
import java.awt.*;

public class TextTransision
{
	protected int loop,X,Y,W,H;	
	protected LinkedQueue L = new LinkedQueue();
	protected Color C;
	protected boolean Scroll;
	protected int counter;
	TextScroll t;
	
	public TextTransision(int x,int y,int w,int h){
		X = x;
		Y = y;
		W = w;
		H = h;
		LoadTextList(L);
		loop = W;
		C = Color.black;
		Scroll = true;
		counter = 0;
		t = (TextScroll)L.front();
	}
	
	public void LoadTextList(LinkedQueue L){
		L.enqueue(new TextScroll("String match Mania!",""));
		L.enqueue(new TextScroll("Programmed by Johnathan Lodder",""));
		L.enqueue(new TextScroll("Copyright(c) 2003 -> Binary Culture",""));
		L.enqueue(new TextScroll("Stellenbosch Universaty (South Africa)",""));
		L.enqueue(new TextScroll("Computer Science Department",""));
	}
	
	public void AddMessage(String M, String A){
		L.enqueue(new TextScroll(M,A));
	}
	
	protected boolean CanIGo(){
		counter++;
		if (counter > 0){
			counter = 0;
			return true;
		} 
		return false;
	}
	
	protected Color fade(Color C){
		int r = Math.max(0,C.getRed()-1);
		int g = Math.max(0,C.getGreen()-1);
		int b = Math.max(0,C.getBlue()-1);
		return new Color(r,g,b);
	}
	
	protected Color lighten(Color C){
		int r = Math.min(255,C.getRed()+1);
		int g = Math.min(255,C.getGreen()+1);
		int b = Math.min(255,C.getBlue()+1);
		return new Color(r,g,b);
	}
	
	public void update(Graphics g){
		if (!L.isEmpty()){
			Shape S = g.getClip();
			g.setClip(X,Y,W,H);
			g.setColor(Color.black);
			g.fillRect(X,Y,W,H);
			g.setColor(C);
			
			if (Scroll){
				g.drawString(t.getMessage(),X+loop,Y+H - (H-12)/2);
				loop--;
				if (CanIGo()){
					C = lighten(C);
				}
			} else {
				g.drawString(t.getMessage(),X+loop,Y+H - (H-12)/2);
				loop++;
				if (CanIGo()){
					C = fade(C);
				}
			}
			
			if (loop < 0){
				Scroll = false;
			} else if ((C.equals(Color.black))) {	
				C = Color.black;
				loop = W;
				Scroll = true;
				L.enqueue(L.dequeue());
				t = (TextScroll)L.front();
			}
			g.setClip(S);
		}	
	}

}
