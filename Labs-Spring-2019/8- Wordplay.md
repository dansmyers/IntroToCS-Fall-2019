# Wordplay

## Description

This lab will let you practice `String` and file operations using the `words.txt` list we introduced in the last class.

Use the `CMS 167 Spring 2019 Words` workspace.

The code for the `StartsWithQ.java` example is below. Use this format for all of your problems: open the file and loop through the words in `main`, printing all of the words that satisfy a `boolean` test method.

```
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFromFileInClass {

  //*** Return true if the word starts with q ***//
  public static boolean startsWithQ(String word) {
    if (word.charAt(0) == 'q') {
      return true;
    } else {
      return false;
    }
  }
  
  //*** Main ***//
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

Tips:

- Use the `charAt` method to access a single character of a `String`. Strings are indexed from 0 just like arrays.

```

## Questions

### Starts With `q` But Not `qu`

Print all of the words that start with `q` but not `qu`.

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

Tip: `String` indexing starts at 0, just like arrays, so what is the index of the last item? It's not `word.length()`!

### I'm Thinking of a Word

I'm thinking of a word that starts with `he` and ends with `he`. What could it be?

### No Vowels

Find all of the words that contain no vowels and no `y`.

Tip: loop over the characters in the word and test each one to see if it's a vowel. If you find a vowel or a `y`, the test method can immediately `return false`. If you make it all the way through the loop and never find a vowel or `y`, `return true`.

### Abecedarian Words

Let's say that a word is *abecedarian* if its letters are in alphabetical order, allowing for repeated letters. For example, *effort*, *ghosty*, and *beefily* are abecedarian words.

Print all the abecedarian words in the list.

Tip: use a loop and compare `word.charAt(i)` to `word.charAt(i + 1)`. Think about the ending condition of the loop.
