# Variables

## Review

A **variable** is a **name** associated with a **value**.

There are two phases in the life of a variable: **declaration** and **assignment**.

To declare a variable, specify its type and name:

```
int milesPerHour;
double exchangeRate;
```

Recall that Java is a **typed language**, so every piece of data (variable or value) has an associated type. When you compile a Java
program, the compiler will check for any **type errors**, which usually indicate that data is being used in ways that don't make sense
for the declared types.

Variable names start with a lowercase letter. Capitalize any additional words (some programmers call this `camelCase`, because it makes
your variable names look bumpy). Use descriptive names and generally avoid using single letters.

Use the `=` operator for **assignment**. The variable name always goes on the **left side**, and the value or calculation goes on the **right side**. Don't reverse them!

```
milesPerHour = 72;
exchangeRate = 101.25;
```

You can combine declaration and assignment in one statement if it's appropriate:

```
double yen = dollars * exchangeRate;
```

## Instructions

Write a program to answer each of the following questions. Put each program in a separate `.java` file on Codio.

Follow the basic program recipe we outlined in the last class:

- Identify the required inputs and output from the problem description. Remember: a program is a **computational process** that operates
on input data to produce output data. The starting point for designing the right process is to identify the **right inputs and output**.

- For each input and output, **make a comment** stating its name, type, and description. Include any **assumptions** that apply to the input variables.

- Within `main`, declare a variable for each input and the output.

- Write down statements that perform the required calculations to get the correct output value.

- Print the result.

## The `Math` Class

Java contains a bulit-in class called `Math` that provides several useful math features.

It includes a built-in constant value of pi, `Math.PI`, which is defined to be the `double` value closest to the true value of pi.
This is better than using a hard-coded 3.14 in your programs.

Write a program to calculate the area of a circle using `Math.PI`.

## Square Roots

The `Math` class also includes a square root method, `Math.sqrt()`. To use it, pass in the value that you want to take the 
root of, like so:

```
double value = 144.0;
double root = Math.sqrt(value);
System.out.println(root);  // prints 12.0
```

Write a program that calculates the square root of 65536.

## Heron's Formula

Heron's formula calculates the area of a triangle given its three side lengths.

If the triangle has sides `a`, `b`, and `c`, the formula is:

```
area = sqrt(s * (s - a) * (s - b) * (s - c))
```

where `s` is the *semi-perimeter* given by:

```
s = (a + b + c) / 2
```

Write a program that implements Heron's formula. What is the area of a triangle with sides 30, 40, and 50?

Tip: think about the role of `s` in this problem. Is it a basic input? No! It's an **intermediate value** that's calculated from the
basic inputs and used to find the final result.

Tip-Tip: use `Math.sqrt()` to calculate the square root.

## 
