/*
 * Author: 13844768
 * Created: 14 April 2003 11:25:36 AM
 * Modified: 14 April 2003 11:25:36 AM
 */


public class PopMessage implements DoObject
{
	protected String M;
	
	public PopMessage(int x, int y, int w, int h, String s){
		Kernal K = new Kernal();
		K.Interface.insert(new GUIFrame(x,y,w,h,"Message"));
		K.Interface.insert(new GUItext(x+10,y+40,s));
		GUIButton b = new GUIButton(x+(w-60)/2,y+h-30,60,20,"Ok");
		b.setAction(this);
		K.Interface.insert(b);
		TrafficHandler.insertKernal(K);
	}
	
	public void run(){
		TrafficHandler.killKernal();
	}
}
