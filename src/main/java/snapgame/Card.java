package snapgame;

public class Card {
    private final String suit;
    private final String symbol;  // This is the rank, such as "2", "A", "J", "Q", "K"
    private final int value;  // This is the numeric value of the card for game logic, e.g., 2, 3, 10, 11 (Jack), 12 (Queen), etc.

    // Constructor
    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    // Getters
    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    // Add the getRank method to return the symbol (rank) of the card
    public String getRank() {
        return symbol;
    }

    // Override the toString method for better output formatting
    @Override
    public String toString() {
        return symbol + " of " + suit;
    }
}
