import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawManager extends JComponent {

    public final int width;
    public final int height;
    public PGDraw pg;
    public int maxSpeed = 10;

    public DrawManager(int w, int h){

        width = w;
        height = h;
        pg = new PGDraw(width, height);

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

        pg.DrawPg(g2d);

    }

}