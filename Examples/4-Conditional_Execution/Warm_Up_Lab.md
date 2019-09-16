# Warm-Up Lab

## Directories

Open your Mimir IDE.

Once it comes up, check your present working directory and verify that it is `/home/YOURNAME`.

```
pwd
```

You can then `cd` into your class directory and make a new subdirectory for today's examples.

```
cd CMS_167

mkdir Conditionals

cd Conditionals
```

Now create a new file for this warm-up exercise.

```
touch Therapist.java

open Therapist.java
```

## I am the Psychotherapist. Please Describe Your Problems.

One of the earliest notable AI programs was ELIZA, developed by Joseph Weizenbaum beginning in the mid-1960's. ELIZA was intended to illustrate natural language processing by taking the role of a therapist. The program would ask the user to talk about themselves, then construct responses based off of the input.

ELIZA wasn't intelligent in any meaningful sense (it worked by applying pre-coded transformation rules to sentences) and it wasn't really intended to be a therepeutic tool, but some people did find it beneficial to discuss their lives with a nonjudgmental machine. The stream of research that ELIZA initiated continues in modern chatbots.

Write a program that functions prompts its users to talk about themselves. Make it ask the users how they're doing, read in a line of text, then print a single, pre-coded response.

Here's an example session. The second line is the user's input, the third line is an echo back, and the fourth line is the stock response.

```
How are you doing today?
I'm feeling kind of tired. I stayed up too late.
You said: I'm feeling kind of tired. I stayed up too late.
I think everything happens for a reason.
```

Later today, we'll enhance this program to let it generate **more than one possible response**.

Remember, to compile and run the program, use

```
javac Therapist.java

java Therapist
```
