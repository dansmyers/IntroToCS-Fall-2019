# The One With Arrays

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


