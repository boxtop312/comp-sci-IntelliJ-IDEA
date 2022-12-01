import java.util.Arrays;
import java.util.Objects;

public class GameOfLife {
    public static void main(String args[]) {
        //       0    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19
        String[][] grid = {
                {" ", " ", "X", " ", " ", " ", "X", "X", " ", " ", "X", "X", " ", " ", " ", " ", "X", " ", " ", " "},//0
                {"X", " ", " ", " ", "X", " ", " ", "X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},//1
                {" ", " ", " ", " ", " ", " ", "X", " ", " ", " ", " ", " ", "X", " ", " ", "X", " ", " ", " ", "X"},//2
                {"X", " ", " ", " ", "X", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X", " ", "X", "X", " ", " "},//3
                {"X", " ", " ", " ", " ", " ", " ", " ", "X", " ", " ", " ", "X", " ", "X", "X", " ", " ", " ", " "},//4
                {"X", " ", "X", " ", "X", " ", " ", "X", " ", " ", " ", " ", " ", "X", " ", " ", " ", "X", " ", " "},//5
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X", " ", " ", "X", "X", " ", " ", "X", " "},//6
                {" ", " ", " ", " ", "X", " ", " ", " ", " ", " ", "X", " ", " ", "X", "X", " ", " ", " ", " ", " "},//7
                {" ", " ", " ", " ", " ", " ", "X", " ", " ", " ", " ", "X", "X", " ", "X", " ", " ", "X", " ", "X"},//8
                {" ", " ", " ", " ", " ", " ", "X", " ", "X", " ", " ", " ", " ", "X", "X", " ", " ", " ", " ", " "},//9
                {" ", " ", " ", "X", " ", " ", " ", " ", " ", " ", "X", " ", " ", " ", " ", " ", " ", " ", " ", "X"},//10
                {" ", " ", " ", " ", " ", " ", "X", "X", " ", "X", "X", " ", " ", " ", " ", " ", " ", "X", " ", " "},//11
                {"X", " ", "X", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X", " ", " ", " ", " ", " ", " ", " "},//12
                {"X", "X", " ", " ", " ", " ", " ", "X", "X", " ", " ", " ", " ", " ", "X", "X", " ", " ", " ", " "},//13
                {" ", " ", " ", " ", " ", " ", " ", "X", " ", "X", " ", " ", "X", "X", " ", " ", "X", " ", "X", " "},//14
                {"X", " ", "X", " ", " ", " ", "X", " ", "X", " ", "X", "X", " ", " ", " ", " ", "X", "X", " ", " "},//15
                {" ", " ", "X", "X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X", " "},//16
                {" ", " ", "X", " ", " ", " ", " ", "X", " ", " ", " ", "X", " ", "X", " ", " ", " ", " ", " ", "X"},//17
                {"X", " ", " ", " ", " ", "X", "X", " ", " ", " ", " ", "X", "X", "X", "X", " ", " ", " ", " ", " "},//18
                {" ", " ", " ", "X", "X", " ", "X", " ", "X", " ", " ", "X", " ", " ", " ", " ", "X", "X", " ", " "}//19
        };
        Game game1 = new Game(grid);
//        System.out.println(game1.neighborCount(1,3));
        String[][] test;
        test = makeBacteria(game1.runGame());
        for (String[] row : test) {
            for (String item : row) {
                System.out.print(item);
            }
            System.out.println();
        }
    }
    public static String[][] makeBacteria (String[][]arr){
        String[][] bacteria = new String[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (arr[i][j] == " ") {
                    bacteria[i][j] = " ";
                } else {
                    bacteria[i][j] = "#";
                }
            }
        }
        return bacteria;
    }
}

class Game {
    private String[][] field;

    public Game(String[][] arry) {
        field = arry;
    }

    public String[][] runGame(){
        String[][] newfield = new String[20][20];
        for(int y = 0; y<field.length;y++){
            for(int x=0; x< field[y].length;x++){
                int neighbors = neighborCount(y,x);
                if(neighbors<2||neighbors>3){
                    newfield[y][x]=" ";
                } else if (neighbors == 3 && Objects.equals(field[y][x], " ")){
                    newfield[y][x]="X";
                } else if (neighbors>1&&neighbors<4&& Objects.equals(field[y][x], "X")) {
                    newfield[y][x]=field[y][x];
                } else if (neighbors>1&&neighbors<4&& Objects.equals(field[y][x], " ")) {
                    newfield[y][x] = field[y][x];
                }

            }
        }
        return newfield;
    }

    public int neighborCount(int y, int x){
        int neighbors = 0;
        int x2 = 0;
        int y2 = 0;
        int x3 = 0;
        int y3 = 0;
        if(x == 0){x2=1;}
        if(x == 19){x3=-1;}
        if(y == 0){y2=1;}
        if(y == 19){y3=-1;}
        for (int y1 = -1+y2; y1 < 2+y3; y1++){
            for (int x1 = -1+x2; x1 < 2+x3; x1++){
                if (Objects.equals(field[y + y1][x + x1], "X")&& !Arrays.equals(new int[]{y + y1, x + x1}, new int[]{y, x})) {
                    neighbors++;
//                    System.out.println((y+y1)+", "+ (x+x1)+"\n");
                }
            }
        }
        return neighbors;
    }

}
