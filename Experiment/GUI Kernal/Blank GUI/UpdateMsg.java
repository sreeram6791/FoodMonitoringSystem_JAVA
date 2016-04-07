import java.awt.*;

public class UpdateMsg extends Message {
  public Graphics Context;
  public UpdateMsg(Graphics G){
		Context = G;
  }
}