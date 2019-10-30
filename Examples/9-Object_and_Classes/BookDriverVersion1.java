/**
 * Driver program because it contains the main
 */
 
public class BookDriver {
    
    public static void main(String[] args) {
        
        // Let's make some variables that represent a Book with an author, title, and price
        String hp1Author = "J.K. Rowling";
        String hp1Title = "Harry Potter and the Sorceror's Stone";
        double hp1Price = 12.99;
        
        // Key idea: these are three separate variables
        
        // They are related, but there's nothing in the code that enforces that relationship
        // Also, there's nothing that prevents illogical accesses to the data: price = -9.99;
        
        // Solution: write a Book class that contains internal data values for author, title, price
        // In other words, we're going to create a compound data type taht collects three
        // related variables together
        
        // Question: can we combine creating the new object and assigning values to its data members?
        //
        // Answer: yes we can do this, but we have write OUR OWN CONSTRUCTOR METHOD
        Book hp2 = new Book("J.K. Rowling", "Harry Potter and the Chamber of Secrets", 13.99);
        
        hp2.price = -13.99;
        
        // Use dot notation to access the internal data members of an object
        // Think of dot as representing possession or ownership
        System.out.println(hp2.author);
        System.out.println(hp2.title);
        System.out.println(hp2.price);
        System.out.println(hp2);  // write a method that prints a nicely formatted String representation
        
        // Next time:
        //
        // 1. What happened to static? What is the difference between a static method and a non-static method?
        // 2. How do we restrict access to data members? How do we ensure that data is only used in
        //    semantically-meaningful ways?
    }
}
