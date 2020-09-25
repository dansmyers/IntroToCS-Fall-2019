/**
 * Calculate the sum of the first 1000 natural numbers
 *
 * @author CMS 167
 */
 
public class SumNumbers {

    /**
     * Main
     */
    public static void main(String[] args) {
        int n = 1;
        int sum = 0;
        
        for (int n = 1; n <= 1000; n++) {
            sum += n;
            n += 1;
        }
    }

}
