import java.awt.*;

public class MessageFrame extends MessageBox{

	protected GUIFrame F;
	
	public MessageFrame(int x,int y,int w, int h,String s){
		super(x+3,y+20,w-6,h-23);
		F = new GUIFrame(x,y,w,h,s);
	}
		
	public void Update(Graphics g){
		F.Update(g);
		super.Update(g);
	}
	
}