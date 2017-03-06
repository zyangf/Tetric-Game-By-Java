# Tetric-Game-By-Java

For my Tetris game, I created an interface to run as an applet that can hold a 10 * 20 grid of filled squares. And I add the Tetris object Block at a JPanel to my TetrisApplet left and the get the main view for my Tetris game from TetrisView class. I draw the game background at black and random all colours which I already define in the colors array without black colour for my Tetris squares. All of this, I add in my main JApplet fire; there are also have an extend view to look for next going down square when my game is started. Moreover, I add my name and registration number in the title of the applet.

The basic structure of my program is a 10 * 20 grid draw at the TetrisView class, and then adds the main view in my main Tetris object block. The Panel block is a main control object which controls each square moving though mouse button respectively. The left mouse button is make the squares can moving left and the right mouse button is make the squares moving right. And the button which in the middle of the mouse uses to control to turn an object square clockwise by 90 degrees. 

For each squares of the grid should have a coordinate and a value. I have not more than one different style squares; I create them each of a subclass. For manage these seven square classes, I create an abstract class TetrisShape to manage these squares. And also there have a class called at ShapeFactory to random running these seven squares when the game is started.  Every square get the random colours (without black) from TetrisView class which I already created before, when my game is started, all of squares will set different random colours and show in the game view. All of squares can stack with each other, when a row is filled, it will be cleared and all squares in the rows above will move down one row. Moreover, each time a row is cleared, the game total account score will be incremented by 10 points. When the game is over, it will show a message for how many points player already get for this time played. For implement this function for my program, I created a class called at TetricModel, this class is use to control all of states for all of squares like squares can moving left, can moving right, can moving down, can turn, can draw and can clear when the row is filled.

In the main Applet function, there have a timer ActionListener use to control the move down time of squares. I defined after 0.3 second the timer ActionListener will make the square will going down one time; and after next 0.3 second the block will going down one time again.

Finally, I want to make my game even more interesting to play. Therefore, I created two subclasses to improve functionality for the main game. Now, in my game, play can use keyboard control the game as well, not only just click mouse button, left key is make square moving left, right key is make square moving right and the space key is make the square can turning clockwise by 90 degrees. Moreover, the second addition extras function is in the applet view right hand, these have an extend view of player can looking for next square when they are playing my game. These functions can make my game more interesting to play.
