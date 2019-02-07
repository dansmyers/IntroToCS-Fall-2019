# Conditionals

## Review

## Running Your Programs from the Terminal

## Directories

Recall that your 

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

What's going on? When you print an object, Java prints the class name (`Scanner`, in this case) and the object's `hashcode`, which is based on the address in the computer's memory where the object is stored.



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
