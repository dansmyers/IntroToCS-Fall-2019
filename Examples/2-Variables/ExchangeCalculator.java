 // Calculate conversion of dollars to Bitcoins
 // CMS 167
 
 // Use the double type for decimal values
 // Stands for "double precision floating point" which refers to how data is represented in memory
 
 public class ExchangeCalculator {
 
   public static void main(String[] args) {
     double dollars = 1000.00; 
     double exchangeRate = 10866.70;
     
     double bitcoins = dollars * exchangeRate;
     
     System.out.println("$" + dollars + " is " + bitcoins + " BTC.");
   }
   
 }
