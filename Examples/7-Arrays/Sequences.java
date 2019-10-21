/**
 * Creating array sequences
 *
 * @author CMS 167
 */
 
public static void main(String[] args) {


    public static int[] fill(int n) {
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        
        return a;
    }
    
    
    public static int[] powersOf2(int n) {
        int[] powers = new int[n];
        
        for (int i = 0; i < n; i++) {
            powers[i] = Math.pow(2, i);
        }
        
        return powers;
    }
    
    
    public static int[] fib(int n) {
        int[] a = new int[n];
        
        a[0] = 0;
        a[1] = 1;
        
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
    
        return a;
    }
    
}
