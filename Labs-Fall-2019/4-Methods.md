# Methods

## Tips



## Sic Bo

Sic bo ("dice pair") is another dice game of Chinese origin, now available in many American casinos that cater to Asian gamers. The game is similar to craps: players roll three dice and bet on the outcome.

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

Use the skeleton below as a starting point for your program:

```
/**
 *

```
