# Carnival of Methods

## Whatever You Say

Complete the class below to write a program that prompts the user for input, then repeats whatever they typed 100 times.

```
/**
 * Echo typed input back 100 times
 *
 * @author CMS 167
 */

import java.util.Scanner;

public class Echo100 {
 
    /**
     * Read and return a line of text using Scanner
     *
     * @return  the input String
     */
    public static String readLine() {
        // TODO: create a new Scanner
        // TODO: use the Scanner's nextLine method to read and return a String
    }
    
    
    /**
     * Echo an input message one time
     *
     * @param  message  the input String
     */
    public static void echoOneTime(String message) {
        System.out.println(message);
    }
    
    
    // TODO: add a method to echo 4 times using echoOneTime()
    
    
    // TODO: add a method to echo 20 times
    
    
    // TODO: add a method to echo 100 times
    
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        String line = readLine();
        echo100Times(line);
    }

}

```

## Sic Bo

Sic bo ("dice pair") is a dice game of Chinese origin, now available in many American casinos that cater to Asian gamers. The game is similar to craps: players roll three dice and bet on the outcome.

There are a wide variety of possible bets, but the two most common wagers in sic bo are "big" and "small".

- The big bet wins if the sum of the three dice is 11 to 17 (including both), but not three-of-a-kind
- The small bet wins if the sum of the three dice is 4 to 10 (including both), but not three-of-a-kind

Write a program for sic bo using the big and small bets.

```
1. Big
2. Small
Choose a bet:
2
The three dice are 3, 5, and 1. The sum is 9.
You win!
```

Tip: both bets lose if the result is a triple, so you can test for that first, then move on to the test the sum if the result is not a triple. To test for a triple, you need the logical and of three comparisons

```
die1 == die2 && die2 == die3 && die1 == die3
```

Use the skeleton below as a starting point for your program. Fill in code and complete the headers for the methods, then write a `main` that uses the other methods to implement the game.

```
/**
 * Sic Bo
 *
 * @author  CMS 167
 */

import java.util.Scanner;

public class SicBo {

    /**
     * Generate a six-sided die roll
     *
     * @return  a random int in the range [1, 6]
     */
    public static int sixSidedDie() {
        // TODO: fill in code to generate a return a six-sided die roll
    }
    
    
    /**
     * Test if three dice are a triple
     *
     * COMPLETE THIS HEADER WITH THREE @param AND AN @return
     */
    public static boolean isTriple(fill in three parameters for this method) {
        // TODO: check if the three dice are the same
    }
    

    /**
     * Read an int from the terminal using Scanner
     *
     * COMPLETE THIS HEADER
     */
    public static int readInt() {
        // TODO: Create a new Scanner
        // TODO: Read and return an int
    }


    /**
     * Print the welcome message and instructions
     */
    public static void printInstructions() {
        // TODO: add code to print welcome message and bets
    }
    
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        printInstructions();
        
        // Read the player's bet
        int bet = readInt();
        
        // TODO: call sixSidedDie() three times to simulate three rolls
        
        // TODO: check if the three dice are a triple
        // If so, print a losing message and return
        
        // TODO: if the sum is big and the player's bet is 1, print winner
        
        // Else if the sum is little and the player's bet is 2, print winner
        
        // Else, print losing message
    }
    
}
```


## Chuck-a-Luck

An old-time carnival game.

- The player bets on a number 1 to 6, then rolls three dice.
- If the number comes up one time, the player wins $1.
- If it comes up two times, the player wins $2.
- If it comes up three times, the players wins $3.
- If it does not come up at all, the player loses $1.

Fill in the skeleton below to implement chuck-a-luck. Use Javadoc-style headers for every method.

```
/**
 * Chuck-a-Luck
 *
 * @author  CMS 167
 */
 
import java.util.Scanner;

public class ChuckALuck {

    // TODO: add a method to generate and return a six-sided die roll
    
    
    // TODO: add a method to read and return an int from the terminal


    // TODO: add a void method to print instructions


    /**
     * Main
     */
    public static void main(String[] args) {
    
        // Print the welcome message and instructions
        printInstructions();
        
        // Read the player's bet
        int number = readInt();
        
        // Test for up to three successes on three die rolls
        //
        // Strategy: use a variable to count the number of successes
        //
        // Call sixSidedDie() to generate a random roll, then check if it matches the player's number
        // If so, add one success
        // Repeat two more times to simulate all three die rolls
        
        int successes = 0;
        
        if (sixSidedDie() == number) {
            successes += 1;  // += is a shorthand way of adding 1 to a variable
        }
        
        // TODO: add two more if statements to check two more die rolls
        
        // TODO: check the final number of successes and report the outcome
        
    }
}

```

## One-Armed Bandit

Write a slot machine game.

- Generate three random numbers between 1 and 9, including both
- If all three numbers are the same, print `Jackpot!`
- If two of the three numbers are the same, print `Winner!`
- If neither condition is satisfied, print `Better luck next time!`

There is no required user input.

There's no skeleton for this program: choose and implement your own methods. Give each method a Javadoc-style header and include a header for the entire class, like in the previous problems.

(You could do the entire program in `main`, but I want you to break some of the work up into methods as a design exercise.)

```
Welcome to the Slot Machine!
Spinning three numbers...
5 1 5
Winner!
```
