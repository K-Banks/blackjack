package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void newGame_newGameInstantiates_true() throws Exception{
        Game testGame = new Game();
        assertEquals(true, testGame instanceof Game);
    }

    @Test
    public void getDeck_getsNewDeck_true() {
        Game testGame = new Game();
        List<String> expected = new ArrayList<String>();
        assertEquals(expected.getClass(), testGame.getDeck().getClass());
    }

    @Test
    public void createDeck_populatesDeckListArray_ArrayList() {
        Game testGame = new Game();
        testGame.createDeck();
        assertTrue(testGame.getDeck().contains("Ace of Spades"));
    }

    @Test
    public void drawCard_drawsRandomCardFromDeck_String() {
        Game testGame = new Game();
        testGame.createDeck();
        assertEquals(true, testGame.drawCard() instanceof String);
    }

    @Test
    public void drawCard_removesCardFromDeck_false() {
        Game testGame = new Game();
        testGame.createDeck();
        String cardSelect = testGame.drawCard();
        assertFalse(testGame.getDeck().contains(cardSelect));
    }
}