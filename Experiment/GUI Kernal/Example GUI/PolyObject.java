/*
 * Author: 13844768
 * Created: 17 April 2003 06:26:34 PM
 * Modified: 17 April 2003 06:26:34 PM
 */


public interface PolyObject
{
	public void RenderWireFrame(GUIRender R);
	public void RenderSolid(GUIRender R);
	public void RenderTextured(GUIRender R);
	public Matrix getCenterPoint();
	public boolean isActive();
	public void setState(boolean state);
}
