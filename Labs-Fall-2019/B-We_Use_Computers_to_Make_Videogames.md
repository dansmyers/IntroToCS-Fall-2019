# We Use Computers To Make Videogames

## Description

This lab will introduce the amazing world of **graphical output**. We'll be able to write programs that **make things appear on the screen**. In a few more days, we'll learn about taking input from the keyboard and using it to control our graphical creations.

To implement this, we're going to introduce two more tools. The first is a library called `StdDraw.java`, which includes a bunch of basic drawing methods. The second is a different editor called *BlueJ*. BlueJ runs on your local computer, so it can make graphical windows appear, which we can't really do with Mimir.

`StdDraw.java` was originally written by Robert Sedgwick and Kevin Wayne for their book *Introduction to Programming in Java* and is used with permission.

![](http://www.hrwiki.org/w/images/a/a6/Videlectrix_developers.png)

## Get BlueJ

Go to [the BlueJ homepage](https://www.bluej.org). Download the appropriate version for your operating system (Mac or Windows). Open the ZIP file into a location that you can remember. Click on the BlueJ logo to launch the program.

**If you get an error about Java's JDK**, let me know. You probably need to download a JDK ("Java Development Kit") from [this site](https://www.oracle.com/technetwork/java/javase/downloads/index.html).

**If you can't get BlueJ** also let me know. It works on almost every computer, but there's always a possibility that some systems will have trouble with it. There are a couple of other options we can explore if BlueJ doesn't work.

## BlueJ Projects

The first thing you need to do is create a **project**. From the main BlueJ screen, go to `Project --> New Project`. In the panel that appears, use the "Choose" button to select a directory where you want to put your BlueJ projects. Then type a name for the project like `CMS_167_Graphics_Lab` and hit OK.

## Classes

Step 1: import `StdDraw.java`. Go on to Canvas and download the `StdDraw.java` file.

In BlueJ, go to `Edit --> Add Class From File`. Select the version of `StdDraw` that you just downloaded and it will show up in the project panel as a new labeled rectangle.

Step 2: make a new class. Go to `Edit --> New Class`. Name the class `BouncingBall` (BlueJ will automatically append the `.java` suffix). Keep the selection boxes on `Java` and `Class`. When you hit OK, you'll see `BouncingBall` appear as a new rectangle in the project window.

## Get Code

Click on `BouncingBall` to open its code. BlueJ populates the class with a default bit of code. **Remove everything**, then put the following code into the window:

```
/**
 * Implement a bouncing ball animation
 *
 * Uses StdDraw.java by Robert Sedgwick and Kevin Wayne
 *
 * @author CMS_167
 */

// Note: you don't need to import StdDraw.java because it's in the same directory with BouncingBall.java

public class BouncingBall {

    public static void main(String[] args) {
		
        // Ball parameters
	// Location and size are between 0.0 and 1.0
	double x = .75;
	double y = .33;
	double radius = .1;
	
	// Move the ball around the drawing window
	while (true) {         	
	    // Clear the screen
            StdDraw.clear();
	        
            // Draw the ball as a filled circle   
	    StdDraw.filledCircle(x, y, radius);     
	    
	    // Display changes, then pause for 10 ms
            StdDraw.show(10);
	}
    }
    
}
```

## Compile and Run

Click on the "Compile" button. You can use the button in the `BouncingBall` window to compile just that class or use the button in the main project window to compile all classes in the project.

When the compilation is successful, right-click (or CTRL-click on Mac) on the `BouncingBall` rectangle in the main project window. A list of methods will appear: select `main`. Press OK on the next window to run the program.

You should see a window appear with a ball in a fixed location.

## Follow the Bouncing Ball

Let's dig into the code and make some improvements.

### The Basic Animation Loop

The program runs an infinite `while` loop. There are three relevant methods:

- `StdDraw.clear()`, to clear the drawing window at the beginning of each loop. This is always the first method called in the animation loop.

- `StdDraw.filledCircle(x, y, radius)` places the ball with its center at `(x, y)` and the specified `radius`.

- `StdDraw.show(10)` draws all changes made during the loop to the window, then pauses for 10 ms. This is always the last method called
in the animation loop. Changing the argument will increase or decrease the frames of animation per second.



### Colors

Let's give the ball a color. Declare three `int` values right after the ball's position, before the main animation loop.

```
int red = 75;
int green = 50;
int blue = 200;
```

Add the following statement right before `StdDraw.filledCircle()`:

```
StdDraw.setPenColor(red, green, blue);
```

Experiment with changing the three values. What effect does this have on the ball?

Colors are represented as red-green-blue triples. Each value is in the range 0-255 (the range of a single byte). Just like mixing paints, mixing the three basic colors in different strengths yields different resulting colors. [Here's a tool](https://htmlcolorcodes.com/color-picker/) you can play with to get the RGB values for any color.

### Motion

Moving the ball is straightforward: change its `(x, y)` position on each iteration of the loop. Declare two more variables at the beginning of the program to represent the ball's velocity:

```
double dx = -.0025;
double dy = .001;
```

Next, inside the animation loop, update the values of `x` and `y`. Make this the last thing you do before calling `StdDraw.show`.

```
x += dx;
y += dy;
```

Run the program. It looks great, but the ball flies off the edge of the screen!

To add reflection, check if the outside of the ball has reached the edge of the screen. If so, reverse the velocity component to make
it move the other way:

```
if ( x + radius >= 1.0 || x - radius <= 0.0) {
    dx = -dx;
}
```

Put this statement right before you update the values of `x` and `y`. Add another `if` statement to get reflection on the top and bottom edges.

### Takeaways

How many parameters are required to describe the ball, its color, and its motion?

What if you wanted to add a second ball? How many additional variables would you need to add? How would you modify the program to deal 
with those extra variables?

What if you wanted a huge number of balls, each with its own position, color, and velocity, and you wanted that number to be determined
at runtime (not hard-coded)? You can't declare independent variables for each ball, because you don't know how many balls there will be, 
and you can't manage hundreds of separate variables in the program.

What we need is a way to **group related variables together**. Does that sound familiar?

## Screen Saver

Take a few minutes to play with the program. You try, for example, changing the color every time the ball hits an edge.

## Object Balls

### A Simplified Main

Make a new class (using `Edit --> New Class`) named `ObjectBall`. We're going to write an **object-oriented version** of the bouncing ball program.

Remove the starter code from `ObjectBall` and paste in the following `main`:

```
public class ObjectBall {

    public static void main(String[] args) {
     
        // Make a new Ball object
        Ball b = new Ball();
        
        while (true) {
            StdDraw.clear();
            
	    // Use the ball's own methods to update its position and draw it to the screen
            b.update();
            b.draw();
            
            StdDraw.show(10);
        }
    }
    
}
```

## Actually Read This Next Part

Here are the key ideas:

- The `Ball` class (which we haven't written yet, but will in a minute) manages all of the state for a single bouncing ball. The seven variables that you had to manage manually in the first part of the program (`x`, `y`, `radius`, `red`, `green`, `blue`, `dx`, and `dy`) are now **wrapped up and encapsulated inside the `Ball` object**.

- The `Ball` defines two methods named `update` and `draw`. Calling `update` makes the `Ball` update its own position and `draw` makes the `Ball` draw itself to the screen using `StdDraw` methods.

- `main` is no longer responsible for managing the data, movement, or drawing of `Ball` objects. Instead, `main` just calls the relevant `update` and `draw` methods, which actually do all the work.

## The `Ball` Class

Make a new class named `Ball`. Fill it with the following code:

```
/**
 * An object representing a bouncing ball
 *
 * @author CMS_167
 */

public class Ball {

    // Instance variables
    double x;
    double y;
    double radius;
    double dx;
    double dy;
    int red;
    int green;
    int blue;
    
    /**
     * Constructor -- set initial values for the Ball
     * 
     * For simplicity, this constructor just assigns default values
     * We could write another constructor that takes values as parameters
     */
    public Ball() {
        this.x = .5;
        this.y = .5;
        this.radius = .05;
        this.dx = .0025;
        this.dy = .005;
        this.red = 50;
        this.green = 10;
        this.blue = 200; 
    }
     
    /**
     * Update -- the Ball updates its own position
     */
    public void update() {
        if (this.x + this.radius > 1.0 || this.x - this.radius < 0.0) {
            this.dx = -this.dx;
        }
        
        if (this.y + this.radius > 1.0 || this.y - this.radius < 0.0) {
            this.dy = -this.dy;
        }
        
        this.x += this.dx;
        this.y += this.dy;
    }
    
    /**
     * Draw -- the Ball draws itself to the graphical window
     */
    public void draw() {
        StdDraw.setPenColor(this.red, this.green, this.blue);
        StdDraw.filledCircle(this.x, this.y, this.radius);   
    }
    
}
```

Compile both classes and run the `ObjectBall` `main` method. You should see the new ball bouncing around the window.

## So You Want to Make Games?

Here's a general strategy for writing simple graphical games.

1. Each *thing* that exists in the game corresponds to a class.

2. Each class has a set of data members that describe its properties. These would be typically location, color, velocity, and maybe 
other things like point values or strength.

3. Each class has an `update` method and a `draw` method. `update` performs the logic to move or otherwise modify the object on each frame of the game. `draw` uses graphics methods to draw the object to the window. Here's the key idea again: **each object manages its 
own data and uses methods to move and draw itself in the correct ways**.

4. `main` runs the basic animation loop, which consists mostly of calls to the `update` and `draw` methods for all of the game objects, plus a little additional logic to check for game ending conditions. **`main` only calls object methods -- it doesn't have to move or draw any game objects**.
