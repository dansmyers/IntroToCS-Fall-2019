/**
 * A class that represents a single playing card
 * 
 * @author CMS_167
 */

// Suit and rank can take on only a limited set of fixed values
// Types with limited fixed values are called enumerated types

// Java has a built-in enum feature for working with enumerated types

// Internally, Java will convert the enum declarations into final constant int values
// like the ones we declared below

// enum stucture is cleaner and easier to modify than declaring our own final constant values
// It also allows Java to enforce restrictions on the values that enum variables can take

enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;
}

enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
}

public class Card {
    
    // Basic attributes for a playing card: suit and rank
    // First key design question: how to represent the suit and rank in our program?
    // One option: create final int values to map names to fixed numbers
    // Better: use Java's enum feature to enumerate the fixed set of values for Suit and Rank
    
    private Suit suit;
    private Rank rank;
    
    
    /**
     * Constructor -- create a new playing card with the given suit and rank
     */
    public Card(Suit newSuit, Rank newRank) {
        this.suit = newSuit;
        this.rank = newRank;
    }
    
    /**
     * toString -- print the playing card
     */
    public String toString() {
        return this.rank + " of " + this.suit;
    }
    
    /**
     * Main method for the Card class -- test the Card
     * 
     * last time we made a Driver class to serve as the entry point for the program
     * 
     * Common pattern: give each class its own main to test the class
     * Also create one driver class to serve as the launching point for the larger application
     */
     
    // Now: the thing I hate most about Java
    
    // Here's the deal with static:
    // A static method belongs to the class as a whole and not to any instance of the class
    //
    // When you declare a method static, it's like saying that method is generic and is the
    // same for all Card objects
    
    // non-static methods are allowed to access data that might be different between different
    // Card objects
    
    // Practical takeaway: static methods cannot access object instance variables (data members)
    // Data members are tied to particular instances of the object
    // Static things are tied to the class as a whole
    
     
    public static void main(String[] args) {
        // Make a new Card object within main
        // Using main inside a class is functionally similar to using it within a separate Driver
        
        Card aceOfSpades = new Card(Suit.SPADES, Rank.ACE);
        Card queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);
        
        System.out.println(aceOfSpades);
        System.out.println(queenOfHearts);
    }
    
    
}
