package su.problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 5/4/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class GarbledEmail {

    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Ankur\\Dropbox\\IdeaProjects\\untitled\\src\\su\\data\\garbled_email_dictionary.txt");
        Scanner scanner = new Scanner(fileInputStream);
        FileWriter fileWriter = new FileWriter("C:\\Users\\Ankur\\Dropbox\\IdeaProjects\\untitled\\src\\su\\data\\AnalyzeGarbledEmail.csv");
        fileWriter.write("word, length \n");
        fileWriter.flush();
        while(scanner.hasNext())
        {
            String word = scanner.next();
            fileWriter.write(word + "," + word.length() + "\n");
            fileWriter.flush();
        }
        fileWriter.close();
        fileInputStream.close();
    }
}
