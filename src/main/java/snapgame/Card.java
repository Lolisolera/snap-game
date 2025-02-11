package snapgame;

public class Card {
    private final String suit;
    private final String symbol;
    private final int value;

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

    // return the symbol (rank) of the card
    public String getRank() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol + " of " + suit;
    }
}
