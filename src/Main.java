import javax.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int w = 1600;
        int h = 1200;

        JFrame f = new JFrame();
        DrawManager drawManager = new DrawManager(w,h);
        GameLogic game = new GameLogic(drawManager);
        f.setSize(w,h);
        f.setTitle("Game Engine in Java!");
        f.add(game);
        game.setFocusable(true);
        game.grabFocus();
        f.add(drawManager);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        game.GameLoop();



    }


}