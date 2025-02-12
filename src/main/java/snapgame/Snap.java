package snapgame;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    private Card lastCard = null;
    private Player currentPlayer;
    private Player opponent;
    private boolean snapDetected;

    public Snap(String name, Player player1, Player player2) {
        super(name);
        this.currentPlayer = player1;
        this.opponent = player2;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!getDeckOfCards().isEmpty()) {
            System.out.println("\n" + currentPlayer.getName() + ", press ENTER to deal a card.");
            scanner.nextLine(); // Wait for input

            Card currentCard = dealCard();
            System.out.println(currentPlayer.getName() + " dealt: " + currentCard);

            if (lastCard != null && lastCard.getRank().equals(currentCard.getRank())) {
                if (snapRound(scanner)) {
                    System.out.println(currentPlayer.getName() + " wins the game!");
                    break;
                }
            }

            lastCard = currentCard;
            swapPlayers();
        }

        System.out.println("Game over! No more cards left.");
        scanner.close();
    }

    private boolean snapRound(Scanner scanner) {
        System.out.println("SNAP opportunity! Type 'snap' within 2 seconds!");
        snapDetected = false;
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!snapDetected) {
                    System.out.println("Too slow! No snap detected. Moving on...");
                }
            }
        }, 2000); // 2-second timer

        String response = scanner.nextLine().trim().toLowerCase();
        timer.cancel(); // Stop the timer once input is received

        if (response.equals("snap")) {
            snapDetected = true;
            return true;
        } else {
            System.out.println("Incorrect input! Moving on...");
            return false;
        }
    }

    private void swapPlayers() {
        Player temp = currentPlayer;
        currentPlayer = opponent;
        opponent = temp;
    }
}
