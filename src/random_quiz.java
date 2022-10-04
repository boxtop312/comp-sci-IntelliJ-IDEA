import java.util.*;
public class random_quiz {
    public static void printNums(int value, int numRounds){
        Random random = new Random();
        int rand = 0;
        int count =0;
        while(count<numRounds) {
            while (true) {
                rand = random.nextInt(99999);
                if (rand != 0) break;
            }
            if ((rand + "").indexOf('5') != -1 && count < numRounds) {
                count++;
                System.out.println(rand);
            }
        }
    }
    public static void main(String[] args){
     printNums(5,4);
    }
}
