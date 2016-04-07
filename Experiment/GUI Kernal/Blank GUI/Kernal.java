public class Kernal {
  	public boolean Active;
	public Util Interface;

  	public Kernal() {
    	Active = true;
    	Interface = new Util();
    }
	
	public void handle(Message Msg){
		Interface.Broadcast(Msg);	
	}
	
}