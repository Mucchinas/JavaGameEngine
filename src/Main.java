import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        int w = 1200;
        int h = 800;

        JFrame f = new JFrame();
        Graph gr = new Graph(w,h);
        f.setSize(w,h);
        f.setTitle("Game Engine in Java!");
        f.add(gr);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

}