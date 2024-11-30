import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Graph extends JComponent{

    private int width, height;

    public Graph(int w, int h){

        width = w;
        height = h;

    }

    protected void paintComponent(Graphics g){

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(rh);

        Rectangle2D.Double r = new Rectangle2D.Double(50,75,100,250);
        Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height);
        Ellipse2D.Double el = new Ellipse2D.Double(40,100, (double) width /2, (double) height /2);

        g2d.setColor(Color.black);
        g2d.fill(bg);

        g2d.setColor(Color.white);
        g2d.fill(r);

        g2d.setColor(Color.cyan);
        g2d.fill(el);
    }

}
