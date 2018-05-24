package models;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
    private String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private List<String> deck = new ArrayList<String>();

    public List<String> getDeck() {
        return deck;
    }

    public void createDeck() {
        for (String suit: suits) {
            for (String value: values) {
                deck.add(value + " of " + suit);
            }
        }
    }

    public String drawCard() {
        Random randomGenerator = new Random();
        int i = randomGenerator.nextInt(deck.size());
        String card = deck.get(i);
        deck.remove(i);
        return card;
    }
}
