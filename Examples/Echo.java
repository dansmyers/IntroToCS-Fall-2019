// Take input from the user and echo it back to the terminal
// CMS 167, Spring 2019

// import statements let us gain access to extra classes
// 
// java.util is a package that contains lots of utility classes
// import always go at the beginning of your program, before public class
import java.util.Scanner;

public class Echo {
  
  public staic void main(String[] args) {
    
    // Create a Scanner object to read input
    // Two steps: declare the Scanner variable
    // then, **instantiate** the Scanner object
    
    Scanner in;
    
    // new is the object instatiation keyword
    // new tells Java to allocate memory to hold a new object
    // 
    // special method to create a new object is called the **constructor**
    // constructor always has the same name as the object type
    // System.in is the standard terminal input (counterpart of System.out)
    // 
    // Create a new Scanner that reads from the standard system input
    in = new Scanner(System.in);
    
    System.out.println("Type something:");
    
    // Use the nextLine method of the Scanner to read one line of input
    // nextLine pauses until the user presses ENTER, then returns everything
    // that was typed as a String
    String line = in.nextLine();
    
    // Print what the user typed
    System.out.println("You typed: " + line);
  }
  
}
