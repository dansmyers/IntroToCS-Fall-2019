# Project 1: Units of Measure

## Due Sunday, February 3, at 11:59:59 PM

## Overview

These six problems will let you practice writing Java programs that combine printing, arithmetic, and variables.

Review the first two chapters of *Think Java* for tips and more examples.

## Grading

Each program has an associated test labeled "Check it!". When you click that button, Codio will compile and run your program, then compare its output to the expected test output. If they match, you'll pass the test. If they don't, you'll be able to compare your output to what was expected. I'll also inspect your code to make sure you have a reasonable approach to each problem (you can't just print the expected output).

The autograder expects specific filenames, so make sure you use the specified names.

Use the style guidelines that we discussed in class:

- Indent each time you open a new pair of curly braces. Everything at the same logical level should be indented by the same amount.

- Variable names start with a lowercase letter. If a variable name has multiple words, each word after the first should be capitalized.

- Start each program with a comment listing the basic purpose of the program and your name.

**I reserve the right to deduct points for programs that do not have good style!**

## General Tips

- Start early! Don't wait until the last minute!

- Review the example programs from class and the ones you wrote in lab.

- Use the file names that I've specified for each program. Make sure spelling, etc. is correct. Put all of your files into the top-level root directory (don't make any new directories).

- Your class name must be the same as the filename. For example, the file `Basics.java` must contain a class named `Basics`.

- Every class must have a `public static void main` and all of your code must be between the curly braces for `main`. Don't put code anywhere else!
  
- Think about inputs and outputs. Start your program by declaring variables for each input and one for the final output, then assign their appropriate values.

## Problems


### The Basics

Write a program that prints the message:

```
I LOVE PROGRAMMING.
```

Put your program in a file named `Basics.java`.

{Check It!|assessment}(code-output-compare-910396664)


### Our Princess Is In Another Castle

At the end of each level of the original *Super Mario Bros.*, Mario jumps up a staircase like the following:

```
     ##
    ###
   ####
  #####
 ######
#######
```

The staircase has six levels. The bottom level has seven blocks and the top level has five spaces and two blocks.

Write a program that uses six `System.out.println` statements to print this staircase. Put your code in a file named `Stairs.java`.

{Check It!|assessment}(code-output-compare-3843919668)


### Beards

The *beard-second* is an incredibly scientific unit of length defined as the distance an average beard grows in 1 second. Google defines the beard-second as 5 nanometers and will perform conversions between beard-seconds and other lengths (try typing "1 foot in beard-seconds" into Google).

Using this definition, it would take an average beard 58.8 days to grow 1 inch.

The longest beard in the world is 17 feet long and is [housed in the Smithsonian institution](https://www.smithsonianmag.com/smithsonian-institution/smithsonian-home-worlds-longest-beard-180953370/). In life, it belonged to Hans Langseth, who immigrated to the U.S. from Norway in 1864; he died in North Dakota in 1927. He would wrap his beard around a corncob and carry it in his pocket.

![Hans Langseth from Wikipedia Commons](https://upload.wikimedia.org/wikipedia/commons/8/81/Hans_Langseth.jpg)

Under the (completely unrealistic) assumption that Hans Langseth grew his entire beard at the average rate, how many days would it have taken to him to get 17 feet of facial hair? Use `double` variables for your calculations.

Name your program `Beards.java` (with an *s*).

{Check It!|assessment}(code-output-compare-4009295654)


### Cricket Thermometer

The rate at which a field cricket chirps is closely correlated with temperature. As the temperature increases, the rate of chirping increases.

If a cricket chirps *C* times in one minute, the temperature is approximately:
 
 ```
 T = (C / 4) + 40
 ```    

degrees Fahrenheit.
 
Write a program that calculates the estimated temperature for a given number of input cricket chirps.

What temperature is associated with 120 chirps per minute? Use `int` variables and put your program in a file named `Cricket.java`.

{Check It!|assessment}(code-output-compare-3247966851)


### Volume of a Sphere

The `Math` class has a built-in method called `pow` that can be used to calculate powers. `Math.pow` takes two arguments, the first is the base and the second is the exponent.

```
// Example of raising a value to the 3rd power
double radius = 5.0;
double radiusCubed = Math.pow(radius, 3);
```

The formula for the volume of a sphere is

volume = (4 / 3) * pi * radius<sup>3</sup>

What is the volume of a sphere with radius 5.0? Put your answer in a file named `Volume.java`.

Hint: what is 4 / 3?

{Check It!|assessment}(code-output-compare-2852176169)


### 1 Barnum = 1 Sucker / Minute

P.T. Barnum was a 19th Century showman, promoter, and politician, founder of the Barnum and Bailey Circus. He's credited with coining the saying, "There's a sucker born every minute," although there's no evidence he actually said this.

Jonathan the tortoise is the oldest known living terrestrial animal. He was hatched in the Seychelles, then transported to the island of Saint Helena in the South Atlantic Ocean in 1882, where he still resides. Measurements show that he was at least 50 years old when he arrived on Saint Helena, so he must have hatched no later than 1832, giving him an estimated age of 187 years old.

![Jonathan on the left in 1886](https://upload.wikimedia.org/wikipedia/commons/2/26/Johnathan_and_another_tortoise_%2C_St_Helena.png)

![Jonathan the tortoise in modern times](https://upload.wikimedia.org/wikipedia/commons/b/b9/World%27s_Oldest_Reptile_%2815844883993%29.jpg)

If Barnum's alleged saying is true, how many suckers have been born during Jonathan's life? Let's assume that Jonathan is exactly 187 years old and that each year has 365 days (ignoring leap years). Put your answer in a file named `Suckers.java`.

{Check It!|assessment}(code-output-compare-4281116279)
