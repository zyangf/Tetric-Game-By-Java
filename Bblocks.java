package CE203Assignment2;

import java.awt.*;

/**
 this class is created a big box block
 */
public class Bblocks extends TetrisShape {

    public Bblocks() {
        super(new Point[]{new Point(0,0), new Point(0,1), new Point(1,0), new Point(1,1)});
    }
    //this is the start coordinate for this Box square


    public void turn() {

    }

    @Override
    public TetrisShape tempTurn() {
        return this;
    }
}