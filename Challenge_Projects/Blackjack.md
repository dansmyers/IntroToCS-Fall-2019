# Blackjack

## Description

Use the `Card` and `Deck` classes to implement [a game of Blackjack](https://www.youtube.com/watch?v=HkzMA1jrm00).

This project will let you practice using object-oriented programming (OOP) to implement a non-trivial interactive game.

You have broad freedom to decide how you want the game to play: how you want the output to appear, how you want to collect input, etc.

As with the other challenge projects, you can submit this one by showing me your solution any time before December 6. 
Please plan ahead so that we don't have a traffic jam of people all trying to turn in their projects at the last minute.

## Rules

Here is a quick summary of the basic rules of Blackjack. You can also read more at the [Wizard of Odds](https://wizardofodds.com/games/blackjack/basics/#toc-Rules),
my go to resource for obscure gambling knowledge. If you aren't familiar with the game, take some time to understand how it's played 
before diving into the code.

Blackjack is played against a dealer. The player’s goal is to collect a hand of cards that beats the dealer’s hand.

There are three ways to win:

1. Achieving a score of 21 with the first two cards (a blackjack)
2. Achieving a score greater than the dealer’s without exceeding 21 
3. Letting the dealer draw cards until his score exceeds 21

Our version of Blackjack will play a single round of the game between a single player and dealer using a 52-card deck.

### Set-up

The set-up phase of the game is as follows:

1. Shuffle the deck
2. Deal two cards to the player and two to the dealer
3. Reveal the player's cards and announce their score: if the total is 21 the player automatically wins
4. Reveal the dealer's first card, but keep the second one hidden

### Hitting and Standing

Once the cards are revealed, the player may add additional cards to her hand:

1. The player chooses to *hit* or *stand*
2. If the player stands, her turn ends and she keeps her current hand
3. If the player hits, she receives an additional card and the score of the new hand is announced
4. If the player’s hand goes over 21, she *busts* and immediately loses
5. These steps repeat until the player either busts or stands

Once the player stands, the dealer will draw cards from the deck according to the following rules:

1. If the dealer’s hand is less than 17, he hits
2. Otherwise the dealer stands
3. If the dealer’s hand exceeds 21, he busts and the player wins

If the dealer stands without busting, then the highest hand is the winner. A draw occurs if the hands are equal.

### Scoring Hands

The score of a hand is determined as follows:

- Numbered cards count for their value
- Face cards count for 10
- An ace counts for 11, unless this would make the player’s score greater than 21, in which case it counts for 1

Note that a hand of two aces would have one count for 11 and the other count for 1, for a total score of 12.

### Features You Do Not Need To Implement

Casino Blackjack is always played for stakes, typically paying 1:1 on a win and 3:2 on a blackjack. Do not implement any wagering.

Most casinos also offer choices to the player besides hit or stand: purchasing insurance, splitting, and doubling down are the
most common. You don’t need to implement any of these features.

## Tips

### Scoring and Aces
The trickiest part of the program is probably keeping track of the score of each hand and dealing with aces. Here is a strategy
that will work:

- Keep a running count of the player's score. Each time a new card is dealt, use its value to update the score.

- Also keep count of the number of aces in the player's hand that count for 11 points. If the player's score goes over 21, but there is at least one ace counting for 11 points, subtract 10 to bring the score back down under 21.

## Example Output

You don't have to exactly copy this output, but here's an example of how the game might play.

```
Welcome to Blackjack.

Shuffling the deck...

Your two cards are 
    ACE of HEARTS
    TWO of CLUBS

The dealer's face-up card is
    NINE of DIAMONDS
    
Your current score is 13.
1. Hit
2. Stand
Hit or Stand? 1

Your next card is
    NINE of SPADES
    
Your current score is 12.
1. Hit
2. Stand
Hit or Stand? 1

Your next card is
    SEVEN of CLUBS
    
Your current score is 19.
1. Hit
2. Stand
Hit or Stand? 2

You stand with 19.

The dealer's second card is
    FIVE of HEARTS
    
The dealer's score is 14.

Dealer hits.
    FOUR of CLUBS.
    
The dealer's score is 18.

Dealer stands with 18.

Your 19 beats the dealer's 18.

You win!
```
