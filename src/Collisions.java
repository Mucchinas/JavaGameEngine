import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Collisions {

    private final int w;
    private final int h;
    public DrawManager dw;
    public ConcurrentLinkedQueue<BallDraw> balls;
    public PGDraw pg;
    public BlocksDraw bd;
    public Rectangle2D.Double[][] blocks;

    Random rand = new Random();

    public Collisions(int w, int h, DrawManager dw){

        this.w = w;
        this.h = h;
        this.dw = dw;
        this.balls = dw.balls;
        this.pg = dw.pg;
        this.bd = dw.block;
        this.blocks = dw.block.blocklist;


    }

    public void CheckCollisions(GameLogic game){


        for (BallDraw ball : balls) {

            if (!dw.yetToStart) {
                ball.posX += ball.ballSpeedX;
                ball.posY += ball.ballSpeedY;
            }


            if (ball.posY < 22) {

                ball.ballSpeedY = -ball.ballSpeedY;
                ball.ballSpeedX = rand.nextInt(8);

            }

            if (ball.posX < 22 || ball.posX > 1545) {

                ball.ballSpeedX = -ball.ballSpeedX;

            }

            if (ball.posX + ball.size > pg.posX && ball.posX < pg.posX + pg.width && ball.posY + ball.size > pg.posY && ball.posY + ball.size < pg.posY + 8){

                ball.ballSpeedY = -ball.ballSpeedY;

            }

            if (ball.posY > 940){

                balls.remove(ball);
                if (balls.isEmpty()){

                    balls.add(new BallDraw(w,h));
                    bd.Restart();
                    dw.yetToStart = true;

                }

            }

            for (int i = 0; i < blocks.length; i++){

                for (int k = 0; k < blocks[i].length; k++){

                    if (blocks[i][k] != null && blocks[i][k].getBounds2D().contains(ball.posX,ball.posY)){

                        blocks[i][k] = null;
                        dw.score += 1;
                        ball.ballSpeedY = -ball.ballSpeedY;
                        ball.ballSpeedX = rand.nextInt(8);


                    }

                }

            }

        }

    }
}
