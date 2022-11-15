import java.util.Scanner;  // Import the Scanner class
public class BandBoosterThing {
    public static void main(String[] args) {
        BandBooster[] cart = new BandBooster[5];
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        for (int ii = 0; ii < cart.length; ii++) {
            System.out.println("BandBooster Name: ");
            cart[ii] = new BandBooster(myObj.nextLine(), 0);
            System.out.println("");
        }
        for (int i = 0; i < 3; i++) {
            for(int ii = 0; ii < cart.length; ii++) {
                System.out.println("Enter the number of boxes sold by " + cart[ii].getName() + " this week: ");
                cart[ii].updateSales(myObj.nextInt());
            }
            for(int ii=0;ii<cart.length;ii++){
                System.out.println("Boosters: \n"+cart[ii].toString());
            }
        }
    }
}

class BandBooster{
    private String name;
    private  int boxesSold;
    public BandBooster(String name1, int boxesSold1){
        name = name1;
        boxesSold = boxesSold1;
    }

    public String getName() {
        return name;
    }

    public int getBoxesSold() {
        return boxesSold;
    }
    public void updateSales(int num){
        boxesSold += num;
    }

    public String toString() {
        return name + ": " + boxesSold +" boxes";
    }
}

