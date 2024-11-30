import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        int w = 1200;
        int h = 800;

        JFrame f = new JFrame();
        BGDraw bg = new BGDraw(w,h);
        f.setSize(w,h);
        f.setTitle("Game Engine in Java!");
        f.add(bg);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);

    }

}