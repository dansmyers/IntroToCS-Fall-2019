/**
 * The Breakout Paddle
 *
 * @author CMS_167
 */
 
import java.awt.event.KeyEvent;

public class Paddle {

    //*** Instance variables ***//
    private double x, y;
    private double halfWidth, halfHeight;
    private final double STEP = .02;  // Distance to move on each key press

    /**
     * Construct a new Paddle
     */
    public Paddle() {
        this.x = .5;
        this.y = .01;
        this.halfWidth = .10;
        this.halfHeight = .01;
    }


    /**
     * Update -- move the Paddle
     *
     * Check for left and right arrow presses StdDraw.isKeyPressed
     */
    public void update() {

        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            this.x -= STEP;    
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.x += STEP;    
        }

    }

    
    /**
     * Add methods to calculate and return the right, left, top, and bottom sides
     * of this Paddle
     */

	
    /**
     * Draw
     */
    public void draw() {
        StdDraw.filledRectangle(this.x, this.y, this.halfWidth, this.halfHeight);
    }

}
