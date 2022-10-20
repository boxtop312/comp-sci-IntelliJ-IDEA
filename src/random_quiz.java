import java.util.*;
public class random_quiz {
    public static void printNums(int value, int numRounds){
        Random random = new Random();
        int rand = 0;
        int count =0;
        while(count<numRounds) {
            do {
                rand = random.nextInt(99999);
            } while (rand == 0);
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
