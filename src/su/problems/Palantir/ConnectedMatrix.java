package su.problems.palantir;

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

// crossword: Int[][], 0 == white, 1 == black
// invariant - in a crossword, from any white square, you can reach any other white square by only travelling through white squares (up, left, right, down)

// def is_valid(crossword): # boolean -> invariant holds

// 1 0 1
// 1 0 0
// 1 1 0


// 1 0 1
// 1 1 1
// 0 0 0

// Solution - The idea is to do a DFS, starting from any zero. The DFS returns the number of zeroes traversed. Compare the traversed zeroes
// with total number of zeroes in the matrix. If they are equal, means all zeroes are connected.

public class ConnectedMatrix {

    int dfsZeroCount = 0;

    private int getNumOfZeroes(int[][] arr){
        int count = 0;
        for(int i=0; i< arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                if(arr[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(int[][] crossword){
        int numOfZeroes = getNumOfZeroes(crossword);
        System.out.println("total zeroes : "+numOfZeroes);
        boolean[][] visited = new boolean[crossword.length][crossword[0].length];
        for(int i=0; i< crossword.length; i++){
            for(int j = 0; j<crossword[i].length; j++){
                if(crossword[i][j] == 0){
                    int count = doDFS(crossword, i, j, visited);
                    return count == numOfZeroes;
                }
            }
        }
        return false;
    }

    private int doDFS(int[][] arr, int i, int j, boolean[][] visited){

        System.out.println("i= "+ i + " j= " + j + " arr= " + arr[i][j] + " visited= " +visited[i][j] + " dfsZeroCount= "+ dfsZeroCount);

        if(visited[i][j]){
            return dfsZeroCount;
        }

        visited[i][j] = true;
        dfsZeroCount++;

        // down
        if(isVisitable(arr, i-1, j, visited)){
            doDFS(arr, i-1, j, visited);
        }
        // up
        if(isVisitable(arr, i+1, j, visited)){
            doDFS(arr, i+1, j, visited);
        }
        // left
        if(isVisitable(arr, i, j-1, visited)){
            doDFS(arr, i, j-1, visited);
        }
        // right
        if(isVisitable(arr, i, j+1, visited)){
            doDFS(arr, i, j+1, visited);
        }

        return dfsZeroCount;
    }

    private boolean isVisitable(int[][] arr, int i, int j, boolean[][] visited){
        if(i < arr.length && i > -1 && j < arr[i].length && j > -1){
            return arr[i][j] == 0 && !visited[i][j];
        }
        return false;
    }

    public static void main(String[] args){
        int[][] crossword = { {1, 0, 1} , { 1, 0, 0}, {1, 1, 0} };
        System.out.println("Result : "+ new ConnectedMatrix().isValid(crossword));
    }


}