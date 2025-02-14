package snapgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, welcome to Lola's Snap Game!");

        CardGame cardGame = new CardGame("Lola's Card Game");
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

            String player1Name = getValidName(scanner, "Player 1");


            String player2Name = getValidName(scanner, "Player 2");


            Player player1 = new Player(player1Name);
            Player player2 = new Player(player2Name);


            System.out.println("\n" + player1Name + " , press ENTER to shuffle the cards.");
            scanner.nextLine();

            cardGame.shuffleDeck();
            System.out.println("\nShuffled Deck:");
            for (Card card : deck) {
                System.out.println(card);
            }


            System.out.println("\n" + player2Name + ", press ENTER to deal the first card.");
            scanner.nextLine();

            Card firstCard = cardGame.dealCard();
            System.out.println(player2Name + " dealt: " + firstCard);

            Snap snapGame = new Snap("Snap Game", player2, player1,scanner,firstCard);
            snapGame.shuffleDeck();
            snapGame.playGame();
        }else{
            System.out.println("Exiting program. Goodbye!");
        }

        scanner.close();
    }


    public static String getValidName(Scanner scanner, String player) {
        String name = "";
        boolean valid = false;

        // Regular expression to allow letters, numbers, spaces, and common symbols
        String regex = "^[a-zA-Z0-9_\\- ]+$";

        while (!valid) {
            System.out.println("\n" + player + " - Please enter your name:");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
            } else if (!name.matches(regex)) {
                System.out.println("Invalid characters in name. Please use only letters, numbers, spaces, dashes, or underscores.");
            } else {
                valid = true;
            }
        }

        return name;
    }
}