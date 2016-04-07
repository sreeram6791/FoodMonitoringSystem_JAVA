import java.awt.*;

public class RenderAxis implements PolyObject
{
	protected boolean Active;	

	public RenderAxis(){
		Active = true;
	}
	
	public void RenderWireFrame(GUIRender R) {
		render(R);
	}
	
	public void RenderSolid(GUIRender R) {
		render(R);
	}
	
	public void RenderTextured(GUIRender R) {
		render(R);
	}
	
	private void render(GUIRender R){
		if (Active){
			Point P;
			P = R.convertPoint(PolyPoint.create(50,0,0));
			R.BkG.setColor(Color.red);
			R.BkG.drawLine(R.getCenterX(),R.getCenterY(),(int)P.getX(),(int)P.getY());	
	
			P = R.convertPoint(PolyPoint.create(0,50,0));
			R.BkG.setColor(Color.green);
			R.BkG.drawLine(R.getCenterX(),R.getCenterY(),(int)P.getX(),(int)P.getY());
	
			P = R.convertPoint(PolyPoint.create(0,0,50));
			R.BkG.setColor(Color.blue);
			R.BkG.drawLine(R.getCenterX(),R.getCenterY(),(int)P.getX(),(int)P.getY());
		}
	}

	public Matrix getCenterPoint(){
		return PolyPoint.create(0,0,0);
	}
	
	public boolean isActive(){
		return Active;
	}
	
	public void setState(boolean state){
		Active = state;
	}
	
}
