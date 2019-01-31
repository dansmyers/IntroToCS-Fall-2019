# Conversation

## Overview

This lab will give you the chance to practice writing problems that incorporate user input with the `Scanner` class.

## Review

The following line creates a `Scanner` and saves it to a variable named `in`:

```
Scanner in = new Scanner(System.in);
```

The left-hand side of the assignment statement is a regular variable declaration: the type of the variable is `Scanner` and its name is
`in`. The right-hand side is the **constructor** that creates the new `Scanner` object.

Recall that the `new` keyword is like a **memory-allocation** operation: it tells Java to set aside space in the computer's memory to
hold the `Scanner` object. The constructor method always has the same name as the object's class. Class names in Java always start with
capital letters, and Java is case-sensitive.

The `Scanner` constructor takes one input: the thing that you want to scan. Here, we want to scan from the standard system input, which is
`System.in`. It's also possible to take input from files, Strings, or other sources, but we're only using the standard system input right
now.

To read from the terminal, use the following statement:

```
String line = in.nextLine();
```

This is another assignment. The left side is a `String` variable named `line`. The right side is a call to `in`'s `nextLine` method, which
will read one line of text from the terminal. When the user presses ENTER, `nextLine` returns whatever was typed and the statement saves
it to the `line` variable.

Here was the basic `Echo` program we built last time. The first line uses `import` to get access to `Scanner`.

```
// Read a line from the terminal and echo it back
// CMS 167, Spring 2019

import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type something:");
        String line = in.nextLine();
        System.out.println("You typed: " + line);
    }
 }
```
