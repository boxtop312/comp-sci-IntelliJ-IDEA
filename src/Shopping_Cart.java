import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Shopping_Cart{
    public static void main(String[] args) {
        boolean shopping = true;
        ShoppingCart cart1 = new ShoppingCart();
        String input = "";
        while(shopping) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("What would you like to do\nadd item, remove item, or end shopping? ");
            input = myObj.nextLine();
            if (input.equals("add item")) {
                System.out.println("What item?");
                String nameItem = myObj.nextLine();
                System.out.println("What price is it?");
                double priceItem = myObj.nextDouble();
                System.out.println("How many?");
                int quantityItem = myObj.nextInt();
                cart1.addToCart(nameItem, priceItem, quantityItem);
                for (int i = 0; i < cart1.getCart().size(); i++) {
                    System.out.println("Item " + (i+1) + " " + cart1.getCart().get(i).getName() + " Cost $" + cart1.getCart().get(i).getPrice() +" Quantity: "+ cart1.getCart().get(i).getQuantity());
                }
                System.out.println("Total Price: " + cart1.getTotalPrice());
            } else if (Objects.equals(input, "remove item")) {
                System.out.println("What item?");
                String nameItem = myObj.nextLine();
                System.out.println("How many?");
                int quantityItem = myObj.nextInt();
                cart1.removeFromCart(nameItem, quantityItem);
                for (int i = 0; i < cart1.getCart().size(); i++) {
                    System.out.println("Item " + (i+1) + " " + cart1.getCart().get(i).getName() + " Cost $" + cart1.getCart().get(i).getPrice() +" Quantity: "+ cart1.getCart().get(i).getQuantity());
                }
                System.out.println("Total Price: " + cart1.getTotalPrice());
            } else if (Objects.equals(input, "end shopping")) {
                System.out.println(cart1.toString());
                System.out.println("Price after tax: "+(cart1.getTotalPrice()*6.25)/100);
                shopping=false;
                break;
            }else{
                System.out.println("Error wrong input\nAvalible inputs: add item, remove item, end shopping.");
            }
        }
    }
}


class Item{
    private String name;
    private double price;
    private int quantity;
    // -------------------------------------------------------
    // Create a new item with the given attributes.
    // -------------------------------------------------------
    public Item (String itemName, double itemPrice, int numPurchased){
        name = itemName;
        price = itemPrice;
        quantity = numPurchased;
    }
    // -------------------------------------------------------
    // Return a string with the information about the item
    // -------------------------------------------------------
    public String toString (){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return (name + "\t\t" + fmt.format(price) + "\t\t" + quantity + "\t\t\t"
                + fmt.format(price*quantity));
    }
    // -------------------------------------------------
    // Returns the unit price of the item
    // -------------------------------------------------
    public double getPrice(){
        return price;
    }
    // -------------------------------------------------
    // Returns the name of the item
    // -------------------------------------------------
    public String getName(){
        return name;
    }
    // -------------------------------------------------
    // Returns the quantity of the item
    // -------------------------------------------------
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int num){
        quantity = num;
    }
}


// **********************************************************************
// ShoppingCart.java
//
// Represents a shopping cart as an array of items
// **********************************************************************
class ShoppingCart{
    private int itemCount; // total number of items in the cart
    private double totalPrice; // total price of items in the cart
    private int capacity; // current cart capacity
    private ArrayList <Item> cart;
    // -----------------------------------------------------------
    // Creates an empty shopping cart with a capacity of 5 items.
    // -----------------------------------------------------------
    public ShoppingCart(){
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        cart = new ArrayList<Item>();
    }
    // -------------------------------------------------------
    // Adds an item to the shopping cart.
    // -------------------------------------------------------
    public void addToCart(String itemName, double price, int quantity){
        if(cart.contains(itemName)){
            cart.set(cart.indexOf(itemName), new Item(itemName,price,(cart.get(cart.indexOf(itemName)).getQuantity()+quantity)));
        }else{
        cart.add(new Item(itemName,price,quantity));
        }
        itemCount++;
        totalPrice+= price*quantity;
    }
    // -------------------------------------------------------
    // Removes an item to the shopping cart.
    // -------------------------------------------------------
    public void removeFromCart(String itemName, int quantity){
        for(int i =0;i<cart.size();i++){
            if(Objects.equals(cart.get(i).getName(), itemName)&&cart.get(i).getQuantity()>quantity){
                cart.set(i, new Item(itemName,cart.get(i).getPrice(),(cart.get(i).getQuantity()-quantity)));
            }else{
                cart.remove(itemName);
            }

        }
    }
    // -------------------------------------------------------
    // Returns the contents of the cart together with
    // summary information.
    // -------------------------------------------------------
    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String contents = "\nShopping Cart\n";
        contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";
        for (int i = 0; i < itemCount; i++)
            contents += cart.get(i).toString() + "\n";
        contents += "\nTotal Price: " + fmt.format(totalPrice);
        contents += "\n";
        return contents;
    }
    // ---------------------------------------------------------
    // Increases the capacity of the shopping cart by 3
    // ---------------------------------------------------------
    private void increaseSize(){
    }

    public ArrayList<Item> getCart() {
        return cart;
    }
    public double getTotalPrice(){
        double totalPrice = 0.0;
        for (Item item : cart) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }
}