# Write Some Programs

## Plan for Today

Use repl.it to write your programs. Put everything in the file named `Main.java`, in a class named `Main` and the standard `main`
method. Remember that there's nothing special about the file being named `Main.java`: it's just how the repl.it environment wants
things to be.

Write a program to answer each of the questions below. After you finish each one, copy it to Word or text file on your local computer to
save it, then erase your code and move on to the next problem.

I want you to rewrite the program for each problem from scratch, including the `public class` and `public static void main` parts. 
Repeating this each time will help you get comfortable with the basic structure of Java programs.


## Review

We looked at our first `Hello, World!` program in the last class. Here it is:

```
// Hello, World!
// DSM, 2019

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    
}
```

Recall that a Java program is a **class**. Every class has a name, which is capitalized and must match the name of the file. The `repl.it` environment required us to use a file named `Main.java`, so our example class is also named `Main`.

A class is a collection of **methods**. All of our classes (for now) will have one method called `main`, which is the **entry point** 
for the program. When you run a class, Java finds its `main` method and executes the **statements** it contains.

Use **indentation** to show the structure of your program. Indent the contents of each pair of curly braces by at least two spaces (I like to use four).

The line

```
System.out.println("Hello, World!");
```

is a **print statement**.

`"Hello, World!"` is a **String**: a sequence of characters. Java strings are always enclosed in double quotes.

`System.out.println` is **built-in Java method** that prints any string we give to it. The string that we want to print is called the **argument** and is always placed in parentheses after `System.out.println`.

Java statements are always **terminated by a semicolon**.

## Confidence Boost

Modify the basic print program to say

```
You are an excellent programmer, NAME.
```

where `NAME` is your name.

Run the program and verify that it produces the output you expect.

Tips:

- Remember that all of your code goes inside the curly braces for `main`

- Maintain correct indentation for every new statement that you add

- Terminate each line with a semicolon


## Haiku

Write a program to print the following haiku by the poet Kobayashi Issa:

```
O snail
Climb Mount Fuji,
But slowly, slowly!
```

Use three print statements.

## Special Characters

We've seen that Java strings must be enclosed in double quotes, but what if you want to put a literal quote inside a string?

The answer is to use a special character, `\"`. Think of the `\` as being an "escape" character: it indicates that the following quote
should not be treated as the end of the string, but as a literal quote character.

For example, the print statement

```
System.out.println("Quoth the Raven \"Nevermore.\"");
```

will print

```
Quoth the Raven "Nevermore."
```

Use five print statements and `\"` characters to print the *The Raven* as a limerick:

```
There once was a girl named Lenore
And a bird, and a bust, and a door
And a guy with depression
And a whole lot of questions
And the bird always says "Nevermore"
```

## Two Other Special Characters

Another useful special character is `\n`, which makes the printed output move to the next line. Use `\t` to insert a tab character into a line.


For example, the statement:

```
System.out.println("This is\n\ta test.");
```

will print

```
This is
        a test
```

Notice that you don't need to put spaces around the special characters. The spacing of the tab may be different on different platforms.

Use multiple print statements and both `\n` and `\t` to print this excerpt from E.E. Cummings' poem *[in Just-]*:

```
it's 
spring 
and 

        the 

                  goat-footed 

balloonMan        whistles 
far 
and 
wee
```

## Math

There are four basic arithmetic operators in Java:

```
+    addition
-    subtraction
*    multiplication
/    division
```

You can print the result of a calculation using `System.out.println`:

```
System.out.println(2 * 2 + 1)
```

Tip: always **separate the parts** of any arithmetic expression with spaces, like I did in that example. It makes your expressions
easier to read.

Use Java to calculate the area of a rectangle with length 5.5 and height 3.2.

## The Rules

Arithmetic works the way you would expect in Java. Standard order of operations applies (multiplciation and division first, then
addition and subtraction) and you can use parentheses to group expressions.

Write a program that performs the following calculation in Java and prints the result:

```
2 + 8     20 - 5 
-----  +  ------
  2          3
```

## Division Bell

Calculate `15 / 4` using Java. What did you get? Is that right?

Try another one: `21 / 5`. What does Java give? What is the correct answer?

What does Java do if you divide two whole numbers? Try some more examples if you need to.

***Answer the question before reading ahead***.

## The Answer

Java makes a distinction between **integer division**, where both arguments are whole numbers, and regular division, where at least one
number contains a decimal point.

Try calculating `15.0 / 4` and `15 / 4.0` and verify that those expressions yield the correct answers.

## It's a Trap(ezoid)!

The formula for the area of a trapezoid is

```
area = (base * height) / 2
```

What is the area of a trapezoid with base 3 and height 5?

Hint: 7 is wrong!

## Smoots

Use all of your powers to answer the following question.

Oliver R. Smoot is an MIT graduate and former head of the American National Standards Institute (ANSI) and the International Organization for Standards (ISO).

In 1958, as part of his initiation into ΛXA, Smoot and his brothers measured the entire length of Harvard Bridge over the Charles River in Cambridge, MA, using Smoot’s body as the ruler. He was at the time 170 cm tall (5 feet, 7 inches), and the bridge was declared to be 364.4 Smoots, "plus or minus one ear" (about 2035 feet or 650.7 meters). Since that time, the measurement of Harvard Bridge has always been denominated in Smoots, with the markings repainted each year by the incoming ΛXA pledge class at MIT. The Cambridge police use the Smoot markings to identify the location of accidents on the bridge.

The Lake Pontchartrain Causeway, which connects Metairie, a suburb of New Orleans, to Mandeville, LA, is 23.83 miles long. It holds the
record for being the longest continuous bridge over water (there are longer bridges, but they are not built in one continuous span).

What is the length of the Lake Pontchartrain Causeway in Smoots?

Tip: one Smoot is about 5.5833 feet.

## Ghawar Hogsheads

A **hogshead** is an archaic unit of volume with a size that depends on what is being measured.

The international standard oil barrel is defined to be 42 US gallons and a hogshead of oil is 1.5 barrels, or 63 gallons.

A hogshead of beer, on the other hand, is defined to be *64* US gallons.

The Ghawar oil field in Saudi Arabia is the largest conventional oil field in the world and produces about 5 million barrels of oil 
each day. How many beer hogsheads beer could the Ghawar field fill in a day?

## Sum

Recall that the **natural numbers** are the basic counting numbers: 1, 2, 3, and so forth.

There is a formula for the sum of the first *N* natural numbers:

```
N (N + 1)
---------
    2
```

For example,

```
1 + 2 + 3 + 4 + 5 = 15

and

5 (5 + 1)   
--------- = 15
    2
```

Use Java to calculate the sum of the first 10000 natural numbers.
