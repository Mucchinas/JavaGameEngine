import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class GameLogic extends JComponent implements KeyListener {

    final int w,h;
    float speed = 0;
    int maxSpeed;
    int ballSpeedX = 6;
    int ballSpeedY = 6;
    boolean boost = false;

    List<BallDraw> balls;

    DrawManager dw;

    public GameLogic(DrawManager dw){

        this.dw = dw;
        w = dw.width;
        h = dw.height;
        maxSpeed = dw.maxSpeed;
        balls = dw.balls;

    }

    public void GameLoop() throws InterruptedException {

        addKeyListener(this);

        while (true) {


            for (BallDraw ball : balls) {

                ball.posX += ballSpeedX;
                ball.posY += ballSpeedY;


                if (ball.posY > 900 || ball.posY < 100) {

                    ballSpeedY = -ballSpeedY;

                }

                if (ball.posX > 1500 || ball.posX < 100) {

                    ballSpeedX = -ballSpeedX;

                }

            }


            if (boost){

                maxSpeed = 15;
                if (Math.abs(speed) < 14){

                    speed *= 1.5f;

                }


            } else {

                maxSpeed = 10;
                if (Math.abs(speed) > 10){

                    speed = Math.round(speed * 0.66f);

                }
            }
            if ((speed > 0 && dw.pg.posX < w-140) || (speed < 0 && dw.pg.posX > 30)){

                dw.pg.posX += speed;

            }
            dw.repaint();

            Thread.sleep(33);

        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT){

            speed = -maxSpeed;

        }

        if (key == KeyEvent.VK_RIGHT){

            speed = maxSpeed;

        }

        if (key == KeyEvent.VK_SPACE){

            boost = !boost;

        }

        if (key == KeyEvent.VK_DOWN){

            speed = 0;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();



    }
}
