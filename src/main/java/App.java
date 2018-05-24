import models.Player;
import models.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to BlackJack");

        boolean playing = true;

        while(playing) {

            try {
                Game blackjack = new Game();
                Player user = new Player();
                Player dealer = new Player();
                blackjack.createDeck();
                user.addCard(blackjack.drawCard());
                dealer.addCard(blackjack.drawCard());
                user.addCard(blackjack.drawCard());
                dealer.addCard(blackjack.drawCard());
                System.out.println("Your hand: " + user.getHand());
                System.out.println("Your points: " + user.valueOfHand());
                System.out.println("Dealer's hand: " + dealer.getHand().get(0));

                boolean gameState = true;
                while (gameState) {
                    System.out.println("Do you hit or stand?");
                    String choice = bufferedReader.readLine().toLowerCase();
                    if (choice.equals("hit")){
                        user.addCard(blackjack.drawCard());
                        System.out.println("Your hand: " + user.getHand());
                        System.out.println("Your points: " + user.valueOfHand());
                        if (user.valueOfHand() > 21) {
                            System.out.println("You busted.");
                            gameState = false;
                        } else if (user.valueOfHand() == 21 ) {
                            System.out.println("Blackjack. You Win.");
                            gameState = false;
                        }
                    } else {
                        System.out.println("Dealer hand: " + dealer.getHand());
                        System.out.println("Dealer points: " + dealer.valueOfHand());
                        while (dealer.valueOfHand() < 17) {
                            dealer.addCard(blackjack.drawCard());
                            System.out.println("Dealer hand: " + dealer.getHand());
                            System.out.println("Dealer points: " + dealer.valueOfHand());
                        }
                        if (dealer.valueOfHand() > 21) {
                            System.out.println("The dealer busted. You win.");
                            gameState = false;
                        } else if (dealer.valueOfHand() == 21 && user.valueOfHand() == 21 || dealer.valueOfHand() == user.valueOfHand()) {
                            System.out.println("Tie game. Dealer Wins");
                            gameState = false;
                        } else if (dealer.valueOfHand() == 21) {
                            System.out.println("Dealer wins.");
                            gameState = false;
                        } else if (dealer.valueOfHand() > user.valueOfHand()) {
                            System.out.println("Dealer wins.");
                            gameState = false;
                        } else {
                            System.out.println("You win.");
                            gameState = false;
                        }
                    }
                }

                System.out.println("Would you like to play again? Y or N");
                String input = bufferedReader.readLine().toLowerCase();
                if (input.equals("n")) {
                    playing = false;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
