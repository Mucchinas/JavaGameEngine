import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BallDraw {

    public int posX;
    public int posY;
    public int ballSpeedX = 6;
    public int ballSpeedY = 6;
    public int size = 10;
    public int ballTopX = posX + size/2;
    public int ballTopY = posY;
    public int ballBottomX = ballTopX;
    public int ballBottomY = posY + size;
    public int ballRightX = posX + size;
    public int ballRightY = posY + size/2;
    public int ballLeftX = posX;
    public int ballLeftY = ballRightY;

    public BallDraw(int w, int h){

        this.posX = w/2 - size/2;
        this.posY = h/2 - size/2;

    }

    public void Draw(Graphics2D g2d){

        Ellipse2D.Double ball = new Ellipse2D.Double(posX,posY,size,size);
        g2d.setColor(Color.white);
        g2d.fill(ball);

        ballTopX = posX + size/2;
        ballTopY = posY;
        ballBottomX = ballTopX;
        ballBottomY = posY + size;
        ballRightX = posX + size;
        ballRightY = posY + size/2;
        ballLeftX = posX;
        ballLeftY = ballRightY;

    }

}
