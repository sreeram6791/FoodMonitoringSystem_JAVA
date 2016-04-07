/*
 * Author: 13844768
 * Created: 09 April 2003 09:52:07 PM
 * Modified: 09 April 2003 09:52:07 PM
 */
import java.awt.*;

public class FilterOptions extends GUIBlankObject implements DoObject
{
	
	protected GUIButton OK,Cancel,toLeft,toRight;
	protected DoObject Da = new Deactivate(this);
	public Util Contents = new Util();
	protected GUITickBox Upper,RemoveSpace,AlfaNumerical;
	public static InterActiveMessageBox Used,notUsed;
	public static component Selected;
	
	public FilterOptions(int x, int y, int w, int h){
		super(x,y,w,h); 
		Contents.insert(new GUIFrame(StartX,StartY,Width,Height,"Filter Options"));
		Contents.insert(new GUItext(StartX+50,StartY+40,"Convert all chars to Upper case."));
		Upper = new GUITickBox(StartX+25,StartY+30,false);
		Contents.insert(Upper);
		Contents.insert(new GUItext(StartX+50,StartY+60,"Remove blank spaces"));
		RemoveSpace = new GUITickBox(StartX+25,StartY+50,false);
		Contents.insert(RemoveSpace);
		Contents.insert(new GUItext(StartX+50,StartY+80,"Use only AlfaNumerical chars"));		
		AlfaNumerical = new GUITickBox(StartX+25,StartY+70,false);
		Contents.insert(AlfaNumerical);
		Contents.insert(new GUItext(StartX+Width/2+20,StartY+110,"Valid characters"));
		Contents.insert(new GUItext(StartX+10,StartY+110,"Invalid characters"));
		Used    = new InterActiveMessageBox(StartX+Width/2+20,StartY+120,Width/2-30,Height-170);
		notUsed = new InterActiveMessageBox(StartX+10,StartY+120,Width/2-30,Height-170);
		Used.setOther(notUsed);
		notUsed.setOther(Used);
		Contents.insert(Used);
		Contents.insert(notUsed);
		loadAllComponents();
		
		toLeft = new GUIButton(StartX+Width/2-15,StartY+120,30,12," >>");
		toLeft.setAction(notUsed);		
		toRight = new GUIButton(StartX+Width/2-15,StartY+135,30,12," <<");
		toRight.setAction(Used);
		Contents.insert(toLeft);
		Contents.insert(toRight);
		
		OK = new GUIButton(StartX+10,StartY+Height-30,60,20,"Ok");
		OK.setAction(this);
		Contents.insert(OK);
		Cancel = new GUIButton(StartX+80,StartY+Height-30,60,20,"Cancel");
		Cancel.setAction(Da);
		Contents.insert(Cancel);
		
		Selected = null;		
	}
	
	protected void loadAllComponents(){
		for (int i = (int)'A'; i <= (int)'Z'; i++){
			Used.addMessage(new Item(new Character((char)i),"["+(char)i+"] letter"));
		}
		for (int i = (int)'0'; i <= (int)'9'; i++){
			Used.addMessage(new Item(new Character((char)i),"["+(char)i+"] number"));
		}
		Used.addMessage(new Item(new Character(' '),"[ ] space"));
		Used.addMessage(new Item(new Character('_'),"[_] underScore"));
		Used.addMessage(new Item(new Character(','),"[,] comma"));			
		Used.addMessage(new Item(new Character(';'),"[;] semi-colon"));
		Used.addMessage(new Item(new Character(':'),"[:] colon"));
		Used.addMessage(new Item(new Character('-'),"[-] dash"));
	}
	
	public void run(){
		Intro.StringA.Str = filterString(Intro.StringA.Str);
		Intro.StringB.Str = filterString(Intro.StringB.Str);
		Active = false;
	}
	
	public String filterString(String S){
		char[] cA = S.toCharArray();
		String s = "";
		for (int i = 0; i < (cA.length); i++){
			if (acceptable(cA[i])){
				s += cA[i];
			}
		}
		if (Upper.getState()) s = s.toUpperCase();
		return s;
	}
	
	public boolean acceptable(char c){
		PositionIterator PI = Used.positions();
		while (PI.hasNext()){
			Position p = PI.getNext();
			component cmp = (component)p.element();
			if (cmp.Active){
				char chr = ((Character)((Item)cmp.getItem()).key()).charValue();
				if (Character.toUpperCase(chr) == Character.toUpperCase(c)) return true;
			}
		}
		return false;
	}
	
	public void Update(Graphics g){
		if (AlfaNumerical.getState()){
			RemoveSpace.isActive = false;
		} else {
			RemoveSpace.isActive = true;
		}
		Contents.reverseBroadcast(new UpdateMsg(g));
	}
	
	public void MouseClick(int x, int y){
		Contents.Broadcast(new MouseClickMsg(x,y));
		checkList(Used);
		checkList(notUsed);
	}
	
	public void MousePress(int x, int y){
		Contents.Broadcast(new MousePressMsg(x,y));
	}
	
	public void MouseRelease(int x, int y){
		Contents.Broadcast(new MouseReleaseMsg(x,y));
	}
	
	public void MouseDown(int x, int y){
		Contents.Broadcast(new MouseDragMsg(x,y));
	}
	
	public void checkList(InterActiveMessageBox L){
		PositionIterator PI;
		
		PI = L.positions();
		while (PI.hasNext()){
			Position p = PI.getNext();
			component cmp = (component)p.element();
			char c = ((Character)((Item)cmp.getItem()).key()).charValue();
			cmp.Active = true;
			if (RemoveSpace.getState() && (c == ' ')) {
				cmp.Active = false;
			}
			if (AlfaNumerical.getState()) {
				if (!isAlphaNumerical(c)) 
					cmp.Active = false;
			}
		}
	}
	
	public boolean isAlphaNumerical(char c){
		return ( GSM.inside((int)c,0,(int)'0',0,(int)'9',0) || GSM.inside((int)c,0,(int)'A',0,(int)'Z',0) || GSM.inside((int)c,0,(int)'a',0,(int)'z',0) );
	}	
	
}
