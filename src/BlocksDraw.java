import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class BlocksDraw {

    private final int w;
    private final int h;
    private final int blockw = 70;
    private final int blockh = 20;
    private final int offset = 5;
    Random rand = new Random();

    Rectangle2D.Double[][] blocklist = new Rectangle2D.Double[20][10];
    Color[][] colorlist = new Color[20][10];

    public BlocksDraw(int w, int h){

        this.w = w;
        this.h = h;
        int startx = Math.round((float) this.w /2 - (float) (blocklist.length * blockw - (blocklist.length - 1) * offset) /2 - (float) blockw/2 - (float) (offset * blocklist.length) /2 - 12);
        int starty = Math.round((float) h / 20);

        for (int i = 0; i < blocklist.length; i++){

            for (int k = 0; k < blocklist[i].length; k++){

                float r = rand.nextFloat() / 2f + 0.5f;
                float g = rand.nextFloat() / 2f + 0.5f;
                float b = rand.nextFloat() / 2f + 0.5f;
                colorlist[i][k] = new Color(r,g,b);
                int blockx = startx + i*blockw + (i-1)*offset;
                int blocky = starty + k*blockh + (k-1)*offset;
                blocklist[i][k] = new Rectangle2D.Double(blockx, blocky, blockw, blockh);

            }

        }

    }

    public void DrawBlocks(Graphics2D g2d){

        for (int i = 0; i < blocklist.length; i++){

            for (int k = 0; k < blocklist[i].length; k++){

                g2d.setColor(colorlist[i][k]);

                if (blocklist[i][k] != null) {

                    g2d.fill(blocklist[i][k]);

                }

            }

        }

    }

    public void Restart(){

        int startx = Math.round((float) this.w /2 - (float) (blocklist.length * blockw - (blocklist.length - 1) * offset) /2 - (float) blockw/2 - (float) (offset * blocklist.length) /2 - 12);
        int starty = Math.round((float) h / 20);

        for (int i = 0; i < blocklist.length; i++){

            for (int k = 0; k < blocklist[i].length; k++){

                float r = rand.nextFloat() / 2f + 0.5f;
                float g = rand.nextFloat() / 2f + 0.5f;
                float b = rand.nextFloat() / 2f + 0.5f;
                colorlist[i][k] = new Color(r,g,b);
                int blockx = startx + i*blockw + (i-1)*offset;
                int blocky = starty + k*blockh + (k-1)*offset;
                blocklist[i][k] = new Rectangle2D.Double(blockx, blocky, blockw, blockh);

            }

        }

    }

}
