# Minesweeper

## Basic Class

Create a new project named `Minesweeper` and import `StdDraw` to it using Edit --> Add Class from File. Create one more new class
named `Minesweeper`, which will hold all of the code for the game. Unlike previous projects, we're going back to a simpler style with
one `main` and a few static methods.

It turns out that the basic Minesweeper game is quite compact. The trickiest part is dealing with mouse clicks.

Here is the basic class:

```
// MINESWEEPER
// CMS 167, Spring 2019

public class Minesweeper {
    
    static final int DIMENSION = 10;
    static final double RADIUS = 1.0 / DIMENSION / 2.0;
    
    static final int NUM_MINES = DIMENSION;
    
    //*** Draw the grid of squares on the board ***//
    public static void drawGrid() {
        
        for (double row = RADIUS; row < 1.0; row += RADIUS * 2) {
            for (double col = RADIUS; col < 1.0; col += RADIUS * 2) {
                StdDraw.square(row, col, RADIUS);  
            }
        }
    }
    
    public static void main(String[] args) {
        
        // 2-D array that represents the locations of the mines
        boolean[][] mines = new boolean[DIMENSION][DIMENSION];
        
        // Insert mines
        mines[0][0] = true;
        mines[4][4] = true;
        mines[5][5] = true;
        mines[9][9] = true;
        
        // Strategy: draw the grid one time, then update it every time the
        // user clicks a square
        //
        // Unlike previous games, we won't clear the screen on every iteration
        
        StdDraw.clear();

        drawGrid();
        
        boolean playing = true;
        while (playing) {               
            
            if (StdDraw.mousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                
                System.out.println(x + "   " + y);
            }
                        
            StdDraw.show(100);
            
        }   
    } 
}
```

## Setup

We'll assume the board is an N x N square grid. The declarations at the top store the value of N in a constant named `DIMENSION`. The 
size of each individual square in the grid is calculated from DIMENSION and stored in `RADIUS`.

The number of mines is set to `DIMENSION`, but could be changed to something else. For now, a small test set of mines is hardcoded at the beginning of `main`. Later, we'll replace that with some code to put the mines in random locations.

The basic game loop runs over and over again waiting for mouse presses. `StdDraw.mousePressed()` returns true if the user clicks the mouse button. The `mouseX` and `mouseY` methods return the x and y coordinates of the click on the `StdDraw` window.

Run this program and try a few clicks to verify that the coordinates you see make sense.

## Convert Clicks to Grid Cells

Here's the big challenge of this program: the mouse clicks are in a continuous 2-D space, with (0.0, 0.0) in the **lower-left corner**. If we want to use a normal grid representation, we need to think about `mines[0][0]` corresponding to the square in the **upper-left** corner of the grid.

Each grid square has width `RADIUS * 2`, so dividing by that value will tell us which grid square the user clicked. Casting to an `int` rounds down to the lower whole number, which is what we want.

Add the following code right after the calls to `mouseX` and `mouseY`:

```
                // Convert mouse position to a grid position
                // Mouse assumes (0, 0) is lower left corner
                // Grid uses index [0][0] as upper left corner
                int col = (int) (x / (RADIUS * 2));
                int row = (int) ((1.0 - y) / (RADIUS * 2));
```

Notice a couple of things:

- The **column** is determined by the mouse's x position.

- The second line uses `1.0 - y` to map y values close to 1.0 (corresponding to clicks near the top of the screen) to **lower-numbered** row values.

Add a line to print the `row` and `col` values and make sure they correspond to the grid indices of each square you click.

## Ka-Boom

Okay. Here's how to deal with mouse clicks:

- If the user clicks a square with a mine, paint it red and stop the game.

- If the user clicks a square without a mine, fill it with the number of mines in the neighbor squares.

Challenge: both of these operations require calculating the center of the clicked square, which depends on the row, column, and `RADIUS`:

```
                double centerY = 1.0 - row * 2 * RADIUS - RADIUS;
                double centerX = col * 2 * RADIUS + RADIUS;
                                
                // Boom!
                if (mines[row][col]) {
                    StdDraw.setPenColor(240, 10, 10);
                    StdDraw.filledSquare(centerX, centerY, RADIUS);
                    playing = false;
                }
                
                // If not boom, print number of neighbor mines
                else {
                    int numMines = countNeighborMines(row, col, mines);
                    
                    StdDraw.setPenColor(0, 0, 0);
                    StdDraw.text(centerX, centerY, Integer.toString(numMines));
                }
```

Take a moment to look at those calculations and understand how they work.

## One! One Mine!

