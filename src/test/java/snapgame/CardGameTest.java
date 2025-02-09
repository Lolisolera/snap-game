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
        cardGame.shuffleDeck(); // Shuffle the deck first to simulate unsorted state
        cardGame.sortDeckIntoSuits(); // Sort the deck by suits and values

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



}



