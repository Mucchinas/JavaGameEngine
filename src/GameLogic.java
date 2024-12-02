import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class GameLogic extends JComponent implements KeyListener {

    final int w,h;
    float speed = 0;
    int maxSpeed;

    ConcurrentLinkedQueue<BallDraw> balls;

    DrawManager dw;
    Collisions coll;

    public GameLogic(DrawManager dw){

        this.dw = dw;
        w = dw.width;
        h = dw.height;
        maxSpeed = dw.maxSpeed;
        balls = dw.balls;
        coll = dw.coll;

    }

    public void GameLoop() throws InterruptedException {

        addKeyListener(this);
        int k = 0;

        while (true) {

            addKeyListener(this);


            coll.CheckCollisions(this);

            if ((speed > 0 && dw.pg.posX < w-140) || (speed < 0 && dw.pg.posX > 30)){

                dw.pg.posX += speed;

            }

            if (dw.score > 10 + k * 10){

                balls.add(new BallDraw(w,h));
                k += 1;

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

            return;

        }

        if (key == KeyEvent.VK_DOWN){

            speed = 0;

        }

        if (key == KeyEvent.VK_UP){

            dw.yetToStart = false;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();



    }
}
