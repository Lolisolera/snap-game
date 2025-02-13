package snapgame;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Player {
    private String name;
    private int score;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public boolean callSnap(Scanner scanner) {
        final boolean[] snapDetected = {false};
        Timer timer = new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!snapDetected[0]) {
                    System.out.println("Too slow! No snap detected. Moving on...");
                    snapDetected[0] = true;
                }
            }
        }, 2000);

        System.out.println(this.getName() + ", type 'snap' within 2 seconds to win!");


        String response = scanner.nextLine().trim().toLowerCase();
        timer.cancel();

        if (response.equals("snap")) {
            snapDetected[0] = true;
            System.out.println(this.getName() + " wins!");
            return true;
        } else {
            System.out.println("Incorrect input! Moving on...");
            return false;
        }
    }
}
