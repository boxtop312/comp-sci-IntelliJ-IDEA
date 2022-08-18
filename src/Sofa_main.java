public class Sofa_main{
    public static void main(String[]args){
        Sofa test = new Sofa();
        System.out.println(test.getNum_seats());
    }
}

class Sofa{
    // Instance variables
    private int num_seats;
    private String color;
    private String size;

    // Constructor
    public Sofa(){
        this.num_seats=2;
        this.color = "blue";
        size = "Large";
    }
    // Getters - retireve values from memory for each object
    public int getNum_seats(){
        return num_seats;
    }

}