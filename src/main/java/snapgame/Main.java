package snapgame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CardGame cardGame = new CardGame("Snap");
        ArrayList<Card> deck = cardGame.getDeck();

        // Print all the cards in the deck
        System.out.println("Deck of cards:");
        for (Card card : deck) {
            System.out.println(card);
        }


    }
}