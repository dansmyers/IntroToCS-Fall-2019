# We Use Computers To Make Videogames

## Description

This lab will introduce the amazing world of **graphical output**. We'll be able to write programs that **make things appear on the screen**. In a few more days, we'll learn about taking input from the keyboard and using it to control our graphical creations.

To implement this, we're going to introduce two more tools. The first is a library called `StdDraw.java`, which includes a bunch of basic drawing methods. The second is a different editor called *BlueJ*. It's technically possible to use Codio for graphics, but it's complicated and doesn't work on every platform. BlueJ runs on your local computer.

`StdDraw.java` was originally written by Robert Sedgwick and Kevin Wayne for their book *Introduction to Programming in Java* and is used with permission.

## Get BlueJ

Go to (www.bluej.org)[the BlueJ homepage]. Download the appropriate version for your operating system (Mac or Windows). Open the ZIP file into a location that you can remember. Click on the BlueJ logo to launch the program.

**If you get an error about Java's JDK**, let me know. You probably need to download a JDK ("Java Development Kit") from (https://www.oracle.com/technetwork/java/javase/downloads/index.html)[this site].

The first thing you need to do is create a **project**. From the main BlueJ screen, go to Project --> New Project. In the panel that appears, use the "Choose" button to select a directory where you want to put your BlueJ projects. Then type a name for the project like `CMS_167_Graphics_Lab` and hit OK.

## Classes

Step 1: import `StdDraw.java`. Go on to Blackboard and navigate to the Course Documents section of CMS 167. Download the `StdDraw.java` file.

In BlueJ, go to Edit --> Add Class From File. Select the version of `StdDraw` that you just downloaded and it will show up in the project panel as a new labeled rectangle.

Step 2: make a new class. Go to Edit --> New Class. Name the class `BouncingBall` (BlueJ will automatically append the `.java` suffix). Keep the selection boxes on `Java` and `Class`. When you hit OK, you'll see `BouncingBall` appear as a new rectangle in the project window.

Click on `BouncingBall` to open its code. BlueJ populates the class with a default bit of code. Remove that, then put the following code into the window:

```
// A class that implements a bouncing ball
// CMS 170, Spring 2019

// Uses the static methods in StdDraw.java

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
