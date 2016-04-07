public class Util{
 	private boolean TerminateBroadcast;
	public GUIObject Anchor;
	
	public Util(){
		Anchor = new ExitObject();
	}

	public void insert(GUIObject Obj){
  		Obj.next = Anchor;
  		Anchor = Obj;
	}

	public void Broadcast(Message Msg){
		GUIObject Temp = Anchor;
  		TerminateBroadcast = false;
  		while ((Temp != null) && (TerminateBroadcast == false))  {
    		try {
      			Temp.handle(Msg);
    		}
    		catch (RuntimeException Err) {
				if (Err instanceof TerminateBroadcastException){
					TerminateBroadcast = true;
				} else {
					new PopMessage((InitKernal.Width-250)/2,(InitKernal.Height - 100)/2,250,100,Err.getMessage());
					Temp.Active = false;
				}
				
    		}
    		Temp = Temp.next;
  		}
	}

	protected void Reverse(GUIObject Obj, Message Msg){
  		if (Obj.next != null) {
    		Reverse(Obj.next,Msg);
  		}
  		if (TerminateBroadcast == false) {
    		try {
      			Obj.handle(Msg);
    		} catch (TerminateBroadcastException err) {
      			TerminateBroadcast = true;
    		}
  		}
	}

	public void reverseBroadcast(Message Msg){
  		TerminateBroadcast = false;
  		if (Anchor != null) Reverse(Anchor,Msg);
	}

}