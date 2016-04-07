import java.awt.*;

public class GUIBlankObject extends GUIObject{
  	public int Width,Height,StartX,StartY;

	public GUIBlankObject(int x,int y,int w, int h){
    	Active = true;
    	next = null;
		StartX = x;
		StartY = y;
		Width = w;
		Height = h;
  	}

  	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Active == true) {
			int MouseX,MouseY;
			if (Msg instanceof UpdateMsg) {
				Update(((UpdateMsg)Msg).Context);
			} else if (Msg instanceof MouseMoveMsg) {
				MouseX = ((MouseMoveMsg)Msg).x;
				MouseY = ((MouseMoveMsg)Msg).y;
				if (GSM.inside(MouseX,MouseY,StartX,StartY,StartX+Width,StartY+Height)) {
					MouseMove(MouseX,MouseY);
					throw new TerminateBroadcastException("This message was suppose to terminate internally");
				}
			} else if (Msg instanceof MouseClickMsg) {
				MouseX = ((MouseClickMsg)Msg).x;
				MouseY = ((MouseClickMsg)Msg).y;
				if (GSM.inside(MouseX,MouseY,StartX,StartY,StartX+Width,StartY+Height)) {
					MouseClick(MouseX,MouseY);
					throw new TerminateBroadcastException("This message was suppose to terminate internally");
				} 
			} else if (Msg instanceof MouseDragMsg) {
				MouseX = ((MouseDragMsg)Msg).x;
				MouseY = ((MouseDragMsg)Msg).y;
				if (GSM.inside(MouseX,MouseY,StartX,StartY,StartX+Width,StartY+Height)) {
					MouseDown(MouseX,MouseY);
				} 
			} else if (Msg instanceof MouseReleaseMsg) {
				MouseX = ((MouseReleaseMsg)Msg).x;
				MouseY = ((MouseReleaseMsg)Msg).y;
				if (GSM.inside(MouseX,MouseY,StartX,StartY,StartX+Width,StartY+Height)) {
					MouseRelease(MouseX,MouseY);
				} 
			} else if (Msg instanceof MousePressMsg) {
				MouseX = ((MousePressMsg)Msg).x;
				MouseY = ((MousePressMsg)Msg).y;
				if (GSM.inside(MouseX,MouseY,StartX,StartY,StartX+Width,StartY+Height)) {
					MousePress(MouseX,MouseY);
				} 
			} else if (Msg instanceof KeyPressMsg) {
				KeyPress(((KeyPressMsg)Msg).stream);
			}
		}
	}
		
	public void Update(Graphics g){}
	public void MousePress(int x, int y){}
	public void MouseRelease(int x, int y){}
	public void MouseClick(int x, int y){}
	public void MouseMove(int x, int y){}
	public void MouseDown(int x, int y){}
	public void KeyPress(char c){}
	
}