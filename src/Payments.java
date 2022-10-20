import java.util.*;
public class Payments {
    public static double compoundInterst(double principle, double interst, double compounding, double time){
        return(principle*(Math.pow((1+(((interst/100)/12)/compounding)),compounding*time)));
//        return(principle+(principle*((interst/12)/100)));
    }
    public static double pay(double principle, double payment){
        return(principle-payment);
    }
    public static String payments(double principle, double interst, double payment){
        double compounding = 1;
        double time = 1;
        int count = 0;

        while(principle > 0){
            System.out.println("Month: "+count+"\nPrinicple ammount: "+ principle +"\nAnnual interst rate: "+ interst +"\n Monthly payment: "+payment);
            principle = compoundInterst(principle, interst, compounding, time);
            principle = pay(principle, payment);
            count ++;
            if(principle<0){
                System.out.println("Month: "+count+"\nPrinicple ammount: "+ principle +"\nAnnual interst rate: "+ interst +"\n Monthly payment: "+payment);
            }
        }
        return"";
    }
    public static void main(String[] args){
        double principle;
        double payment;
        double interst;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter initial ammount: ");
        principle = Double.parseDouble(myObj.nextLine());  // Read user input
        myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter annual interst: ");
        interst = Double.parseDouble(myObj.nextLine());  // Read user input
        myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter monthly payment: ");
        payment = Double.parseDouble(myObj.nextLine());  // Read user input
        System.out.println(payments(principle, interst, payment));
    }
}
