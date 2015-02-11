package su.design.snakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Akshat on 2/11/2015.
 */
public class Game {

    private final Board board;
    private final Queue<Player> players;
    private Player winner = null;


    public Game(int boardSize, int[][] snakes, int[][] ladders) {
        this.board = new Board(boardSize, snakes, ladders);
        this.players = new LinkedList<>();
    }

    public void addPlayer(String player) {
        Player p = new Player(player, board.getFirstSquare());
        board.getFirstSquare().enter(p);
        players.add(p);
    }

    public void play() {

        Dice dice = new Dice();
        while(notOver())
        {
            Player currentPlayer = players.poll();
            currentPlayer.move(dice.roll());
            if(currentPlayer.wins())
            {
                winner = currentPlayer;
            }else{
                players.add(currentPlayer);
            }
        }
        System.out.println("Winner is "+winner.getName());

    }

    protected boolean notOver() {
        return winner==null;
    }
}
