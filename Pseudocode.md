# Pseudocode for Snap Game

## Stage 1: Creating the deck of cards

### Class: Card  (representing individual cards)

* Properties:
  * suit (String) → "♥", "♣", "♦", "♠" 
  * symbol (String) → "2", "3", ..., "J", "Q", "K", "A"
  * value (int) → 2-14 (numeric mapping of symbols)
* Methods:
  * toString(): Returns a string representation of the card.

### Class: CardGame (creates a deck)

* Properties:
  * deckOfCards (ArrayList of Card objects)
  * name (String) → Name of the game
* Constructor:
  * Create and populate deckOfCards with 52 Card objects.
* Methods:
  * getDeck(): Prints out all cards in the deck.
  * shuffleDeck(): Randomly shuffles deckOfCards (with custom prompt: "please shuffle the cards").
  * dealFirstCard(): Deals the first card and prints it (with custom prompt: "please deal the first card").

## Stage 2: Implementing core functionalities

### Class: CardGame (continued)

* Methods:
  * dealCard():
    * Removes and returns the top card from deckOfCards.
  * sortDeckInNumberOrder():
    * Sorts deckOfCards by value. 
  * sortDeckIntoSuits():
    * Sorts deckOfCards into groups of suits (hearts, clubs, diamonds, spades).
  * shuffleDeck():
    * Randomly shuffles deckOfCards.
    * Custom Feature: Prompt the player to shuffle the cards.

## Stage 3: Implementing Snap Game logic

### Class: Snap (extends CardGame)

* Methods:
  * playGame():
    * While the deck is not empty:
      1. Prompt the player: "please enter your name".
      2. Deal a card and show it.
      3. If two consecutive cards match (same symbol), print "SNAP! You win!" and exit the loop.
      4. If no match, continue with the game.

* Custom Features:
  * Prompt the player for a valid name:
    1. Ensure the user provides a name (validation: non-empty).
    2. Prompt to shuffle the cards before starting the game.
    3. Prompt to deal the first card at the start of the game.

## Stage 4: Adding two-player functionality

### Class: Player

* Properties:
  * name (String)
  * score (int)
* Methods:
  * takeTurn(): 
    * Waits for the player to press Enter.
  * askForName(): 
    * Asks the player for their name and validates it (ensures a valid name is entered).

### Class: Snap (modified)

* Methods:
  * playTwoPlayerGame():
    * Alternate turns between two players.
    * If a matching card appears:   
      1. Start a 2-second timer. 
      2. If a player types "snap" within time, they win. 
      3. If no "snap" within the timer, prompt the other player for their turn.

## Validation and user interaction

1. Ask the player for their name (validation: must not be empty).
2. Prompt the player to shuffle the cards before starting the game.
3. Prompt the player to deal the first card, with validation for correct input.
