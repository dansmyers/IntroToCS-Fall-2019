/**
 * Playing around with files and Strings
 * 
 * @author CMS_167
 */
 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordPlay {
    
    public static boolean startsWithQ(String word) {
        if (word.charAt(0) == 'q') {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        
        try {
            Scanner reader = new Scanner(new File("./DOESNOTEXIST.txt"));
        
            while (reader.hasNext()) {
                String line = reader.nextLine();
                
                if (startsWithQ(line)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
