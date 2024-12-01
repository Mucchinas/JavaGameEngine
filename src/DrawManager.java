import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class DrawManager extends JComponent {

    public final int width;
    public final int height;
    public PGDraw pg;
    public BlocksDraw block;
    public List<BallDraw> balls = new ArrayList<>();
    public int maxSpeed = 10;
    public int score = 0;

    public DrawManager(int w, int h){

        width = w;
        height = h;
        pg = new PGDraw(width, height);
        block = new BlocksDraw(width, height);
        balls.add(new BallDraw(width,height));

    }

    protected void paintComponent(Graphics g){

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(rh);

        Rectangle2D.Double c = new Rectangle2D.Double(0,0, width,20);
        Rectangle2D.Double b = new Rectangle2D.Double(0,height - 50, width,20);
        Rectangle2D.Double l = new Rectangle2D.Double(0,0,20, height);
        Rectangle2D.Double r = new Rectangle2D.Double(width - 36,0,20,height);

        Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height);

        g2d.setColor(Color.black);
        g2d.fill(bg);

        g2d.setColor(Color.gray);
        g2d.fill(c);
        g2d.fill(b);
        g2d.fill(l);
        g2d.fill(r);

        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        g2d.drawString("Score: " + score, width*9/10, height*15/16);

        pg.DrawPg(g2d);
        block.DrawBlocks(g2d);
        for (BallDraw ball : balls){

            ball.Draw(g2d);

        }

    }

}