package su.design.snakeAndLadder.square;

/**
 * Created by Akshat on 2/11/2015.
 */
public class SnakeRole extends SquareRole {

    private Square snakeSquare;
    private int transport;

    public SnakeRole(Square snakeSquare, int transport) {
        super(snakeSquare);
        this.snakeSquare = snakeSquare;
        this.transport = transport;
    }

    @Override
    public Square warp() {
        System.out.print("-------entering "+snakeSquare.getPosition()+" -------snake bite !! sliding ");
        return snakeSquare.findRelativeSquare(snakeSquare.getPosition()+transport);
    }
}
