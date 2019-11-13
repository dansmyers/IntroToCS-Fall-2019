/**
 * Breakout: A Brick-Blasting Arcade Game
 *
 * @author CMS_167
 */

// TODO: Finish the game
 
// DO NOT DIRECTLY ACCESS ANY OBJECT PROPERTIES FROM main!

public class Breakout {

    static final int NUM_ROWS = 6;
    static final int NUM_COLS = 8;

    public static void main(String[] args) {

        //*** Initialization ***//

        Ball ball = new Ball();
        Paddle paddle = new Paddle();

        // Array of Bricks
        Brick[] bricks = new Brick[NUM_ROWS * NUM_COLS];
        int numBricks = NUM_ROWS * NUM_COLS;

        // Initialize the bricks
        // Code automatically converts index i into a row-column position
        for (int i = 0; i < bricks.length; i++) {
            int row = i / NUM_COLS;
            int col = i - (NUM_COLS * row);
            
            bricks[i] = new Brick(row, col);
        }

        // Main game loop
        
        boolean playing = true;
        while (true) {

            //*** Check terminating conditions ***//
            // Stop if the ball is at the bottom edge
            // Stop if all bricks have been destroyed

            //*** Check for collisions ***//
            ball.checkPaddleCollision(paddle);  // Make the ball reverse direction when it hits the paddle

            // Check for all brick collisions
            //
            // If the ball hits the brick, reverse its direction (in the checkBrickCollision method)
            // and set the Brick to null to remove it from the board
            for (int i = 0; i < bricks.length; i++) {
                if (bricks[i] == null) {
                    continue;
                }

                if (ball.checkBrickCollision(bricks[i])) {
                    bricks[i]= null;
                    numBricks--;
                }
            }

            //*** Update positions ***//
            ball.update();
            paddle.update();

            //*** Draw ***//
            StdDraw.clear();

            ball.draw();
            paddle.draw();

            for (int i = 0; i < bricks.length; i++) {
                if (bricks[i] == null) {
                    continue;
                } else {
                    bricks[i].draw();
                }
            }

            StdDraw.show(20);
         
        } // End of main game loop
     
    } // End of main method
 
} // End of class
