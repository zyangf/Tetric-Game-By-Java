package CE203Assignment2;

/**
 * Created by zyangf on 20/11/2014.
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static java.awt.Color.*;

/* this is my TetrisView class, it is created the main view for my TetrisGame.
    And also set the colors for my Tetris Squares.*/

public class TetrisView extends JComponent {
    static Color[] colors =
            {black,green, blue, red,
                    yellow, magenta, pink, cyan};
    //defined all of colors

    TetricModel a;
    int w, h;
    static int size = 20;
    static Random generator = new Random();

    static int randomIndex = generator.nextInt(colors.length-1)+1;
    //random all of colors and set in my squares

    public TetrisView(TetricModel a) {
        this.a = a;
        w = a.getWidth();
        h = a.getHeight();
        //defined the high and width to my Tetris main game view
    }


    public void paintComponent(Graphics g) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                g.setColor(colors[a.get(i, j)]);
                g.fill3DRect(i * size, j * size,
                        size, size, true);
            }
        }
        //draw the background and set the colors
    }

    public Dimension getPreferredSize() {
        return new Dimension(w * size, h * size);
    }
}