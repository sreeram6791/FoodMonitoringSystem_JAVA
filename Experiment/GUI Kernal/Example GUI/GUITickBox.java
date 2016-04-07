import java.awt.*;

public class GUITickBox extends GUIBlankObject{
  	protected boolean state;
	protected boolean isActive; 

	public GUITickBox(int x,int y,boolean startState){
    	super(x,y,10,10);
		state = startState;
		isActive = true;
  	}
		
	public void Update(Graphics g){
		StandardShapes.bevelIn(g,StartX,StartY,Width,Height,Color.white);
		if (state == true){
			if (isActive){
				g.setColor(Color.black);
			} else {
				g.setColor(Color.gray);
			}
			g.fillRect(StartX+3,StartY+3,Width-5,Height-5);
		}
	}

	public void MouseClick(int x, int y){
		state = !state;
	}
	
	public boolean getState(){
		return state;
	}
	
	public void setState(boolean s){
		state = s;
	}
	
}