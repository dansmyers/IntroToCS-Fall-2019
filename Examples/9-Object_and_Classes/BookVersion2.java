**
 * Write a Java object that represents a book with author, title, price
 */
 
public class Book {
    
    /**
     * Declare internal data variables
     * 
     * Lots of possible names: data members, instance variables, attributes, fields
     */
    
    // Data members are declared at the top of the class, outside of any methods
    
    // Goal: modify the properties of the internal data members so that they can't
    // be accessed by other parts of the program
    
    // Java's term for this concept: access modifiers
    // four different access modifiers that you can use in a Java class
    
    // 1. public
    // no restrictions on access
    // public data and methods can be accessed and modified by any other part of the program
    // at any time
    //
    // it makes sense that main and other methods are public
    // because those methods exist to be called by other parts of the program
    // making them publically accessible supports that goal
    
    // 2. private
    // access is restricted to ONLY the methods of the class containing the data
    //
    // private data members can only be used within a class's own methods
    // They can't be directly read or modified by any other part of the program
    //
    // Common strategy: make all internal data members private unless you have a good
    // reason why one should be publically accessible
    
    // Question: if private variables can't be set or read by any other part of the program,
    // how do we use them, for example to print them?
    //
    // Answer: write methods that allow us to interact with private but only in controlled ways
    //
    // For example, write a method to change the value of price but generate an error if the new
    // price doesn't make any sense.
    
    // 3. protected
    // protected data is like private data, but it allows subclasses to be able to access
    // or modify the internal data value
    //
    // Recall that we said a class is like a blueprint for making objects of a certain type
    // Like a house blueprint that tells you how to build houses with a certain plan
    //
    // object-oriented languages allow the creating child classes that are modifications of
    // a parent class
    //
    // Like taking one master blueprint and creating a set of descendant blueprints that are
    // all variations on the master house plan
    //
    // protected data is useful for sharing information between a parent class and its subclasses
    // this is not something we're going to worry about in this class
    
    // 4. default access modifier (no access modifier when you declare the variable)
    // like public, but restricted to other classes in the same directory
    //
    // Technical term for this is "package level visibility"
    //
    // Data and methods can be accessed by other classes that are part of the program if those parts
    // are stored in the same directory
    
    // Our general plan:
    //
    // make constructors and methods be public so they can be called from other parts of the program
    // make internal class data members be private
    
    private String author;
    private String title;
    private double price;
    
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
    
    // Write methods for interacting with the private data variables
    
    // First kind of method: "accessor" methods ("get" methods)
    // Return the value of a private variable
    // 1. public
    // 2. return type is the type of the variable
    // 3. name is get + name of the variable
    // 4. body returns the value of the variable and that's it
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    // Question: what if we have a private data member, but don't write a get method for it?
    //
    // A variable like this can only be used within the class where it's declared
    // Purely internal variable that can't be accessed by any other part of the program
    // These can be useful for managing things like internal class state that only matters
    // to the class itself but not to other parts of the program
    
    
    // Second kind of method: set method ("mutator" method)
    // Change the value of private internal data member
    // 1. public 
    // 2. return type is void
    // 3. name is set + name of the variable
    // 4. one input parameter which is the new variable value
    
    // The real power of this approach
    // We can add additional logic to these methods
    // to control how variables are updated
    //
    // ensure that price is only modified in ways that make logical sense
    
    // Here, trying to set a bad price prints an error message to the terminal
    //
    // Recall: we had Exceptions as a way to deal with bad runtime behavior (FileNotFoundException)
    //
    // We could modify this method to throw an exception if anoher part of the program tries
    // to set a bad value for price
    //
    // The advantage of using exceptions is that it forces other parts of the program to have
    // a plan to deal with runtime errors using try-catch
    
    public void setPrice(double newPrice) {
        
        if (newPrice <= 0.0) {
            System.out.println("Updated price must be positive.");
        } else {
            this.price = newPrice;
        }
    }
    
    // Question: what if we have a private data member that doesn't have a set method?
    // For example, what if we don't create a setAuthor method in this class
    //
    // A read-only variable
    // Its value can be set one time when it's created
    // It can be read after that but not modified again
    
    // toString method -- return a nicely formatted String representation
    // toString is automatically called when you print an object
    // default toString prints Name@memoryaddress format
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
