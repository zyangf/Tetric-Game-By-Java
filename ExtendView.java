package CE203Assignment2;

import javax.swing.*;
import java.awt.*;

/**
 * this class is created a view to looking for next running square
 * this class Panel is add in the right for applet
 */
public class ExtendView extends JPanel {
    private final Block extendView;
    int size = 20;

    public ExtendView(Block EView) {
        this.extendView = EView;

        setSize(100,100);
    }

    public void paintComponent(Graphics g) {

        for(Point p :extendView.model.NextBlock().getBlocks()) {
            g.setColor(TetrisView.colors[extendView.model.NextColour()]);
            g.fill3DRect(p.x * size, p.y * size, size, size, true);
        }

    }
}
