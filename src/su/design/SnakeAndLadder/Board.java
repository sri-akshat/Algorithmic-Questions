package su.design.snakeAndLadder;

import su.design.snakeAndLadder.square.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 2/11/2015.
 */
public class Board {

    List<Square> squares = new ArrayList<Square>();
    Square firstSquare = null;
    Square lastSquare = null;

    public Board(int boardSize, int[][] snakes, int[][] ladders) {

        initializeSquares(boardSize);
        initFirstSquare();
        initLastSquare();
        initSnakes(snakes);
        initLadder(ladders);
    }

    private void initLadder(int[][] ladders) {
        for(int i=0;i<ladders.length;i++)
        {
            int fromPos = ladders[i][0];
            int endPos = ladders[i][1];
            int transport = endPos - fromPos;
            Square ladderSquare = squares.get(fromPos);
            ladderSquare.setSquareRole(new LadderRole(ladderSquare, transport));
        }
    }

    private void initSnakes(int[][] snakes) {
        for(int i=0;i<snakes.length;i++)
        {
            int fromPos = snakes[i][0];
            int endPos = snakes[i][1];
            int transport = endPos - fromPos;
            Square snakeSquare = squares.get(fromPos);
            snakeSquare.setSquareRole(new SnakeRole(snakeSquare, transport));
        }
    }

    private void initLastSquare() {
        lastSquare = squares.get(squares.size()-1);
        lastSquare.setSquareRole(new LastSquareRole(lastSquare));
    }

    private void initFirstSquare() {
        firstSquare = squares.get(0);
        firstSquare.setSquareRole(new FirstSquareRole(firstSquare));
    }

    private void initializeSquares(int boardSize) {
        for(int i=0;i<boardSize;i++)
        {
            Square square = new Square(this, i);
            square.setSquareRole(new RegularSquareRole(square));
            squares.add(i, square);
        }
    }

    public Square getSquare(int squareIndex) {
        return squares.get(squareIndex);
    }

    public Square getLastSquare() {
        return lastSquare;
    }

    public Square getFirstSquare() {
        return firstSquare;
    }
}
