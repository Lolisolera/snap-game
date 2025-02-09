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

// Shuffle the deck
        cardGame.shuffleDeck();
        System.out.println("\nShuffled Deck:");
        for (Card card : deck) {
            System.out.println(card);
        }

        // Deal a card
        Card dealtCard = cardGame.dealCard();
        System.out.println("\nDealt Card: " + dealtCard);

        // Sort deck in number order
        cardGame.sortDeckInNumberOrder();
        System.out.println("\nDeck Sorted by Number Order:");
        for (Card card : deck) {
            System.out.println(card);
        }

        // Sort deck into suits
        cardGame.sortDeckIntoSuits();
        System.out.println("\nDeck Sorted by Suits:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}