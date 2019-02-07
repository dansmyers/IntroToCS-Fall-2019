# Conditionals

## Review

## Running Your Programs from the Terminal

## Directories

Recall that your 

## Finishing up RPS

In the last class, we put together a program that used the logical `and` operator, `&&`, to test two conditions at the same time:

```
// Test if player chose rock AND computer chose scissors
if (playerMove == 1 && cpuMove == 3) {
    playerWins = true;
}
```

The `&&` operator combines the results of two `boolean` tests. If both tests are `true`, then logical `and` operator evalutes to `true`. If one or both tests are `false`, the logical `and` of the tests is also false. This matches what you would expect the word *and* to mean.

Let's add one more condition to check for input. At the beginning of the program, we asked the user to put in a number 1, 2, 3 or select a move. Add this statement to verify that the input is between 1 and 3:

```
// Report an error if the player's input is less than zero OR greater than three
if (playerMove < 1 || playerMove > 3) {
    System.out.println("That is not a valid choice. Humanity fails at everything.");
    return;
}
```

The logical `or` operator, represented by `||`, returns `true` if **at least one or both** of its inputs are `true`.


## 



## Printing an Object

Write a program containing this code fragment and see what happens when you run it.

```
Scanner in = new Scanner(System.in);

// Print a Scanner object -- what's displayed?
System.out.println(in);
```

You should see an output that looks like

```
Scanner@2f92e0f4
```

The exact sequence of letters and numbers will be different.

What's going on? When you print an object, Java prints the class name (`Scanner`, in this case) and the object's **hashcode**, which is based on the address in the computer's memory where the object is stored.

Try modifying your program to create and print a second `Scanner`:

```
Scanner in = new Scanner(System.in);
System.out.println(in);
Scanner in2 = new Scanner(System.in);
System.out.println(in2);
```

You should see that the two `Scanner` objects have different hash codes. They were created by two different calls to the constructor method using the `new` keyword to allocate memory each time. Therefore, even though they are the same class of object, they are stored at **distinct locations in memory**.


## Even or Odd

Write a program that reads an `int` from the terminal and reports if it is even or odd.

```
Enter an integer:
42
42 is even.
```

How can you test for oddness? Use the mod oeprator, `%`, which you might remember returns the remainder after division.

```
13 % 5 returns 3, because that's the remainder when 13 is divided by 5
```

If `x % 2 == 0`, then `x` is evenly divisible by 2 (it has no remainder). If the mod calculation returns 1, then `x` must be odd.
