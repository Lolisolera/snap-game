package snapgame;

import snapgame.CardGame;
import snapgame.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {
    @Test
    public void testDealCard() {
        CardGame cardGame = new CardGame("Snap Game");
        Card dealtCard = cardGame.dealCard();
        assertNotNull(dealtCard, "The dealt card should not be null.");
    }
}



