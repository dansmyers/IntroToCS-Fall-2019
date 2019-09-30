# Method Practice Problems

## Is It Me You're Looking For?

Write a program named `Hello100.java` that contains four methods:

- `sayHello`, which will print `Hello!` to the screen.
- `sayHello5Times`, which calls `sayHello` five times.
- `sayHello25Times`, which calls `sayHello5Times`.
- `sayHello100Times`, which calls `sayHello25Times`.

All of the methods should have the return type `void`, because they do not `return` any values.

Here is the class definition and `main`:

```
public class Hello100 {

    //*** Put method definitions above main ***//

    public static void main(String[] args) {
        sayHello100Times();
    }

}
```

## Tricky

This program uses the variable name `x` in multiple places. What happens when it executes?

```
public class Tricky {

    public static int baz(int x) {
        x = x * 2;
        return x;    
    }

    public static int foo(int value) {
        int x = baz(value + 1);
        return x;
    }

    public static void main(String[] args) {
        int x = 1;
        x = foo(x);
        System.out.println(x);
    }
}
```

## Tricky II

Step through the execution of this program using a stack diagram. For your example, assume the user inputs ` `

```
import java.util.Scanner;

public class TrickyII {

    public static String readLine() {
        Scanner reader = new Scanner(System.in);
        String message = reader.nextLine();
        return message;
    }

    public static void printTwice(String message) {
        System.out.println(message);
        System.out.println(message);
    }

    public static void printFourTimes(String message) {
        printTwice(message);
        printTwice(message);
    }

    public static void main(String[] args) {
        System.out.println("What's your favorite band?");
        String message = readLine();
        printFourTimes(message);
    }

}
```
