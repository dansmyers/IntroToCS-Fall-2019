// MagicEight Ball
// CMS 167, Spring 2019

public class MagicEightBall {
  
  public static void main(String[] args) {
    
    // Create a Scanner and read a question from the user
    
    // Generate a random response
    double r = Math.random();  // a uniform random value in (0.0, 1.0)
    
    if (r < .20) {
      System.out.println("My sources say no.");
    } else if (r < .40) {
      // Case 2
    } else if (r < .60) {
      System.out.println("I'm not sure.");
    } else if (r < .80) {
      // Case 4
    } else {
      System.out.println("Signs point to yes.");
    }
    
  }
}
