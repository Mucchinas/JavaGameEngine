import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BallDraw {

    public int posX;
    public int posY;
    public int size = 10;

    public BallDraw(int w, int h){

        posX = w/2 - size/2;
        posY = h/2 - size/2;

    }

    public void Draw(Graphics2D g2d){

        Ellipse2D.Double ball = new Ellipse2D.Double(posX,posY,size,size);
        g2d.setColor(Color.white);
        g2d.fill(ball);

    }

}
