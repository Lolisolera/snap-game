## Pseudocode for snap-game

## Stage 1: Creating the Deck of Cards

Class: Card  (representing individual cards)
     * Properties:
         * suit (String) → "♥", "♣", "♦", "♠" 
         * symbol (String) → "2", "3", ..., "J", "Q", "K", "A"
         * value (int) → 2-14 (numeric mapping of symbols)
     * Methods:
         * toString(): Returns a string representation of the card.

Class: CardGame (creates a deck)
     * Properties:
         * deckOfCards (ArrayList of Card objects)
         * name (String) → Name of the game
     * Constructor:
         * Create and populate deckOfCards with 52 Card objects.
     * Methods:
         * getDeck(): Prints out all cards in the deck.
         * shuffleDeck(): Randomly shuffles deckOfCards (with custom prompt: "please shuffle the cards").
         * dealFirstCard(): Deals the first card and prints it (with custom prompt: "please deal the first card").

## Stage 2: Implementing Core functionalities

Class: CardGame (continued)
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


## Stage 3: Implementing Snap Game Logic

Class: Snap (extends CardGame)
     * Methods:
         * playGame():
              * While the deck is not empty:
                   * Prompt the player: "please enter your name".
                   * Deal a card and show it.
                   * If two consecutive cards match (same symbol), print "SNAP! You win!" and exit the loop.
                   * If no match, continue with the game.

Custom Features:
     * Prompt the player for a valid name:
         * Ensure the user provides a name (validation: non-empty).
     * Prompt to shuffle the cards before starting the game.
     * Prompt to deal the first card at the start of the game.

## Stage 4: Adding Two-Player Functionality

Class: Player
     * Properties:
         * name (String)
         * score (int)
     * Methods:
         * takeTurn(): Waits for the player to press Enter.
         * askForName(): Asks the player for their name and validates it (ensures a valid name is entered).

Class: Snap (modified)
     * New Methods:
         * playTwoPlayerGame():
              * Alternate turns between two players.
              * If a matching card appears:   
                  * Start a 2-second timer.
                  * If a player types "snap" within time, they win.
                  * If no "snap" within the timer, prompt the other player for their turn.

Validation & User Interaction:
    * Ask the player for their name (validation: must not be empty).
    * Prompt the player to shuffle the cards before starting the game.
    * Prompt the player to deal the first card, with validation for correct input.
