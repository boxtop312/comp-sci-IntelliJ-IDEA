import javax.swing.*;
import java.awt.*;

public class Random_Graphics{
    public static void main(String[] args){
        JFrame frame = new JFrame("Drawing");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new Random_Graphics_Draw());
        frame.setVisible(true);
    }
}