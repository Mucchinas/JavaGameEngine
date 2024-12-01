import java.awt.geom.Rectangle2D;
import java.util.List;

public class Collisions {

    private final int w;
    private final int h;
    public DrawManager dw;
    public List<BallDraw> balls;
    public PGDraw pg;
    public BlocksDraw bd;
    public Rectangle2D.Double[][] blocks;


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

            ball.posX += game.ballSpeedX;
            ball.posY += game.ballSpeedY;


            if (ball.posY > 945 - ball.size || ball.posY < 22) {

                game.ballSpeedY = -game.ballSpeedY;

            }

            if (ball.posX > 1560 - ball.size || ball.posX < 22) {

                game.ballSpeedX = -game.ballSpeedX;

            }

        }

    }
}
