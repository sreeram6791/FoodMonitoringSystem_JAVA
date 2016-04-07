/*
 * Author: 13844768
 * Created: 08 April 2003 02:03:07 PM
 * Modified: 08 April 2003 02:03:07 PM
 */

import java.awt.*;

public class Intro extends GUIObject implements DoObject{
	protected int StartX,StartY,Width,Height;
	public Util Contents = new Util();
	public static GUITextBox StringA,StringB;
	protected GUIButton filter,random,proceed,cancel,custom;
	protected GUIObject FO;
	
	public Intro(int X, int Y, int W, int H){
		Active = true;
		next = null; 
		StartX = X;
		StartY = Y;
		Width = W;
		Height = H;
		FO = new FilterOptions(350,50,400,500);
		FO.Active = false;
		Contents.insert(new GUITextScroll(330,10,300,20));
		Contents.insert(new GUItext(340,116,"String A"));
		Contents.insert(new GUItext(340,146,"String B"));
		StringA = new GUITextBox(400,100,200,20);
		Contents.insert(StringA);
		StringB = new GUITextBox(400,130,200,20);
		Contents.insert(StringB);
		Contents.insert(new GUIImage(0,0,"Images/DNA.jpg"));		
		random = new GUIButton(350,170,120,20,"Random");
		random.setAction(new RandomString());
		Contents.insert(random);
		filter = new GUIButton(350,200,120,20,"Filter Options");
		filter.setAction(this);
		Contents.insert(filter);
		custom = new GUIButton(350,230,120,20,"Custom");
		custom.setAction(new CustomString());
		Contents.insert(custom);
		
		Contents.insert(new GUItext(350,300,"Please insert two strings into the text boxes above. When you are done,"));
		Contents.insert(new GUItext(350,320,"please press the Next button."));
		
		Contents.insert(new GUItext(350,360,"[ Description of program ]   This program takes 2 inputs (String A and String"));
		Contents.insert(new GUItext(350,380,"B), and determines all the Longest Common Sequences. This set of the"));
		Contents.insert(new GUItext(350,400,"Longest Common Sequences (LCS's) are then inserted into a undirected"));
		Contents.insert(new GUItext(350,420,"Graph. Using Dijkstra's algorith, the shortest path between the first and"));
		Contents.insert(new GUItext(350,440,"middle (in order of insertion) vertices is then constructed. The vertices"));
		Contents.insert(new GUItext(350,460,"on this shortest path is then finally inserted into a Red-and-Black binary"));
		Contents.insert(new GUItext(350,480,"tree."));			
		
		proceed = new GUIButton(650,560,60,20,"Next");
		proceed.setAction(new SpeacialProceedCommand(this));
		Contents.insert(proceed);
		cancel = new GUIButton(730,560,60,20,"Cancel");
		cancel.setAction(new Deactivate(this));
		Contents.insert(cancel);				
		Contents.insert(FO);
	}
	
	public void handle(Message Msg) throws TerminateBroadcastException{
		if (Active){
			if (Msg instanceof UpdateMsg) {
				Contents.reverseBroadcast(Msg);
			} else Contents.Broadcast(Msg);
		}
	}
	
	public void run(){
		FO.Active = true;
	}
}