# Challenge Project: Project Euler

## Overview

In this challenge project, you'll complete some problems from [Project Euler](http://projecteuler.net), a site that hosts a lot of interesting mathematical programming challenges.

If you successfully complete all three problems, your final grade will be increased by one part of a letter (e.g. B to B+). Remember that you can also use this project to raise your letter grade if you've lost credit for any reason.

The project description is simple: solve any three problems from the [Project Euler problem list](https://projecteuler.net/archives).
We already did Problem 1 as an example in class, so that one doesn't count.

## Grading

There are no automated tests for this project. To get credit, come show me your code and talk through the approach you used to solve
each problem.

You can get credit any time before the end of the day on December 6 (the last day of classes), but please plan ahead so that we don't have a traffic jam of people trying to turn in projects at the last minute.

## Example Problems

These are three of my favorite problems from the list, along with a few tips for solving them. You can complete these or pick different ones that interest you.


### Smallest Multiple (Problem 5)

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

### 10001st Prime (Problem 7)

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?

Tips:

The basic strategy is something like this:

```
int n = 2;
int numPrimes = 0;

while (true) {
    if (isPrimes(n)) {
        numPrimes++;
    }
    
    if (numPrimes == 10001) {
        System.out.println(n);
        break; 
    } else {
        n++;
    }
}
```

Think about how to test if a number is prime. The straightforward way is to test for divisibility by any numbers between 2 and sqrt(n). This could be slow though, because you'll spend a lot of time grinding through numbers.

A faster way is to use an array to keep track of the primes you find. It's then sufficient to test for divisibility by the **primes** 
that are less than sqrt(n).

You can try the straightforward solution first. If it runs for more than, say, a minute, try implementing the faster solution.

### Longest Collatz Sequence (Problem 14)

The following iterative sequence is defined for the set of positive integers:

```
n → n/2 (n is even)
n → 3n + 1 (n is odd)
```

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proven, it is thought
that all starting numbers finish at 1. This result is known as the **Collatz Conjecture** after the mathematician Lothar Collatz.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

![](https://imgs.xkcd.com/comics/collatz_conjecture.png)

Tips:

- Use a method called `collatz(int n)` that returns the **number of terms** in the sequence starting with `n`.

- The collatz method uses a `while` loop to generate terms of the sequence until it terminates at 1, counting the number of terms that 
are generated.

- Use a loop to call `collatz` for all values of `n` from 1 to 1 million and keep track of the value of `n` that generates the longest
sequence.
