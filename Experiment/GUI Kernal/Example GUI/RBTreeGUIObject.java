import java.awt.*;

public class RBTreeGUIObject extends GUIBlankObject{
 
	protected RBTree Tree;
	
	public RBTreeGUIObject(int x,int y,int w, int h){
    	super(x,y,w,h);
  	}
	
	public void setTree(RBTree T){
		Tree = T;
	}
		
	public void Update(Graphics g){
		StandardShapes.bevelIn(g,StartX,StartY,Width,Height,Color.white);
		if (Tree != null){
			new PrintRedBlackTree(Tree.getTree(),g,StartX,StartY,Width,Height);
		}
	}
	public void MousePress(int x, int y){}
	public void MouseMove(int x, int y){}
	public void MouseDown(int x, int y){}
	public void KeyPress(char c){}
	
}