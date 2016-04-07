public class ExitObject extends GUIObject {

public void handle(Message Msg) throws TerminateBroadcastException{
  if (Msg instanceof ExitMsg) {
    TrafficHandler.getKernal().Active = false;
    throw new TerminateBroadcastException("Broadcast was suppose to terminate internally.");
  } 
}

}