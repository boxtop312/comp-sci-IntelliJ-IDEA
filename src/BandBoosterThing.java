import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class
public class BandBoosterThing {
    public static void main(String[] args) {
        ArrayList<BandBooster> cart = new ArrayList<BandBooster>();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        for (int ii = 0; ii < 5; ii++) {
            System.out.println("BandBooster Name: ");
            cart.add(new BandBooster(myObj.nextLine(), 0));
            System.out.println("");
        }
        for (int i = 0; i < 3; i++) {
            for(int ii = 0; ii < cart.size(); ii++) {
                System.out.println("Enter the number of boxes sold by " + cart.get(ii).getName() + " this week: ");
                cart.get(ii).updateSales(myObj.nextInt());
            }
            System.out.println("Boosters:");
            for(int ii=0;ii<cart.size();ii++){
                System.out.println(cart.get(ii).toString());
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

