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
Try the following calculation. Does it yield the EXACT correct result?

```
System.out.println(.1 + .2);
```

Java must store all of its data in a real physical computer. Because
of the limitations of the physical machine, the data types used to
represent fractional numbers may have very small errors, which can
lead to tiny inaccuracies in calculations involving decimal values.

Experiment and find another calculation that gives a small numerical
error.
