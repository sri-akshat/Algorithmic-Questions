package su.design.snakeAndLadder.square;

/**
 * Created by Akshat on 2/11/2015.
 */
public abstract class SquareRole {

    private Square square = null;

    public SquareRole(Square square) {
        this.square = square;
    }

    public Square warp() {
        return square;
    }
}
