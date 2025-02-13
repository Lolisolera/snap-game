package snapgame;

import java.util.Scanner;

public class Snap extends CardGame {
    private Card lastCard = null;
    private Player currentPlayer;
    private Player opponent;
    private Scanner scanner;


    public Snap(String name, Player player1, Player player2, Scanner scanner) {
        super(name);
        this.currentPlayer = player1;
        this.opponent = player2;
        this.scanner = scanner;
    }

    public void playGame() {
        while (!getDeckOfCards().isEmpty()) {
            System.out.println("\n" + currentPlayer.getName() + ", press ENTER to deal a card.");
            scanner.nextLine();

            Card currentCard = dealCard();
            System.out.println(currentPlayer.getName() + " dealt: " + currentCard);

            if (lastCard != null && lastCard.getRank().equals(currentCard.getRank())) {
                if (snapRound()) {
                    System.out.println(currentPlayer.getName() + " wins the game!");
                    return;
                }
            }

            lastCard = currentCard;
            swapPlayers();
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
