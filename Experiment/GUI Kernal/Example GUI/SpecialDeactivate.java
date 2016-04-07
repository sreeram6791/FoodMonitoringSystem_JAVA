/*
 * Author: 13844768
 * Created: 10 April 2003 01:57:48 PM
 * Modified: 10 April 2003 01:57:48 PM
 */


public class SpecialDeactivate implements DoObject
{
	protected GUIObject O;
	
	public SpecialDeactivate(GUIObject o){
		O = o;
	}
	
	public void run(){
		new PopMessage((InitKernal.Width-250)/2,(InitKernal.Height-100)/2,250,100,"Thank you for using String Match Mania.");
		O.Active = false;
	}

}
