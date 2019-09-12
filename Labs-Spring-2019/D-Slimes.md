# Slimes

## Description

You're a slime. You get to move around, absorbing other slimes, getting bigger each time you eat one. But the other slimes are also absorbing each other and getting bigger. In the Game of Slimes, you grow or you die.

## The Code

Make a new BlueJ project named `SlimeGame` and add `StdDraw` to it. Create three more classes: `SlimeGame`, `Slime`, and `Player`.

```
// Slime Game
// Move around and absorb other slimes to get bigger
//
// CMS 167

import java.util.ArrayList;

public class SlimeGame {
    
    public static void main(String[] args) {
        
        final int MAX_SLIMES = 200;
        final int START_SLIMES = 200;
        
        Player player = new Player();
        
        ArrayList<Slime> slimes = new ArrayList<Slime>();
        for (int i = 0; i < START_SLIMES; i++) {
            slimes.add(new Slime());   
        }
        
        boolean playing = true;
        while (playing) {
            
            // Move the player
            player.update();
            
            ArrayList<Slime> removeList = new ArrayList<Slime>();
            
            // Loop over the other slimes
            for (Slime s : slimes) {
                // Move the slime
                s.update();   
                
                // Check if the player absorbs slime s
                if (player.absorbs(s)) {
                    player.grow(s.getRadius() * .10);
                    removeList.add(s);
                    continue;
                }
                
                if (s.absorbs(player)) {
                    playing = false;   
                }
                
                // Check if this slime absorbs any others
                for (Slime other : slimes) {
                    
                    // Can't absorb yourself
                    // Using == checks if other and s are the same object
                    if (other == s) {
                        continue;    
                    }
                    
                    if (s.absorbs(other)) {
                        s.grow(other.getRadius() * .10);   
                        removeList.add(other);
                    }
                }
                
            }
            
            // Remove absorbed slimes from the list
            slimes.removeAll(removeList);
            
            // Generate new slimes
            if (slimes.size() < MAX_SLIMES && Math.random() < .10) {
                slimes.add(new Slime());
            }
              
            // Draw
            StdDraw.clear();
            player.draw();
            for (Slime s : slimes) {
                s.draw();   
            }
            StdDraw.show(20);
        }
        
    }
    
}
```

```
// A Slime that moves randomly
// It can absorb other slimes to grow bigger

public class Slime {
    
    // protected instance variables are passed to subclasses
    protected double x;
    protected double y;
    protected double radius;
    protected double step;
    protected int red;
    protected int green;
    protected int blue;
    
    private double dx;
    private double dy;
    private int moves;
    
    public Slime() {
        this.x = Math.random() * .9 + .05;
        this.y = Math.random() * .9 + .05;
        
        this.radius = Math.random() * .04;
        
        this.red = (int) (Math.random() *  255);
        this.green = (int) (Math.random() *  255);
        this.blue = (int) (Math.random() *  255);
        
        this.moves = 0;
    }
    
    public double getX() {
       return this.x;   
    }
    
    
    public double getY() {
        return this.y;
    }

    
    public double getRadius() {
        return this.radius;   
    }
    
    
    public boolean absorbs(Slime other) {
        
        // You can't absorb a bigger slime
        if (other.getRadius() > this.radius * 1.10) {
            return false;   
        }
        
        // Euclidean distance between slime centers
        double xDist = this.x - other.getX();
        double yDist = this.y - other.getY();
        
        double distance = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));  
        
        // If the slime is the same size or smaller, aborb it if its center
        // is within radius
        if (distance < this.radius) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public void grow(double amount) {
        if (this.radius > .50) {
            return;   
        }
        this.radius += amount;   
    }
    
    
    public void update() {
        if (this.moves == 0) {
            this.dx = (Math.random() - .5) * .001;
            this.dy = (Math.random() - .5) * .001;
            this.moves = (int) (Math.random() * 1000);
        }
        
        if (this.x + this.radius > 1.0 || this.x - this.radius < 0.0) {
            this.dx = -this.dx;   
        }
        
        if (this.y + this.radius > 1.0 || this.y - this.radius < 0.0) {
            this.dy = -this.dy;   
        }
        
        this.x += this.dx;
        this.y += this.dy;
        this.moves--;
        
        
    }
    
    
    public void draw() {
        StdDraw.setPenColor(this.red, this.green, this.blue);
        StdDraw.filledCircle(this.x, this.y, this.radius);
    }
}
```


