import snapgame.CardGame;
import snapgame.Card;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {
    @Test
    public void testGetDeck() {
        CardGame cardGame = new CardGame("Snap Game");
        ArrayList<Card> deck = cardGame.getDeck();

        // Ensure the deck has 52 cards
        assertEquals(52, deck.size(), "Deck should contain 52 cards.");
    }


    @Test
    public void testDealCard() {
        CardGame cardGame = new CardGame("Snap Game");
        Card dealtCard = cardGame.dealCard();
        assertNotNull(dealtCard, "The dealt card should not be null.");
    }



    @Test
    public void testSortDeckInNumberOrder() {
        CardGame cardGame = new CardGame("Snap Game");
        cardGame.shuffleDeck(); // Shuffle the deck first to simulate unsorted state
        cardGame.sortDeckInNumberOrder(); // Sort the deck by number value

        // Check if cards are sorted by value
        ArrayList<Card> deck = cardGame.getDeck();
        for (int i = 0; i < deck.size() - 1; i++) {
            assertTrue(deck.get(i).getValue() <= deck.get(i + 1).getValue(),
                    "Deck is not sorted in number order.");
        }
    }


    @Test
    public void testSortDeckIntoSuits() {
        CardGame cardGame = new CardGame("Snap Game");
        cardGame.shuffleDeck();
        cardGame.sortDeckIntoSuits();

        // Check if the deck is sorted by suits, then by value
        ArrayList<Card> deck = cardGame.getDeck();
        for (int i = 0; i < deck.size() - 1; i++) {
            // Check if suits are sorted and values within suits are sorted
            assertTrue(deck.get(i).getSuit().compareTo(deck.get(i + 1).getSuit()) <= 0 ||
                            (deck.get(i).getSuit().equals(deck.get(i + 1).getSuit()) &&
                                    deck.get(i).getValue() <= deck.get(i + 1).getValue()),
                    "Deck is not sorted by suit and then by value.");
        }
    }


    @Test
    public void testShuffleDeck() {
        CardGame cardGame = new CardGame("Snap Game");
        ArrayList<Card> originalDeck = new ArrayList<>(cardGame.getDeck()); // Save the original deck order

        cardGame.shuffleDeck(); // Shuffle the deck

        // Ensure that the deck order has changed after shuffling
        assertNotEquals(originalDeck, cardGame.getDeck(), "Deck was not shuffled.");
    }

    @Test
    public void testDeckInitialisation() {
        CardGame cardGame = new CardGame("Snap Game");
        ArrayList<Card> deck = cardGame.getDeck();

        // Ensure that all cards have different suit-symbol combinations
        for (int i = 0; i < deck.size(); i++) {
            for (int j = i + 1; j < deck.size(); j++) {
                assertNotEquals(deck.get(i), deck.get(j), "Deck should not have duplicate cards.");
            }
        }
    }

    @Test
    public void testDealCardReducesDeckSize() {
        CardGame cardGame = new CardGame("Snap Game");
        int initialDeckSize = cardGame.getDeck().size();

        cardGame.dealCard(); // Deal one card
        int newDeckSize = cardGame.getDeck().size();

        assertEquals(initialDeckSize - 1, newDeckSize, "Deck size should decrease by 1 after dealing a card.");
    }


    @Test
    public void testDealCardFromEmptyDeck() {
        CardGame cardGame = new CardGame("Snap Game");

        // Deal all cards from the deck
        for (int i = 0; i < 52; i++) {
            cardGame.dealCard();
        }

        Card dealtCard = cardGame.dealCard();
        assertNull(dealtCard, "Deck should be empty, and dealCard should return null.");
    }



}



