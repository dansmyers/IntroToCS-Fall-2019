# Conversion

## Overview

This lab will give you the chance to practice writing problems that incorporate user input with the `Scanner` class.

## Review

The following line creates a `Scanner` and saves it to a variable named `in`:

```
Scanner in = new Scanner(System.in);
```

The left-hand side of the assignment statement is a regular variable declaration: the type of the variable is `Scanner` and its name is
`in`. The right-hand side is the **constructor** that creates the new `Scanner` object.

Recall that the `new` keyword is like a **memory-allocation** operation: it tells Java to set aside space in the computer's memory to
hold the `Scanner` object. The constructor method always has the same name as the object's class. Class names in Java always start with
capital letters, and Java is case-sensitive.

The `Scanner` constructor takes one input: the thing that you want to scan. Here, we want to scan from the standard system input,
which is `System.in`. It's also possible to take input from files, Strings, or other sources, but we're only using the standard system 
input right now.

To read from the terminal, use the following statement:

```
String line = in.nextLine();
```

This is another assignment. The left side is a `String` variable named `line`. The right side is a call to `in`'s `nextLine` method, 
which will read one line of text from the terminal. When the user presses ENTER, `nextLine` returns whatever was typed and the statement 
saves it to the `line` variable.

Here is the basic `Echo` program we built last time. The first line uses `import` to get access to `Scanner`.

```
// Read a line from the terminal and echo it back
// CMS 167, Spring 2019

import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type something:");
        String line = in.nextLine();
        System.out.println("You typed: " + line);
    }
 }
```

## Reading a Number

`Scanner` also has methods to read numbers from the terminal, `nextInt` and `nextDouble`. Here's an example:

```
double length = in.nextDouble();
```

Write a program that reads a bridge length in feet from the terminal and prints the length in Smoots (there are about 5.5833 feet in one
Smoot).


## Exceptions

Try typing something into the Smoot converter program that isn't a valid integer, like a word. What happens?

Answer: Java throws a `NumberFormatException`. **Exceptions** are Java's way of dealing with errors that occur at **run-time** (as
opposed to errors that are caught at **compile-time**, before the program runs).

It's possible to write code to **catch** an Exception and handle it in a constructive way, as opposed to simply letting your program 
throw up and die if it gets unexpected input. We'll see examples of that a little later when we talk about file I/O.


## Formatted Output with `printf`

You've probably wondered how to get cleaner output when printing `double` values. For instance, it would be nice to show only the first
two or three decimal places, rather than the ten or so that Java prints by default.

There is a method called `System.out.printf` that can be used to format output values. Here's an example of how it works:

```
System.out.printf("The length in Smoots is %.2f, plus or minus one ear.\n", lengthInSmoots);
```

The first argument to `printf` is a string, which includes special **format specifiers** indicated by the `%` sign. Here, the format
specifier `%.2f` indicates a float value (that's the `f`) displayed to two decimal plcaes. The second argument is the variable that
should be inserted where `%.2f` appears in the output string. The string ends with `\n` because `printf` does not automatically move
to the next line.

Modify your Smoot converter to use `printf` and *three* decimal places of output.

`printf` is also useful if you want to mix text with variables: you can put multiple format specifiers in the string and add multiple
variables, which will be printed in the order they appear. Here's an example that prints three `int` values; `%d` is the format
specifier for `int`.

```
System.out.println("The area of a %d by %d rectangle is %d.\n", length, width, area);
```

## Metrics

Write a program to accept a distance in units of kilometers (using `nextDouble` to read from the terminal) and convert it to patriotic
American miles. 1 mile is about 1.60934 kilometers. Print the result to four decimal places.

The Comrades Maraton in South Africa is the world's oldest and largest ultramrathon race, established in 1921. It is run between the cities of Durban and Pietermaritzburg in South Africa, a distance of about 87 km. 25000 people are expected to participate in 2019. Interestingly, the direction of the race alternates every year, with the course beginning in Durban being mostly uphill and the other direction being mostly downhill.

Use your program to calculate the distance of the Comrades Marathon in miles.


## The Weight

Write a program to read in a weight in kilograms and convert it to pounds. There are about 2.20462 pounds in one kilogram. Display the result to 1 decimal place.

The current world record for weight lifted overhead in the clean and jerk is 263.5 kg, held by Iranian superheavy weightlifter / 
human Coke machine Hossein Rezazadeh:

https://www.youtube.com/watch?v=FOE-PZJq2sk

Use your program to calculate the weight of Rezazadeh's record lift in pounds.


## Randomness

Many programs, including simulations and games, require sequences of **random numbers** to model things that happen by chance.

A program that creates seqeunces of random numbers is called a **pseudorandom number generator** (PRNG). The *pseudo-* part comes in
because the numbers are not truly random; rather, they're being generated by an underlying deterministic algorithm, but in such a way
that they have the same statistical properties as a random sequence.

(https://www.random.org/ is a service that claims to generate *true* random numbers by sampling naturally occurring radio noise in the
atmosphere).

Java has a class called `Random` that can create random number streams. Here's an example of how to use it:

```
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random rand = new Random();  // Constructor!
        
        // Generate a random int between 0 and 99
        int randValue = rand.nextInt(100);
  
        System.out.println(randValue);
    }
}
```

The `nextInt` method generates a random `int` based on its input value. For an input of *N*, it returns a random number in the range 0 
to *N - 1*. Run the program a few times.

Modify the program to generate a random value between 1 and 100, inclusive.


## Guessing Game (ver. .01)

Write a program that asks the user to guess a hidden number, then reports how close the guess was to the true value. Here's an example
of what the output should look like:

```
I'm thinking of a number between 1 and 100 (including both). Can you guess what it is?
Type a number: 45
Your guess is: 45
The number I was thinking of is: 14
You were off by: 31
```

Use the `nextInt` method of the `Random` class to pick the number.

Tip: `Math.abs` can calculate absolute values.
