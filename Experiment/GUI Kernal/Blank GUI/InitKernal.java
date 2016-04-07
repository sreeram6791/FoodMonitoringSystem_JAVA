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
		TrafficHandler.setRefreshRate(10);
		Kernal K = new Kernal();

		// Insert the GUI Objects here
		// e.g. K.Interface.insert(new GUIButton(0,0,Width,Height,"Test Button"));
		// See GUIBlankObject to learn how to Write your own GUI Object
		K.Interface.insert(new GUIFrame(0,0,Width,Height,"This is a blank test frame"));


		return K;
	}

}
