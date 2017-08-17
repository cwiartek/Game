package pl.com.bottega.game.engine;

import java.util.Random;

public class ComputerPlayer extends NamedPlayer{

    private String name;
    private Random random = new Random();

    public ComputerPlayer(String name){
        super(name);
    }

    public Hand giveHand(){
        int r = random.nextInt(Hand.values().length);
        return Hand.values()[r];

    }


}
