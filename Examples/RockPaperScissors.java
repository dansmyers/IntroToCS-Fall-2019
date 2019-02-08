// Rock, Paper, Scissors
// CMS 167, Spring 2019

// Tips for writing larger programs:
// 
// 1. Develop incrementally: write one small piece, test it, and then add more
// 2. Don't be afraid to refine your ideas
// 3. Start with the plan

import java.util.Scanner;

public class RockPaperScissors {
  
  public static void main(String[] args) {
    
    // Collect an input from the user using Scanner
    System.out.println("Welcome to RPS, pathetic human.");
    System.out.println("1. Rock");
    System.out.println("2. Paper");
    System.out.println("3. Scissors");
    System.out.println("Select a move (I promise not to look):");
    
    Scanner in = new Scanner(System.in);
    int playerMove = in.nextInt();
    
    // TODO: validate input?
    
    // Generate a random move for the computer
    double r = Math.random();  // uniform random value in (0.0, 1.0)
    int cpuMove;
    
    if (r < .3333) {
      cpuMove = 1;
    } else if (r < .6666) {
      cpuMove = 2;
    } else {
      cpuMove = 3;
    }
    
    System.out.println("I choose " + cpuMove + "!");
    
    // Compare the moves and declare win, lose, or draw
    
    // Draw is easy: moves have same value
    if (playerMove == cpuMove) {
      System.out.println("Draw! I'll get you next time, meatbag.");
      return;
    }
    
    // Other cases
    boolean playerWins = false;
    
    // Add test cases for the ways the player can win
    
    // Player chooses rock
    if (playerMove == 1 && cpuMove == 3) {
      playerWins = true;
    }
    
    // Player chooses paper
    if (playerMove == 2 && cpuMove == 1) {
      playerWins = true;
    }
    
     // Player chooses scissors
    if (playerMove == 3 && cpuMove == 2) {
      playerWins = true;
    }   
    
    // Value of playerWins deterines the final output
    if (playerWins) {
      System.out.println("You beat me! Beep, boop...");
    } else {
      System.out.println("Humanity...so squishy...so weak...");
    }
  }
}
