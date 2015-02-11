package su.design.snakeAndLadder;

import su.design.snakeAndLadder.square.Square;

/**
 * Created by Akshat on 2/11/2015.
 */
public class Player {

    private final String name;
    private Square currentSquare;

    public Player(String name, Square currentSquare) {
        this.name = name;
        this.currentSquare = currentSquare;
    }

    public void move(int shift) {
        System.out.println("Player "+this.getName()+" move");
        System.out.print("leaving " + currentSquare.getPosition());
        currentSquare.leave();
        currentSquare = currentSquare.moveAndLand(shift);

        currentSquare.enter(this);
        System.out.println("------ entering " + currentSquare.getPosition());
    }

    public boolean wins() {
        return currentSquare.isLast();
    }

    public String getName() {
        return name;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }
}
