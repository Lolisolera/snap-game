package snapgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, welcome to Lola' Snap Game!");


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


        String playSnap = "";
        while (true) {
            System.out.println("\nWould you like to play? (yes/no)");
            playSnap = scanner.nextLine().trim().toLowerCase();

            if (playSnap.equals("yes") || playSnap.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
        if (playSnap.equals("yes")) {
            System.out.println("\nPlayer 1 - Please enter your name:");
            String player1Name = scanner.nextLine().trim();

            if (player1Name.isEmpty()) {
                player1Name = "Player 1";
            }

            System.out.println("\nPlayer 2 - Please enter your name (or press Enter to use default 'Player 2'):");
            String player2Name = scanner.nextLine().trim();

            if (player2Name.isEmpty()) {
                player2Name = "Player 2";
            }


            Player player1 = new Player(player1Name);
            Player player2 = new Player(player2Name);


            Snap snapGame = new Snap("Snap Game", player1, player2, scanner);
            snapGame.shuffleDeck();
            snapGame.playGame();
        } else {
            System.out.println("Exiting program. Goodbye!");
        }

        scanner.close();
    }
}
