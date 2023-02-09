import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PlantsMain {
    public static void main(String[] args){
        JFrame frame = new JFrame("Drawing");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new PlantsDisplay());
        frame.setVisible(true);
    }
}

class PlantsDisplay extends JPanel{
    public PlantsDisplay(){}
    // paintCommponent is not explicitly called. It is executed whenever the JPanel is called.
    // Graphics g object is implicitly passed to function.
    public void paintComponent(Graphics g){
        super.paintComponent(g); //satisfies the parent class' requirements.
        setBackground(Color.WHITE);
        Plants thngy = new Plants(50,50);
        thngy.addPlant(new Plant(2), new PlantPot(2));
        thngy.addPlant(new LeafedPlant(2), new PlantPot(2));
        thngy.addPlant(new Cactus(2), new PlantPotWithSaucer(2));
        thngy.addPlant(new FloweringCactus(2), new PlantPotWithSaucer(2));
        thngy.showPlants(g);
    }
}

class Plant{
    protected int startX;
    protected int startY;
    protected int scale;
    void drawPlant(Graphics g){
        g.setColor(Color.green);
        g.fillRect((startX+45)*scale, (startY-30)*scale,10*scale,30*scale);
    }

    public Plant(int s){
        startX=50;
        startY=50;
        scale=s;
    }
    public void setStartY(int Y){startY=Y;}
    public void setStartX(int X){startX=X;}
}

class Cactus extends Plant{
    Cactus(int scale){super(scale);}

    void drawPlant(Graphics g) {
        super.drawPlant(g);
        g.setColor(Color.green);
        g.fillRect(scale*(startX+35), (startY-10)*scale, 10*scale, 2*scale);
        g.fillRect((startX+35)*scale, (startY-20)*scale, 5*scale, 10*scale);
        g.fillRect((startX+55)*scale, (startY-12)*scale, 10*scale,2*scale);
        g.fillRect((startX+60)*scale, (startY-22)*scale,5*scale,10*scale);
    }
}

class FloweringCactus extends Cactus{
    FloweringCactus(int scale){super(scale);}
    void drawPlant(Graphics g) {
        super.drawPlant(g);
        CactusFlower one = new CactusFlower((startX+45), (startY-30), (startX+55), scale);
        one.drawCactusFlower(g);
        CactusFlower two = new CactusFlower(startX+33,startY-20, startX+43,scale);
        two.drawCactusFlower(g);
        CactusFlower three = new CactusFlower(startX+58, startY-22, startX+68,scale);
        three.drawCactusFlower(g);
    }
}

class LeafedPlant extends Plant{
   LeafedPlant(int scale){super(scale);}
    void drawPlant(Graphics g) {
       super.drawPlant(g);
       g.fillRect((startX+45)*scale, (startY-40)*scale,10*scale,10*scale);
       g.fillPolygon(new int[]{(startX+45)*scale, (startX-5+45)*scale, (startX-5+45)*scale, (startX-15+45)*scale, (startX-20+45)*scale, (startX-15+45)*scale, (startX-5+45)*scale, (startX-5+45)*scale, (startX+45)*scale}, new int[]{(startY-20)*scale, (startY-20)*scale, (startY-25)*scale, (startY-25)*scale, (startY-18)*scale, (startY-10)*scale, (startY-10)*scale, (startY-15)*scale, (startY-15)*scale},9);
       g.fillPolygon(new int[]{(startX+45+10)*scale, (startX+5+45+10)*scale, (startX+5+45+10)*scale, (startX+15+45+10)*scale, (startX+20+45+10)*scale, (startX+15+45+10)*scale, (startX+5+45+10)*scale, (startX+5+45+10)*scale, (startX+45+10)*scale}, new int[]{(startY-20)*scale, (startY-20)*scale, (startY-25)*scale, (startY-25)*scale, (startY-18)*scale, (startY-10)*scale, (startY-10)*scale, (startY-15)*scale, (startY-15)*scale},9);

    }
}

class CactusFlower {
    protected int startX;
    protected int startY;
    protected int endX;
    protected int scale;

    void drawCactusFlower(Graphics g) {
        g.setColor(Color.yellow);
        int distance = (endX - startX) / 10;
        int[] polyX = new int[]{startX * scale, (startX + distance) * scale, (startX + distance * 2) * scale, (startX + distance * 3) * scale, (startX + distance * 4) * scale, (startX + distance * 5) * scale, (startX + distance * 6) * scale, (startX + distance * 7) * scale, (startX + distance * 8) * scale, (startX + distance * 9) * scale, (startX+distance*5)*scale};
        int[] polyY = new int[]{(startY - 1) * scale, (startY + 1) * scale, (startY - 3) * scale, (startY - 1) * scale, (startY - 5) * scale, (startY - 5) * scale, (startY - 1) * scale, (startY - 3) * scale, (startY + 1) * scale, (startY - 1) * scale, (startY+1)*scale};
        g.fillPolygon(polyX, polyY, 11);
    }

    CactusFlower(int sX, int sY, int eX, int s) {
        startX=sX;
        startY=sY;
        endX=eX;
        scale=s;
    }
}

class PlantPot{
    protected int startX;
    protected int startY;
    protected int scale;
    public void drawPot(Graphics g){
        g.setColor(new Color(110,30,0));
        g.fillPolygon(new int[]{(startX+100)*scale,(startX+90)*scale,(startX+10)*scale,(startX)*scale},new int[]{(startY)*scale,(startY+80)*scale,(startY+80)*scale,startY*scale},4);
    }
    public PlantPot(int s){
        startX=50;
        startY=50;
        scale=s;
    }
    public void setStartY(int Y){startY=Y;}
    public void setStartX(int X){startX=X;}
}

class PlantPotWithSaucer extends PlantPot{
    PlantPotWithSaucer(int scale){super(scale);}
    public void drawPot(Graphics g) {
        super.drawPot(g);
        g.fillPolygon(new int[]{(startX+100)*scale, (startX+90)*scale, (startX+10)*scale, (startX)*scale}, new int[]{(startY+80)*scale,(startY+90)*scale, (startY+90)*scale, (startY+80)*scale}, 4);
    }
}

class CompletePlant{
    protected int startX;
    protected int startY;
    protected Plant plant;
    protected PlantPot plantPot;
    public CompletePlant(Plant p, PlantPot pP){
        startX=50;
        startY=50;
        plant = p;
        plantPot=pP;
    }
    public void showCompletePlant(Graphics g){
        plant.setStartX(startX);
        plant.setStartY(startY);
        plant.drawPlant(g);
        plantPot.setStartX(startX);
        plantPot.setStartY(startY);
        plantPot.drawPot(g);
    }
    public void setStartY(int Y){startY=Y;}
    public void setStartX(int X){startX=X;}

}

class Plants{
    private int startX;
    private int startY;
    Plants(int X, int Y) {
        startX = X;
        startY = Y;
    }
    ArrayList<CompletePlant> plantArrayList = new ArrayList<CompletePlant>();

    void addPlant(Plant plant, PlantPot pot){
        plantArrayList.add(new CompletePlant(plant,pot));
    }
    void showPlants(Graphics g){
        int count = 1;
        for(CompletePlant p:plantArrayList){
            p.setStartX(startX);
            p.setStartY(startY);
            plantArrayList.get(count-1).setStartX(count*110);
            p.showCompletePlant(g);
            count++;
        }
    }

}