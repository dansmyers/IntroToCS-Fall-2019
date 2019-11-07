/**
 * A deck of cards
 *
 * @author CMS_167
 */
 
 // Conceptually, a class that acts as a container for a collection of Card objects
 // Use one class as a building-block or component of another class
 
 // Basic idea: use a 1-D array of Card objects to represent the deck
 // That array will have 52 elements
 
 import java.util.Arrays;
 
 public class Deck {
     
     private Card[] cards;  // creating the name for the array, but not allocating memory for it yet
     private int nextUndealtCard;  // index of the next undealt card in the array
     
     
     /**
      * Constructor -- fill the array with all 52 cards
      */
     public Deck() {
         // Allocate memory for the cards array
         this.cards = new Card[52];
         
         this.nextUndealtCard = 0;
         
         // Instead, iterate using a loop over all the Suit-Rank combinations
         // New feature: enhanced for loop
         // A way to directly iterate over the elements of a set without needing an int counting variable
         
         int index = 0;
         
         for (Suit s : Suit.values()) {
             for (Rank r : Rank.values()) {
                 Card c = new Card(s, r);
                 
                 // Insert into the cards array
                 this.cards[index] = c;
                 index++;
             }
         }
         
     }
     
     // Other useful methods
     
    public void shuffle() {
        
        // Rearrange the cards in a random order
        
    }
    
    public Card deal() {
        
        // Returns the next undealt card in the deck
        Card c = this.cards[this.nextUndealtCard];
        this.nextUndealtCard++;
        
        return c;
        
    }
    
     
     
     
     /**
      * toString -- print the entire deck of cards
      */
     public String toString() {
         
         // Strategy: be very lazy
         // Always use a built-in method to do what you want if one is available
         return Arrays.toString(this.cards);
     }
     
     
     /**
      * Main -- test the Deck class
      */
     public static void main(String[] args) {
         Deck d = new Deck();
         System.out.println(d);
         
         for (int i = 0; i < 52; i++) {
             System.out.println(d.deal());
         }
     }
 
 }
