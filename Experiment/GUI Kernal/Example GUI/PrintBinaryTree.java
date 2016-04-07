/*
 * Author: 13844768
 * Created: 02 April 2003 07:55:35 PM
 * Modified: 02 April 2003 07:55:35 PM
 */
import java.awt.*;

public class PrintBinaryTree extends EulerTour
{
	protected Graphics G;
	protected int count;
	protected int maxWidth,W,H,StartX,StartY;
	protected PositionIterator PI;
	protected Object posX = new Object();
	protected Object posY = new Object();
		
	public PrintBinaryTree(BinaryTree t, Graphics g, int x, int y,int w, int h){
		W = w;
		H = h;
		StartX = x;
		StartY = y;
		count = 0;
		PI = new PositionIterator();
		execute(t,g);
		DisplayNodes(PI);
	}
	
	protected void displayInfo(Object o,int x, int y){
		String s = "[info]";
		int sw = G.getFontMetrics().stringWidth(s);
		G.setColor(Color.black);
		G.fillRect(StartX+x-(sw+12)/2,StartY+y-10,sw+12,20); 		
		G.setColor(Color.white);
		G.drawRoundRect(StartX+x-(sw+12)/2,StartY+y-10,sw+12,20,8,8);
		G.drawString(s,StartX+x-(sw)/2,StartY+y+4);
	}
	
	public void DisplayNodes(PositionIterator p){
		NodeStack N = new NodeStack();
		G.setColor(Color.gray);
		while (p.hasNext()){
			BTNode temp = (BTNode)p.getNext();
			N.push(temp);
			if (tree.root() != temp) {
				int sx = ((Integer)(temp.get(posX))).intValue();
				int sy = ((Integer)(temp.get(posY))).intValue();
				BTNode parent = temp.getParent();
				int ex = ((Integer)(parent.get(posX))).intValue();
				int ey = ((Integer)(parent.get(posY))).intValue();			
				G.drawLine(StartX+sx,StartY+sy,StartX+ex,StartY+ey);
			}
		}
		G.setColor(Color.white);
		while (!N.isEmpty()){
			BTNode temp = (BTNode)N.pop();
			int x = ((Integer)(temp.get(posX))).intValue();
			int y = ((Integer)(temp.get(posY))).intValue();
			if (tree.isInternal(temp)){
				displayInfo(temp.element(),x,y);
			} else {
				G.setColor(Color.black);
				G.fillRect(StartX+x-10,StartY+y-10,20,20);
				G.setColor(Color.white);
				G.drawRect(StartX+x-10,StartY+y-10,20,20);
			}
			temp.destroy(posX);
			temp.destroy(posY);			
		}
	}
	
	public Object execute(BinaryTree t, Graphics g){
		super.execute(t);
		G = g;
		maxWidth = t.size();
		eulerTour(t.root());
		return null;
	}
	
	protected void visitExternal(Position p){
		visitBelow(p);
	}	
	
	protected void visitBelow(Position p){
		int x = (int)((double)(W*(count+0.5)/maxWidth));
		int y = 25+depth(tree,p)*50;
		((DecorablePosition)p).set(posX,new Integer(x));
		((DecorablePosition)p).set(posY,new Integer(y));		
		PI.insert(p);
		count++;
	}
	
	protected int depth(InspectableTree t, Position p){
		if (t.isRoot(p))
			return 0;
		else 
			return 1 + depth(t, t.parent(p));
	}

}
