package pl.com.bottega.game.engine;

import java.util.Scanner;

public class HumanPlayer extends NamedPlayer {

        private static final int MAX_ERRORS_COUNT = 3;


        private Scanner scanner = new Scanner(System.in);

        public HumanPlayer(String name)
        {
            super(name);
        }

        public Hand giveHand() throws IllegalInputException{
            Hand hand = null;
            byte counter = 0;
            do{
                System.out.println(name + " Wpisz: kamien, nozyce, papier");
                String handstr = scanner.nextLine();
                hand = hand.fromPolishWords(handstr);

                counter++;
            }while(wrongInput(hand) && doesNotExceedTries(counter));

            if(hand ==null)
                throw new IllegalInputException("user exceeded" + MAX_ERRORS_COUNT + "attemps");

            return hand;
        }

        private boolean doesNotExceedTries(byte counter) {
            return counter < MAX_ERRORS_COUNT;
        }

        private boolean wrongInput(Hand hand) {
            return hand == null;
        }


}




