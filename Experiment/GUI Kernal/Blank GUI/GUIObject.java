abstract class GUIObject {
  public boolean Active;
  public GUIObject next;

  public GUIObject(){
    Active = true;
    next = null;
  }

  abstract void handle(Message Msg) throws TerminateBroadcastException;
}