```
// A Slime that represents the Player in the game
// Inherits methods and properties from Slime, but has its own update method

import java.awt.event.KeyEvent;

public class Player extends Slime {
    
    public Player() {        
        this.x = .02;
        this.y = .02;
        
        this.radius = .02;
        
        this.step = .005;
        
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }
    
    
    public void update() {
        if(StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
            this.y += this.step;   
        }
        
        if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
            this.y -= this.step;   
        }
        
        if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.x += this.step;   
        }
        
        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.x -= this.step;   
        }
       
    }
}
```

## New Features

Most of the code is similar to our other games, but this project shows off two new features.

### Inheritance and `extends`

First, we're going to play around with Java's `extends` feature. We've talked before about how classes can exist in families or hierarchies. This is useful for writing complex programs, because it allows you to create one high-level class that serves as a template for more specialized classes. Common code can be shared from the **parent** class and doesn't have to be reimplemented in the **subclasses**.

In this case, the parent class is `Slime`, which represents all slimes in the game. The `Slime` class defines a set of useful methods for all `Slime` objects:

- `absorbs`, which tests if one `Slime` is big enough and close enough to absorb another
- `grow`, which increases a `Slime`'s `radius` parameter
- `draw`
- `get` methods for the `Slime`'s other attributes
- A general `update` method, which moves the slime in a random direction for a random number of steps, then picks another direction.

The `Player` class is a special type of `Slime`. It needs to be able to call `absorbs` and `grow`, like other `Slime` objects, but it moves in a different way because it's controlled by the keyboard.

Take a look at the code for the `Player` class:

```
// A Slime that represents the Player in the game
// Inherits methods and properties from Slime, but has its own update method

import java.awt.event.KeyEvent;

public class Player extends Slime {
    
    public Player() {        
        this.x = .02;
        this.y = .02;
        
        this.radius = .02;
        
        this.step = .005;
        
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }
    
    
    public void update() {
        if(StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
            this.y += this.step;   
        }
        
        if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
            this.y -= this.step;   
        }
        
        if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.x += this.step;   
        }
        
        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.x -= this.step;   
        }
       
    }
}
```

The `Player` only defines two methods: a constructor and an `update` method that uses the keyboard. Notice that it doesn't have any of the variables we'd expect it to have: `x`, `y`, `radius`, and color variables.

Where are the `Player`'s variables? They're being automatically **inherited** from the `Slime` class. The magic word is `extends`:

```
public class Player extends Slime {
```

This keyword informs Java that a `Player` is a special type of `Slime`, and everything a `Slime` can do, a `Player` can also do. Therefore, we don't need to redeclare variables in the `Player` class, or write methods for `absorbs`, `draw`, `grow` etc. These features are already available through **inheritance** from the `Slime` class.

### Enhanced `for` Loop

Take a look at this section of the `SlimeGame` `main` method:

```
            // Loop over the other slimes
            for (Slime s : slimes) {
                // Move the slime
                s.update();   
                
                // Check if the player absorbs slime s
                if (player.absorbs(s)) {
                    player.grow(s.getRadius() * .10);
                    removeList.add(s);
                    continue;
                }
                
                if (s.absorbs(player)) {
                    playing = false;   
                }
                
                // Check if this slime absorbs any others
                for (Slime other : slimes) {
                    
                    // Can't absorb yourself
                    // Using == checks if other and s are the same object
                    if (other == s) {
                        continue;    
                    }
                    
                    if (s.absorbs(other)) {
                        s.grow(other.getRadius() * .10);   
                        removeList.add(other);
                    }
                }
                
            }
```

It's common to need to iterate over the elements of an `ArrayList`. One way to do this is with a standard counting-based `for` loop:

```
for (int i = 0; i < slimes.size(); i++) {
    Slime s = slimes.get(i);
    
    // Check things with Slime s
}
```

Java supports another form of the `for` loop that does the same things as that pattern, but removes the need to declare a loop index variable or call the `get` method:

```
for (Slime s : slimes) {
    // Check things with Slime s
}
```

This pattern automatically steps through the contens of the `ArrayList` `slimes`. On each iteration the variable `s` is assigned the next `Slime` in the list.

The two techniques are equivalent, but the enhanced loop is easier to read if you don't need the loop index.