The last piece is the `countNeighborMines` method. Given a row and column and the `mines` array, it checks the eight neighbor squares and returns the number of mines that surround (`row`, `col`).

Challenge: what about edge and corner squares? You can't check a square if it would be off the grid.

Here's the code. The loops try to step through the eight neighbors of position (`row`, `col`):

- (`row - 1`, `col - 1`)
- (`row - 1`, `col`)
- (`row - 1`, `col + 1`)
- (`row`, `col - 1`)
- (`row`, `col + 1`)
- (`row + 1`, `col - 1`)
- (`row + 1`, `col`)
- (`row + 1`, `col + 1`)

If any position would go off the board, just skip it.

```
    public static int countNeighborMines(int row, int col, boolean[][] mines) {
        int numMines = 0;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;    
                }
                
                if (row + i < 0 || row + i >= DIMENSION) {
                    continue;   
                }
                
                if (col + j < 0 || col + j >= DIMENSION) {
                    continue;   
                }
                
                if (mines[row + i][col + j]) {
                    numMines++;   
                }
            }
        }
        
        return numMines;
    }
```

## Random Mines

Finally, add some code to position random mines in the grid. Put this right before the start of the main loop, replacing the temporary hardcoded mine locations.

```
        int minesInserted = 0;
        while (minesInserted < NUM_MINES) {
            int randRow = (int) (Math.random() * DIMENSION);
            int randCol = (int) (Math.random() * DIMENSION);
            
            if (!mines[randRow][randCol]) {
                mines[randRow][randCol] = true;
                minesInserted++;
            }
        }
```

## The Complete Code

```
// MINESWEEPER
// CMS 167, Spring 2019

public class Minesweeper {
    
    static final int DIMENSION = 10;
    static final double RADIUS = 1.0 / DIMENSION / 2.0;
    
    static final int NUM_MINES = DIMENSION;
    
    //*** Draw the grid of squares on the board ***//
    public static void drawGrid() {
        
        for (double row = RADIUS; row < 1.0; row += RADIUS * 2) {
            for (double col = RADIUS; col < 1.0; col += RADIUS * 2) {
                StdDraw.square(row, col, RADIUS);  
            }
        }
    }
    
    //*** Count the number of mines surrounding a square ***//
    //
    // Challenge: edge squares don't have all eight neighbors, so we have to include
    // some checks to determine if a neighbor square exists before attempting to
    // count it
    public static int countNeighborMines(int row, int col, boolean[][] mines) {
        int numMines = 0;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;    
                }
                
                if (row + i < 0 || row + i >= DIMENSION) {
                    continue;   
                }
                
                if (col + j < 0 || col + j >= DIMENSION) {
                    continue;   
                }
                
                if (mines[row + i][col + j]) {
                    numMines++;   
                }
            }
        }
        
        return numMines;
    }
    
 
    public static void main(String[] args) {
        
        // 2-D array that represents the locations of the mines
        boolean[][] mines = new boolean[DIMENSION][DIMENSION];
        
        // Insert random mines
        int minesInserted = 0;
        while (minesInserted < NUM_MINES) {
            int randRow = (int) (Math.random() * DIMENSION);
            int randCol = (int) (Math.random() * DIMENSION);
            
            if (!mines[randRow][randCol]) {
                mines[randRow][randCol] = true;
                minesInserted++;
            }
        }
        
        // Strategy: draw the grid one time, then update it every time the
        // user clicks a square
        //
        // Unlike previous games, we won't clear the screen on every iteration
        
        StdDraw.clear();

        drawGrid();
        
        boolean playing = true;
        while (playing) {
                        
            if (StdDraw.mousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                
                // Convert mouse position to a grid position
                // Mouse assumes (0, 0) is lower left corner
                // Grid uses index [0][0] as upper left corner
                int col = (int) (x / (RADIUS * 2));
                int row = (int) ((1.0 - y) / (RADIUS * 2));
                
                double centerY = 1.0 - row * 2 * RADIUS - RADIUS;
                double centerX = col * 2 * RADIUS + RADIUS;
                                
                // Boom!
                if (mines[row][col]) {
                    StdDraw.setPenColor(240, 10, 10);
                    StdDraw.filledSquare(centerX, centerY, RADIUS);
                    playing = false;
                }
                
                // If not boom, print number of neighbor mines
                else {
                    int numMines = countNeighborMines(row, col, mines);
                    
                    StdDraw.setPenColor(0, 0, 0);
                    StdDraw.text(centerX, centerY, Integer.toString(numMines));
                }
            }
                        
            StdDraw.show(100);
            
        }  
    } 
}
```
