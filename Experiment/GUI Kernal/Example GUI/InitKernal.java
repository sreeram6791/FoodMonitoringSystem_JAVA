/*
 * Author: Domino
 * Created: 03/14/2003 04:26:06
 * Modified: 03/14/2003 04:26:06
 */
import java.awt.*;

public class InitKernal
{	public static int Width;
	public static int Height;
	
	public InitKernal(int W, int H){
		Width  = W;
		Height = H;
	}

	public Kernal get(){
		TrafficHandler.setRefreshRate(1);
		Kernal K = new Kernal();
		K.Interface.insert(new GUISquare(0,0,Width,Height,Color.black));
		K.Interface.insert(new RBTAnim(0,0,Width,Height));		
		K.Interface.insert(new GraphAnim(0,0,Width,Height));
		K.Interface.insert(new LCSAnim(0,0,Width,Height));
		K.Interface.insert(new Intro(0,0,Width,Height));
		return K;
	}

}
