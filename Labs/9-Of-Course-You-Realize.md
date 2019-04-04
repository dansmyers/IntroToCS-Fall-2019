# Of Course You Realize...

## Review

Remember these key ideas about classes:

- A class is a **blueprint** for creating objects of a certain type. Objects we create in a program are called **instances** of a class.

- Many of our classes function like **compound data types**: they group together a set of logically-related variables under a common name. These internal variables are called **instance variables** or **fields** of the class.

- Objects **encapsulate** their data to protect it from arbitrary and incorrect access by other parts of the program. A class typically defines a set of **methods** that allow other parts of the program to interact with its internal instance variables in safe ways.

Here is an example of a typical class:

```
public class Rectangle {

  // Private instance variables
  private int height;
  private int width;
  
  // Constructor that sets initial values of the instance variables
  public Rectangle(int newHeight, int newWidth) {
    this.height = newHeight;
    this.width = newWidth;
  }

  // toString -- called automatically when printing a Rectangle
  // Returns a String representation of the object's data
  public String toString() {
    return "Rectangle: " + this.width + " x " + this.height;
  }
}
```

Some other points:

- `private` instance variables can only be accessed by methods within the same class. External code can't access or change a private variable.

- `this` is the special **object self-reference keyword**. Use it to refer to a class's internal variables.


## Problems

### Card

Let's create a `Card` class representing a single playing card with two attributes: an `int suit` and an `int value`.

We'll assume that the `suit` of the card can be represented by a number:

- 0 stands for Clubs
- 1 stands for Diamonds
- 2 stands for Hearts
- 3 stands for Spades

The `value` is also a number:

- 1 for Ace
- 2 through 10 for the number cards
- 11 for Jack
- 12 for Queen
- 13 for King

(Aside: Java supports an advanced technique for dealing with data that can only take on a fixed set of values called **enumerated types** or `enum` for short. We're not using it here, but it would a good way to represent things like card suits and values.)

Here is a template for the `Card` class:

```
public class Card {

  private int suit;
  private int value;

  public Card(int newSuit, int newValue) {
  
  }
  
  public int getSuit() {
  
  }
  
  public int getValue() {
  
  }
}
```

Implement the class and add code to the constructor and the `get` methods.

### Printing

Unfortunately, the integer encoding makes it hard to print `Card` objects. Let's modify the class to add a `toString` method.

Here's the idea: create two `String[]`, one that holds the real names of the four suits and the other that holds the real names of the 13 values. The `toString` method uses these two arrays to look up the real name associated with each number.

```
public class Card {

  private final String[] suitNames = {"Clubs", "Diamonds", "Hearts", "Spades"};
  private final String[] valueNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven, "Eight",
                                   "Nine", "Ten", "Jack", "Queen", "King"};

  private int suit;
  private int value;

  public Card(int newSuit, int newValue) {
  
  }
  
  public int getSuit() {
  
  }
  
  public int getValue() {
  
  }
  
  public String toString() {
    return this.suitNames[this.suit] + " of " + this.valueNames[this.value];
  }
}
```

Now create a `CardDriver` class that constructs and prints a few `Card` objects. Note that you'll still need to pass integer values into the constructor: you can't pass in the `String` names.


### I Have Not Yet Begun to Fight

Now create a class to play a game of `War`. The class will have a `static` method named `deal` that contructs and returns a new random `Card`.

```
public class War {

  public static Card deal() {
    // Add code to generate and return a new random Card
  }

  public static void main(String[] args) {
    
    Card c1 = deal();
    Card c2 = deal();
    
    // Compare the values of c1 and c2
    
    // The higher value card is the winner
    
  }
}
```

### Jam

Once you get the basic game working, spend the rest of the period improving it. Some ideas:

- Use a loop to let the player attempt multiple rounds.

- Keep score, player vs. computer, and stop when one side accumulates a certain number of points.

- What happens on a tie? Implement a tie-breaking war rule.
