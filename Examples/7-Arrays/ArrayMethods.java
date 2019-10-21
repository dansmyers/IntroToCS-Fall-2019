/**
 * Array Methods
 *
 * @author CMS 167
 */
 
public static void main(String[] args) {

    /**
     * Sum of array elements
     *
     * @param  a  input int array
     * @return    the sum of a's elements
     */
    public static int sum(int[] a) {
        int total = 0;
        
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        
        return total;
    }
    
    
    /**
     * Average of array elements
     *
     * @param  a  input int array
     * @return    the average of a's elements as a double
     */
    public static double average(int[] a) {
        return sum(a) / ((double) a.length);    
    }


    /**
     * Sum of array elements
     *
     * @param  a  input int array
     * @return    the max of a's elements
     */
    public static int max(int[] a) {
        int max = a[0];
        
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        
        return max;
    }
    
}
