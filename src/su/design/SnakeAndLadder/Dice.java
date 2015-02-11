package su.design.snakeAndLadder;

import java.util.Random;

/**
 * Created by Akshat on 2/11/2015.
 */
public class Dice {

    public int roll(){
        Random random = new Random();
        return random.nextInt(6 - 1 + 1 + 1);
    }
}
