package su.problems;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Akshat
 * Date: 4/13/13
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class LawnMower {

    public boolean isDesignFeasible(int[][] lawn, int rows, int columns)
    {
        final int[][] maxByRow  = initializeMaxByRow(lawn, rows, columns);
        final int[][] maxByColumn  = initializeMaxByColumn(lawn, rows, columns);

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(maxByRow[i][0] > lawn[i][j] && maxByColumn[j][0] > lawn[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] initializeMaxByRow(int[][] lawn, int rows, int columns) {

        int[][] maxByRow = new int[rows][1];
        int max = 0;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(lawn[i][j] > max)
                {
                    max = lawn[i][j];
                }
            }
            maxByRow[i][0] = max;
            max = 0;
        }
        return maxByRow;  //To change body of created methods use File | Settings | File Templates.
    }

    private int[][] initializeMaxByColumn(int[][] lawn, int rows, int columns) {

        int[][] maxByColumn = new int[columns][1];
        int max = 0;
        for(int j = 0; j < columns; j++)
        {
            for(int i = 0; i < rows; i++)
            {
                if(lawn[i][j] > max)
                {
                    max = lawn[i][j];
                }
            }
            maxByColumn[j][0] = max;
            max = 0;
        }
        return maxByColumn;  //To change body of created methods use File | Settings | File Templates.
    }

    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Ankur\\Dropbox\\IdeaProjects\\untitled\\src\\su\\data\\lawnMoverInput.txt");
        FileWriter fileWriter = new FileWriter("C:\\Users\\Ankur\\Dropbox\\IdeaProjects\\untitled\\src\\su\\data\\lawnMoverOutput.txt");
        Scanner scanner = new Scanner(fileInputStream);
        int testCaseNum = scanner.nextInt();
        LawnMower lawnMower = new LawnMower();
        for(int k = 0; k < testCaseNum; k++)
        {
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            int [][] lawn = new int[row][column];
            for(int i = 0; i < row ; i++)
            {
                for(int j = 0; j < column; j++)
                {
                    lawn[i][j] = scanner.nextInt();
                }
            }

            String result = lawnMower.isDesignFeasible(lawn, row, column) ? "YES" : "NO";
            fileWriter.write("Case #"+(k+1)+": " + result + "\n");
            fileWriter.flush();
        }
        fileWriter.close();

    }


}
