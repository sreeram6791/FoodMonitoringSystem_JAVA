public class MouseMoveMsg extends Message {
  public int x;
  public int y;

  public MouseMoveMsg(int X, int Y){
    x = X;
    y = Y;
  }

}