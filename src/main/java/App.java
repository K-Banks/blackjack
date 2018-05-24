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
                Player player1 = new Player();
                blackjack.createDeck();
                blackjack.drawCard();

                String choice = bufferedReader.readLine();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
