package CE203Assignment2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * this class is working for KeyListener functional which in the block object class
 */
public class KeyClick extends KeyAdapter{

    private final Block block;

    public KeyClick(Block block){
        this.block = block;
    }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                this.block.action = Block.LEFT;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.block.action = Block.RIGHT;
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                this.block.action = Block.TURN;
            } else if(e.getKeyCode()==KeyEvent.VK_P){
                this.block.paused = !this.block.paused;
            } else if(e.getKeyCode()==KeyEvent.VK_S){
               this.block.gamestart = !this.block.gamestart;
               this.block.gamestart = false;
            }
            //the same functional with mouse
            // left key is for square moving left
            //right key is for square moving right
            // the key of space is for square turn

            }
        }


