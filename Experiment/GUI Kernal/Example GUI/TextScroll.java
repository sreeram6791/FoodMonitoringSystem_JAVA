/*
 * Author: 13844768
 * Created: 13 April 2003 04:30:17 PM
 * Modified: 13 April 2003 04:30:17 PM
 */


public class TextScroll
{
	protected String M,A;
	
	public TextScroll(String Msg,String by){
		M = Msg;
		A = by;
	}
	
	public String getMessage(){
		return M;
	}
	
	public String getAuthor(){
		return A;
	}

}
