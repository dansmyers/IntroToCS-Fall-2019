# Snake

## Description and Setup

This lab will use `ArrayList` to create a Snake game. We're going to take advantage of the `ArrayList`'s ability to add and remove elements and grow over the life of the program, which we couldn't do with regular 1-D arrays.

I recommend creating a new project in BlueJ, then adding `StdDraw` to it using Edit --> Add Class From File. Create three more classes:
`Square`, `Snake`, and `SnakeGame`.

## The Main Game Loop

Put the following code in `SnakeGame`.

```
// SNAKE
// CMS 167, Spring 2019

public class SnakeGame {

    public static void main(String[] args) {
        Snake snake = new Snake();
        Square pellet = new Square(.90, .90);
        
        boolean eaten = false;
           
        boolean playing = true;
        while (playing) {
             
            // Move the snake
            // Add a new segment if the snake eats the pellet
            snake.update(pellet);
             
            // Did the snake hit itself?
            if (snake.collidesWithSelf()) {
                playing = false;    
            }
            
            // Draw
            snake.draw();
            pellet.draw();
             
            StdDraw.show(100);
        }
    }
}
```

The `main` code is straightforward and it has the same elements we've used in other programs: an `update` method, `draw` methods, and some collision-checking methods.

Here's a key idea: **this code doesn't care about how the snake is implemented**. It simply assumes that the `update`, `collidesWithSelf`, and `draw` methods will do what they're supposed to do.

## Square

The `Square` class represents both the food pellets and the snake's body segments. We wrote a version of `Square` in a previous class. Here's a slightly modified version that you can use for this program:

```
public class Square {
    
    private double x;
    private double y;
    final double RADIUS = .025;
    
    public Square(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
   
    public void draw() {
        StdDraw.setPenColor(0, 0, 0);
        StdDraw.filledSquare(this.x, this.y, this.RADIUS);
    }
    
    //*** Get the center and edge positions ***//
    
    public double getX() {
        return this.x;   
    }
    
    public double getY() {
        return this.y;
    }
    
    public double right() {
        return this.x + this.RADIUS;
    }
    
    public double left() {
        return this.x - this.RADIUS;
    }
    
    public double top() {
        return this.y + this.RADIUS;
    }
    
    public double bottom() {
        return this.y - this.RADIUS;
    }
    
    //*** Check for collisions with another square ***//
    public boolean collidesWith(Square other) {
    
        if (this.right() <= other.left()) {
            return false;
        }
        
        if (this.left() >= other.right()) {
            return false;   
        }
        
        if (this.top() <= other.bottom()) {
            return false;   
        }
        
        if (this.bottom() >= other.top()) {
            return false;
        }
        
        return true;
    }
    
    //*** Reposition this square at a new random spot ***//
    public void newLocation() {
        this.x = Math.random();
        this.y = Math.random();
    }
    
}
```

The code is similar to what we wrote last time. One change: I made the radius of the `Square` a `final double RADIUS`, which makes sense, because it's really a constant. It's okay for the `Snake` to access the `RADIUS` parameter directly, since it can't change.

I also modified the constructor to take the location of the `Square` as input.

## Snake

Here is a template for the `Snake` class. We're going to fill in the methods step-by-step.

```
import java.util.ArrayList;
import java.awt.event.KeyEvent;

public class Snake
{
    private ArrayList<Square> body;
    private String direction;
    
    //*** Construct a new Snake ***//
    //
    // Default Snake has two segments and is moving right
    public Snake() {
        this.body = new ArrayList<Square>();
        this.body.add(new Square(.5, .5));
        this.body.add(new Square(.45, .50));
        this.direction = "right";
    }
    
    //*** Move the Snake ***//
    //
    // Increase the length if the Snake collides with the pellet
    public void update(Square pellet) {

    }
    
    //*** Return true if this Snake's head hits one of its segments ***//
    public boolean collidesWithSelf() {

    }
    
    public void draw() {
    
    }
}
```

### `draw`

The `Snake` has an `ArrayList<Square>` that represents its body segments. The constructor adds two `Square`s to the list to make the initial body.

