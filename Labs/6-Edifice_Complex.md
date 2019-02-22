# Edifice Complex

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

## Files

Create a new directory named `ForLoopLab` for this lab and put a file into it named `Buildings.java`. You'll write a method for each problem in this lab, so you can put all of your code in `Buildings.java`.

When you open your terminal, use `cd` to change to the directory:

```
cd ForLoopLab
```

Then use `javac` and `java` to compile and run your code:

```
javac Buildings.java
java Buildings
```

## Tower of Power

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


## Tower II

I want to build tower after tower, so I want a tower-printing method. Write a program that completes the method below, then calls it from `main` to print a 1-line tower, a 12-line tower, and a 50-line tower.

```
public static void printTower(int height) {


}
```


## Stairs

Write a program that can print a descending staircase like the one below, using a loop with a variable to control the height.

```
#
##
###
####
#####
```

If the first line is numbered 1, then line `i` contains `i` blocks.

Put your code in a `void` method named `buildStairs`.

Tip: use one outer loop to count through the levels and a second **inner** loop to print the number of blocks on each line.

Tip-Tip: the loop below starts at `level = 0` and runs as long as `level < height`. This is the more common way to do a basic counting loop, rather than starting at 1 and using a `<=` test. This will come up again when we talk about arrays.

```
public static void buildStairs(int height) {
    for (int level = 0; level < height; level++) {

        for ( something that you'll fill in ) {
            System.out.print("#");  // print on the same line
        }
    
        System.out.println();  // go to the next line
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

Write a set of loops that print Mario-style stairs of arbitrary height. Put your code in a `void` method named `buildMarioStairs`.

Tip: the first line has `height - 2` spaces and 2 blocks. The second line has `height - 3` spaces and 3 blocks.


```
public static void buildMarioStairs(int height) {
    int numSpaces = height - 2;
    int numBlocks = 2;

    for (int level = 0; level < height; level++) {

        // Use a loop to print the spaces on the current line
    
        // Use a loop to print the blocks on the current line
    
        // Update the number of spaces and blocks for the next line

    }
}
```


## Look on My Works, Ye Mighty, and Despair!

Write a program that can print pyramids of stars like the following:

```
    *
   ***
  *****
 *******
*********
```

Use a similar strategy as the Mario-stairs program: an outer loop for the levels and two inner loops for the spaces and stars.

The first level has `height - 1` spaces and 1 star. The second has `height - 2` spaces and 3 stars.

Put your code in a method named `buildPyramid`.


## Project Euler #1

Project Euler is a site that hosts a large list of math-based programming problems. This is their first challenge.

Find the sum of all positive integers less than 10000 that are divisible by 3 or 5.

