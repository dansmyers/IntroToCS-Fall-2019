# Pong

## Description

We're going to use our graphics programming skills to implement Pong: the grandaddy of them all.



## Setup

Create a new project in BlueJ named Pong. Import `StdDraw.java` using `Edit --> Add Class From File`.

Create three new classes:

- `Pong.java`: the driver class with the main game loop.
- `Ball.java`: the pong ball; this will be similar to, but slightly different from, the `Ball` we used in the last labs.
- `Paddle.java`: an object representing the Paddles on the left and right sides.

## `Pong`

Put the following code into `Pong.java`.

```
/**
 * PONG
 *
 * @author CMS_167
 */

public class Pong {

  /**
   * Main
   */
  public static void main(String[] args) {
		
    /*** Initialize ***/
    Paddle left = new Paddle(true);
    Paddle right = new Paddle(false);
    Ball ball = new Ball();
		
    boolean playing = true;
		
    /*** Main game loop ***/		
    while (playing ) {
					
      // Check for collisions	
      // Reverse ball's direction if it collides with a paddle
      ball.checkCollision(left);
      ball.checkCollision(right);
				
      // Use object methods to update positions
      ball.update();
      left.update();
      right.update();
					
      // Game is over if the Ball reaches the left or right edge      
      if (ball.atEdge()) {
        playing = false;
      }    
          
      // Draw
      StdDraw.clear();
			
      left.draw();
      right.draw();
      ball.draw();
			
      StdDraw.show(20);

    }
  }

}
```

Take a few minutes and read through this code carefully. Everything that's happending here should make sense.

The `Ball` and `Paddle`s have `update` and `draw` methods. We'll look at those in a second.

The `Ball` class also has two other methods:

- `checkCollision`, which checks for the collision between the `Ball` and a given `Paddle`
- `atEdge`, which tests if the `Ball` has reached the left or right edge

## `Ball`

The `Ball` is similar to our previous balls.

It has five data members:

- `x` and `y` to define its center point
- `radius`
- `dx` and `dy` to describe its velocity

Put the following code into `Ball.java`.

```
public class Ball {
	
  private double x, y;  // Center position, both are in (0, 1)
  private double radius;  // Size
  private double dx, dy;  // Velocity (change in position on each step)
	
  /*** Constructor ***/
  public Ball() {
    this.x = .5;
    this.y = .5;
    this.radius = .01;
    this.dx = .0025;
    this.dy = .001;
  }
	
  /*** Move the ball ***/
  public void update() {

  }
	
  /*** Return true if this Ball has reached either edge, false otherwise ***/
  public boolean atEdge() {
    return false;
  }
	
  /*** Check if this Ball collides with a Paddle ***/
  public void checkCollision(Paddle paddle) {
		
    // Check if the Ball collides with the input paddle
		
    // If there is a collision, reverse the Ball's movement in the x direction
    
  }
		
  /*** Draw this ball using StdDraw ***/
  public void draw() {
      StdDraw.filledCircle(this.x, this.y, this.radius);
  }
  
}
```


## `Paddle`

The `Paddle` class is based on a `StdDraw` rectangle. It has five data members:

- `x` and `y` to describe its center point
- `halfWidth`, which measures the horizontal distance from the center to the left or right edge
- `halfHeight`, which measures the vertical distance from the center to the top or bottom edge
- `isLeft`, which is used to distinguish between the left-side and right-side `Paddle`s.

The `isLeft` variable is important: it's used to check whether a `Paddle` is on the left side of the screen or the right side.



```
public class Paddle {

  private double x, y;  // Center position, both are in (0, 1)
  private double halfWidth, halfHeight;  // Size
  private boolean isLeft;
  
  private final double STEP = .01;  // Distance to move on each key press

  /*** Constructor ***/
  public Paddle(boolean isLeft) {
    this.isLeft = isLeft;

    // Set x position based on value of isLeft
    if (this.isLeft) {
      this.x = .01;
    } else {
      this.x = .99;
    }
    
    this.y = .50;
    this.halfWidth = .01;
    this.halfHeight = .10;
  }
  
	
  /*** Move the Paddle ***/
  public void update() {
		
    // Test for keypress and update y position appropriately
    // Review the code from the last lab
		
    // Left paddle should use w and s keys for up and down
    if (this.isLeft) {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            this.y += STEP;
        }
        
        // Add if statement to check for VK_S and move down
    }
		
    // Add code to check up and down arrows for the right paddle
    
  }
	
  
  /*** Add methods to calculate and return right, left, top, and bottom of the Paddle ***/
  public double right() {
      return this.x + this.halfWidth;
  }
	
  
  /*** Draw this paddle using StdDraw functions ***/
  public void draw() {	
      StdDraw.filledRectangle(this.x, this.y, this.halfWidth, this.halfHeight);
  }

}
```

## First Run

Once you have all of the code entered, run the program and verify that it draws the three objects to the window, even though nothing is
moving yet.

This is a key tip for larger programs: **always develop incrementally**. Make on change at a time and observe the effects. If the change
doesn't do what it's supposed to do, **stop** and debug any problems before continuing.

## Move the `Ball`

Complete the `update` method for the `Ball` class. This will be the same as the `update` from our previous `Ball`.

**You only need to check for reflection off of the top and bottom of the screen**, since reaching the left or right side will end the game.

**After making this change, run the program again**.

## Move the `Paddle`

Complete the `update` method for the `Paddle` class.

There are two cases to consider:

- The left paddle uses `w` and `s` keys to move up and down
- The right paddle uses up and down arrow keys

Again, run the program and verify that you can move the paddles correctly before continuing.

## Collide

Now complete the `checkCollision` method in `Ball`.

This method will be the same as the collision-checking code we wrote in the previous lab. Here is an excerpt to jog your memory.

```
double left = this.x  - this.radius;

// Add code to calculate right, top, and bottom of this Ball

// Check if paddle is TOTALLY LEFT of the Ball
if (paddle.right() < left) {
    return;
}

// Add other checks for TOTALLY RIGHT, TOTALLY ABOVE, and TOTALLY BELOW

```

You'll need to add `left`, `top`, and `bottom` methods to the `Paddle` class to calculate and return the positions of each side.

Again, run the game an make sure the `Ball` bounces correctly off of the `Paddle`s.

## Game Over, Man

Finally, complete the `atEdge` method in the `Ball` class to test if the `Ball` has reached the left or right side of the screen.

When you put it all together, you should have a nice two-player Pong game.

## More Features

There are lots of things you can experiment with changing:

- Add colors, make colors change, etc.
- Make the `Ball` speed up on each `Paddle` reflection
- Respawn the `Ball` when it reaches the edge, rather than ending the game
- Keep score and display the score using `StdDraw.text`

