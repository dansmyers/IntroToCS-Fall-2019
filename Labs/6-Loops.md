# Loops

## Overview

This lab will let you practice writing programs that use the `for` loop.

Recall: the `for` loop is used when you have a block of code that you want to run a fixed number of times. Here is a basic `for` loop that adds up the numbers from 1 to 999:

```
int sum = 0;

for (int i = 1; i < 1000; i++) {
    sum = sum + i;
}
```

The loop declaration has three parts.

1. The declaration of a **loop index variable**. It's very common for this to be `i` or another single letter, but it can be any variable name. In the programs we write, the index variable will always be an `int`.

2. The **continuation condition**, which is a test that controls how many times the loop executes. The loop executes as long as the condition evaluates to `true`.

3. The **update statement**, which changes the value of the index variable after each iteration. The most common update is `i++`, which is short for `i = i + 1`.

In this example, the variable `sum` is used as an **accumulator**: it adds up all the values of `i` for every iteration of the loop. The statement

```
sum = sum + i;
```

can be read as "take the current value of `sum`, add the current value of `i`, and put the result back into `sum`".

## Tower

Write a program that uses a `for` loop to print a tower like the following:

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

I'd also like to be able to control the height of the tower using a variable, so I can make bigger or smaller towers depending on how my day is going. Modify your loop to use a variable to control the number of iterations.


## Tower of Power

I want to build tower after tower, so I want a tower-printing method. Write a program that completes the method below, then calls it from `main` to print a 1-line tower, a 12-line tower, and a 50-line tower.

```
public static void printTower(int height) {


}
```


## Stairs

Write a program that can print a descending staircase like the one below:

```
#
###
#####
#######
#########
###########
```


## Baby Needs a New Pair of Shoes

Write a loop that simulates 10000 rolls of a six-sided die and reports their average.

To generate the rolls create a method that returns an `int` in [1, 6]:

```
public static int rollDie() {

    // Generate and return an int in [1, 6]

}
```

Your simulation loop (in `main`) should run for 10000 iterations. On each iteration, call `rollDie` and add the result to an accumulated `sum` variable. After the loop ends, divide the `sum` by 10000 to get the average.

Tip: use a `double` value for the average because it might not be a whole number.

Once you have the result, modify your program to find the average of rolling two dice. This should require only a tiny change of one or two lines.

