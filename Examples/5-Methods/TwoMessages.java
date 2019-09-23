// Use two methods to print two messages
// CMS 167

// What is the output of this program?

public class TwoMessages {

    public static void messageOne() {
        System.out.println("Hello.");
        messageTwo();
    }
    
    public static void messageTwo() {
        System.out.println("Is it me you're looking for?");
    }
    
    public static void main(String[] args) {
        messageOne();
    }

}
