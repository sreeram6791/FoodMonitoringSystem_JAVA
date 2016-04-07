/*
 * Author: 13844768
 * Created: 17 April 2003 06:26:34 PM
 * Modified: 17 April 2003 06:26:34 PM
 */

import java.awt.*;
	
public class PolyVertex extends GUIBlankObject implements PolyObject
{
	public static Object Source = new Object();
	protected Vertex v;
	public int x,y,z,Sx,Sy,Wdt,Hgt;
	protected boolean Active;
	
	public PolyVertex(Vertex V){
		super(0,0,4,4);
		x = (int)(Math.random()*200-100);
		y = (int)(Math.random()*200-100);
		z = (int)(Math.random()*200-100);
		V.set(Source,this);
		v = V;
		Active = true;
	}
	
	public void RenderWireFrame(GUIRender R){
		Render(R);
	}
	
	public void RenderSolid(GUIRender R){
		Render(R);
	}
	
	public void RenderTextured(GUIRender R){
		Render(R);
	}
	
	protected void Render(GUIRender R){
		Sx = R.StartX;
		Sy = R.StartY;
		Wdt = R.Width;
		Hgt = R.Height;
		
		if (Active){
			Point P = R.convertPoint(PolyPoint.create(x,y,z));
			edgeIterator E = v.edges();
			while (E.hasNext()){
				Edge t = E.getNext();
				if (t.has(GraphAnim.OnShortestPath)){
					R.BkG.setColor(Color.green);
				} else if ((GraphAnim.SelectedVertex == v)||(GraphAnim.SelectedVertex == GraphAnim.G.opposite(v,t))) {
					R.BkG.setColor(Color.yellow);
				} else {
					R.BkG.setColor(Color.blue);
				}
				Vertex temp = GraphAnim.G.opposite(v,t);
				PolyVertex T = (PolyVertex)temp.get(Source);
				Point e = R.convertPoint(PolyPoint.create(T.x,T.y,T.z));
				R.BkG.drawLine((int)P.getX(),(int)P.getY(),(int)e.getX(),(int)e.getY());
				if (GraphAnim.show) {
					double d = 1/((Double)t.element()).doubleValue();
					String s = "1/"+(int)d;
					int l = GSM.getPixelLength(R.BkG,s);
					R.BkG.setColor(Color.white);
					R.BkG.drawString(s,(int)( (P.getX()+e.getX())/2-l/2 ), (int)( (P.getY()+e.getY())/2 + 5));
				}
			}
			StartX = 10+(int)P.getX()-2;
			StartY = 10+(int)P.getY()-2;	
		}	
	}
	
	public Matrix getCenterPoint(){
		return PolyPoint.create(x,y,z);	
	}

	public boolean isActive(){
		return Active;
	}
	
	public void setState(boolean state){
		Active = state;
	}

	public void MouseClick(int x, int y){
		GraphAnim.SelectedVertex = v;
	}
	
	public void Update(Graphics g){
		if (GSM.inside(StartX,StartY,Sx,Sy,Sx+Wdt-Width,Sy+Hgt-Height)){
			g.setColor(Color.white);
			g.fillRect(StartX,StartY,Width,Height);
		}
	}
}
