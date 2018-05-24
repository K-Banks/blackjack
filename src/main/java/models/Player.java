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
            } else {
                cardPoints = 10;
            }
            handPoints += cardPoints;
        }
//        for (String card : hand) {
//            String[] singleCardSplit = card.split(" ");
//            String cardValue = singleCardSplit[0];
//            if (handPoints > 21 && cardValue.equals("Ace")) {
//                handPoints -= 10;
//                singleCardSplit[0] = "ace";
//                hand.remove(card);
//                String newCard = singleCardSplit.join(" ");
//            }
//        }
        return handPoints;
    }
}
