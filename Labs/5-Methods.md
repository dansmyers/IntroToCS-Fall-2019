# Methods

## Is It Me You're Looking For?

Write a program named `Hello100.java` that contains four methods:

- `sayHello`, which will print `Hello!` to the screen.

- `sayHello5Times`, which calls `sayHello` five times.

- `sayHello25Times`, which calls `sayHello5Times`.

- `sayHello100Times`, which calls `sayHello25Times`.

All of the methods should have the return type `void`, because they do not produce any outputs.

Here is the class definition and `main`:

```
public class Hello100 {

    //*** Put method definitions above main ***//

    public static void main(String[] args) {
        sayHello100Times();
    }

}
```

## Say Whatever

Create a new called `Whatever100.java`. The methods it contains should be the same as `Hello100`, but each method should take an input `String` that it prints.

```
public class Whatever100 {
    
    public static void sayWhatever(String message) {
        System.out.println(message);
    }
    
    //*** Add other methods here ***//
    
    public static void main(String[] args) {
        sayWhatever100Times("");
    }
 
}
```


## Coin

Write a program named `Chance.java` that contains a method named `coinToss` that randomly returns either 0 or 1. The return type of the method will be `int`.

```
public class Chance {

    //*** Put method definitions above main ***//

    public static void main(String[] args) {
        
        // Flip some coins
        System.out.println("Toss 1 = " + coinToss());
        System.out.println("Toss 2 = " + coinToss());
        System.out.println("Toss 3 = " + coinToss());
        
    }
}
```


## Call Me The Tumbling Dice

Add two new methods to your `Chance` class:

- `rollDie`, which returns a randomly chosen `int` 1 through 6.

- `sumOfTwoDice`, which calculates and returns the sum of two dice using `rollDie`.

Both methods will return `int` values. Add code to `main` to test these methods.


## Take a Chance on Me

Now use the methods you have written to create a simple game:

- Flip the coin and roll the sum of two dice.

- The player wins if the coin is 0 and the sum is even, or if the coin is 1 and the sum is odd. Any other combination loses.

Here's a tip:

Sometimes you need to comment out large blocks of code. Here, for example, you might want to comment out your old test code and put the logic for the game in `main`. Rather than commenting out each line using `//`, you can use the **block comment**:

```
/*
  This is a block comment.
  
  Java ignores eveything in between the slash-star and star-slash, even
  newlines and blank lines.
*/


/*
 * Block comments can be used for descriptions at the top of programs.
 *
 * It can be nice to add extra stars to show what's part of each block.
*/
```


## Even-Odd

Here is a method-based version of the Even-Odd dice game. Add in the methods that will complete the class:

```
import java.util.Scanner;

public class EvenOdd {

    //*** Declare methods above main ***//
    
    public static void main(String[] args) {
    
        // Print options of 1 for the odd bet and 2 for the even bet
        printChoices();
        
        // Read the users's choice
        int choice = readChoice();
        
        // Test for bad input if choice is not 1 or 2
        // Remember: || is logical OR and ! is logical NOT
        if (!(choice == 1 || choice == 2)) {
            System.out.println("Sorry, that's not a valid choice.");
            return;  // Leave main and end program
        }
        
        // Roll the two dice
        int roll = sumOfTwoDice();
        System.out.printf("The roll is %d.\n", roll);
   
        // Test for outcome
        if ((choice == 1 && roll % 2 != 0) || (choice == 2 && roll % 2 == 0)) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose...");
        }
    }

}
```

Points to consider:

- The `readChoice` method should create a `Scanner` and read and return a single `int`.

- Look carefully at the two `if` statements: how do their tests work?

- Using `sumOfTwODice` returns the sum, but doesn't give the individual dice values. A method can only return one value, so there's no way to get the sum and the individual dice from one method. If you want to the individual dice, you could modify `main` to call `rollDie` two times.
