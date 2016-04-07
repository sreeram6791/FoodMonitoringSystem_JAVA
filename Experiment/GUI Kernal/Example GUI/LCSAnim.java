import java.awt.*;

public class LCSAnim extends GUIBlankObject{
	protected Util Contents = new Util();
	public static NodeList L = new NodeList();	
	public static MessageBox MBox,SysM;
	protected boolean started,finished;
	protected String S1,S2;
	protected GfxTraverse GTV;
	protected GUIButton proceed,cancel;
	protected Deactivate Da = new Deactivate(this);
	
	public LCSAnim(int x,int y,int w, int h){
		super(x,y,w,h);
		Active = false;
		started = false;
		finished = false;
		
		Contents.insert(new GUIFrame(10,y+170,250,120,"Compare"));
		Contents.insert(new GUIImage(10,10,"Images/LCSpic1.jpg"));
		Contents.insert(new GUIImage(270,10,"Images/LCSpic2.jpg"));	
		
		MBox = new MessageFrame(x+w-220,y+10,210,h-60,"List of LSC's");
		Contents.insert(MBox);
		
		proceed = new GUIButton(650,560,60,20,"Next");
		proceed.setAction(new ProceedCommand(this));
		proceed.Active = false;
		Contents.insert(proceed);
		cancel = new GUIButton(730,560,60,20,"Cancel");
		cancel.setAction(Da);
		Contents.insert(cancel);	
		
		SysM = new MessageFrame(x+10,y+300,250,h-320,"System messages");
		Contents.insert(SysM);	
	}
	
	public static boolean discardDuplicates(NodeList N){
		boolean q = false;
		if (!N.isEmpty()){
			Comparator C = new lexicographicComparator();
			Position p = N.first();
			Position temp;
			while (p != N.last()){
				temp = N.after(p);
				while (true){
					String ta = (String)p.element();
					String tb = (String)temp.element();					
					if (C.isEqual(ta,tb)) {
						Position t = N.before(temp);
						SysM.addMessage("Duplicate (" + (String)temp.element() + ") was removed");
						q = true;
						N.remove(temp);
						temp = t;						
					}
					if (temp == N.last())
						break;
					temp = N.after(temp);					
				}
				if (p == N.last())
					break;
				p = N.after(p);
			}
		}
		return q;
	}
	
	
	protected void progressOneStep(Graphics g){
		if (!started){
			started = true;
			S1 = Intro.StringA.Str;
			S2 = Intro.StringB.Str;
			GTV = new GfxTraverse(S1,S2);
		} else {
			if (!finished){
				GTV.Progress(g);
				if (GTV.finished) {
					LCSAnim.SysM.addMessage("Finished");
					finished = true;
					proceed.Active = true;
				}
			}			
		}
	}
	
	public void Update(Graphics g){
		Contents.reverseBroadcast(new UpdateMsg(g));
		if (Active) progressOneStep(g);
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