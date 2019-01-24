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

**`int`** is the basic type for integer numbers. **`double`** is the basic type for decimal numbers.

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

A **`final`** variable can only be assigned one time. Use `final` to implement constants or data that shouldn't change. By convention, constant names are written in ALL CAPS.

```
final int SECONDS_PER_HOUR = 3600;
```

Java includes a library of built-in math routines and constants, called `Math`. The built-in constant value of pi is `Math.PI`.

```
double circleArea = Math.PI * radius * radius;
```

## Instructions

Write a program to answer each of the following questions. Put each program in a separate `.java` file on Codio.

## Concatenation

You can use the `+` operator to print a string and a value at the same time. This is useful when you want to give some context to a print value.

```
double circleArea = Math.PI * radius * radius;
System.out.println("The area of the circle is " + circleArea);
```

Modify the rectangle area program to print an output message like in the example above.


## Smoots II

Recall the story of Oliver R. Smoot from the last lab. The Harvard Bridge (2035 feet in length) was measured to be 364.4 Smoots "plus or minus one ear".

The Burj Khalifa is the tallest tower in the world, measuring 2722 feet to its top spire. What is the height of the Burj Khalifa in Smoots?

Add the string `"plus or minus one ear"` to your output.

Tip: you don't strictly need them for this problem, but please use variables for your calculations.


## Double Math

Recall that all of the data in our Java programs must ultimately be stored on a real, physical computer. This implies that there must be **limitations** for the range and precision of values that can be represented in Java programs.

Print the result of the following calculation:

```
double sum = .1 + .2;
```

What do you see?

This is an example of **rounding error**: floating point numbers (like `double`) can only represent some numbers approximately, so 
calculations involving fractions may have very small errors.

Find another example using `double` arithmetic that doesn't give the exact result you would expect.


## Integer Overflow

Here's a quirk of `int` values. Put the following code in a program and run it. `Integer.MAX_VALUE` is a built-in constant that
represents the biggest `int` number, which is 2,147,483,647.

What happens?

```
int value = Integer.MAX_VALUE;
System.out.println(value);

value = value + 1;
System.out.println(value);
```


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


