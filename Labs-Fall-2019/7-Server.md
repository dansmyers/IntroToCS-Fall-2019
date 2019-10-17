# Systems and Servers

## Overview

This lab will be a little different from previous ones. You won't be doing any programming today. Instead, we're going to work through
a few system tools and show off some features of Linux.

You'll work on

- Installing and running new programs on Linux
- Creating a web page and running a web server on Mimir to display it
- Password cracking with a tool called *John the Ripper*.

## Fun with Programs

### Cowsay?

Let's install a new program.
```
prompt$ sudo apt-get install cowsay
```

**`sudo`** Linux systems have the notion of privilege levels and access control. The top level account on any system is the **superuser** or **root** account, which has the ability to make any change to anything. Regular users always run with privileges below that of root.

`sudo` is `substitute user do`&mdash;it's a way to run individual commands with superuser-level privileges without actually logging in as the root account.

![xkcd #149](https://imgs.xkcd.com/comics/sandwich.png)

`apt-get` is a standard command for managing packages and installing programs on many Linux distros. It has to be run as root to make
system changes, so it's prefixed by `sudo`.

Run the program:
```
prompt$ cowsay "Hello, Friend!"
  _______________
< Hello, Friend! >
  ---------------
       \   ^__^ 
        \  (oo)\_______
           (__)\       )\/\
               ||----w |
               ||     ||
```               
Make the cow say a few different things.

### The Man Pages (Not a Dating Site)

To get more information on a system command, consult its manual page using the `man` command.
```
prompt$ man cowsay
```    
This brings up a description of the `cowsay` command, including discussion of its optional flags and arguments.

Use the arrow keys to scroll and press `q` to quit the viewer.

Using the information in the man page, make the cow take on the following qualities:
  - dead
  - tired
  - youthful
  - Borg
    
You can also use a different image file with the -f flag:
```
prompt$ cowsay -f dragon "Extra crispy!"
```

### Fortunate Cows

Install another silly program:
```
prompt$ sudo apt-get install fortune
```
`fortune` prints sayings&mdash;some profound, some not&mdash;to the console. You can have some fun by **piping** the output of `fortune` to the input of `cowsay`.
```
prompt$ fortune | cowsay
```

A **pipe** is a connection between two processes. The output of one end of the pipe becomes the input to the other end. In this example, the output of `fortune`, which would ordinarily go to the console, is redirected to the `cowsay` program instead, which then uses it as input and prints an oracular cow.

Pipes are a common tool in the Unix world: they allow you to chain small, simple programs together to accomplish complex feats of text processing.

### One More Thing...
Telnet is a program for establishing a remote connection to another server.

```
prompt$ sudo apt-get install telnet
prompt telnet towel.blinkenlights.nl
```

Close the terminal window to quit.
