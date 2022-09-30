import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Random_Graphics_Draw extends JPanel{
    public Random_Graphics_Draw(){
        setLayout(null);
    }
    // paintCommponent is not explicitly called. It is executed whenever the JPanel is called.
    // Graphics g object is implicitly passed to function.
    public void paintComponent(Graphics g){
        super.paintComponent(g); //satisfies the parent class' requirements.
        setBackground(Color.BLACK);
        drawGrid(g);
        drawThreeDBox(g);
        for(int i=0;i<100;i++){
            drawCircs(g, generateColor());
            drawRects(g, generateColor());
            drawLines(g, generateColor());
        }

    }
    public void drawGrid(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(10,10,580,580);
        g.drawLine(300,10,300,590);
        g.drawLine(10,300,590,300);
    }
    public int generateRandomTwoFiftyFive(){
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(256);
            if(rand !=0) break;
        }
        return(rand);
    }
    public int generateRandomFiveEighty(){
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(580);
            if(rand > 20) break;
        }
        return(rand);
    }
    public int generateRandomThreeTenToFiveEighty(){
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(580);
            if(rand > 310) break;
        }
        return(rand);
    }
    public int generateRandomTwoHundred() {
        Random random = new Random();
        int rand = 0;
        while (true) {
            rand = random.nextInt(201);
            if (rand != 0) break;
        }
        return (rand);
    }
    public int[] generateColor(){
        int num1 = generateRandomTwoFiftyFive();
        int num2 = generateRandomTwoFiftyFive();
        int num3 = generateRandomTwoFiftyFive();
        return(new int[]{num1,num2,num3});
    }
    public void drawLines(Graphics g, int[] randoms){
        int red = randoms[0];
        int green = randoms[1];
        int blue = randoms[2];
        g.setColor(new Color(red, green, blue));
        int x1 = generateRandomFiveEighty();
        int y1 = generateRandomFiveEighty();
        int x2 = generateRandomFiveEighty();
        int y2 = generateRandomFiveEighty();
        while(x1 < 10||x1 >= 290||y1 < 310||y1>=580||x2 < 10||x2 >= 290||y2 < 310||y2>=580){
            x1 = generateRandomFiveEighty();
            y1 = generateRandomFiveEighty();
            x2 = generateRandomFiveEighty();
            y2 = generateRandomFiveEighty();
        }
        g.drawLine(x1, y1, x2, y2);
    }
    public void drawRects(Graphics g,int[] randoms){
        int red = randoms[0];
        int green = randoms[1];
        int blue = randoms[2];
        g.setColor(new Color(red, green, blue));
        int x = generateRandomFiveEighty();
        int y = generateRandomFiveEighty();
        int width = 50;
        while(x < 310||x+width >= 580||y < 10||y+width>=290){
            x = generateRandomFiveEighty();
            y = generateRandomFiveEighty();
        }
//        if(x-50 < 10){
//            x+=(10-(x-5));
//        } else if (x+50 > 590) {
//            x-=(590-(x-50));
//        }
//        if (y-50 < 10){
//            y+=(10-(y-5));
//        } else if(y+50>590){
//            y-=(590-(y-50));
//        }
        g.fillRect(x,y,50,50);
    }
    public void drawCircs(Graphics g, int[] randoms){
        int red = randoms[0];
        int green = randoms[1];
        int blue = randoms[2];
        int width = generateRandomTwoHundred();
        g.setColor(new Color(red, green, blue));
        int x = generateRandomFiveEighty();
        int y = generateRandomFiveEighty();
        while(x-width < 310||x+width >= 590||y-width < 310||y+width>=590){
            x = generateRandomFiveEighty();
            y = generateRandomFiveEighty();
            width = generateRandomTwoHundred();
        }
//        if(x-width*2 < 310){
//            x+=(310-(x-5));
//        } else if (x+width > 590) {
//            x-=(590-(x-width));
//        }
//        if (y-width*2 < 310){
//            y+=(310-(y-5));
//        } else if(y+width>590){
//            y-=(590-(y-width));
//        }
        g.drawArc(x, y,width,width,0,360);
    }
    public void drawThreeDBox(Graphics g){
        g.setColor(Color.GREEN);
        g.fillPolygon(new int[]{175,175,100,100}, new int[]{225,125,100,200},4);
        g.setColor(Color.blue);
        g.fillPolygon(new int[]{175,175,250,250}, new int[]{225,125,100,200},4);
        g.setColor(Color.red);
        g.fillPolygon(new int[]{100,175,175,175}, new int[]{100,125,100,75},4);
        g.setColor(Color.yellow);
        g.fillPolygon(new int[]{250,175,175,175}, new int[]{100,125,100,75},4);
    }
}
