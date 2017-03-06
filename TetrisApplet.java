package CE203Assignment2;

/**
 * Created by zyangf on 20/11/2014.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* this is my main applet class for my Tetris game.
Create an object of class TetrisView and starts the system.
there also have the time function to move currently active block at fixed intervals*/
public class TetrisApplet extends JApplet {
    Timer timer;
    //implement timer;

    public void init() {

        try {
            final Block m = new Block();
            add(BorderLayout.WEST, m);
            ExtendView e = new ExtendView(m);
            add(BorderLayout.CENTER, e);
            Helper h = new Helper();
            add(BorderLayout.CENTER, h);
            /* set the Panels of Block and ExtendView in my Applet*/


                timer = new Timer(300, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (m.model.isGameOver()) {
                            timer.stop();
                            JOptionPane.showMessageDialog(null, "Game Over! You total score are: " + TetricModel.total + " points");
                            System.exit(1);
                        } else {
                            if (!m.gamestart) {
                                if (!m.paused) {
                                    m.update();
                                    repaint();
                                }
                            }
                        }
                    }
                });
                timer.start();
            /* Created an ActionListener to control the game start.
               let the squares can move down at 0.3 second.
               when the squares can move down for next one, the game will stop and show a message of
                total points which player already got and exit game. */

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        setSize(320, 450);
        //created the size of this applet
        Frame c = (Frame)this.getParent().getParent();
        c.setTitle("ZhuoLin Yang's Tetris  1204853 ");
        //set the Applet title, display my name and registration number in the title of the applet
    }


}

