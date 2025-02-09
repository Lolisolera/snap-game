package snapgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private final String name;
    private final ArrayList<Card> deckOfCards;

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

            for (int i = 0; i < suits.length; i++) {
                for (int j = 0; j < symbols.length; j++) {
                    deckOfCards.add(new Card(suits[i], symbols[j], values[j]));
                }
            }
        }

        // Method to get the list of cards in the deck
        public ArrayList<Card> getDeck() {
            return deckOfCards;
        }

    // Deal the top card from the deck
    public Card dealCard() {
        if (!deckOfCards.isEmpty()) {
            return deckOfCards.remove(0);
        }
        return null; // Deck is empty
    }

    // Sort deck in number order
    public void sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparingInt(Card::getValue));
    }

    // Sort deck into suits, then by value within suits
    public void sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getValue));
    }

    // Shuffle the deck
    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }
}


