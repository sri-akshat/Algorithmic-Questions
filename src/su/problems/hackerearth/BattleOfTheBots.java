package su.problems.hackerearth;

import java.util.Scanner;

/**
 * Created by asrivastava6 on 9/12/15.
 */
public class BattleOfTheBots {

    private int rowMax = 7, colMax = 7;
    private int[][] grid = new int[rowMax][colMax];
    private int p1x,p1y,p2x,p2y;
    private int player;

    public static void main(String[] args){
        BattleOfTheBots battleOfTheBots = new BattleOfTheBots();
        battleOfTheBots.init();
        System.out.println(battleOfTheBots.calculateDensity(battleOfTheBots.new Option(Direction.N, 2, 3)));
        System.out.println(battleOfTheBots.calculateDensity(battleOfTheBots.new Option(Direction.S, 2, 3)));
        System.out.println(battleOfTheBots.calculateDensity(battleOfTheBots.new Option(Direction.E, 2, 3)));
        System.out.println(battleOfTheBots.calculateDensity(battleOfTheBots.new Option(Direction.W, 2, 3)));
        System.out.println(battleOfTheBots.calculateDensity(battleOfTheBots.new Option(Direction.NE, 2, 3)));
        System.out.println(battleOfTheBots.calculateDensity(battleOfTheBots.new Option(Direction.NW, 2, 3)));
        System.out.println(battleOfTheBots.calculateDensity(battleOfTheBots.new Option(Direction.SE, 2, 3)));
        System.out.println(battleOfTheBots.calculateDensity(battleOfTheBots.new Option(Direction.SW, 2, 3)));
    }

    private void init(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i < rowMax;i++){
            for(int j=0; j< colMax;j++){
                grid[i][j] = scanner.nextInt();
                switch(grid[i][j]){
                    case 1:
                        p1x = i;
                        p1y = j;
                        break;
                    case 2:
                        p2x = i;
                        p2y = j;
                        break;
                }
            }
        }

        player = scanner.nextInt();
    }

    enum Direction {
        N, S, E, W, NE, NW, SE, SW;
    }

    class Option{

        private Direction direction;
        private int x, y;

        public Option(Direction direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
        }
    }

    private double calculateDensity(Option option){

        int densityGridStartX = 0, densityGridStartY = 0, densityGridEndX = 0, densityGridEndY = 0;

        switch(option.direction){
            case N:
                densityGridStartX = 0;
                densityGridStartY = 0;
                densityGridEndX = option.x - 1;
                densityGridEndY = colMax - 1;
                break;

            case S:
                densityGridStartX = option.x + 1;
                densityGridStartY = 0;
                densityGridEndX = rowMax - 1;
                densityGridEndY = colMax - 1;
                break;

            case E:
                densityGridStartX = 0;
                densityGridStartY = option.y + 1;
                densityGridEndX = rowMax - 1;
                densityGridEndY = colMax - 1;
                break;

            case W:
                densityGridStartX = 0;
                densityGridStartY = 0;
                densityGridEndX = rowMax - 1;
                densityGridEndY = option.y - 1;
                break;

            case NE:
                densityGridStartX = 0;
                densityGridStartY = option.y + 1;
                densityGridEndX = option.x - 1;
                densityGridEndY = colMax - 1;
                break;

            case NW:
                densityGridStartX = 0;
                densityGridStartY = 0;
                densityGridEndX = option.x - 1;
                densityGridEndY = option.y - 1;
                break;

            case SE:
                densityGridStartX = option.x + 1;
                densityGridStartY = option.y + 1;
                densityGridEndX = rowMax - 1;
                densityGridEndY = colMax - 1;
                break;

            case SW:
                densityGridStartX = option.x + 1;
                densityGridStartY = 0;
                densityGridEndX = rowMax - 1;
                densityGridEndY = option.y - 1;
                break;
        }

        double freeSquare = 0;
        double totalSquare = 0;

        for(int i=densityGridStartX;i<densityGridEndX+1;i++){
            for(int j=densityGridStartY;j<densityGridEndY+1;j++){
                totalSquare += 1;
                if(grid[i][j] == 0){
                    freeSquare += 1;
                }
            }
        }
        return freeSquare/totalSquare;
    }


}
