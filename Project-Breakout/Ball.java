/**
 * The Breakout Ball
 *
 * @author CMS_167
 */
 
public class Ball {

    //*** Instance variables ***//
    private double x, y;
    private double radius;
    private double dx, dy;


    /**
     * Constructor -- intiailize a new Ball
     */
    public Ball() {
        this.x = .5;
        this.y = .10;
        this.radius = .01;
        this.dx = .005;
        this.dy = .005;
    }
    

    /**
     * Update -- add code to move the ball and reflect off of the sides
     *
     * Look at the BouncingBall and Pong examples
     */
    public void update() {

    }


    /**
     * Check if this Ball collides with the Paddle
     *
     * If so, reverse the Ball's y velocity
     *
     * Look at the examples from Secret Collect and Pong
     * 
     * @return  nothing, this method only updates the Ball's dy data member
     */
    public void checkPaddleCollision(Paddle paddle) {
 
    }
    

    /**
     * Check if this Ball collides with the given Brick
     *
     * Similar to testing for Paddle collisions, but this method
     * returns a boolean indicating if the collision happened
     *
     * @return  false if no collision, true otherwise
     */
    public boolean checkBrickCollision(Brick brick) {
        
        // Starter code returns false so the program will run
        return false; 
        
    }
    

    /**
     * Draw
     */
    public void draw() {
        StdDraw.filledCircle(this.x, this.y, this.radius);
    }

}
