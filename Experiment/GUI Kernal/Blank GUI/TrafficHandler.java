/*
 * Author: 13844768
 * Created: 09 April 2003 09:10:13 PM
 * Modified: 09 April 2003 09:10:13 PM
 */
import java.applet.Applet;

public class TrafficHandler
{
	private static NodeStack Kernals = new NodeStack();
	public static int GUIRefreshRate = 100;
	public static Applet Source;
	public static GUITextBox ActiveTestFrame;
	
	public static Kernal getKernal(){
		while (((Kernal)Kernals.top()).Active == false) {
			Kernals.pop();
		}
		return (Kernal)Kernals.top();
	}
	
	public static void killKernal(){
		Kernals.pop();
	}
	
	public static void insertKernal(Kernal K){
		Kernals.push(K);
	}
	
	public static void setRefreshRate(int r){
		GUIRefreshRate = r;
	}
}
