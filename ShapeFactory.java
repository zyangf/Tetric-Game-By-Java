package CE203Assignment2;


import java.util.Random;

/**
 this class is the can get all of different multiple squares from each subclass
 and make them random running in the main game program
 */
public class ShapeFactory {
    static Random random = new Random();

    static TetrisShape create(){
        int numShapes = random.nextInt(6);
        switch (numShapes){
            case 0:
                return new Bblocks();
            case 1:
                return new Zblocks();
            case 2:
                return new Lblocks();
            case 3:
                return new Tblocks();
            case 4:
                return new IShape();
            case 5:
                return new Lblocks2();
            case 6:
                return new Zblock2();
        }
        return null;
    }


}
