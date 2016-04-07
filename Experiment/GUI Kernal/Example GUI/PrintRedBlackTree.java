/*
 * Author: 13844768
 * Created: 02 April 2003 07:55:35 PM
 * Modified: 02 April 2003 07:55:35 PM
 */
import java.awt.*;

public class PrintRedBlackTree extends PrintBinaryTree
{		
	public PrintRedBlackTree(BinaryTree t, Graphics g, int x, int y,int w, int h){
		super(t,g,x,y,w,h);
	}
	
	protected void displayInfo(Object o,int x, int y){
		Object e = ((RBTItem)o).element();
		String s;
		if (e instanceof String)
			s = (String)e;
		else
			s = "[info]";
		int sw = G.getFontMetrics().stringWidth(s);
		
		G.setColor(Color.white);
		G.fillRect(StartX+x-(sw+12)/2,StartY+y-10,sw+12,20); 		
		if (((RBTItem)o).isRed()) 
			G.setColor(Color.red);
		else
			G.setColor(Color.black);

		G.drawRoundRect(StartX+x-(sw+12)/2,StartY+y-10,sw+12,20,8,8);
		G.setColor(Color.black);
		G.drawString(s,StartX+x-(sw)/2,StartY+y+4);
	}
	
	public void DisplayNodes(PositionIterator p){
		NodeStack N = new NodeStack();
		G.setColor(Color.white);
		while (p.hasNext()){
			BTNode temp = (BTNode)p.getNext();
			N.push(temp);
			if (tree.root() != temp) {
				int sx = ((Integer)(temp.get(posX))).intValue();
				int sy = ((Integer)(temp.get(posY))).intValue();
				BTNode parent = temp.getParent();
				int ex = ((Integer)(parent.get(posX))).intValue();
				int ey = ((Integer)(parent.get(posY))).intValue();			
				if ((tree.isExternal(temp)) || (((RBTItem)temp.element()).isRed() == false))
					G.setColor(Color.black);
				else 
					G.setColor(Color.red);
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
				G.setColor(Color.white);
				G.fillRect(StartX+x-10,StartY+y-10,20,20);
				G.setColor(Color.black);
				G.drawRect(StartX+x-10,StartY+y-10,20,20);
			}
			temp.destroy(posX);
			temp.destroy(posY);			
		}
	}	
}
