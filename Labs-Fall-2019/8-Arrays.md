# Arrays

## Review

A array is an **indexed sequence of elements**. Arrays are useful because they provide a way to store multiple values under one variable
name.

Every array has a type, which is the type of data that the array holds. For example, an `int[]` holds `int` values. You can create arrays
of any type, but each array can have only one type of data.

To declare an array, use the `new` keyword:

```
double[] dArr = new double[5];
```

The square brackets indicate that the type of `dArr` is an array. The right-hand side of the assignment creates a new array by allocating
enough memory to hold 5 `double` values. In Java, arrays are a kind of object, so they're created using `new` like the other objects
we've seen. The size of the array can be any non-negative integer expression.

Think of the array as a set of contiguous boxes, each of which holds a data value.

Each element of the array has an associated **index** number. The index of the first element is **zero**, the second element is **one**,
and so forth.

The final element in the array always has index **length - 1**.
```
 ---
| 0 |  <-- index 0
 ---
| 0 |  <-- index 1
 ---
| 0 |  <-- index 2
 ---
| 0 |  <-- index 3
 ---
| 0 |  <--- index 4
 ---
```

Access individual elements of the array using square brackets:

```
System.out.println(dArr[0]);  // print first element
System.out.println(dArr[1]);  // print second element
```

The length of the array is available using its `.length` property. A common operation is to loop over the elements of an array and do 
something with each one.

```
// This is the standard array access loop

for (int i = 0; i < dArr.length; i++) {
  System.out.println(dArr[i]);  // print the ith element
}
System.out.println();
```

Another common pattern is looping over an array to **reduce** its values into one output, such as a sum:

```
int sum = 0;
for (int i = 0; i < dArr.length; i++) {
  sum += dArr[i];
}
```

## Filling Arrays

Write class with a `main` method. In `main`, create a new `int[]` and use a `for` loop to fill the array with the numbers 0 to 19. Use a
second `for` loop to print the array.

Now modify your loop fill the array with even numbers 0 to 38.

Modify it one more time to fill the array with the odd numbers 1 to 39.
## Product of Elements

Write a method called `product` that takes an `int[]` as input and returns the product of its elements as an `int`. Here is a shell program to help you get started.

```
public class ArrayProduct {
  
  //*** Product of array elements ***//
  //
  // input: an integer array a
  // output: the integer product of a's elements
  public static int product(int[] a) {
  
  }

  public static void main(String[] args) {
    // Create a new integer array
    
    // Fill it with test values
    
    // Call the sum method
  }
  
}
```

## Add Two Arrays

Write a program with a method named `arraySum` that takes two integer arrays as input and returns a new array containing sums of each pair of elements. You can assume the arrays are the same size.

Tip:

You can't add arrays by their name!

```
int[] newArray = new int[a.length];  // This line is good

newArray = a + b;  // COMPILER DOES NOT WANT
```

You need to use a loop to add each pair of elements.

```
public static int[] arraySum(int[] a, int[] b) {

  // Create a new array with the same length as a
  
  // Use a loop to sum up corresponding elements of a and b
  
}
```

## Count Zeros

Write a program with a method called `countZeros` that takes an `int[]` as input and counts up and returns the number of zeros in the array.


## Banana? Banana!

Write a program with a method called `hasBanana` that takes a **`String[]`** as input and returns `true` if the array contains the word
`banana` and `false` otherwise.

Tip: to compare `String`s by value, use

```
if (a[i].equals("banana")) {
  return true;
}
```
Tip: loop over the array, like in the other problems, and use an `if` statement to test if `a[i] == 0`.

Test your program using the command line input.

```
/**
 * Yes, we have no bananas
 */
 
public class Bananas {

    /**
     * Test if a String[] contains the word "banana"
     *
     * @param  a  the input array of String
     * @return    true if a contains "banana", false otherwise
     */
    public boolean hasBanana(String[] a) {
    
    }
    
    /**
     * Main
     */
    public static void main(String[] args) {
        if (hasBanana(args)) {
            System.out.println("banana typed at command line.");
        }
    }

}
```
