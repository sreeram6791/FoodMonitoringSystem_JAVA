import java.awt.*;

public class RBTAnim extends GUIBlankObject{
  	protected Util Contents = new Util();
	protected boolean started,finished;
	protected GUIButton proceed,cancel;
	public static Graph G = new Graph();
	public static RBTree RBT;
	public static MessageBox Output;
	protected RBTreeGUIObject Display;

	public RBTAnim(int x,int y,int w, int h){
		super(x,y,w,h);
    	Active = false;
		started = false;
		finished = false;

		Output = new MessageFrame(x+10,y+h-210,w-20,200,"Output");
		Contents.insert(Output);		

		cancel = new GUIButton(x+w-100,y+h-35,60,20,"Finished");
		cancel.Active = false;
		cancel.setAction(new SpecialDeactivate(this));
		Contents.insert(cancel);	
		
		Display = new RBTreeGUIObject(StartX+10,StartY+10,Width-20,Height-230);
		Contents.insert(Display);	
  	}

	
	protected void progressOneStep(Graphics g){
		if (!started){
			started = true;
			RBT = GfxConstruct.CreateRedBlackTree(GraphAnim.Shortest);
			Display.setTree(RBT);
			PrintTextBinaryTreeInOutput RBTText = new PrintTextBinaryTreeInOutput();
			RBTText.execute(RBT.getTree());
		} else {
			if (!finished){
				finished = true;
				cancel.Active = true;
			}			
		}
	}
		
	public void Update(Graphics g){
		if (Active) progressOneStep(g);
		Contents.reverseBroadcast(new UpdateMsg(g));
	}
	
	public void MousePress(int x, int y){
		Contents.Broadcast(new MousePressMsg(x,y));
	}
	
	public void MouseClick(int x, int y){
		Contents.Broadcast(new MouseClickMsg(x,y));
	}
	
	public void MouseRelease(int x, int y){
		Contents.Broadcast(new MouseReleaseMsg(x,y));
	}
	
	public void MouseDown(int x, int y){
		Contents.Broadcast(new MouseDragMsg(x,y));
	}
	
}