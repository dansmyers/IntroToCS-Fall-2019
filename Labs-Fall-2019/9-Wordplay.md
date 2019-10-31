# Wordplay

## Description

This lab will let you practice `String` and file operations using the `words.txt` list we introduced in the last class.

Use your `CMS_167/Files` directory that should already contain `words.txt`:

```
cd CMS_167/Files
```

The code for the `StartsWithQ.java` example is below. Use this format for all of your problems: open the file and loop through the words in `main`, printing all of the words that satisfy a `boolean` test method.

```
/**
 * Use a boolean test method to find words in the word list
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StartsWithQ {

  /**
   * Return true if the word starts with 'q', false otherwise
   */
  public static boolean startsWithQ(String word) {
    if (word.charAt(0) == 'q') {
      return true;
    } else {
      return false;
    }
  }
  
  
  /**
   * Main
   */
  public static void main(String[] args) {
    
    Scanner fileInput = null;
    
    try {
      fileInput = new Scanner(new File("words.txt"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    // Print all the words that start with 'q'
    while (fileInput.hasNextLine()) {
      String word = fileInput.nextLine();
      
      if (startsWithQ(word)) {
        System.out.println(word);
      }
    }
    
  }
  
}
```

Remember: use the `charAt` method to access a single character of a `String`. Strings are indexed from 0 just like arrays.

## Questions

### Starts With `q` But Not `qu`

Modify the program above to print the words that start with `q` but not `qu`. Take the example we did in class and modify it to use a
test method that returns a `boolean` like in the example above.


### Long words

Use the `.length()` method to get the number of characters in a `String`, like so

```
int numChars = word.length();
```

Here's one annoying thing about this method:

- Arrays have a `length` *property*. To get the length of an array, use `a.length`, with no parentheses.

- `String` objects have a `length()` *method*, so you must include the parentheses to call the method.

Print all of the words with 18 or more characters.

### Ends With `x`

You can combine `charAt` and `length` to access the last character of a `String`. Print the words that end with `x`.

Tip: `String` indexing starts at 0, just like arrays, so what is the index of the last character? It's not `word.length()`!

### I'm Thinking of a Word

I'm thinking of a word that starts with `he` and ends with `he`. What could it be?

### No Vowels

<img src=https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Crwth_rem.jpg/800px-Crwth_rem.jpg width="30%" />

*The Welsh Crwth*

<img src=https://upload.wikimedia.org/wikipedia/commons/9/9f/Western_Cwm_and_Lhotse.jpg width="30%" />

*The Western Cwm (a glaciated valley) on Mt. Everest with the Lhotse Face in the background*

Find all of the words that contain no vowels and no `y`.

Tip: loop over the characters in the word and test each one to see if it's a vowel. If you find a vowel or a `y`, the test method can immediately `return false`. If you make it all the way through the loop and never find a vowel or `y`, `return true`.

### Abecedarian Words

Let's say that a word is *abecedarian* if its letters are in alphabetical order, allowing for repeated letters. For example, *effort*, *ghosty*, and *beefily* are abecedarian words.

Print all the abecedarian words in the list.

Tips: 

You can compare two `char` values using the regular relational operators: `<`, `>`, and so forth. You might remember from our discussion of ASCII and Unicode that a `char` is mapped to a number behind the scenes.

Use a loop and test if `word.charAt(i) > word.charAt(i + 1)`. If so, return `false`, because the letters are not abecedarian. Think about the ending condition of the loop.

### 

### TACOCAT is TACOCAT Backwards

<img src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/cf45aa02-f54d-4cab-a8e8-4e43c0ed6c74/dcn8689-dc15f569-0e2e-4552-b107-12fc38995653.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2NmNDVhYTAyLWY1NGQtNGNhYi1hOGU4LTRlNDNjMGVkNmM3NFwvZGNuODY4OS1kYzE1ZjU2OS0wZTJlLTQ1NTItYjEwNy0xMmZjMzg5OTU2NTMucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.UopOXSHXupOZqB0oUtH4dPwiENGDw3zC1nxStTpzhCM" width="30%" />

Find all the palindromes in the word list.

Tip: Use a loop that compares pairs of letters, starting at the outermost letters (indexes 0 and length - 1) and working inwards. If you find a pair that doesn't match, return `false` immediately. If you succeed in checking all pairs, return `true`.

### Triple Double Letters

The word `balloon` has two consecutive pairs of double letters.

I'm thinking of a word that has *three* **consecutive** pairs of double letters. What could it be?
