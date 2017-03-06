package CE203Assignment2;

import javax.swing.*;
import java.awt.event.*;

/* this class is an Object for control all of my Tetris squares action for moving left, moving right and down*/

public class Block extends JPanel {
    JPanel jp = null;

    static final int DOWN = 0, LEFT = 1, RIGHT = 2, TURN=3;
    public  boolean paused = false;
    public boolean gamestart = true;

    int action = DOWN;

    TetricModel model = new TetricModel();
    // Created the Block Panel


    public Block() throws InterruptedException {
        jp = new JPanel();
        TetrisView view = new TetrisView(model);
        add(view);
        setVisible(true);
        //adding the game view from the TetrisView class
//        while(!pasue){
//            update();
//            repaint();
//        }


        MouseListener nl = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == e.BUTTON1) {
                    action = LEFT;
                } else if (e.getButton() == e.BUTTON3) {
                    action = RIGHT;
                } else if (e.getButton() == e.BUTTON2) {
                    action = TURN;
                }
            }
        };
        // hitting the left mouse button, the square should moving left
        //hitting the right mouse button, the square should moving right
        //hitting the middle mouse button, the square should turn an object clockwise by 90 degrees.
        addMouseListener(nl);

        setFocusable(true);
        requestFocusInWindow();
        //adding MouseListener for use mouse control my game

        addKeyListener(new KeyClick(this));
        //adding KeyListener for use keyboard control my game
    }

    public void update() {
        switch (action) {
            case LEFT :
                model.moveLeft();
                repaint();
                break;

            case RIGHT :
                model.moveRight();
                repaint();
                break;
            case TURN:
                model.Turn();
                repaint();
                break;
        }
        action = DOWN;
        model.drop();
        repaint();
        //this is the main update function for my game action,
        //control my game work for moving left, moving right and down.
    }
}
