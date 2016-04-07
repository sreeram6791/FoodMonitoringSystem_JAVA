/*
 * Author: 13844768
 * Created: 10 April 2003 01:57:48 PM
 * Modified: 10 April 2003 01:57:48 PM
 */


public class Deactivate implements DoObject
{
	protected GUIObject O;
	
	public Deactivate(GUIObject o){
		O = o;
	}
	
	public void run(){
		O.Active = false;
	}

}
