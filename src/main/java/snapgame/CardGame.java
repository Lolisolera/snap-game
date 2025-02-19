package snapgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private final ArrayList<Card> deckOfCards;

    public CardGame(String name) {
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
        String[] suits = {"♥", "♣", "♦", "♠"};
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int j = 0; j < symbols.length; j++) {
                deckOfCards.add(new Card(suit, symbols[j], values[j]));
            }
        }
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }


    public Card dealCard() {
        if (!deckOfCards.isEmpty()) {
            return deckOfCards.removeFirst();
        }
        return null; // Deck is empty
    }


    public void sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparingInt(Card::getValue));
    }


    public void sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getValue));
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }
}