Here's a tip: we don't have to write code to draw each body square, because the `Square` class already has a `draw` method of its own. Let's use that to animate each `Square`.

```
public void draw() {
    for (int i = 0; i < this.body.size(); i++) {
        this.body.get(i).draw();
    }
}
```

The loop iterates over each position in the `body` list, gets each segment, and calls its `draw` method.

Try running the code and verify that the basic snake appears in the window.

### Moving to the Right

We could implement movement by iterating over the squares in the `body` list and shifting each one. This would be tricky, though, because the snake may bend and twist and we'd have to make sure that each segment slides into the position occupied by the previous segment.

Here's a different approach: **don't move the segments**. Instead, use the powers of `ArrayList` to **add a new head segment** on each update and **delete the old tail segment**. Together, this makes the snake look like its sliding into a new position, but the body segments in the middle don't have to change move at all.

```
Snake is moving right  ---->

                    current head
    x x x x x x     |
    x         x     v
    x         x x x x
    ^                  ^
    |                  |
    |                  add a new head segment here
    |
    delete the last tail segment
```

Here is the basic code to move the snake right. The only slightly tricky part is calculating the position of the new head square.

```
public void update() {

    // Get the current head
    Square head = this.body.get(0);
    
    double newHeadX = 0.0;
    double newHeadY = 0.0;

    // Move right
    if (this.direction.equals("right")) {
        newHeadX = head.getX() + head.RADIUS * 2;
        newHeadY = head.getY();
    }
    
    // Add the new head segment
    // Recall: position 0 is the first position
    // This add method puts a new element at position 0
    this.body.add(0, new Square(newHeadX, newHeadY));
    
    // Remove the old tail segment
    // Recall: this.body.size() - 1 must be the last element
    this.body.remove(this.body.size() - 1);
}
```

Run the code and verify that the `Snake` moves to the right.

### More Directions

Add three more `if` statements to move the `Snake` in the other three directions. Each statement should calculate appropriate values for `newHeadX` and `newHeadY`. Put all three statements before the code that adds the new head.

Test your code by changing the `direction` parameter in the constructor.

## Control

To allow the player to control the snake, we need to add code that checks for key presses and changes the `direction` appropriately. Add ode to check fro key presses to the beginning of the `update` method:

```
public void update() {

    // Check for direction changes
    if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
        this.direction = "right";
    }
    
    // Code for checking other directions goes here

    // Get the current head
    Square head = this.body.get(0);
    
    double newHeadX = 0.0;
    double newHeadY = 0.0;

    // Move right
    if (this.direction.equals("right")) {
        newHeadX = head.getX() + head.RADIUS * 2;
        newHeadY = head.getY();
    }
    
    // Statements for moving in other directions go here
    
    // Add the new head segment
    // Recall: position 0 is the first position
    // This add method puts a new element at position 0
    this.body.add(0, new Square(newHeadX, newHeadY));
    
    // Remove the old tail segment
    // Recall: this.body.size() - 1 must be the last element
    this.body.remove(this.body.size() - 1);
}
```

### Extension

At this point, you should be able to move the `Snake` around the screen.

Getting longer is actually easy: **if the `Snake` eats the pellet, don't remove its tail segment**. Modify the end of the `update` method to check if the `Snake` collides with the `pellet`. This is also easy, because we can take advantage of the `collidesWith` method in `Square`.

```
if (!head.collidesWith(pellet)) {
    this.body.remove(this.body.size() - 1);
}
```

### Self-Destruction

The last method is `collidesWithSelf`, which tests if the `Snake`'s head hits any of its other body segments. The strategy here is straightfoward:

- Get a reference to the head square

- Iterate over the other body segments

- Use the `collidesWith` method to test for any intersections

```
public boolean collidesWithSelf() {
    Square head = this.body.get(0);
        
    // Loop over other body segments
    // Loop starts at index 1 to avoid comparing head to itself
    for (int i = 1; i < this.body.size(); i++) {
        if (head.collidesWith(this.body.get(i))){
            return true;   
        }
    }
    
    // If no segments collided, return false
    return false;
}
```
