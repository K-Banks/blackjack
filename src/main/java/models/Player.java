package models;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> hand = new ArrayList<String>();

    public List<String> getHand() {
        return hand;
    }

    public void addCard(String card) {
        hand.add(card);
    }

    public int valueOfHand(){
        Integer handPoints = 0;
        for ( String card : hand ) {
            String[] singleCardSplit = card.split(" ");
            String cardValue = singleCardSplit[0];
            int cardPoints;
            if (cardValue.equals("Ace")){
                cardPoints = 11;
            } else if (cardValue.equals("2")){
                cardPoints = 2;
            } else if (cardValue.equals("3")){
                cardPoints = 3;
            } else if (cardValue.equals("4")){
                cardPoints = 4;
            } else if (cardValue.equals("5")){
                cardPoints = 5;
            } else if (cardValue.equals("6")){
                cardPoints = 6;
            } else if (cardValue.equals("7")){
                cardPoints = 7;
            } else if (cardValue.equals("8")){
                cardPoints = 8;
            } else if (cardValue.equals("9")){
                cardPoints = 9;
            } else if (cardValue.equals("ace")) {
                cardPoints = 1;
            } else {
                cardPoints = 10;
            }
            handPoints += cardPoints;
        }
        handPoints = this.aceChecker(handPoints);
        return handPoints;
    }

    public Integer aceChecker(Integer points) {
        if (points > 21) {
            int tracker = 0;
            for (String card: hand) {
                String[] singleCardSplit = card.split(" ");
                if (singleCardSplit[0].equals("Ace")) {
                    String newCard = "ace " + singleCardSplit[1] + " " + singleCardSplit[2];
                    hand.add(newCard);
                    hand.remove(card);
                    tracker = 1;
                }
                if (tracker > 0) {
                    Integer value = this.valueOfHand();
                    return value;
                }
            }

        }
        return points;
    }
}
