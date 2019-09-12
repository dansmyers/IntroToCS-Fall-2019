# Variables and Input

McChocolate Potatoes
--------------------
The Japanese yen currently trades for about $.0094.

I'm a sucker for regional fast food items. It turns out that you can get **chocolate fries** at [McDonald's in Japan](https://www.eater.com/2016/1/19/10790586/mcdonalds-chocolate-fries-japan) (they are officially known
as "McChocolate Potatoes"). Are they any good? Maybe not, but they cost only 330 yen.

What is the cost of a side of chocolate fries in dollars? Print your result to two decimal places.

Put your program in a file named `ChocolatePotatoes.java`.

Tips:

- Use a `final double` variable to store the conversion factor.

- Use `System.out.printf("%.2f", priceInDollars)` to print a `double` value to two decimal places.

- You don't need to use a `Scanner` to read from the terminal for this problem.


Division Bell
--------------
Calculate 15 / 4 using Java. What did you get? Is that right?

Try another one: 21 / 5. What does Java give? What is the correct
answer?

What does Java do if you divide two whole numbers? Try some more
examples if you need to.

**ANSWER THE QUESTION BEFORE READING AHEAD**

Java makes a distinction between *integer division*, where both
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

Write a program that can read in an integer temperature in degrees Fahrenheit and convert 
it to degrees Celsius. Print the result to one decimal place.

Make sure you don't get zero!

Put your program in a file named `Temperature.java`.

Tips:

Create a `Scanner` using

```
Scanner input = new Scanner(System.in);
```

You can read an integer value using

```
int tempInF = input.nextInt();
```


Number Fail
-----------
Recall that all of the data in our Java programs must ultimately be stored on a real, physical computer. This implies that there must be **limitations** for the range and precision of values that can be represented in Java programs.

Write a program that prints the result of the following calculation:

```
double sum = .1 + .2;
```

What do you see?

This is an example of **numerical error**: floating point numbers (like `double`) can only represent some numbers approximately, so 
calculations involving fractions may have very small errors.

Find another example using `double` arithmetic that doesn't give the exact result you would expect.


## Comrades

Write a program that can read in a number of kilometers as input and print the corresponding number of miles. There are
1.60934 kilometers in one mile.

The Comrades Maraton in South Africa is the world's oldest and largest ultramrathon race, established in 1921. 
It is run between the cities of Durban and Pietermaritzburg in South Africa, a distance of about 87 km. 
25000 people are expected to participate in 2019. Interestingly, the direction of the race alternates every year,
with the course beginning in Durban being mostly uphill and the other direction being mostly downhill.

What is the length of Comrades Marathon in miles?

Tips:

- Use `nextInt` to read an integer number of kilometers from the terminal.

- Use a `final` variable to store the magic conversion number.

- Use `System.out.printf` and print the result to four decimal places.


## Mystery Operator

Java supports a special operator, `%`, which is called the **modulus operator**.

Try some calculations using the modulus operator:

```
System.out.println(7 % 3);
System.out.println(12 % 5);
System.out.println(19 % 7);
```

Can you figure out what the mod operator does?

Hint: it has something to do with division.


## Overflow

Here's another quirk of `int` values. Put the following code in a program named `Overflow.java` and run it. `Integer.MAX_VALUE` is a built-in constant that represents the biggest `int` number, which is 2,147,483,647.

What happens?

```
int value = Integer.MAX_VALUE;
System.out.println(value);

value = value + 1;
System.out.println(value);
```

## The Weight

Write a program to read in a weight in kilograms and convert it to pounds. There are about 2.20462 pounds in one kilogram.
Display the result to one decimal place.

The current world record for weight lifted overhead in the clean and jerk is 263.5 kg, held by Iranian superheavy
weightlifter / human vending machine [Hossein Rezazadeh](https://www.youtube.com/watch?v=FOE-PZJq2sk):

Use your program to calculate the weight of Rezazadeh's record lift in pounds.

Tip: you can use the `Scanner`'s `nextDouble` method to read a `double` value from the terminal.


