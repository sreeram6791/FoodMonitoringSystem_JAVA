import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.applet.Applet;

// <applet code="GUI" width=800 height=600> </applet>

public class GUI extends Applet implements Runnable,MouseMotionListener,KeyListener,MouseListener
{
	private int width,height;
	private Graphics bkG; 
	private Image bkIm;
	private Thread animateThread;
	
	public void init ()
	{
		width = getSize ().width;
		height = getSize ().height;
		
		bkIm = createImage (width, height);
		bkG = bkIm.getGraphics ();
		bkG.setColor (Color.black);
		bkG.fillRect (0, 0, width, height);		
		bkG.setColor(Color.green);
		bkG.drawString("Loading...",((int)(width/2)),((int)(height/2)));
		
		// =========== Get superKernal ===============
		TrafficHandler.Source = this;
		InitKernal I = new InitKernal(width,height);
		TrafficHandler.insertKernal(I.get());
		addMouseMotionListener(this);
		addMouseListener(this); 
		addKeyListener(this);
	}
	
	public void start ()
	{
		if (animateThread == null)
		{
			animateThread = new Thread (this);
			animateThread.start ();
		}
	}
	
	public void run ()
	{
		while (animateThread != null)
		{
			try
			{
				Thread.sleep(TrafficHandler.GUIRefreshRate);
			}
			catch (InterruptedException e) {}
			repaint ();
		}
	}
	
	public void update (Graphics g)
	{
		paint (g);
	}
	
	public void paint (Graphics g)
	{		
		Message Updt = new UpdateMsg(bkG);
		TrafficHandler.getKernal().Interface.reverseBroadcast(Updt);
		g.drawImage (bkIm, 0, 0, this);
	}
	
	public void stop ()
	{
		animateThread = null;
	}
	
	public void mouseMoved(MouseEvent e) {
		TrafficHandler.getKernal().Interface.Broadcast(new 
			
			MouseMoveMsg(e.getX(),e.getY()));
	}
	
	public void mouseDragged(MouseEvent e) {
		TrafficHandler.getKernal().Interface.Broadcast(new MouseDragMsg(e.getX(),e.getY()));
	}
	
	public void keyTyped(KeyEvent e){
		TrafficHandler.getKernal().Interface.Broadcast(new KeyPressMsg(e.getKeyChar()));
	}
	
	public void keyPressed(KeyEvent e){	}	
	
	public void keyReleased(KeyEvent e){}
	
	public void mouseClicked(MouseEvent e){
		TrafficHandler.getKernal().Interface.Broadcast(new MouseClickMsg(e.getX(),e.getY()));
	}
	
	public void mousePressed(MouseEvent e){	
		TrafficHandler.getKernal().Interface.Broadcast(new MousePressMsg(e.getX(),e.getY()));
	}	
	
	public void mouseReleased(MouseEvent e){
		TrafficHandler.getKernal().Interface.Broadcast(new MouseReleaseMsg(e.getX(),e.getY()));
		TrafficHandler.getKernal().Interface.Broadcast(new MouseClickMsg(e.getX(),e.getY()));
	}
	
	public void mouseEntered(MouseEvent e){	}
	public void mouseExited(MouseEvent e){ }
} 
