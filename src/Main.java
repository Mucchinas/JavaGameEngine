import javax.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int w = 1600;
        int h = 1000;
        int speed = 10;

        JFrame f = new JFrame();
        DrawManager drawManager = new DrawManager(w,h);
        f.setSize(w,h);
        f.setTitle("Game Engine in Java!");
        f.add(drawManager);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);

        while (true) {

            drawManager.pg.posX += speed;
            drawManager.repaint();
            if (drawManager.pg.posX > w - 120){

                speed = -speed;

            }

            if (drawManager.pg.posX < 40){

                speed = -speed;

            }

            Thread.sleep(33);

        }

    }

}