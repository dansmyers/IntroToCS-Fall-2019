// Read from the terminal and echo the input back
// CMS 167

// Use an import statement to add classes to your program
// Some classes, like System and Math, are automatically available

import java.util.Scanner;

public class Echo {

  public static void main(String[] args) {
  
    // Create a new Scanner
    Scanner input = new Scanner(System.in);
    
    // Use the Scanner's nextLine method to read from the terminal
    // Notice that String is capitalized because it's an object
    String line = input.nextLine();
    
    // Echo the String back
    System.out.println(line);
  }

}
