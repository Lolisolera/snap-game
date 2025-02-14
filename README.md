# Lola's Snap Game

Lola's Snap Game is a Java-based card game where two players take turns dealing cards from a deck and 
trying to "snap" when two consecutive cards match in value. If a player types "snap" within 2 seconds 
of matching cards, they win the round. If no one calls "snap" in time, the game moves on. 
The game includes functionality for shuffling the deck, dealing the first card, and validating user 
inputs such as player names and actions.

## Features

* Custom prompts to enter player names and interact with the game.
* Card deck management including shuffling, dealing, and sorting.
* Two-player functionality with alternating turns.
* A 2-second timer for the "snap" feature.
* Validation to ensure players input valid data.

## Technologies used

Java (JDK 8 or higher recommended).

## Getting started

To run this project on your local machine, follow these steps:

1. Ensure that you have Java Development Kit (JDK) 8 or higher installed on your machine. You can download it from [Oracle's JDK Downloads](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
2. Make sure that Maven is installed to manage the project dependencies. Download Maven from [Maven's website](https://maven.apache.org/download.cgi).

## Running the game

1. Clone the repository to your local machine:
    
   * `git clone https://github.com/Lolisolera/snap-game.git`
   * `cd snap-game`

2. Compile and run the project:

   1. `mvn clean install` 
   2. `mvn exec:java` (this compiles the project and runs Snap Game in your terminal)

## Game instructions

1. The game prompts each player to enter their name. Please ensure to provide a valid name (non-empty). 
2. A player is prompted to shuffle the deck. 
3. Each player takes turns, pressing Enter to deal a card. 
4. When two consecutive cards match in value, a timer starts. 
5. The player must type "snap" within two seconds to win. If no player calls "snap" in time, the game moves on. 
6. After the game ends, the winner is displayed, and you can start a new round if desired.

## Code structure

  * Card Class: Represents individual cards with properties like suit, symbol, and value.
  * CardGame Class: Manages the deck of cards, shuffling, sorting, and dealing.
  * Player Class: Represents a player with a name, score, and methods for taking turns and interacting with the game.
  * Snap Class: The main game logic, extending CardGame, with methods for playing the game, validating "snap", and handling two-player functionality.

## Custom features

  * Name Validation: Players are prompted to enter a valid name.
  * Card Deck Management: Includes shuffling, dealing, and sorting cards.
  * Two-Player Mode: The game alternates between two players, with functionality to detect "snap".
  * Timer for "Snap": If a matching card appears, players have 2 seconds to type "snap" to win.

## Contributions

Feel free to fork the repository and submit pull requests if you'd like to contribute to this project.