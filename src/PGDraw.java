import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class PGDraw extends JComponent {

    public float posX;
    public float posY;
    private float width = 70;
    private final float height = 20;

    public PGDraw(float w, float h){

        posX = w/2 - width/2;
        posY = h*6/7 - height/2;

    }

    public void DrawPg(Graphics2D g2d){

        Rectangle2D.Double pg = new Rectangle2D.Double(posX, posY, width, height);

        g2d.setColor(Color.white);
        g2d.fill(pg);

    }
}
