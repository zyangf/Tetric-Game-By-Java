package CE203Assignment2;

import java.awt.*;

/**
 *this is class for created the inversion L style square
 */
public class Lblocks2 extends TetrisShape {
    Point [][] turnTable = {{new Point(1,1), new Point(0, 0), new Point(-1,-1), new Point(0,2)},
            {new Point(-1,1), new Point(0,0), new Point(1,-1), new Point(-2,0)},
            {new Point(-1,-1),new Point(0,0),new Point(1,1),new Point(0,-2)},
            {new Point(1,-1), new Point(0,0), new Point(-1,1), new Point(2,0)}
    };
    //this is the new coordinate when the inversion L style square is turn by 90 degrees.

    int phase = -1;

    public Lblocks2(){
            super(new Point[]{new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,0)});
        }
    //this is the start coordinate for this inversion L style square
    @Override
    public void turn(){
        super.blocks = tempTurn().blocks;
        phase = (phase + 1) % turnTable.length;
    }

    @Override
    public TetrisShape tempTurn() {
        int tmpPhase = (phase + 1) % turnTable.length;

        Point []t = turnTable[tmpPhase];

        return new DummyShape(new Point[]{
                new Point(blocks[0].x + t[0].x, blocks[0].y + t[0].y),
                new Point(blocks[1].x + t[1].x, blocks[1].y + t[1].y),
                new Point(blocks[2].x + t[2].x, blocks[2].y + t[2].y),
                new Point(blocks[3].x + t[3].x, blocks[3].y + t[3].y)
        });

    }
    // calculate the value of new coordinate when it turn and set it for the blocks Object to change a new one
}