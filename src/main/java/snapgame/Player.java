package snapgame;

import java.util.Scanner;

public class Player {
    private String name;
    private int score;

    //constructor
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


    public String takeTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", it's your turn. Press Enter to play.");
        scanner.nextLine();
        return scanner.nextLine();
    }


    public boolean callSnap() {
        Scanner scanner = new Scanner (System.in);
        System.out.println(name + ", call 'snap' if you see the matching cards!");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("Snap");
    }

}

