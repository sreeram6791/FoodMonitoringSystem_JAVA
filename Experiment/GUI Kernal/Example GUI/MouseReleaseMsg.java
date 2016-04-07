public class MouseReleaseMsg extends Message {
  public int x;
  public int y;

  public MouseReleaseMsg(int X, int Y){
    x = X;
    y = Y;
  }

}