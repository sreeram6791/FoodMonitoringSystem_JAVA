/*
 * Author: 13844768
 * Created: 09 April 2003 09:52:07 PM
 * Modified: 09 April 2003 09:52:07 PM
 */


public class RandomString implements DoObject
{
	public RandomString(){}
	
	public void run(){
		Intro.StringA.Str = RandomStr((int)(Math.random()*10)+10);
		Intro.StringB.Str = RandomStr((int)(Math.random()*10)+10);
	}
	
	protected String RandomStr(int l){
		String s = "";
		for (int i = 0; i < l; i++){
			int r = (int)(Math.random()*4);
			char chr = 'A';
			if (r==0)      { chr = 'A'; }
			else if (r==1) { chr = 'D'; }
			else if (r==2) { chr = 'C'; }
			else if (r==3) { chr = 'T'; }		
			s = s + chr;
		}
		return s;
	}

}
