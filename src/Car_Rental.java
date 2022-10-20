import java.util.Scanner;
public class Car_Rental {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the make of your car: ");
        String make = myObj.nextLine();  // Read user input

        System.out.println("Enter the model of your car: ");
        String model = myObj.nextLine();  // Read user input

        System.out.println("Enter the license plate for the car");
        String plate = myObj.nextLine();  // Read user input
        String plateNum = plate.replaceAll("" + "[A-Za-z]", "");
        String plateStr = plate.replaceAll("[1234567890 ]", "");
        plateNum = plateNum.replaceAll("[^\\w+]", "");
        plateNum = plateNum.replaceAll(" ", "");
        int plateNumInt = Integer.parseInt(plateNum);
        int plateStrInt = 0;
        for(int i=0; i<plateStr.length(); i++) {
            int asciiValue = plateStr.charAt(i);
            plateStrInt += asciiValue;
            System.out.println(asciiValue);
        }
        int plateInt = plateNumInt + plateStrInt;
        System.out.println(plateInt);
        int plateIntByTwentySix = (plateInt%26)+65;
        String plateIntByTwentySixASCII = Character.toString((char)plateIntByTwentySix);
        String newPlate = plateIntByTwentySixASCII + plateInt;
        System.out.println("Make = "+make +"\nModel = "+model+"\n"+plate+ " = "+newPlate);


        /**
         Integer.parseInt(String var) converts a string to an int value.
         String s = "512";
         int i=Integer.parseInt(s);
         **/
    }
}
