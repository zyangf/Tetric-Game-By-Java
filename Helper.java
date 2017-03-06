package CE203Assignment2;

import javax.swing.*;

/**
 * Created by zyangf on 12/12/2014.
 */
public class Helper extends JPanel {
    static JTextArea gameHepler;
    public Helper(){
        gameHepler = new JTextArea(20,10);
        gameHepler.setText("Welcome to play my Game!\n");
        gameHepler.setText("Mouse left button: move left\n");
        gameHepler.setText("Mouse right button: move right\n");
        gameHepler.setText("Mouse centre button: turn");
        gameHepler.setEditable(false);
        //Helper.add(gameHepler);
    }
}

