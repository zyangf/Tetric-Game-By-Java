package CE203Assignment2;

import java.awt.*;

/**
 this class is created my TetrisModel for the square.
 I draw the basic square and add functional for a basic square like moving left, moving right, go down.
 I have some subclass in outside to set the seven different multiple squares;
 this class is doing set the colors and all of functional for all of squares
 */

public class TetricModel {

   private int a[][] = new int[10][20];
   private TetrisShape shape;
  private TetrisShape NextShape;
    private int NextColor;

   static int total =0;

    public TetricModel() {
        shape = ShapeFactory.create();
        NextShape = ShapeFactory.create();
        NextColor = TetrisView.generator.nextInt(TetrisView.colors.length-1)+1;
        TetrisView.randomIndex = TetrisView.generator.nextInt(TetrisView.colors.length-1)+1;
 //       draw();
        //set colors for square and next square which in the next looking view
    }
    private boolean canTurn(){
        TetrisShape dummy = shape.tempTurn();
        if ( dummy.left() <= 0 ) return false;
        if ( dummy.right() >= 9 ) return false;
        if ( dummy.bottom() >= 19 ) return false;
        if ( dummy.top() <= 0 ) return false;
        for ( Point p : dummy.blocks ) {
            if(a[p.x][p.y]!=0 && !shape.contain(p) ){
                return false;
            }
        }
        return true;
    }
    // add the functional for the square can be turn in the game view

    private boolean canDrop() {

        if(shape.bottom() >= 19) {

        return false;}
        for(Point p : shape.getBlocks()) {
            if(a[p.x][p.y+1]!=0 && !shape.contain(new Point(p.x, p.y + 1))){
                return false;
            }
        }
        return true;
    }
    //add the functional for the square can be drop in the game view.
    private boolean canLeft() {

        if(shape.left() <= 0) {

            return false;}
        for(Point p : shape.getBlocks()) {
            if(a[p.x-1][p.y]!=0 && !shape.contain(new Point(p.x-1, p.y))){
                return false;
            }
        }
        return true;
    }
    //add the functional for the square can be moving left in the game view (if can't, the square should just go in down).
    private boolean canRight() {

        if(shape.right() >= 9) {

            return false;}
        for(Point p : shape.getBlocks()) {
            if(a[p.x+1][p.y]!=0 && !shape.contain(new Point(p.x+1, p.y))){
                return false;
            }
        }
        return true;
    }
    //add the functional for the square can be moving right in the game view (if can't, the square should just go in down).

    private void clear(){
        for(Point p: shape.getBlocks()){
        a[p.x][p.y] = 0;}
    };
    //clear the square which I draw that before

    private void draw(){
        for(Point p: shape.getBlocks()){
        a[p.x][p.y] = TetrisView.randomIndex;}
    };
    //draw the square and get the random colors

     public void moveLeft(){
         if(canLeft()){
             clear();
             for (Point p:shape.getBlocks()){
                 p.x-=1;
             }
             draw();
         }
     };
    //add the functional make the action for square moving left work

     public void moveRight(){
         if(canRight()){
             clear();
             for (Point p:shape.getBlocks()){
                 p.x++;
             }
             draw();
         }
     };
    //add the functional make the action for square moving right work

    public  void drop(){
        // if canDrop then
        if(canDrop()){
            clear();
            for (Point p:shape.getBlocks()){
                p.y++;
            }
            draw();

        } else {
            for (int y = 0; y <= 19; y++) {
                boolean isfull = true;
                for (int x = 0; x < 10; x++) {
                    if (a[x][y] == 0) {
                        isfull = false;
                    }
                }
                if (isfull) {
                    total += 10;
                    Down(a, y);
                }
            }
            shape = NextShape;
            TetrisView.randomIndex = NextColor;
            NextShape = ShapeFactory.create();
            NextColor = TetrisView.generator.nextInt(TetrisView.colors.length-1)+1;
            draw();
        }

    };
    //add the functional make the action for square going down work;
    //and defined when the view row is full, the line should be clear and the total account for point should improved 10 points.
    //when one square can't drop, the next square should going in down until game over
    public void Turn(){
        if(canTurn()) {
            clear();
            shape.turn();
            draw();
        }

    };
    // add the functional for turn 90 degrees for square

    public int getWidth() { return a.length; }
    public int getHeight() { return a[0].length; }
    public int get(int x, int y) { return a[x][y]; }
    public boolean isGameOver() { return shape.top()==0 && !canDrop(); }
    //defined the condition for game stop.


   private void Down(int[][] a, int row){
        if(row==-1){
            return;
        }

        int curent = row-1;
        boolean empty = true;
        for ( int x = 0; x < 10; x++){
            if ( a[x][curent] != 0 ) empty = false;
            a[x][row] = a[x][curent];
        }
        if (!empty) {
            Down(a, curent);
        }
    }
    //This one is use to clear the row when the row is full
    public TetrisShape NextBlock(){
            return NextShape;
    }

    public int NextColour() {

       return NextColor;
    }
}
