# Dice

## Overview

Work in pairs for today's lab.

## Finishing up RPS

In the last class, we put together a program that used the logical `and` operator, `&&`, to test two conditions at the same time:

```
// Test if player chose rock AND computer chose scissors
if (playerMove == 1 && cpuMove == 3) {
    playerWins = true;
}
```

The `&&` operator combines the results of two `boolean` tests. If both tests are `true`, then logical `and` operator evalutes to `true`. If one or both tests are `false`, the logical `and` of the tests is also false. This matches what you would expect the word *and* to mean.

Let's add one more condition to check for input. At the beginning of the program, we asked the user to put in a number 1, 2, 3 or select a move. Add this statement to verify that the input is between 1 and 3:

```
// Report an error if the player's input is less than zero OR greater than three
if (playerMove < 1 || playerMove > 3) {
    System.out.println("That is not a valid choice. Humanity fails at everything.");
    return;
}
```

The logical `or` operator, represented by `||`, returns `true` if **at least one or both** of its inputs are `true`.

Note that you can't test for a range in one statement, like `1 < playerMove < 3`, even though it's common mathematically. You must use
the logical operators to combine the results of more than one test.


## Using `final` Variables for Clarity

Here's one more improvement that you can make to the RPS program. Right now, each move is associated with a number: 1 for rock, 2 for paper, and 3 for scissors. This leads to conditionals like the following:

```
if (playerMove == 1 && cpuMove == 3) {
    playerWin = true;
}
```

This is okay, but we can make the code more readable by using constant variables instead of numbers. Add the following lines to the top of `main`:

```
final int ROCK = 1;
final int PAPER = 2;
final int SCISSORS = 3;
```

Recall that `final` variables can't change once they've been assigned and are traditionally named in ALL CAPS.

Now, you can rewrite the conditional statements with the constant names, which makes it easier to understand what's going on:

```
if (playerMove == ROCK && cpuMove == SCISSORS) {
    playerWin = true;
}
```

## Play RPS

Once you have the RPS program finished, you and your partner can take turns playing a few rounds. Fix any bugs you encounter or any stylistic elements that you don't like.

## Printing an Object

Write a program containing this code fragment and see what happens when you run it.

```
Scanner in = new Scanner(System.in);

// Print a Scanner object -- what's displayed?
System.out.println(in);
```

You should see an output that looks like

```
Scanner@2f92e0f4
```

The exact sequence of letters and numbers will be different.

What's going on? When you print an object, Java prints the class name (`Scanner`, in this case) and the object's **hashcode**, which is based on the address in the computer's memory where the object is stored.

Try modifying your program to create and print a second `Scanner`:

```
Scanner in = new Scanner(System.in);
System.out.println(in);
Scanner in2 = new Scanner(System.in);
System.out.println(in2);
```

You should see that the two `Scanner` objects have different hash codes. They were created by two different calls to the constructor method using the `new` keyword to allocate memory each time. Therefore, even though they are the same class of object, they are stored at **distinct locations in memory**.


## Even or Odd

Write a program that reads an `int` from the terminal and reports if it is even or odd.

```
Enter an integer:
42
42 is even.
```

How can you test for oddness? Use the mod oeprator, `%`, which you might remember returns the remainder after division.

```
13 % 5 returns 3, because that's the remainder when 13 is divided by 5
```

If `x % 2 == 0`, then `x` is evenly divisible by 2 (it has no remainder). If the mod calculation returns 1, then `x` must be odd.


## Cho-Han

*Cho-han* is a traditional Japanese dice game. The rules of the game are simple:

- The player bets if the sum of two six-sided dice will be odd or even.

- If the player's guess is correct, he wins. If not, he loses.

The game appears in Japanese movies set in historical periods, where it's played by *Yakuza* gangsters and wandering samurai.

Write a program for *cho-han*. Your program should prompt the user to choose an even or odd bet, then simulate the roll of two dice and announce if the player was correct.

```
1. Even
2. Odd
Select a bet:
1
The dice are 4 and 3. The sum is 7.
You lose.
```

Tip: you can use the `nextInt` method of the `Random` class to generate a random `int` in the range [1, 6]:

```
import java.util.Random;  // Put this at the top of the program

// In main:
Random rng = new Random();
int die1 = rng.nextInt(5) + 1;  // random value in [0, 5] + 1
int die2 = rng.nextInt(5) + 1;  // random value in [0, 5] + 1
```

## Sic Bo

*Sic bo* ("dice pair") is another dice game of Chinese origin, now available in many American casinos that cater to Asian gamers. The game is similar to craps: players roll three dice and bet on the outcome.

There are a wide variety of possible bets, but the two most common wagers in *sic bo* are "big" and "small".

- The big bet wins if the sum of the three dice is 11 to 17 (including both), but not three-of-a-kind

- The small bet wins if the sum of the three dice is 4 to 10 (including both), but not three-of-a-kind

Write a program for *sic bo* using the big and small bets.

```
1. Big
2. Small
Choose a bet:
2
The three dice are 3, 5, and 1. The sum is 9.
You win!
```

Tip: both bets lose if the result is a triple, so you can test for that first, then move on to the test the sum if the result is *not* a triple. To test for a triple, you need the logical `and` of three comparisons

```
die1 == die2 AND die2 == die2 AND die1 == die3
```
