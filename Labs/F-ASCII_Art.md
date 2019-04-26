# ASCII Art and Compression

## Description

In this lab, you'll be creating a program that can decompress some ASCII art

For this homework, you'll be writing a program to uncompress a text file and generate ASCII art.  [ASCII art](https://en.wikipedia.org/wiki/ASCII_art) involves using characters to draw a graphic picture and can be complex:

![very complex](https://upload.wikimedia.org/wikipedia/commons/4/4a/Wikipedia-Ascii.png).

![](https%3A%2F%2Fwww.deviantart.com%2Fpulvinar%2Fart%2FAscii-Star-Trek-Facepalm-159257902&psig=AOvVaw1itM-hxuhw_U3g9v3jvKiq&ust=1556374691760919)

Compression is another fundamental concept in computer science.  Compression allows us to take very large data file and make them smaller and thus suitable for transmission via the internet.  Compression can be either *lossy* (meaning that a file cannot be uncompressed back into its original form) or lossless (meaning we can compress and then uncompress a file with no loss of data.

To get started on this homework, download the hw03.zip file from Piazza (resources section).  Unzip it.  You should see 2 types of files: ArtObject.java, and some .txt files.  You will be modifying ArtObject.java.  The .txt files will be different (compressed) input files.  The file basic.txt which is small enough to inspect and verify (although it doesn't make any cool ASCII art).  mystery1.txt, mystery2.txt, and mystery3.txt contain cool ASCII art pictures that you'll only be able to see once you've implemented the uncompression algorithm below.  Open ArtObject.java and look at the main method as well the constructor for ArtObject.

The testcases in this hw will be from the file basic.txt which you'll be uncompressing.  Each line in the file will be one line in your final ASCII art image.  First, let's talk about the file format and how to uncompress it.  Open the file basic.txt with a text editor.  You'll see lines which look like:
```
$,4,%,1,*,10
```
These lines consists of (symbol, number) pairs separated by commas:
```
$ 4
% 1
* 10
```
For each of these pairs, you have a character: ```($, %, and *)``` and a number ```(4, 1, and 10)```.  To uncompress each pair, you need to repeat the character a number of times.  In other words, the pair ```*  10``` means the `*` character should be repeated 10 times yielding the string ```**********```.  Then repeat this process for each pair in the line, until you have processed the entire line.  After you have processed all the lines in the input file, you'll have a cool image.  You'll add code to display this image to the screen/console or to save the image into its own output file.

**Tasks:**

- (1) In the ArtObject file, write a method named ```processPair``` which takes a character and an integer as arguments.  The method should return a String with the character repeated the correct number of times.  You can add temporary calls to ```a.processPair``` in ```main``` to test this method while you develop (just be sure to remove/comment them before you submit).  Submit ArtObject and make sure it passes test cases 1-2 at this point.
- (2) In the ArtObject file, write a method named ```processLine``` which takes a line (String parameter) in the format: ```character, number, character, number, ...``` and returns a String with all the (character, number) pairs processed correctly.  This method should extract a (character,number) pair from the input parameter and call the ```processPair``` method repeatedly.  

You can use a Scanner to process a line (String) of input.  Review Section 12.4 (Streams Using Strings) in your textbook. Remember that a Scanner usually breaks lines up into *tokens* based on whitespace and spaces.  For this hw, we need to change the Scanner to split the line up based on commas, not spaces (like a Scanner usually does).  Use this code to instantiate a Scanner to read from a String (named ```line``` in this example) and set the scanner to split the line up based on commas.

```
String line = "$,4,@,3";
Scanner inline = new Scanner(line);
inline.useDelimiter(",");
```
Since the String ```line``` has the value  ```"$,4,@,3"``` the Scanner ```inline``` will contain the tokens $ 4 @ 3 ready for you to read using calls like ```inline.next()``` (returns the next String) and ```inline.nextInt()``` (returns the next token as an integer, if possible). 

You can add temporary calls to ```a.processLine``` in ```main``` to test this method while you develop (just be sure to remove/comment them before you submit).  Submit ArtObject and make sure it passes test cases 3-5 at this point.

- (3) In the ArtObject file, finish the ```outputToScreen``` method.  Instantiate a Scanner object and read in a line (as a String) from the file.  Transform the line from the file into a line of ASCII art output by calling ```processLine```.  Print the returned String.  Then repeat this for each line in your input file.  Submit ArtObject and make sure it passes the testcase 6 for the output when reading basic.txt (but be sure to remove/comment any debugging print statements you've added as those will cause the testcase to fail).

- (4) In the ArtObject file, modify the outputToFile method.  Notice that this method takes String representing an output file name as a parameter.  This method should save (an uncompressed version of) the ASCII art to a file.  From main, call the outputToFile method with the String basic-output.txt.  This should cause a file named basic-output.txt to be created and the uncompressed ASCII art to be written to it.  Your code should now pass test case #7.

- (5) Add javadoc style comments to your methods (except main).

Now, for fun: run your program with some of the other .txt files.  Happy Spring!

If you are planning to be a computer science major, here are some things to think about after completing the assignment:

- The purpose of compression is usually to make files smaller.  Compare some of the "compressed" txt files to their ASCII art output.  Under what circumstances does our compression algorithm fail (and actually make our "compressed" txt file larger than the ASCII art output)?  How would you describe a ASCII art picture for which our algorithm achieves maximum compression?
- Are there any symbols which could not be used in an ASCII art picture, given the compression algorithm we're using?  Why or why not?  Can you think of a way to change our compression algorithm to overcome this limitation?
- Note how this homework broke down the problem by using methods.  We could have written this entire program in a main method using nested loops.  Why is the program structure you wrote in this assignment better?  You should be able to come up with at least 3 reasons.
