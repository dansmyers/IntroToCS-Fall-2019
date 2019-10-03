# Edifice Complex

## Setup

Change to your `CMS_167` directory and make a folder named `Lab_5`:

```
cd CMS_167
mkdir Lab_5
cd Lab_5
```

## Tower

Write a program that uses a loop to construct a tower of stars:

```
**********
**********
**********
**********
**********
**********
**********
**********
```

```
/**
 * Tower
 *
 * @author CMS 167
 */
 
public class Tower {

    /**
     * Main
     */
    public static void main(String[] args) {
        
        // Use a counting loop to print an 8-floor tower
    
    }

}
```


## Construction

Now, modify your program to contain `void` method with a parameter that controls the height of the tower. Each line should still have
ten stars.

```
/**
 * Tower
 *
 * @author CMS 167
 */
 
public class Tower {


    /**
     * Print a tower
     *
     * @param  height  the number of lines in the tower
     */
    public static void printTower(int height) {
        // Fill in your code here
    }
    

    /**
     * Main
     */
    public static void main(String[] args) {
        printTower(25);
    }

}
```

## Stairs

Write a program with a method that prints a descending staircase like the one below.

```
#
##
###
####
#####
```

Use a counting loop for the number of lines. Inside that loop, use a second inner loop to print the blocks on each line. Line 
`n` has `n` blocks.

Tip: use `System.out.print("#")` to put one block on a line without going to the next block.

Here's a skeleton:

```
/**
 * Print staircases
 *
 * @author CMS 167
 */
 
public class Stairs {

    /**
     * Print a staircase
     *
     * @param  height  the number of levels in the staircase
     */
    public static void printStairs(int height) {
        int n = 1;
        
        // The outer loop iterates over the levels
        while (n <= height) {
        
            // Use a second inner loop to print a total of n blocks
            // Tip: you need to initialize a second loop index variable
            
            
            n++;
            System.out.println();  // Advance to the next line
        }
        
    }
    
    
    /**
     * Main
     */
    public static void main(String[] args) {
        printStairs(10);
    }

}
```

## Subtraction Game

Here's a mathematical strategy game.

Beginning with a pile of 21 stones, players alternate removing stones until none are left. On her turn, a player may take 1, 2,
or 3 stones. The player who takes the last stone is the winner.

This game is known by a few different names, inluding the Subtraction Game and Nim. 
A version was played on an episode of *Survivor*, where they called it Thai 21.

There are lots of variations:

- Changing the number of stones or the numbers that may be removed on each turn.
- Using multiple piles of stones. In classic Nim, a player may take as many stones as he wants, but from only one pile at a time.
- Playing a *misère* game (French for "destitution"), where the player who takes the last stone *loses*.

Write a program that implements the Thai 21 version of the Subtraction Game. Use the skeleton below to get started.

This program shows a useful strategy for game programs.

- You might think that the best way to handle a two-player game is to put both player's turns inside the the loop: on each iteration,
have player 1 make a move, then have player 2 make a move.

- This works, but it makes ending the loop tricky, because you don't want to do player 2's turn if player 1 wins.

- Here, we're going to use the loop to play just one turn. A variable keeps track of which player's turn it is.

- If the current player *doesn't* win, switch to the other player for the next pass through the loop.

```
/**
 * Subtraction Game
 *
 * @author CMS 167
 */

import java.util.Scanner;

public class SubtractionGame {

    /**
     * Read and return an int from the terminal
     *
     * @return  an int typed by the user
     */
    public static int readInt() {
    
    }
    
    
    /**
     * Main
     */
    public static void main(String[] args) {
    
        boolean playing = true;  // Guard variable
        int stones = 21;
        int player = 1;
        
        while (playing) {
        
            System.out.println();
            System.out.println("Stones: " + stones):
            System.out.println("It's your turn, Player " + player + ".";
            System.out.println("Take 1, 2, or 3 stones from the pile.");
            
            // Use readInt() to get the player's move
            int move = readInt();
            
            // Reduce the number of stones
            
            // Check the winning condition
            // If there are 0 stones, print a winning message and set playing = false;
            
            // If the current player didn't win, switch to the other player
        
        }
        
    }

}

```

## Input Checking Loop

Modify your program to use a loop to require the user to put in a valid input. Put this inside the main game loop.

Look carefully at this code. How does it work?

```
boolean gettingInput = true;
int move;

while (gettingInput) {
    // Use readInt to get the player's move
    move = readInt();
    
    if (move >= 1 && move <= 3 && move <= stones) {
        gettingInput = false;
    } else {
        System.out.println("You can't take that many stones.");
    }
}
```

## Look On My Works, Ye Mighty, and Despair!

![](https://upload.wikimedia.org/wikipedia/en/1/1c/Iron_Maiden_-_Powerslave.jpg)

https://www.poetryfoundation.org/poems/46565/ozymandias

Write a program that can print pyramids of stars like the following:

```
    *
   ***
  *****
 *******
*********
```

Use three loops:

- An outer one for the levels
- An inner one that prints the spaces on each line
- A second inner one that prints the stars on each line

Tip: the first level has `height - 1` spaces and 1 star. The second has `height - 2` spaces and 3 stars.

```
/**
 * Construct pyramids
 *
 * @author Pharaoh Ramses II
 */
 
public class Pyramids {

    /**
     * Print a pyramid of stars, a monument to my greatness
     *
     * @param  height  the heigh of my monument
     */
    public static void printPyramid(int height) {
        int spaces = height - 1;
        int stars = 1;
        
        int n = 1;
        
        while (n <= height) {
        
            // Use an inner loop to print the spaces
            
            // Use a second inner loop to print the stars
            
            // Update the number of spaces and stars for the next line
            

            n++;
            System.out.println();  // Advance to the next line
        }
        
    }
    
    
    /**
     * Main
     */
    public static void main(String[] args) {
        printPyramid(12);
    }

}

```

## Hoard

Of course, my pyramid must be hollow to hold all of the treasure that will be buried to accompany me to the Afterlife.

Write a program with a `printHollowPyramid` method that prints pyramids like the following:

```
    *
   * *
  *   *
 *     *
*********
```

## Super Pyramids

Now make your pyramids look like this:

```
    *
   * *
  * * *
 * * * *
* * * * *
```

Hint: think about printing a number of `"* "` strings (star followed by a space).
