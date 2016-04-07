/*
 * Author: 13844768
 * Created: 09 April 2003 09:52:07 PM
 * Modified: 09 April 2003 09:52:07 PM
 */


public class ProceedCommand implements DoObject
{
	protected GUIObject Obj;
	
	public ProceedCommand(GUIObject O){
		Obj = O;
	}
	
	public void run(){
		Obj.next.Active = true;
		Obj.Active = false;
	}

}
