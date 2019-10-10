# More Loops

## Setup

```
cd CMS_167
mkdir Lab_6
cd Lab_6
```

## FizzBuzz

If you apply for a software engineering job, it's common to have to pass a **TECHNICAL INTERVIEW**, which can include solving programming
problems on a computer or on a whiteboard.

This is one of the classic programming interview problems that was originally proposed as a check to see if candidates who claimed to be
experienced could actually code.

Print the numbers 1 through 30, except

- For numbers divisible by 3, print `Fizz`
- For numbers divisbile by 5, print `Buzz`
- For numbers divisible by 3 and 5, print `FizzBuzz`

Here is some example output:

```
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
```

Use a `for` loop with an `if - else if - else if - else` block inside it.

## Multiplication Table

Use a pair of `for` loops to print a 12 x 12 multiplication table.

## Baby Needs a New Pair of Shoes

What is the average value obtained by rolling two dice?

One way to solve this problem is to reason about the underlying probabilities. Another way is to simply **simulate** a large number
of dice rolls and calculate the average from the simulated results. With high probability, the simulated average should be a close
approximation of the true average.

This type of program is called a **Monte Carlo simulation**, named after the famous Monte Carlo casino complex in the tiny
European principality of Monaco.

Fill in the `main` of the program below. Use a `for` loop to call `simulate` 1000 times and add up the results of all the simulated
die rolls. At the end of the program, calculate the average over all 1000 trials.

```
/**
 * Simulate rolling two dice
 *
 * @author CMS 167
 */
 
import java.util.Random;
 
public class AverageOfTwoDice {

    /**
     * Static random number generator
     */
    public static Random rng = new Random(0);


    /**
     * Simulation method: roll two dice and return their sum
     *
     * @return  the sum of two dice as a int
     */
    public static int simulate() {
        int die1 = rng.nextInt(6) + 1;
        int die2 = rng.nextInt(6) + 1;
        return die1 + die2;
    }
    
    
    /**
     * Main
     */
    public static void main(String[] args) {
        int sumOfSimulations = 0;
        int numTrials = 1000;
    
        // Use a for loop to call simulate 1000 times
        // Accumulate all of the results in sumOfSimulations

       
        // Calculate and print the average die roll
        // The answer should be about 7.0
    }

}
```


## Passe-Dix Again

Recall the pass-dix game:

- Roll three dice
- The player wins if the sum is greater than 10 and loses if the sum is less than or equal to 10.

Use a simulation program to estimate the odds of winning at passe-dix. Use the code below as a starting point. Here, the `simulate`
method returns `true` or `false`, based on whether the player won that particular simulated trial. The `main` method calls `simulate`
1000 times in a loop, keeping count of the number of trials that result in a win. The winning percentage is then `numWins / 1000`.

```
/**
 * Simulate playing passe-dix
 *
 * @author CMS 167
 */
 
import java.util.Random;
 
public class AverageOfTwoDice {

    /**
     * Static random number generator
     */
    public static Random rng = new Random(0);


    /**
     * Simulation method: roll three dice and return their sum
     *
     * @return  true if the player wins, false otherwise
     */
    public static boolean simulate() {
        // Simulate the roll of three dice
        
        // Return true if sum > 10
        
        // false otherwise
    }
    
    
    /**
     * Main
     */
    public static void main(String[] args) {
        int numWins = 0;
        int numTrials = 1000;
    
        // Use a for loop to call simulate 1000 times
        // Keep count of the number of simulations that return true

       
        // Print the fraction of simulations that resulted in a win
        double winPercent = numWins / 1000.0;
        System.out.println(winPercent);
    }

}
```

## If They're the Super Mario Brothers, Does That Mean His Name is Mario Mario?

At the end of each level in the original *Super Mario Bros.*, Mario jumps up a stair like the following:

```
     ##
    ###
   ####
  #####
 ######
#######
```

Write a set of loops that print Mario-style stairs of arbitrary height. Put your code in a `void` method named `printMarioStairs`.

Tip: the first line has `height - 1` spaces and 2 blocks. The second line has `height - 2` spaces and 3 blocks.

```
/**
 * Build Mario-style stairs
 *
 * @author CMS 167
 */
 
public class MarioStairs {

    /**
     * Print a staircase
     *
     * @param  height  the number of levels in the staircase
     */
    public static void printMarioStairs(int height) {
        int numSpaces = height - 1;
        int numBlocks = 2;

        for (int level = 0; level < height; level++) {

            // Use a loop to print the spaces on the current line
    
            // Use a loop to print the blocks on the current line
    
            // Update the number of spaces and blocks for the next line
        }
    }
    
    
    /**
     * Main
     */
    public static void main(String[] args) {
        printMarioStairs(20);
    }

}
```

## Craps

The most popular dice game in American casinos, craps allows players to make an extensive array of bets. The most common
is called the "pass" bet, and it works as follows:

- A player (the "shooter") rolls two six-sided dice.

- If their sum is 7 or 11, the bet immediately wins. If the sum is 2 ("snake eyes"), 3, or 12 ("boxcars" or "midnight"), the bet immediately loses.

- If the sum is any other number, that number becomes the *point*.

- The shooter continues rolling the dice with the goal of rolling the point value again before rolling a 7. If the point comes up first, the bet wins; if a 7 comes up first, the bet loses. The shooter will re-roll as many times as required until either the point or 7 comes up.

Write a simulation program to estimate the probability of winning the pass bet in craps.

Tips:

- Use a `simulate` method and `main` method, like in the previous problem. The `simulate` method should complete one round of craps and return `true` or `false` to indicate whether the pass bet won or lost on that round.

- Within the `simulate` method, roll two dice and check their sum. If the result is 7, 11, 2, 3, or 12, you can return the result immediately. If the result is anything else, use a `while` loop to implement the second phase of the bet.

- Run 1000 trials.

Hint: your answer should be about 49%.

