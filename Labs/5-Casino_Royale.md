# Casino Royale

## Overview

Our goal for today's lab is to begin working on your next project: an electronic casino program.

Here's how it will work:

- The user is presented with a menu of game choices and picks one.

- Each game has an associated method, which implements all of the behaviors and rules for the game.

- There will also be a few support methods to handle generating random numbers, etc.

Here is an example of one complete run of the program:

```
Welcome to the Casino!
1. Even-Odd
2. Slots
3. Matching Pennies
4. Sic Bo
5. 
Please select a game:
1

Welcome to Even-Odd!
I'll roll two dice and check if their sum is even or odd.
If that matches your bet, you win!
1. Even
2. Odd
Please select a bet:
1
The dice are 3 and 5.
You win!
```

I'll give you the complete specs and rules for each game when the next project is assigned. Our goal for today is to lay out the basic structure of the program and complete the first game together.

## Strategy: Stepwise Refinement

Part of the challenge of writing larger programs is coming up with a plan and keeping it organized as you develop. It's often easy to write code if you know what the program is supposed to do, but figuring out **the next step to take** is often the most challenging part of programming.

**Stepwise Refinement** is a strategy for building larger programs. Here's how it works.

First, start with the `main` method and write down, in plain words, the high-level steps the program should take. Here's one way this could happen in the `Casino` class:

```
public class Casino {

    public static void main(String[] args) {
    
        // Print the welcome message and list of games
    
        // Read the user's game choice
    
        // Select and play the chosen game
    }
}
```

Note: **there isn't a single best way to do this**, which is kind of frustrating, but also liberating. The key idea is to start with a high-level description of what you want the program to do, without worrying about Java statements, and then make it more specific.

Now, make a method call for each one of your high-level steps.

```
public class Casino {

    public static void main(String[] args) {
    
        // Print the welcome message and list of games
        printWelcomeMessage();
    
        // Read the user's game choice
        int choice = readNumber();
    
        // Select and play the chosen game
        playGame(choice);
    }
}
```

The original problem, which might have seemed to big, is now broken up into three method calls. Two of these, `printWelcomeMessage` and `readNumber` are fairly straightforward: we know how to print messages and read input.

The last, `playGame`, seems more complex, but we can also approach developing it in a stepwise fashion.

## The First Two Methods

Write code for the `printWelcomeMessage` and `readNumber` methods.

A couple of notes:

- Other parts of the program will require reading numbers, so the `readNumber` method can be used again. It must return an integer value, so its return type is `int`.

- `printWelcomeMessage` only contains print statements, so its return type is `void`.

```
import java.util.Scanner;

public class Casino {

    //*** Print the welcome for the casino and list of games ***//
    public static void printWelcomeMessage() {
    
    
    }


    //*** Read and return a number from the console ***//
    public static int readNumber() {
    
        // Create a Scanner for System.in
        
        // Read the nextInt
        
        // Return what you read
        
    }


    public static void main(String[] args) {
    
        // Print the welcome message and list of games
        printWelcomeMessage();
    
        // Read the user's game choice
        int choice = readNumber();
    
        // Select and play the chosen game
        playGame(choice);
    }
}

```

Once you've implemented those two methods, test your code by running what you have. Make sure that it does what you expect before you develop any more.

**Always develop incrementally**. A good strategy is to test the program after every new method that you write.


## Player of Games

Let's add the `playGame` method.

```
import java.util.Scanner;

public class Casino {

    //*** Print the welcome for the casino and list of games ***//
    public static void printWelcomeMessage() {
    
    
    }


    //*** Read and return a number from the console ***//
    public static int readNumber() {
    
        // Create a Scanner for System.in
        
        // Read the nextInt
        
        // Return what you read
        
    }
    
    
    //*** Invoke a method to play the chosen game ***//
    public void playGame(choice) {
        if (choice == 1) {
            playEvenOdd();
        } else {
            System.out.println("Please enter the number of a game.");
        }
    }


    //*** Main ***//
    public static void main(String[] args) {
    
        // Print the welcome message and list of games
        printWelcomeMessage();
    
        // Read the user's game choice
        int choice = readNumber();
    
        // Select and play the chosen game
        playGame(choice);
    }
}
```

The structure of `playGame` is straightforward: it takes an integer as input and uses the integer to run a method that corresponds to the game the user wants to play. Right now, the only choice is Even-Odd, but we can add `else if` blocks for the other options.

## Next Steps

Now the strategy of the program becomes clearer:

- Implement the `playEvenOdd` method to add that game.

- Add another choice to `playGame` and then implement its game's method.

- Keep doing this until you have methods for every game.
