import java.awt.*;

public class GSM
{
	public static boolean inside(int x, int y, int StartX, int StartY, int EndX, int EndY){
		return ((StartX <= x)&&(x <= EndX)&&(StartY <= y)&&(y <= EndY));
	}
	
	public static int random (int n){
		return (int) (Math.random () * n);
	}
	
	public static int getPixelLength(Graphics g, String str){
		return g.getFontMetrics().stringWidth(str);
	}

}
