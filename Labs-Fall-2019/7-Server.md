# Systems and Servers

## Overview

This lab will be a little different from previous ones. You won't be doing any programming today. Instead, we're going to work through
a few system tools and show off some features of Linux.

You'll work on

- Installing and running new programs on Linux
- Creating a web page and running a web server on Mimir to display it
- Password cracking with a tool called *John the Ripper*.

First, set up your working directory for the lab.

```
cd CMS_167
mkdir Lab_7
cd Lab_7
```

## Fun with Programs

### Cowsay?

Let's install a new program. **Type this command in the terminal window of your Mimir IDE**.
```
sudo apt-get install cowsay
```

Linux systems have the notion of privilege levels and access control. The top level account on any system is the **superuser** or **root** account, which has the ability to make any change to anything. Regular user accounts always run with privileges below that of root.

`sudo` is `substitute user do`&mdash;it's a way to run individual commands with superuser-level privileges without actually logging in as the root account.

`apt-get` is a standard command for managing packages and installing programs on many Linux distros. It has to be run as root to make
system changes, so it's prefixed by `sudo`.

![xkcd #149](https://imgs.xkcd.com/comics/sandwich.png)

Run the program:

```
cowsay "Hello, Friend!"
```

Make the cow say a few different things.

### The Man Pages (Not a Dating Site)

To get more information on a system command, consult its manual page using the `man` command.
```
man cowsay
```    
This brings up a description of the `cowsay` command, including discussion of its optional flags and arguments.

Use the arrow keys to scroll and **press `q` to quit the viewer**.

`cowsay` can take on several optional arguments, which are called **flags**. For example, to make a dead cow, supply the `-d` flag:

```
cowsay -d "Hello, Friend!"
 _______________
< Hello, Friend >
 ---------------
        \   ^__^
         \  (xx)\_______
            (__)\       )\/\
             U  ||----w |
                ||     ||
```
    
You can also use a different image file with the `-f` flag:

```
cowsay -f dragon "Extra crispy!"
```

### Fortunate Cows

Install another silly program:
```
sudo apt-get install fortune
```
`fortune` prints sayings&mdash;some profound, some not&mdash;to the console. You can have some fun by **piping** the output of `fortune` to the input of `cowsay`.

```
fortune | cowsay
```

A **pipe** is a connection between two processes. The output of one end of the pipe becomes the input to the other end. In this example, the output of `fortune`, which would ordinarily go to the console, is redirected to the `cowsay` program instead, which then uses it as input and prints an oracular cow.

Pipes are a common tool in the Unix world: they allow you to chain small, simple programs together to accomplish complex feats of text processing.


## Let's Make a Web Server

### Write a Serve a Basic Web Page

**Creating the Page**  Let's make a basic web page. It needs to be named `index.html`.

```
touch index.html
open index.html
```

Put the following text in `index.html`. I'll tell you more about how this file is put together in the next section, after you've had the
chance to run and display it.

```
<!DOCTYPE html>
<html>
    <!-- This is an HTML comment -->
    <!-- 
        The basic HTML file has two sections:
        <head> contains metainformation on the whole page
        <body> contains page content
      -->

    <head>
        <title>This appears at the top of the browser.</title>
    </head>
    <body>
        <h1>This is a Website.</h1>
        
        <p>This is a paragraph of text on a website.</p>
        
        <p>Here's another paragraph.</p>
        
        <p>That's all.</p>
    </body>
</html>
```

Save the file using CTRL + s or COMMAND + s on Macs.

**Serving Your Page** Mimir supports a basic web server that you can run by typing `srv`:

```
srv

Serving HTTP on 0.0.0.0 port 80 ...
```

The `srv` program creates a network connection that listens for incoming requests from web browsers. When it receives one, it responds
by returning the `index.html` page that you just created and saved.

**Port numbers** Every program that makes a network connection is assigned a special **port number** that is used by the operating 
system to manage its connections. By convention, web servers are usually assigned to run on port 80.

**Viewing Your Page** Go to `View` in the top Mimir menu, then select `View Port` and choose port 80. This action will pop up a new tab 
displaying your web page.

The URL for your page will be something like:

```
https://silly-baldr_80.ide.mimir.io/
```

where `silly-baldr` will be replaced with a different name matching your current Mimir workspace.

**Stopping the Server** Press CTRL + c in the terminal window to stop the server program.


### Page Contents

Web pages are written in **HTML**, the *Hypertext Markup Language*. An HTML file is a mixture of regular text and special **tags** that tell your web browser how to format the page.

All tags are enclosed in angle brackets.

THe top-level tag is `<html>`, which encloses all of the page content. Inside the `<html>` tag are two main sections:

- `<head>`, which is used to hold meta-information about the page.
- `<body`>, which stores the actual page content.

Notice that all of the tags have an opening version, like `<body>`, and a closing version with a slash, like `</body>`

Your example page uses two other tags

- `<h1>` is the top-level header tag. Anything you put between `<h1>` and its closing partner `</h1>` appears big and bold when the page renders. There are also `<h2>`, `<h3>`, and `<h4>` tags.

- `<p>` is the paragraph tag, to make a new section of text on the page.

### Jam

Before going further, experiment with making some changes to your page and visualizing the results.

### Interior Decoration

cURL is a useful tool that let's you interact with a remote server from the command line. Among its MANY uses is grabbing files from a remote location.

```
curl -O https://upload.wikimedia.org/wikipedia/commons/0/0a/The_Great_Wave_off_Kanagawa.jpg
```

The `-O` flag saves the file locally.

Open your `index.html` file and add an `<img>` tag in the body section to display the image.

```
<p>
    <img src="The_Great_Wave_off_Kanagawa.jpg"/>
</p>
```

Reload the page and check out your picture.

Yikes. That's large. You can add style to the tag to scale the image to a percentage of the display width:

```
<p>
    <img src="The_Great_Wave_off_Kanagawa.jpg" style="width:50%"/>
</p>
```

You can also set an absolute size in pixels, e.g. `"width:200px"`.

### A Little CSS

Styling elements using individual tags was common in the old-school web, but modern practice favors separating page content from styling. Let's add a `<style>` section to the `<head>` block that will hold rules for styling page elements.

```
<head>
    <title>This appears at the top of the browser.</title>

    <style>
        img {
            width: 50%;
        }
    </style>
</head>
```

The style rule specifies that the contents of all `<img>` tags should have their width set to 50% of the page size.

This way of styling the page is called **CSS**, which is short for *Cascading Style Sheets*, though that name doesn't really have any meaning and survives only for historical regions. Basically, when you read about CSS, think of styling and page layout.

You can add elements to the style block to control the presentation of other parts of the page. For example, to style the contents of  the entire body:

```
<head>
    <title>This appears at the top of the browser.</title>

    <style>
        img {
            width: 200px;
        }

        body {
            font-family: "Helvetica", "Arial", sans-serif;
            font-size: 18pt;
            background-color: #FAFAFA;
        }
    </style>
</head>
```

**Fonts** The `font-family` parameter takes a list of fonts (a "font stack") and uses the first one that's available on the system. Here, the first choice font is Helvetica and the last choice is the default system sans-serif font, which is guaranteed to exist.`font-size` controls the size.

**Colors** Colors are specified as three values, denoting the red, green, and blue components of the color. Each value is represented using the **hexadecimal** number system, which encodes a byte of data as a number from `00` to `FF`.

The string `#FAFAFA` sets R, G, and B to a nice equal gray color. For something more vibrant try

- `#0071BA` (the official brand-approved Rollins blue color). This color has no red (`00`), some green (`71`) and a good amount of blue (`BA`).
- `#FACF00` (the official brand-approved Rollins gold color). This color has a lot of red (`FF`), some green (`CF`) and no blue (`00`).

Play around with a color picker and experiment with different color strings:

https://htmlcolorcodes.com/color-picker/

You can also set the `color` property to control the color of the text.

**A e s t h e t i c s** Here's one last style block that makes things a little more readable by bringing the page contents to the center.

```
<style>
    img {
        width: 100%;
    }

    body {
        font-family: "Helvetica", "Arial", sans-serif;
        font-size: 18pt;
        color: #333333;
        background-color: #FCFCFC;
        margin: 40px auto;
        max-width: 640px;
    }
</style>
```

`max-width` controls the size of the display region in the browser.

`margin` sets a padding of 40px around all sides of the page content; `auto` centers the display region inside the browser frame, pulling everything to the middle. Note that this is centering the display region, not the content itself.

The background and text are softened a little away from strict white and black.


## Password Cracking

For the second part of the lab, we'll work on cracking some passwords using *John the Ripper*, an open source cracking program.

### How does a Linux system store your password?

Old systems actually stored users' passwords in a cleartext file called `/etc/passwd`. Unfortunately, this meant that anyone gaining access to that file would have every system users' real password.

Modern systems use a **shadow** password file, stored in `/etc/shadow`. The shadow file doesn't store user's real passwords. Instead, it stores **hashes** of each password.

Recall that a hash function takes data (of any size) and spits out a fixed-size summary:

```
hash(input data) = fixed-size output
```

Here's what happens when you log in to a system:

- You type your password.
- The system computes the **hash** of your password and compares it to the stored hash in the `shadow` file.
- If the hashes match then, with very high probability, the password you typed is the correct one and the system allows you to log in.
- If the hashes don't match, then you must have typed the wrong password.

### What Do Hackers Do With Stolen Passwords?

You'll often hear that a company has been hacked and some users have had their passwords compromised. This doesn't mean that the users' real passwords have been stolen. Rather, it means that the database of **password hashes** has been taken by a hacker.

The hacker now has the challenge of **reverse-engineering** the correct passwords that match the stolen hashes.

```
hash(?) = stolen password hash
```

This is usually hard, because strong cryptographic hash functions are **not invertible**. Therefore, the attacker's only option is to try lots of passwords until finding one that matches a hash from the database.

- One strategy is to **brute-force** the passwords: just try every combination of possible passwords until finding one that generates a match. This is guaranteed to eventually work, but it's time consuming.

- A better strategy (from the hacker's perspective) is to take advantage of **weak passwords**. This is what *John the Ripper* is designed to do.

It turns out that a very high fraction of real passwords can be cracked without resorting to an extensive brute-force search.


### Get Ripped

A password cracker takes a shadow password file as input and reverse-engineers the real passwords that correspond to the hashes it contains.

Install John the Ripper:

```
sudo apt-get install john
```

Now make an example shadow password file:

```
openssl passwd -1 "password" > shadow_test
```

Let's break this command down:

- `openssl` is a program for performing, among other things, crypto-related operations.

- The `-1` tells `openssl` to use a standard hash function called MD5, which is not the fanciest hash around, but is a good choice for this example.

- `password` is the real password that is being hashed. **This is a terrible password**.

- The operation `> shadow_test` redirects the output of `openssl`, which would normally be printed to the terminal, to a file named `shadow_test`.

Check the contents of the file:

```
cat shadow_test
```

You will see output that looks like

```
$1$w3wN/O62$g76w7x9WCQ6p9C54UPYMI/
```

This is the MD5 hash of the string `password`, represented as text characters.

### Crack

Now get cracking:

```
john shadow_test
```

`john` quickly tries a few basic cracking rules, one of which is blasting through a list of common passwords. Since `password` is on that list, it quickly identifies that the string `password` matches up with the data in the `shadow_test` file.

Let's try something a littler harder:

```
openssl passwd -1 "raspberry" > shadow_test
```

You can run `john shadow_test` again and let it run for a minute or so, but it won't crack the password. `raspberry` is too unusual for the default cracking approach. Try pressing the spacebar as `john` runs to get a status update on what it's currently trying.

Can we do better? Yes, we can, with a **dictionary** attack. Many people base their passwords off of common words, so a good hacking
approach is to just cycle through the 10000 or so most common words.

Download a large list of words:

```
sudo apt-get install wamerican-large
```

Now run the program again, using the large wordlist as a list of candidate passwords.

```
john --wordlist=/usr/share/dict/american-english-large shadow_test
```

It will take a moment, but `john` will work its way through the list to find `raspberry` and crack the password. Press the spacebar for updates as it cracks.

### The Mangler

How about one more?

```
openssl passwd -1 "raspberry1" > shadow_test
```

This seems better, because it's a total of 10 characters and includes a number. 

John is still one step ahead of you, though, because it can apply **mangling rules** to the candidate wordlist to generate new passwords that match common patterns.

Appending a single digit to a word is a really common password-generating strategy, so `john` supports it as a default mangling rule.

```
john --wordlist=/usr/share/dict/american-english-large --rules shadow_test
```

This approach is extremely effective. People are not very creative, on average, so a good list of words and a set of common mangling patterns (appending a number, capitalizing the first letter, etc.) is enough to crack a large fraction of the hashes in a typical password database.

### Rules for Survival

How to create good passwords that will stand up to cracking? Basically, a combination of length and unusualness.

- Long, truly random passwords are always strong, because they can only be cracked by brute force. On the other hand, they're almost impossible to remember without a password manager.
    
- Failing that, a combination of length, a large character set with capitals and special characters, and a generation process that avoids common mangling rules.

One popular approach is to randomly string together words from a list.

![xkcd 936](https://imgs.xkcd.com/comics/password_strength.png)

## One More Thing...
Telnet is a program for establishing a remote connection to another server.

```
sudo apt-get install telnet
telnet towel.blinkenlights.nl
```

Close the terminal window to quit.
