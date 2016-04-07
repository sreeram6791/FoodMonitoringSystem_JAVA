/*
 * Author: 13844768
 * Created: 09 April 2003 09:52:07 PM
 * Modified: 09 April 2003 09:52:07 PM
 */


public class SpeacialProceedCommand implements DoObject
{
	protected GUIObject Obj;
	
	public SpeacialProceedCommand(GUIObject O){
		Obj = O;
	}
	
	public void run(){
		if ((Intro.StringA.Str.length() == 0)||(Intro.StringB.Str.length() == 0))
			new PopMessage((InitKernal.Width-250)/2,(InitKernal.Height-100)/2,250,100,"Cannot compare blank string!");
		else {
			Obj.next.Active = true;
			Obj.Active = false;
		}
	}

}
