# Breakout: a Brick-Blasting Arcade Game

## Due Tuesday, 11/26 (that's the Tuesday before Thanksgiving!)

## Description

You're going to write your own version of one of the all-time classic arcade games: Breakout.

<img src="https://i.ytimg.com/vi/AMUv8KvVt08/maxresdefault.jpg" width="50%" />

You've probably seen this game or one of its *many* derivatives before (back in my day we called it [Arkanoid](https://en.wikipedia.org/wiki/Arkanoid) *shakes old man fist at heaven*).

The object is to bounce the ball off the paddle and make it collide with the grid of bricks.

This project will let you keep practicing all of the concepts we've developed in our previous graphics labs:

- Representing game elements as objects
- Moving and drawing objects on the screen
- Getting keyboard input and using it to control objects
- Checking for collisions

You don't have to write **that much** code for this project, but you do have to think hard about how a non-trivial program built from multiple classes works.

To get full credit for this project, you must do two things:

1. Finish the basic Breakout game, using the instructions below.
2. Add **one new feature** to the game. This can be anything you want, but you have to make some modification to the code that extends or alters the game in some small or large way.

## The Code

This repo contains four classes:

1. `Breakout.java`: the driver program that contains the `main` method with the game loop
2. `Ball.java`: representing the ball; this class is similar to the other ball classes we've written
3. `Paddle.java`: the paddle at the bottom of the screen; it can move left and right
4. `Brick.java`: a single brick

I've already given you some starter code. Start by looking at `Breakout.java`.

There is a `Brick[]` named `bricks` that stores all of the `Brick` objects. I've written an initialization loop and the `Brick` constructor to automatically fill this array with a correctly-positioned grid of bricks.

**You don't need to modify any of the initialization code**.

The main loop does the following:

- Check for the game-ending conditions (you'll need to write this code)

- Check if the `Ball` hits the `Paddle` using the `Ball`'s `checkPaddleCollision` method.

- Check if the `Ball` hits any of the `Brick` objects.

- Update the `Ball` and `Paddle` positions.

- Draw everything.

## Plan

Here is a recommended plan of attack for implementing the full game.

1. Make the `Ball` move and bounce around the screen.

2. Make the `Paddle` move left and right.

3. Implement the `right`, `left`, `top`, and `bottom` methods in the `Paddle` class.

4. Implement `checkPaddleCollision` in the `Ball` class to make the `Ball` reflect off the `Paddle`.

5. Implement the `right`, `left`, `top`, and `bottom` methods in the `Brick` class.

4. Implement `checkBrickCollision` in the `Ball` class. Note that this method is almost identical to the other collision detection
methods, but it returns a `boolean` value that's used to destroy the `Brick` if a collision happens.

5. Implement the game-ending checks. The game ends if all of the bricks are destroyed or if the `Ball` reaches the bottom of the screen.
You'll need to add an `atBottomOfScreen` method to the `Ball` class.

The most important tip: **develop in stages**. Make one change to the code, then compile and run your program. If your program doesn't do what you expect, or has any errors, **fix them before moving on**.

## Submission

Upload your work **to Canvas** to an assignment that I'll create. Put the four classes in a ZIP file.
