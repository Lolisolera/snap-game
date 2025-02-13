package snapgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CardGame cardGame = new CardGame("Standard Card Game");
        ArrayList<Card> deck = cardGame.getDeckOfCards();


        System.out.println("Deck of cards:");
        for (Card card : deck) {
            System.out.println(card);
        }

        cardGame.shuffleDeck();
        System.out.println("\nShuffled Deck:");
        for (Card card : deck) {
            System.out.println(card);
        }


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


        System.out.println("\nWould you like to play Snap? (yes/no)");
        String playSnap = scanner.nextLine().trim().toLowerCase();

        if (playSnap.equals("yes")) {
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");


            Snap snapGame = new Snap("Snap Game", player1, player2, scanner);
            snapGame.shuffleDeck();
            snapGame.playGame();
        } else {
            System.out.println("Exiting program. Goodbye!");
        }

        scanner.close();
    }
}
