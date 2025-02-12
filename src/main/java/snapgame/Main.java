package snapgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a standard CardGame instance to test Stage 1 and 2 functionalities
        CardGame cardGame = new CardGame("Standard Card Game");
        ArrayList<Card> deck = cardGame.getDeckOfCards();

        // Print all the cards in the deck
        System.out.println("Deck of cards:");
        for (Card card : deck) {
            System.out.println(card);
        }


        cardGame.shuffleDeck();
        System.out.println("\nShuffled Deck:");
        for (Card card : deck) {
            System.out.println(card);
        }

        // Sort deck in number order
        cardGame.sortDeckInNumberOrder();
        System.out.println("\nDeck Sorted by Number Order:");
        for (Card card : deck) {
            System.out.println(card);
        }


        cardGame.sortDeckIntoSuits();
        System.out.println("\nDeck Sorted by Suits:");
        for (Card card : deck) {
            System.out.println(card);
        }

        // Start Snap game
        System.out.println("\nWould you like to play Snap? (yes/no)");
        String playSnap = scanner.nextLine().trim().toLowerCase();

        if (playSnap.equals("yes")) {
            // Create Player objects
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");

            // Create a Snap game instance for two players
            Snap snapGame = new Snap("Snap Game", player1, player2);

            // Shuffle the deck before starting the Snap game
            snapGame.shuffleDeck();

            // Start the Snap game
            snapGame.playGame();
        } else {
            System.out.println("Exiting program. Goodbye!");
        }

        scanner.close();
    }
}
