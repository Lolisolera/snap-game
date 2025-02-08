package snapgame;
import java.util.ArrayList;

public class CardGame {
        private final ArrayList<Card> deckOfCards;
        private final String name;

        // Constructor to initialize the game name and create the deck of cards
        public CardGame(String name) {
            this.name = name;
            this.deckOfCards = new ArrayList<>();
            createDeck();
        }

        // Method to create the deck of 52 cards
        private void createDeck() {
            String[] suits = {"♥", "♣", "♦", "♠"};
            String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
            int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

            for (String suit : suits) {
                for (int i = 0; i < symbols.length; i++) {
                    deckOfCards.add(new Card(suit, symbols[i], values[i]));
                }
            }
        }

        // Method to get the list of cards in the deck
        public ArrayList<Card> getDeck() {
            return deckOfCards;
        }

        // Additional methods will be added later for sorting and shuffling
    }

