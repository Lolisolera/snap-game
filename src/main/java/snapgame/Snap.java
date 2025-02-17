package snapgame;

import java.util.Scanner;

public class Snap extends CardGame {
    private Card lastCard = null;
    private Player currentPlayer;
    private Player opponent;
    private Scanner scanner;

    public Snap(String name, Player player1, Player player2, Scanner scanner, Card firstCard) {
        super(name);
        this.currentPlayer = player1;
        this.opponent = player2;
        this.scanner = scanner;
        this.lastCard = firstCard;
    }

    public void playGame() {

        while (!getDeckOfCards().isEmpty()) {
            swapPlayers();

            System.out.println(currentPlayer.getName() + ", press ENTER to deal a card.");
            scanner.nextLine();


            Card currentCard = dealCard();
            System.out.println(currentPlayer.getName() + " dealt: " + currentCard);

            // Check for Snap
            if (lastCard != null && lastCard.getRank().equals(currentCard.getRank())) {
                if (snapRound()) {
                    return; // End game if snap is called
                }
            }

            lastCard = currentCard;
        }

        System.out.println("Game over! No more cards left.");
    }

    private boolean snapRound() {
        return currentPlayer.callSnap(scanner);
    }

    private void swapPlayers() {
        Player temp = currentPlayer;
        currentPlayer = opponent;
        opponent = temp;
    }
}

