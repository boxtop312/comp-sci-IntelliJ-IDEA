import javax.swing.*;
import java.awt.*;
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
        drawLines(g);
    }
    public void drawGrid(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(10,10,580,580);
        g.drawLine(300,10,300,590);
        g.drawLine(10,300,590,300);
    }
    public void drawLines(Graphics g){

    }
}
