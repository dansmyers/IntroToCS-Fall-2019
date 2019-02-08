// Convert input in feet to inches
// CMS 167, Spring 2019

import java.util.Scanner;

public class FeetToInches {
  
  public static void main(String[] args) {
    
    // Construct a new Scanner object
    Scanner in = new Scanner(System.in);  // Constructor
    
    System.out.println("Enter a length in feet: ");
    double feet = in.nextDouble();
    
    // Test if feet is non-negative
    // If not, print an error message and quit
    if (feet < 0) {
      System.out.println("You must enter a non-negative number.");
      return;  // End the program right now
    }
    
    double inches = feet * 12;
    System.out.printf("That's %.2f inches.\n", inches);
  }
}
