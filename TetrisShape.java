package CE203Assignment2;

/**
 * Created by zyangf on 24/11/2014.
 */
import java.awt.*;
/* this class is defined the condition for Tetris Square moved
when the square in the game view boundaries, and also for the turning action */

public abstract class TetrisShape {

    Point[] blocks;

    protected TetrisShape(Point[] blocks) {
        this.blocks = blocks;
    }


    public abstract void turn();

    public abstract TetrisShape tempTurn();

    Point[] getBlocks() { return blocks; }
     public boolean contain(Point p){
         for(Point point : blocks){
             if (p.equals(point)){
                 return true;
             }
         }
         return false;
     }

    public int top() {
        int top = 21;
        for(Point point : blocks){
            if(point.y < top) top = point.y;
        }

        return top;
    }
    public int bottom() {
        int bottom = -1;
        for(Point point : blocks){
            if(point.y > bottom) bottom = point.y;
        }
        return bottom;
  }
    public int left() {
        int left = 11;
        for(Point point : blocks){
            if(point.x < left) left = point.x;
        }

        return left; }
    public int right() {
        int right = -1;
        for(Point point : blocks){
            if(point.x > right) right = point.x;
        }

        return right;
    }

    class DummyShape extends TetrisShape {

        protected DummyShape(Point[] blocks) {
            super(blocks);
        }

        @Override
        public void turn() {

        }

        @Override
        public TetrisShape tempTurn() {
            return this;
        }
    }
}
