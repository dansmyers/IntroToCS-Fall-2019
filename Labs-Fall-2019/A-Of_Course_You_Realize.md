# Of Course You Realize...

## Review

Remember these key ideas about classes:

- A class is a **blueprint** for creating objects of a certain type. Objects we create in a program are called **instances** of a class.

- Many of our classes function like **compound data types**: they group together a set of logically-related variables under a common name. These internal variables are called **instance variables** or **fields** of the class.

- Objects **encapsulate** their data to protect it from arbitrary and incorrect access by other parts of the program. A class typically defines a set of **methods** that allow other parts of the program to interact with its internal instance variables in safe ways.

Some other points:

- `private` instance variables can only be accessed by methods within the same class. External code can't access or change a private variable.

- `this` is the special **object self-reference keyword**. Use it to refer to a class's internal variables.

## Warm-Up

Create a `Rectangle` class with `private double width` and `private double height` data members.

Write a constructor that sets initial values of `width` and `height`, `get` methods for both attributes, and a `toString` method. Write
an `area` method that calculates and returns the area of the `Rectangle`.

Write a `main` to test your class.

## Shuffle

Let's return to the `Deck` class from last time and add a `shuffle` method.

Our goal is to *permute* the elements of the `cards` array into a random ordering. A common strategy for doing this is called the **Fisher-Yates shuffle algorithm**. Here is the code you need:

```
public void shuffle() {
    for (int i = this.cards.length - 1; i > 0; i--) {
        // Generate a random array index in [0, i - 1]
        int j = (int) (Math.random() * i);
    
        //Swap the array elements at positions i and j
        Card temp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = temp;
    }
}
```

Effectively, the shuffle starts at position `n - 1` of the array, picks a random element from earlier in the array, and swaps it into
position `n - 1`. It then moves to position `n -2`, picks a random element, swaps it into position `n - 2`, and so forth.

Implement the `shuffle` code, then add a line to your `main` to `shuffle` the deck before you print it.

```
d.shuffle();
```

## Get

Add `getRank` and `getSuit` methods to the `Card` class.

## War

Now write a driver class that uses `Deck` and `Card` to play War.

```
public class War {

  public static void main(String[] args) {
  
    // Create a new Deck
    
    // Shuffle the deck
    
    // Deal cards
    Card player = deck.deal();
    Card cpu = deck.deal();
    
    // Print the two cards
    
    // Compare the ranks of c1 and c2
    
    // The higher ranked card is the winner
    
  }
}
```

Once you have that working, try the following modifications:

- Add a tie-breaking war rule

- Use a loop to play best 2 out of 3
