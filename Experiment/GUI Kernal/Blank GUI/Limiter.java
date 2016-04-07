/*
 * Author: 13844768
 * Created: 05 April 2003 11:38:10 PM
 * Modified: 05 April 2003 11:38:10 PM
 */


public class Limiter
{
	protected int t,Max;
	
	public Limiter(int time){
		Max = time;
		t = 0;
	}
	
	public boolean canIgo(){
		t++;
		if (t > Max) {
			t = 0;
			return true;
		}
		return false;		
	}

}
