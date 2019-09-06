// A simple program illustrating variables in Java
// CMS 167

// Variables let you give names to data in your programs
//
// This is one of the most important programming language features, because it
// makes it possible to write large, complex programs.

public class RectangleArea {

  public static void main(String[] args) {
  
    // There are two steps in the life of a variable:
    // 1. Declaration
    // 2. Assignment
    
    // To declare a variable, specify its type and a name
    // int is the basic type for an integer variable
    int length;
    int width;
    
    // Use = to assign a value to a variable
    // The variable name is always on the left and the new value is on the right
    // Assignment *replaces* the old variable value with the new one
    length = 25;
    width = 10;
    
    // Declaration and assignment can be combined into one statement
    int area = length * width;
    
    // Using a variable in a print statement will print its value
    System.out.println("Length: " + length);
    System.out.println("Width: " + width);
    System.out.println("Area: " + area);
  
  }

}
