## Pseudocode for snap-game

## Stage 1: Creating the Deck of Cards

Class: Card
     * Properties:
         * suit (String) → "♥", "♣", "♦", "♠" 
         * symbol (String) → "2", "3", ..., "J", "Q", "K", "A"
         * value (int) → 2-14 (numeric mapping of symbols)
     * Methods:
         * toString(): Returns a string representation of the card.

Class: CardGame
     * Properties:
         * deckOfCards (ArrayList of Card objects)
         * name (String) → Name of the game
     * Constructor:
         * Create and populate deckOfCards with 52 Card objects.
     * Methods:
         * getDeck(): Prints out all cards in the deck.


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


## Stage 3: Implementing Snap Game Logic

Class: Snap (extends CardGame)
     * Methods:
         * playGame():
              * While the deck is not empty:
                   * Wait for the user to press Enter.
                   * Deal a card and show it.
                   * If two consecutive cards match (same symbol), print "SNAP! You win!" and exit the loop.


## Stage 4: Adding Two-Player Functionality

Class: Player
     * Properties:
         * name (String)
         * score (int)
     * Methods:
         * takeTurn(): Waits for the player to press Enter.

Class: Snap (modified)
     * New Methods:
         * playTwoPlayerGame():
              * Alternate turns between two players.
              * If a matching card appears:   
                  * Start a 2-second timer.
                  * If a player types "snap" within time, they win.
                  * Otherwise, the other player wins.
