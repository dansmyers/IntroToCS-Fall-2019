// Examples of if statements
// CMS 167

import java.util.Scanner;

public class IfStatements {

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a number and I'll tell you if it's even or odd.");
        int value = input.nextInt();
        
        if (value % 2 == 0) {
            System.out.println("Even.");
        } else {
            System.out.println("Odd.");
        }
    
    }

}
