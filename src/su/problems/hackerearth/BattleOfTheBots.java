package su.problems.hackerearth;

import java.util.ArrayList;
import java.util.List;
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

        List<Option> options = battleOfTheBots.calculateOptions();



//        System.out.println(battleOfTheBots.new Option(Direction.N, 2, 3).calculateDensity());
//        System.out.println(battleOfTheBots.new Option(Direction.S, 2, 3).calculateDensity());
//        System.out.println(battleOfTheBots.new Option(Direction.E, 2, 3).calculateDensity());
//        System.out.println(battleOfTheBots.new Option(Direction.W, 2, 3).calculateDensity());
//        System.out.println(battleOfTheBots.new Option(Direction.NE, 2, 3).calculateDensity());
//        System.out.println(battleOfTheBots.new Option(Direction.NW, 2, 3).calculateDensity());
//        System.out.println(battleOfTheBots.new Option(Direction.SE, 2, 3).calculateDensity());
//        System.out.println(battleOfTheBots.new Option(Direction.SW, 2, 3).calculateDensity());
    }

    private List<Option> calculateOptions() {

        List<Option> options = new ArrayList<>();
        int currX = -1, currY = -1;
        switch(player){
            case 1:
                currX = p1x;
                currY = p1y;
                break;
            case 2:
                currX = p2x;
                currY = p2y;
                break;
        }

        for(Direction direction : Direction.values()){
            if(direction.isValid(currX, currY)){
                options.add(new Option(direction, currX, currY));
            }
        }

        return options;
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

    interface DirectionStrategy{
        boolean isValid(int x, int y);
        int getRow(int x);
        int getCol(int y);
    }

    enum Direction implements DirectionStrategy{
        N {
            @Override
            public boolean isValid(int x, int y) {
                return getRow(x) > -1;
            }

            @Override
            public int getRow(int x) {
                return x-1;
            }

            @Override
            public int getCol(int y) {
                return y;
            }
        }, S {
            @Override
            public boolean isValid(int x, int y) {
                return getRow(x) < 7;
            }
            @Override
            public int getRow(int x) {
                return x+1;
            }

            @Override
            public int getCol(int y) {
                return y;
            }
        }, E {
            @Override
            public boolean isValid(int x, int y) {
                return getCol(y) < 7;
            }
            @Override
            public int getRow(int x) {
                return x;
            }

            @Override
            public int getCol(int y) {
                return y+1;
            }
        }, W {
            @Override
            public boolean isValid(int x, int y) {
                return getCol(y) > -1;
            }
            @Override
            public int getRow(int x) {
                return x;
            }

            @Override
            public int getCol(int y) {
                return y-1;
            }
        }, NE {
            @Override
            public boolean isValid(int x, int y) {
                return getRow(x) > -1 && getCol(y) < 7;
            }
            @Override
            public int getRow(int x) {
                return x-1;
            }

            @Override
            public int getCol(int y) {
                return y+1;
            }
        }, NW {
            @Override
            public boolean isValid(int x, int y) {
                return getRow(x) > -1 && getCol(y) > -1;
            }
            @Override
            public int getRow(int x) {
                return x-1;
            }

            @Override
            public int getCol(int y) {
                return y-1;
            }
        }, SE {
            @Override
            public boolean isValid(int x, int y) {
                return getRow(x) < 7 && getCol(y) < 7;
            }
            @Override
            public int getRow(int x) {
                return x+1;
            }

            @Override
            public int getCol(int y) {
                return y+1;
            }
        }, SW {
            @Override
            public boolean isValid(int x, int y) {
                return getRow(x) < 7 && getCol(y) > -1;
            }
            @Override
            public int getRow(int x) {
                return x+1;
            }

            @Override
            public int getCol(int y) {
                return y-1;
            }
        }
    }

    class Option implements Comparable<Option>{

        private Direction direction;
        private int x, y;
        private Double density;
        private Double freeSquare;

        public Option(Direction direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
            this.density = calculateDensity();
        }

        private double calculateDensity(){

            int densityGridStartX = 0, densityGridStartY = 0, densityGridEndX = 0, densityGridEndY = 0;

            switch(this.direction){
                case N:
                    densityGridStartX = 0;
                    densityGridStartY = 0;
                    densityGridEndX = this.x - 1;
                    densityGridEndY = colMax - 1;
                    break;

                case S:
                    densityGridStartX = this.x + 1;
                    densityGridStartY = 0;
                    densityGridEndX = rowMax - 1;
                    densityGridEndY = colMax - 1;
                    break;

                case E:
                    densityGridStartX = 0;
                    densityGridStartY = this.y + 1;
                    densityGridEndX = rowMax - 1;
                    densityGridEndY = colMax - 1;
                    break;

                case W:
                    densityGridStartX = 0;
                    densityGridStartY = 0;
                    densityGridEndX = rowMax - 1;
                    densityGridEndY = this.y - 1;
                    break;

                case NE:
                    densityGridStartX = 0;
                    densityGridStartY = this.y + 1;
                    densityGridEndX = this.x - 1;
                    densityGridEndY = colMax - 1;
                    break;

                case NW:
                    densityGridStartX = 0;
                    densityGridStartY = 0;
                    densityGridEndX = this.x - 1;
                    densityGridEndY = this.y - 1;
                    break;

                case SE:
                    densityGridStartX = this.x + 1;
                    densityGridStartY = this.y + 1;
                    densityGridEndX = rowMax - 1;
                    densityGridEndY = colMax - 1;
                    break;

                case SW:
                    densityGridStartX = this.x + 1;
                    densityGridStartY = 0;
                    densityGridEndX = rowMax - 1;
                    densityGridEndY = this.y - 1;
                    break;
            }
            
            double totalSquare = 0;

            for(int i=densityGridStartX;i<densityGridEndX+1;i++){
                for(int j=densityGridStartY;j<densityGridEndY+1;j++){
                    totalSquare += 1;
                    if(grid[i][j] == 0){
                        freeSquare += 1;
                    }
                }
            }
            System.out.println(direction.name() + " density : " + density + " freeSquare : "+freeSquare);
            return freeSquare/totalSquare;
        }


        @Override
        public int compareTo(Option o) {
            if(o.density.equals(this.density)){
                return o.freeSquare.compareTo(this.freeSquare);
            }else{
                if(o.density > this.density){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
    }
}
