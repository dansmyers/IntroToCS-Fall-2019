# Secret Collect.

## Description

A re-implementation of an early game by Videlectrix, makers of classic games like *Awexome Cross*, *Thy Dungeonman*, *RhinoFeeder*, and the *Snake Boxer* series.

You are a square that's trying to collect another square. This program will illustrate how to do keyboard input, hit detection, and text with `StdDraw`.

## The Main Game Loop

Create a file named `SecretCollect.java` and put the following code into it.

```
// Secret Collect.
// CMS 167, Spring 2019

public class SecretCollect {

    public static void main(String[] args) {
        Player p = new Player();
        Square goal = new Square();
        
        boolean playing = true;
        while (playing) {
        
            StdDraw.clear();
        
            // Move
            p.update();
            
            // Draw
            p.draw();
            goal.draw();
            
            StdDraw.show(10);  
        }
    }
} 
```

The main loop is similar to the one we wrote last time. Every object has an `update` method that controls its movement and  `draw` method that displays it on the screen.

## The Player and Square Classes

Create a class named `Player` in a file named `Player.java`. Put the following code into it.

```
// A player square controlled by the keyboard

public class Player {
    
    // The center position
    private double x;
    private double y;
    
    // Radius (half-width) of the square
    private double radius;

    public Player() {
        this.x = .10;
        this.y = .10;
        this.radius = .025;
    }
    
    
    public void update() {
    
    }
    
    
    public void draw() {
        StdDraw.setPenColor(0, 0, 0);
        StdDraw.filledSquare(this.x, this.y, this.radius);
    }
}
```

Create `Square.java` and give it the following code:

```
// A player square controlled by the keyboard

public class Square {
    
    // The center position
    private double x;
    private double y;
    
    // Radius (half-width) of the square
    private double radius;

    public Square() {
        this.x = .90;
        this.y = .90;
        this.radius = .025;
    }
    
    public void draw() {
        StdDraw.setPenColor(100, 200, 25);
        StdDraw.filledSquare(this.x, this.y, this.radius);
    }
}
```

The two classes are nearly identical. The only differences are that they start in different locations, have different colors, and the `Player` class defines an update method.

### Aside
Think about the relationship between the two classes. If they're *almost* the same, wouldn't it be useful if we could create one class that contained all of the common code, and then only write the smaller customized elements to make the separate `Player` and `Square` classes?

Java allows this under its concept of **inheritance**. It's possible for one class to **inherit** the methods and properties of another, which can be used to reduce the amount of duplicate code that needs to be written for similar classes. We won't do much with inheritance in the rest of this class, but it's a core feature of object-oriented programming in general.

## Movement

Let's make the player square move.

`StdDraw` has a method called `isKeyPressed` that checks if a key is pressed. The codes for the different keys are defined in built-in Java class called `KeyEvent`.

Add this line to the top of `Player`:

```
import java.awt.event.KeyEvent;
```

Use this code for `update`:

```
public void update() {
    if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
        this.y += .005;
    }
}
```

`KeyEvent.VK_UP` is a built-in code that represents the up arrow key.

Run the program and experiment with pressing up on your keyboard. You should see the player square shift up. Want to move faster or slower? Experiment with changing the step size.

Add code to the `update` method to recognize the other three key presses: `VK_DOWN`, `VK_LEFT`, and `VK_RIGHT`. Note that you don't need an `else` block for any of these tests: if the player isn't pressing any keys, the `update` method doesn't make any changes to the square's position.

## Collision

Let's add a little more code to detect when the player square touches the goal square.

In `SecretCollect`, add the following code. Put it between the section that calls `update` and the section that calls the `draw` methods.

```
if (goal.collidesWith(p)) {
    // Terminate the game loop
    // The loop ends after the next drawing step
    playing = false;
    
    // Display a message
    StdDraw.setPenColor(0, 0, 0);
    StdDraw.text(.10, .90, "secret collect!");   
}
```

The `collidesWith` method will check if there's a collision between the goal square and the given player. Put it into the `Square` class.

```
public boolean collidesWith(Player p) {

    // Calculate edges of this square
    double right = this.x + this.radius;
    double left = this.x - this.radius;
    double top = this.y + this.radius;
    double bottom = this.y - this.radius;
    
    // Test if the player's RIGHT side is LESS THAN of the goal's LEFT side
    // This condition puts the player square COMPELTELY LEFT of the goal square
    // If the player is completely left, they can't overlap
    if (p.right() < left) {
        return false;
    }
    
    // Test if the player's LEFT side is GREATER THAN the goal's RIGHT side
    // This puts the player COMPLETELY RIGHT of the goal square
  
    // Test if the player's TOP is LESS THAN the goal's BOTTOM
    // This puts the player COMPLETELY BELOW the goal square
    
    // Test if the player's BOTTOM is GREATER THAN the goal's TOP
    // This puts the player COMPLETELY ABOVE the goal square
    
    // If all of the previous tests fail, the player square must be in collision
    // with the goal square
    return true;
}
```

The first test checks if the player square is **totally to the left** of the goal square. If this is the case, the two square's can't
overlap with each other.

To make it work, add a new method called `right` into the `Player` class that returns the position of its right side.

```
public double right() {
    return this.x + this.radius;
}
```

Run this code, and you should see the game terminate as soon as the player's right side crosses the left side of the goal square.

Now add the other three cases to `collidesWith` and their associated support methods to `Player`: `left()`, `top()`, and `bottom()`.

## Dodge Ball

Here's an extra challenge when you have all of that done.

Add a `Ball` to the game and give it a `collidesWith` method, identical to the one from the `Square` class. Test if the player collides with the `Ball` on each iteration. If the player hits the ball, end the main game loop.

Another idea: when the player touches the goal square, don't immediately end the game. Instead, generate a new random goal position:

```
if (goal.collidesWith(p)) {
    goal.newPosition();  // generate a new random (x, y) position for the square
}
```

Now the game is about grabbing as many squares as you can while dodging all of the balls.

Can you add more than one ball?
