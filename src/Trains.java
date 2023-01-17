import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Trains {
    public static void main(String[] args){
        JFrame frame = new JFrame("Drawing");
        frame.setSize(3000,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new Display());
        frame.setVisible(true);
    }
}

class Display extends JPanel{
    public Display(){}
    // paintCommponent is not explicitly called. It is executed whenever the JPanel is called.
    // Graphics g object is implicitly passed to function.
    public void paintComponent(Graphics g){
        super.paintComponent(g); //satisfies the parent class' requirements.
        setBackground(Color.WHITE);
        Train one = new Train(50,50);
        one.addCar("Locomotive", Color.yellow);
        one.addCar("PassengerCar", Color.green);
        one.addCar("RailCar", Color.darkGray);
        one.addCar("FreightCar", Color.orange);
        one.addCar(1,"Caboose", Color.red);
        one.showCars(g);

    }
}

class RailCar{
    protected int startX;
    protected int startY;
    protected Color color;
    void drawCar(Graphics g){
     g.setColor(color);
     g.fillRect(startX+10, startY, 100, 50);
     g.setColor(Color.darkGray);
     g.fillRect(startX, startY+40, 10, 5);
     g.setColor(Color.gray);
     g.fillOval(startX+25, startY+35, 25,25);
     g.fillOval(startX+70, startY+35, 25, 25);
    }
    RailCar(Color bodyColor){
        startX=50;
        startY=50;
        color = bodyColor;
    }
    public void setStartX(int x){startX = x;}
    public void setStartY(int y){startY=y;}
}

class Locomotive extends RailCar{
    Locomotive(Color bodyColor) {
        super(bodyColor);
    }
    void drawCar(Graphics g){
        super.drawCar(g);
        g.setColor(Color.darkGray);
        g.fillPolygon(new int[]{startX, startX+10, startX+10}, new int[]{startY+40, startY+40, startY+30}, 3);
        g.fillRect(startX+15, startY-13, 5, 13);
        g.fillPolygon(new int[]{startX+10, startX+25, startX+15, startX+20}, new int[]{startY-15, startY-15, startY-10, startY-10}, 4);
        g.setColor(Color.lightGray);
        g.fillRect(startX+15,startY+5, 20,20);
    }

}

class PassengerCar extends RailCar{
    PassengerCar(Color bodyColor){
        super(bodyColor);
    }
    void drawCar(Graphics g) {
        super.drawCar(g);
        g.setColor(super.color);
        g.fillPolygon(new int[]{startX+5,startX+10,startX+10}, new int[]{startY, startY-10, startY},3);
        g.fillPolygon(new int[]{startX+115, startX+110, startX+110}, new int[]{startY, startY-10,startY},3);
        g.fillRect(startX+10,startY-10,100,10);
        g.setColor(Color.lightGray);
        g.fillRect(startX+15, startY+5, 25,25);
        g.fillRect(startX+45,startY+5,30,25);
        g.fillRect(startX+80,startY+5,25,25);
    }
}

class FreightCar extends RailCar{
    FreightCar(Color bodyColor){
        super(bodyColor);
    }
    void drawCar(Graphics g){
        super.drawCar(g);
        g.setColor(Color.BLACK);
        g.drawRect(startX+40, startY+10,40,30);
        g.drawLine(startX+40, startY+10, startX+80, startY+40);
        g.drawRect(startX+41, startY+11,40,30);
        g.drawLine(startX+41, startY+11, startX+81, startY+41);
        g.fillRect(startX+75,startY+20,5,10);

        g.setColor(Color.gray);
        g.fillOval(startX+25, startY+35, 25,25);
        g.fillOval(startX+70, startY+35, 25, 25);
    }
}

class Caboose extends RailCar{
    Caboose(Color bodyColor){
        super(bodyColor);
    }


    void drawCar(Graphics g) {
        super.drawCar(g);
        g.setColor(super.color);
        g.fillRect(startX+20,startY-13,80,13);
        g.setColor(Color.black);
        g.fillRect(startX+18, startY-15, 84,3);
        g.setColor(Color.lightGray);
        g.fillRect(startX+30,startY+5,25,25);
        g.fillRect(startX+65,startY+5,25,25);
    }
}

class Train{
    private int startX;
    private int startY;
    Train(int X, int Y){
        startX=X;
        startY=Y;
    }
    int count = 0;
    ArrayList<RailCar> train = new ArrayList<RailCar>();
    void addCar(String carType, Color bodyColor){
        if(Objects.equals(carType, "Locomotive")){
            train.add(new Locomotive(bodyColor));
            count++;
        } else if (Objects.equals(carType, "RailCar")) {
            train.add(new RailCar(bodyColor));
            count++;
        } else if (Objects.equals(carType, "PassengerCar")) {
            train.add(new PassengerCar(bodyColor));
            count++;
        } else if(Objects.equals(carType, "FreightCar")){
            train.add(new FreightCar(bodyColor));
            count++;
        } else if (Objects.equals(carType,"Caboose")){
            train.add(new Caboose(bodyColor));
            count++;
        }

    }

    void addCar(int index,String carType, Color bodyColor){
        if(Objects.equals(carType, "Locomotive")){
            train.add(index,new Locomotive(bodyColor));
            count++;
        } else if (Objects.equals(carType, "RailCar")) {
            train.add(index,new RailCar(bodyColor));
            count++;
        } else if (Objects.equals(carType, "PassengerCar")) {
            train.add(index,new PassengerCar(bodyColor));
            count++;
        } else if(Objects.equals(carType, "FreightCar")){
            train.add(index,new FreightCar(bodyColor));
            count++;
        } else if (Objects.equals(carType,"Caboose")){
            train.add(index,new Caboose(bodyColor));
            count++;
        }

    }
    void showCars(Graphics g){
        int count = 1;
        for(RailCar car:train){
            car.setStartX(startX);
            car.setStartY(startY);
            train.get(count-1).setStartX(count*110);
            car.drawCar(g);
            count++;
        }

    }
}
