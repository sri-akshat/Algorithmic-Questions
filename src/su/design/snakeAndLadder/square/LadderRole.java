package su.design.snakeAndLadder.square;

import su.design.snakeAndLadder.square.Square;
import su.design.snakeAndLadder.square.SquareRole;

/**
 * Created by Akshat on 2/11/2015.
 */
public class LadderRole extends SquareRole {

    Square ladderSquare;
    int transport;

    public LadderRole(Square ladderSquare, int transport) {
        super(ladderSquare);
        this.ladderSquare = ladderSquare;
        this.transport = transport;
    }

    @Override
    public Square warp() {
        System.out.print("------ entering " + ladderSquare.getPosition() + " -------ladder <3 climbing ");
        return ladderSquare.findRelativeSquare(ladderSquare.getPosition()+transport);
    }
}
