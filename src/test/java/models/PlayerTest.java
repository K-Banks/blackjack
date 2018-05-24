package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void newPlayer_instantiatesNewPlayer_true() {
        Player testPlayer = new Player();
        assertTrue(testPlayer instanceof Player);
    }

    @Test
    public void getHand_returnsPlayerHandArrayList_true() {
        Player testPlayer = new Player();
        List<String> expected = new ArrayList<String>();
        assertEquals(expected.getClass(), testPlayer.getHand().getClass());
    }

        @Test
    public void addCard_addsCardToHandListArray_true() {
        Player testPlayer = new Player();
        Game testGame = new Game();
        testGame.createDeck();
        String card = testGame.drawCard();
        testPlayer.addCard(card);
        assertTrue(testPlayer.getHand().contains(card));
    }

    @Test
    public void valueOfHand_addsPointsinHand_Integer() {
        Player testPlayer = new Player();
        testPlayer.addCard("3 of Hearts");
        testPlayer.addCard("8 of Hearts");
        assertEquals(11, testPlayer.valueOfHand());

    }

    @Test
    public void aceCheck_changesValueOfAce_12() {
        Player testPlayer = new Player();
        testPlayer.addCard("Ace of Hearts");
        testPlayer.addCard("Ace of Hearts");
        assertEquals(12, testPlayer.valueOfHand());
    }
}