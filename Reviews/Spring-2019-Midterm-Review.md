CMS 167 Spring 2019: Midterm Study Guide
========================================

Exam Format
-----------

The exam will be 8-10 short answer questions. For each question, I'll
ask you to write a few sentences or a short code fragment.

No notes, books, calculators, or electronic devices.

The example programs here are representative of the kinds of questions
I might ask you to do on the exam.

I **will not** give you questions that have syntax errors or tricks.
Any program or code fragment I give you should run correctly and do
what it's supposed to do. If you find an error, it's probably a typo.
Let me know so I can correct the mistake for everyone.


Classes, Variables, and Types
-----------------------------

List the eight basic Java primitive types and the kind of data
associated with each one.

Any data type that is not one of the eight basic primitive types is an
__________ in Java. (fill in the blank)

Conventions for variable and class names.

Write programs that use variables to perform calculations and 
conversions. Examples:

    Celsius to Fahrenheit converter
    Cricket temperature calculator
    Pounds to kilos
    Kilometers to miles
    Area of a circle
    
    You don't need to memorize any conversion constants. I'll give
    you any background information you need.
    
Using the built-in Math class, like Math.PI and Math.sqrt()


Input and Scanner
-----------------

Declare a Scanner:

    Scanner in = new Scanner(System.in);
    
    Does the Scanner have to be named in?
    
Write a program that prompts the user to enter a number of miles and
converts it to inches.

Write a program that prompts the user to enter a number of weeks and
converts it to days.


Binary Numbers
--------------

Be able to perform conversions from positive base-10 integers to their
binary equivalents:

    11
    28
    63
    75
    
Convert binary numbers to their base-10 equivalents:

    
    
Perform addition on unsigned binary numbers.

    111 + 111
    1001 + 1101
    00110 + 10011
    
Be able to check the results of binary addition by converting back to
base 10.


If Statements
-------------

Test for divisibility using the % operator, which returns the
remainder after division.

The other sections have example questions that require using `if`.


Methods
-------

What will be printed by the following program?

```
public class Example {

    public static boolean foo (int test) {
        if (test % 3 == 0 && test % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean baz(int value) {
        int x = value * 5;
        return foo(x);
    }
    
    public static void main(String[] args) {
        System.out.println(baz(12));
    }

}
```

Consider the following method:

```
public static int weird(int n) {
    if (n % 2 == 0) {
        return n / 2;
    } else {
        return 2 * n + 1;
    }
}
```
    
What is weird(11)?

What is weird(weird(11))?


Write a method that returns a boolean representing a random coin toss.


Write a method that takes an `int` as input and returns true if it's
divisible by 10 and false otherwise.


For Loops
---------

Two basic purposes of the `for` loop:

- Run a block of code a specified number of times
- Step through a range of values

Write a `for` loop that prints the integers from 1 to 100.

Write a `for` loop that prints the numbers from 1 to 100 that are
divisible by 3. There are two ways to do this:

-Loop over the entire range by ones and test each value
-Start at 3 and add 3 after each loop.

Write a for loop that prints the odd integers from -11 up to 11.

Write a `for` loop that calculates the sum of all positive integers
less than 10000 that are divisible by 7 or 11.

Write a program to print an inverted staircase like the following:

```
######
#####
####
###
##
#
```

Use one outer for loop that iterates over the number of lines and a
second inner for loop that prints the blocks on each line. Use a
variable named `height` to control the number of lines.


What does the `break` statement do?


While Loops
-----------

Write a while loop that prints the even numbers from 2 to 200.

Write a while loop that prompts the user to enter an odd number. If
the user's number is odd, it quits. If the number is even, it asks
again.


Strings and Printing
--------------------

Special characters: \t, \n, \\, \"

Using `System.out.printf` for formatted output:

    %d is the specifier for an integer value
    %.2f specifies a decimal value with 2 digits
    
I wrote the following code fragment, but it doesn't work. What am I
doing wrong?

    String s1 = "narwhal"
    String s2 = "narwhal";
    
    if (s1 == s2) {
        System.out.println("I want this line to print.");
    }
    
Explain the difference between the String class's equals method (test
for value equality) and the == operator applied to objects (test for
reference equality).
