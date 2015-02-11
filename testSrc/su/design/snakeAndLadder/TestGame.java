package su.design.snakeAndLadder;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 2/11/2015.
 */
public class TestGame {

    @Test
    public void testPlayForEnding()
    {
        int boardSize = 100;
        int[][] snakes = { {11 ,5} };
        int[][] ladders = { {2 ,6} , {7 ,9} };
        Game game = new Game(boardSize, snakes, ladders);
        game.addPlayer("A");
        game.addPlayer("B");
        game.play();
        Assert.assertTrue(!game.notOver());
    }
}
