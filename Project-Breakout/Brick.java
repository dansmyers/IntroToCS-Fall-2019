/**
 * A Breakout Brick
 *
 * @author CMS_167
 */
 
public class Brick {

    //*** Instance variables ***//
    private double x, y;
    private double halfWidth, halfHeight;
    private int red, green, blue;

    /**
     * Constructor -- takes a position in the grid of bricks and automatically
     * calculates the correct x and y position for the new Brick's center
     *
     * DON'T MODIFY THIS METHOD.
     */
    public Brick(int row, int col) {
        // Calculate the starting position based on the row and column
        this.halfHeight = .30 / Breakout.NUM_ROWS / 2;
        this.halfWidth = 1.0 / Breakout.NUM_COLS / 2;

        this.x = col * (2 * halfWidth) + halfWidth;
        this.y = .90 - row * (2 * halfHeight) - halfHeight;

        // Random color
        this.red = (int) (Math.random() * 256);
        this.green = (int) (Math.random() * 256);
        this.blue = (int) (Math.random() * 256);

    }


    /**
     * Add new methods to calculate and return the right, left, top, and bottom 
     * of this Brick
     */

	
    /**
     * Draw
     */
    public void draw() {
        StdDraw.setPenColor(this.red, this.green, this.blue);
        StdDraw.filledRectangle(this.x, this.y, this.halfWidth, this.halfHeight);
        StdDraw.setPenColor(0, 0, 0);  // Set color back to black
    }

}
