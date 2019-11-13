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

## Submission

Upload your work **to Canvas** to an assignment that I'll create.

## Plan
