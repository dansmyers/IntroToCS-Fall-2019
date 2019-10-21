/**
 * Creating array sequences
 *
 * @author CMS 167
 */
 
public static void main(String[] args) {

    /**
     * Fill an array with values 0 to n - 1
     *
     * @param  n  the length of the array
     * @return    an array filled with 0 to n - 1
     */
    public static int[] fill(int n) {
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        
        return a;
    }
 
    
    /**
     * Fill an array with powers of 2
     *
     * @param  n  the number of powers to generate
     * @return    the array of 2^0 to 2^(n - 1)
     */    
    public static int[] powersOf2(int n) {
        int[] powers = new int[n];
        
        for (int i = 0; i < n; i++) {
            powers[i] = Math.pow(2, i);
        }
        
        return powers;
    }
    
    
    /**
     * Fill an array with Fibonacci numbers
     *
     * @param  n  the number of Fibonacci numbers to generate
     * @return    the array of the first n Fibonacci numbers
     */    
    public static int[] fib(int n) {
     
        // Special case for n = 1
        if (n == 1) {
            int [] a = {0};
            return a;
        }
     
        int[] a = new int[n];
        
        a[0] = 0;
        a[1] = 1;
        
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
    
        return a;
    }
    
}
