import java.util.Scanner;
public class Coins {
    public static String ChangeMaker(int num){
        int quarters;
        int dimes;
        int nickles;
        int pennies;
        int num1;
        quarters = 0;
        dimes = 0;
        nickles = 0;
        pennies = 0;
        num1 = num;
        while(num1 > 0){
            if(num1 >= 25){
                num1 -= 25;
                quarters +=1;
            } else if(num1 >=10){
                num1 -=10;
                dimes +=1;
            } else if(num1 >=5){
                num1 -=5;
                nickles +=1;
            } else if(num1 <=4){
                num1 -=1;
                pennies +=1;
            }
        }
        return "Quarters: " + quarters +"\nDimes: " + dimes + "\nNickles: " + nickles + "\nPennies: " + pennies;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("input cents: ");
        int cents = input.nextInt();
        System.out.println(ChangeMaker(cents));
    }
}

