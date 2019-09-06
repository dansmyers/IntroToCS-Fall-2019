# Variables Practice Problems


Life on Mars
------------
The Martian day is about 2.7% longer than an Earth day.

How many Earth seconds are in a Martian day? Use variables with descriptive names for all
the quantities in your program.

Tip: to make a number 2.7% larger, multiply it by 1.027.


Division Bell
--------------
Calculate 15 / 4 using Java. What did you get? Is that right?

Try another one: 21 / 5. What does Java give? What is the correct
answer?

What does Java do if you divide two whole numbers? Try some more
examples if you need to.

**ANSWER THE QUESTION BEFORE READING AHEAD**

Java makes a distinction between integer division, where both
arguments are whole numbers, and regular division, where at least
one number contains a decimal point.

When you divide two integers, whether whole numbers or `int` variables, Java always truncates the result,
rounding it down towards zero.

Try calculating 15.0 / 4 and 15 / 4.0 and verify that those
expressions yield the correct answers.

Take-away: unless you **know** that you need integer division, always use a `double` variable or include decimal
points in your numbers when performing division.


Temperature Conversion
----------------------
A classic example.

To convert a temperature of *F* degrees Fahrenheit into Celsius, use

```
C = (F - 32) * (5 / 9)
```

Write a program that can perform this temperature conversion. What is
the conversion for 85 degrees Fahrenheit?

Hint: make sure you don't get zero!


Number Fail
-----------
Recall that all of the data in our Java programs must ultimately be stored on a real, physical computer. This implies that there must be **limitations** for the range and precision of values that can be represented in Java programs.

Print the result of the following calculation:

```
double sum = .1 + .2;
```

What do you see?

This is an example of **numerical error**: floating point numbers (like `double`) can only represent some numbers approximately, so 
calculations involving fractions may have very small errors.

Find another example using `double` arithmetic that doesn't give the exact result you would expect.
