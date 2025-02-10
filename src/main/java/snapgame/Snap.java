package snapgame;

import java.util.Scanner;

public class Snap extends CardGame {
    private Card lastCard = null; // To store the last card dealt

    public Snap(String name) {
        super(name); // Call the constructor of CardGame
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!getDeckOfCards().isEmpty()) {
            System.out.println("\nPress ENTER to deal a card.");
            scanner.nextLine();  // Wait for the user to press Enter

            Card currentCard = dealCard();
            System.out.println("Dealt card: " + currentCard);

            // Check if there is a Snap (two consecutive cards with the same rank)
            if (lastCard != null && lastCard.getRank().equals(currentCard.getRank())) {
                System.out.println("SNAP! You win!");
                break; // End the game if a Snap happens
            }

            // Update lastCard to the current card
            lastCard = currentCard;
        }

        scanner.close();
    }
}
