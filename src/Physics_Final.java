import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Physics_Final{
    public String[] Objects;
    public static void main(String[] args) {
        JFrame f=new JFrame("Simulation Settings");
        f.setSize(1920,1080);
        JButton addButton=new JButton("Add Object");
        addButton.setBounds(50,50,100,30);
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new OptionPane();
            }
        });
        f.add(addButton);
        JCheckBox gravity = new JCheckBox("Gravity");
        gravity.setBounds(140,200,100,20);
        f.add(gravity);
        JTextField gravityNum = new JTextField("9.80665");
        gravityNum.setBounds(50,200,50,20);
        f.add(gravityNum);
        JLabel gravityUnit = new JLabel("m/s^2");
        gravityUnit.setBounds(105,195,40,30);
        f.add(gravityUnit);
        new TabbedPane(f);
        f.setLayout(null);
        f.setVisible(true);
    }
}

class TabbedPane{
    ArrayList<PhysicsObject> physicsObjectArrayList = new ArrayList<PhysicsObject>();
    String[] Objects = {""};
    public TabbedPane(JFrame f){
        JPanel objectsPanel=new JPanel();
        JPanel AttributesPanel=new JPanel();
        JPanel p3=new JPanel();
        JTextArea objectsTextArea=new JTextArea(400,500);
        JComboBox AttributesComboBox=new JComboBox(Objects);
        AttributesComboBox.setBounds(1010, 60,90,20);
        AttributesPanel.add(AttributesComboBox);
        objectsPanel.add(objectsTextArea);
        JTabbedPane tp=new JTabbedPane();
        tp.setBounds(1000,50,400,500);
        tp.add("Objects",objectsPanel);
        tp.add("Attributes",AttributesPanel);
        tp.add("help",p3);
        f.add(tp);
    }
    void addPhysicsObject(PhysicsObject PO){
        physicsObjectArrayList.add(PO);
    }

    void removePhysicsObject(PhysicsObject PO){
        physicsObjectArrayList.remove(PO);
    }
    void removePhysicsObject(String name){
        for (int i = 0; i < physicsObjectArrayList.size(); i++) {
            if(physicsObjectArrayList.get(i).getName()==name){
                physicsObjectArrayList.remove(i);
            }
        }
    }

    void removePhysicsObject(int index){
        physicsObjectArrayList.remove(index);
    }


}
abstract class OptionPane{
    private JFrame f;
    OptionPane() {
        f = new JFrame();
    }
}

abstract class PhysicsObject{
    protected String name;
    public String getName() {return name;}
}

