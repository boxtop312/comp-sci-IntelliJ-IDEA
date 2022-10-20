import javax.swing.*;
import java.awt.*;

public class SQFractal extends JPanel {
    public SQFractal() {
        setLayout(null);
    }

    // paintCommponent is not explicitly called. It is executed whenever the JPanel is called.
    // Graphics g object is implicitly passed to function.
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //satisfies the parent class' requirements.
        setBackground(new Color(140, 124, 91));
        drawSquare(g,600,600);
    }

    public void drawSquare(Graphics g, int maxX, int maxY) {
        int midx = maxX / 2;
        int midy = maxY / 2;

        int startWidth = maxX / 4;
        int startHeight = maxY / 4;
        int tix = midx - (startWidth / 2);
        int tly = midy - (startHeight / 2);
        drawFractalLeftUp(g,tix,tly,startWidth,startHeight,0);
        drawFractalRightUp(g,tix,tly,startWidth,startHeight,0);
        drawFractalRightDown(g,tix,tly,startWidth,startHeight,0);
        drawFractalLeftDown(g,tix,tly,startWidth,startHeight,0);
        g.setColor(Color.black);
        g.fillRect(tix, tly, startWidth, startHeight);
    }

    public void drawFractalLeftUp(Graphics g, int x, int y, int width, int height, int i) {
        if(width <=0&&height <=0){
            return;
        }else{
            g.setColor(Color.red);
            g.fillRect(x, y, width, height);
            drawFractalLeftUp(g,x-width/2,y-height/2,width/2,height/2,i);
            drawFractalRightUp(g,x+width,y-height/2,width/2,height/2,i);
            drawFractalLeftDown(g,x-width/2,y+width,width/2,height/2,i);
//            drawSquare(g,(int)(x+width),(int)(y+width));
//            drawFractal(g,x+width/4,y+height/4,width/4,height/4,0);
//            drawSquare(g,(int)(width+x),(int)(height+y));
//            drawFractalLeft(g,x+1,y+1,(int)(width/4+width/3+width/60),(int)(height/4+height/3+height/60),i);
        }
    }
    public void drawFractalRightUp(Graphics g, int x, int y, int width, int height, int i) {
        if(width <=0&&height <=0){
            return;
        }else{
            g.setColor(Color.blue);
            g.fillRect(x, y, width, height);
            drawFractalRightUp(g,x+width,y-height/2,width/2,height/2,i);
            drawFractalLeftUp(g,x-width/2,y-height/2,width/2,height/2,i);
            drawFractalRightDown(g,x+width,y+height,width/2,height/2,i);
//            drawSquare(g,(int)(x+width),(int)(y+width));
//            drawFractal(g,x+width/4,y+height/4,width/4,height/4,0);
//            drawSquare(g,(int)(width+x),(int)(height+y));
//            drawFractalRight(g,x+width,y-height/2,(int)(width/4+width/3+width/60+width),(int)(height/4+height/3+height/60),i);
//            drawFractalLeft(g,x+1,y+1,(int)(width/4+width/3+width/60),(int)(height/4+height/3+height/60),i);

        }
    }
    public void drawFractalRightDown(Graphics g, int x, int y, int width, int height, int i) {
        if(width <=0&&height <=0){
            return;
        }else{
            g.setColor(Color.green);
            g.fillRect(x, y, width, height);
            drawFractalRightDown(g,x+width,y+height,width/2,height/2,i);
            drawFractalRightUp(g,x+width,y-height/2,width/2,height/2,i);
            drawFractalLeftDown(g,x-width/2,y+width,width/2,height/2,i);
//            drawSquare(g,(int)(x+width),(int)(y+width));
//            drawFractal(g,x+width/4,y+height/4,width/4,height/4,0);
//            drawSquare(g,(int)(width+x),(int)(height+y));
//            drawFractalRight(g,x+width,y-height/2,(int)(width/4+width/3+width/60+width),(int)(height/4+height/3+height/60),i);
//            drawFractalLeft(g,x+1,y+1,(int)(width/4+width/3+width/60),(int)(height/4+height/3+height/60),i);

        }
    }
    public void drawFractalLeftDown(Graphics g, int x, int y, int width, int height, int i) {
        if(width <=0&&height <=0){
            return;
        }else{
            g.setColor(Color.yellow);
            g.fillRect(x, y, width, height);
            drawFractalLeftDown(g,x-width/2,y+width,width/2,height/2,i);
            drawFractalRightDown(g,x+width,y+height,width/2,height/2,i);
            drawFractalLeftUp(g,x-width/2,y-width/2,width/2,height/2,i);
//            drawSquare(g,(int)(x+width),(int)(y+width));
//            drawFractal(g,x+width/4,y+height/4,width/4,height/4,0);
//            drawSquare(g,(int)(width+x),(int)(height+y));
//            drawFractalLeft(g,x+1,y+1,(int)(width/4+width/3+width/60),(int)(height/4+height/3+height/60),i);
        }
    }

    // The 100 point version requires that you create four new methods.


    public void delay(long n) {
        n *= 1000;
        long startDelay = System.nanoTime();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.nanoTime();
    }
}
