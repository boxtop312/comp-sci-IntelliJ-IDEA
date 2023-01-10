import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class WordSearchReplit{
    public static void main(String[] args) throws FileNotFoundException {
        int rows = 0;
        int columns = 0;
        String[] rowsColumns = new String[2];
        Scanner in = new Scanner(new File("wordsearch.txt"));
        rowsColumns = in.nextLine().split(" ");//first line of txt file
        in.nextLine();// 2nd line of txt file, blank
        rows = Integer.parseInt(rowsColumns[0]);
        columns = Integer.parseInt(rowsColumns[1]);
        String[][] grid = new String[rows][columns];
        String str = "";
        for (int y = 0; y < rows; y++) {
            str = in.nextLine();//lines of text file that contain the wordsearch grid
            for (int x = 0; x < columns * 2; x += 2) {
                grid[y][x / 2] = String.valueOf(str.charAt(x));
            }
        }
        System.out.println(Arrays.deepToString(grid));




    }

}

class WordSearch{


}