package su.design.snakeAndLadder.square;

import su.design.snakeAndLadder.Board;
import su.design.snakeAndLadder.Player;

/**
 * Created by Akshat on 2/11/2015.
 */
public class Square {

    private SquareRole squareRole;
    private int position;
    private Player player;
    private Board board;

    public Square(Board board, int position) {
        this.board = board;
        this.position = position;
    }


    public void setSquareRole(SquareRole squareRole) {
        this.squareRole = squareRole;
    }

    public SquareRole getSquareRole() {
        return squareRole;
    }

    public Square findRelativeSquare(int squareIndex) {
        return board.getSquare(squareIndex);
    }

    public int getPosition() {
        return position;
    }

    public Square getLastSquare() {
        return board.getLastSquare();
    }

    public void leave() {
        this.player = null;
    }

    public void enter(Player player) {
        this.player = player;
    }

    public boolean isLast() {
        return board.getLastSquare()==this;
    }

    public Square moveAndLand(int shift) {
        int currentPos = this.getPosition();

        if (currentPos + shift > this.getLastSquare().getPosition()) {
            System.out.print("------Move Invalid !! not moving-----");
            return this;
        } else {
            Square destination = this.findRelativeSquare(currentPos + shift).getSquareRole().warp();
            if (destination.isOccupied()) {
                System.out.print("-----look who's here !!! beating "+destination.getPlayer().getName()+" sending to start------");
                Player beatenPlayer = destination.getPlayer();
                board.getFirstSquare().enter(beatenPlayer);
                beatenPlayer.setCurrentSquare(board.getFirstSquare());
            }
            return destination;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isOccupied() {
        return player != null;
    }
}

