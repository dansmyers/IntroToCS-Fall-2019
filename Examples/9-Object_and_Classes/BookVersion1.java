/**
 * A Java object that represents a book with author, title, price
 */
 
public class Book {
    
    /**
     * Declare internal data variables
     * 
     * Lots of possible names: data members, instance variables, attributes, fields
     */
    
    // Data members are declared at the top of the class, outside of any methods
    
    String author;
    String title;
    double price;
    
    // Write the custom constructor method
    // Rules:
    //
    // 1. the method is public but not static
    // 2. there is no return type, not even void
    // 3. the name of the method is the same as the name of the class
    public Book(String newAuthor, String newTitle, double newPrice) {
        
        // Set the initial values of the data members of this object
        
        // Use this to refer to object data members from within the object's own code
        // this is the "object self-reference"
    
        this.author = newAuthor;
        this.title = newTitle;
        this.price = newPrice;
        
        // Nothing to return
    }
    
    
    // toString method -- return a nicely formatted String representation
    // toString is automatically called when you print an object
    // Default toString prints Name@memoryaddress format
    // If we write a custom toString, we can print whatever String we want
    
    // Rules:
    // 1. name is always toString
    // 2. return type must be String
    public String toString() {
        
        // write code to return a String version of the object's data
        return this.title + " by " + this.author + ", " + this.price;
    }
    
    // No main -- the BookDriver class contains the main
}
