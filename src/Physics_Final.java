import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics2D.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.Timer;


public class Physics_Final{
    public static TabbedPane tP;
    static boolean isNumeric(String str){return str != null && str.matches("[0-9.]+");}
    public static void main(String[] args) {
        JFrame f=new JFrame("Simulation Settings");
        f.setSize(1920,1080);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addButton=new JButton("Add Object");
        addButton.setBounds(50,50,100,30);
        JTabbedPane jTP = new JTabbedPane();
        tP = new TabbedPane(f, jTP);
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               ObjectPane OP =  new ObjectPane();
                tP.addPhysicsObject(new MassObject(OP.getName()) {});
            }
        });
        f.add(addButton);
        JButton removeButton = new JButton("Remove Object");
        removeButton.setBounds(160,50,125,30);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removePane rP = new removePane();
                if(isNumeric(rP.getName())){
                    tP.removePhysicsObject(Integer.parseInt(rP.getName()));
                }else{
                    tP.removePhysicsObject(rP.getName());
                }
            }
        });
        f.add(removeButton);


        JCheckBox gravity = new JCheckBox("Gravity");
        gravity.setBounds(140,200,100,20);
        f.add(gravity);
        JTextField gravityNum = new JTextField("9.80665");
        gravityNum.setBounds(50,200,50,20);
        f.add(gravityNum);
        JLabel gravityUnit = new JLabel("m/s^2");
        gravityUnit.setBounds(105,195,40,30);
        f.add(gravityUnit);
        JCheckBox elasticity = new JCheckBox("Elastic Collisions");
        elasticity.setBounds(50,240,200,20);
        f.add(elasticity);
        JCheckBox walls = new JCheckBox("Simulation Borders");
        walls.setBounds(50,270,200,20);
        f.add(walls);
        JTextField scale = new JTextField("10");
        scale.setBounds(50,300,50,20);
        f.add(scale);
        JLabel scaleLabel = new JLabel("px/m");
        scaleLabel.setBounds(105,300,50,20);
        f.add(scaleLabel);
        JCheckBox airResistance = new JCheckBox("Air resistance");
        airResistance.setBounds(50,330,200,20);
        airResistance.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                airResistance.setSelected(false);
            }
        });
        f.add(airResistance);

        JButton start = new JButton("Start Simulation");
        start.setBounds(160+135,50,130,30);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DisplayGraphics m=new DisplayGraphics(tP, gravity.isSelected(),gravityNum.getText(),elasticity.isSelected(),scale.getText());
                f.setState(Frame.ICONIFIED);
                JFrame newJFrame =new JFrame();
                newJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newJFrame.add(m);
                newJFrame.pack();
                newJFrame.setLocationRelativeTo( null );
                //f.setLayout(null);
                newJFrame.setVisible(true);
                m.startAnimation();

            }
        });
        f.add(start);

        f.setLayout(null);
        f.setVisible(true);
    }
}

class TabbedPane{
    public ArrayList<MassObject> physicsObjectArrayList = new ArrayList<MassObject>();

    public JTabbedPane jTP;

    public TabbedPane(JFrame f, JTabbedPane tp){
        jTP = tp;
        tp.setBounds(1000,50,400,500);
        updateList();
        f.add(tp);
    }
    static boolean isNumeric(String str){return str != null && str.matches("[0-9.]+");}

    void drawAttributes(int index, JPanel jP){
        MassObject PO = physicsObjectArrayList.get(index);
        JButton referesh = new JButton("Refresh");
        referesh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateList();
            }
        });
        jP.add(referesh);
        JCheckBox hasGravity = new JCheckBox("Has Gravity");
        hasGravity.setSelected(PO.hasGravity);
//        hasGravity.setBounds(10,10,100,20);
        jP.add(hasGravity);
        JLabel massLabel = new JLabel("Mass");
        jP.add(massLabel);
        JTextField mass = new JTextField("  "+PO.getMass()+"  ");
        jP.add(mass);
        JLabel initForceLabel = new JLabel("Initial Force");
        jP.add(initForceLabel);
        JTextField initForce = new JTextField("  "+PO.getInitialForce()+"  ");
        jP.add(initForce);
        JLabel forceDirectionLabel = new JLabel("Initial Direction of Force");
        jP.add(forceDirectionLabel);
        JTextField forceDirection = new JTextField("  "+PO.getForceDirection()+"  ");
        jP.add(forceDirection);
        JLabel initVelocityLabel = new JLabel("Initial Velocity");
        jP.add(initVelocityLabel);
        JTextField initVelocity = new JTextField("  "+PO.getIntialVelocity()+"  ");
        jP.add(initVelocity);
        JLabel velocityDirectionLabel = new JLabel("Initial Direction of Velocity");
        jP.add(velocityDirectionLabel);
        JTextField velocityDirection = new JTextField("  "+PO.getVelocityDirection()+"  ");
        jP.add(velocityDirection);
        JLabel sizeLabel = new JLabel("Size");
        jP.add(sizeLabel);
        JTextField size = new JTextField("  "+PO.getSize()+"  ");
        jP.add(size);
        JLabel StartXLabel = new JLabel("Starting X Location");
        jP.add(StartXLabel);
        JTextField StartX = new JTextField("  "+PO.getStartX()+"  ");
        jP.add(StartX);
        JLabel StartYLabel = new JLabel("Starting Y Location");
        jP.add(StartYLabel);
        JTextField StartY = new JTextField("  "+PO.getStartY()+"  ");
        jP.add(StartY);
        JButton update = new JButton("Save Attributes");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MassObject PO = physicsObjectArrayList.get(index);
                PO.setHasGravity(hasGravity.isSelected());
                if(isNumeric(forceDirection.getText())) {
                    PO.setForceDirection(Integer.parseInt(forceDirection.getText()));
                }
                if(isNumeric(mass.getText())){
                    PO.setMass(Integer.parseInt(mass.getText()));
                }
                if(isNumeric(initForce.getText())) {
                    PO.setInitialForce(Integer.parseInt(initForce.getText()));
                }
                if(isNumeric(initVelocity.getText())) {
                    PO.setIntialVelocity(Integer.parseInt(initVelocity.getText()));
                }
                if(isNumeric(velocityDirection.getText())) {
                    PO.setVelocityDirection(Integer.parseInt(velocityDirection.getText()));
                }
                if(isNumeric(StartX.getText())){
                    PO.setStartX(Integer.parseInt(StartX.getText()));
                    PO.setxPos(Integer.parseInt(StartX.getText()));
                }
                if(isNumeric(StartY.getText())) {
                    PO.setStartY(Integer.parseInt(StartY.getText()));
                    PO.setyPos(Integer.parseInt(StartX.getText()));
                }
                if(isNumeric(size.getText())) {
                    PO.setSize(Integer.parseInt(size.getText()));
                }
            }
        });
        jP.add(update);


    }
    void addPhysicsObject(MassObject PO){
        physicsObjectArrayList.add(PO);
        updateList();
    }

    void removePhysicsObject(MassObject PO){
        physicsObjectArrayList.remove(PO);
    }
    void removePhysicsObject(String name){
        int i;
        for (i = 0; i < physicsObjectArrayList.size(); i++) {
            if(java.util.Objects.equals(physicsObjectArrayList.get(i).getName(), name)){
                physicsObjectArrayList.remove(i);
                break;
            }
        }
        jTP.removeTabAt(i);
    }

    void removePhysicsObject(int index){
        physicsObjectArrayList.remove(index);
        jTP.removeTabAt(index);
    }

    void updateList(){
        for(int i=0;i< physicsObjectArrayList.size();i++) {
            JPanel panel = new JPanel();
            drawAttributes(i,panel);
            if(jTP.indexOfTab(physicsObjectArrayList.get(i).getName())==-1) {
                jTP.add(physicsObjectArrayList.get(i).getName(),panel);
            }else{
                Icon thing = jTP.getIconAt(i);
                jTP.removeTabAt(i);
                jTP.insertTab(physicsObjectArrayList.get(i).getName(),thing,panel,"fuck", i);

            }


        }
    }

}
abstract class OptionPane{
    protected JFrame f;
    OptionPane() {
        f = new JFrame();
    }
}

class ObjectPane extends OptionPane{
    private String name;
    public ObjectPane(){
        super();
        name=JOptionPane.showInputDialog(f,"Enter Name");
    }
    public String getName() {return name;}
}

class removePane extends OptionPane{
    private String name;
    public removePane(){
        super();
        name=JOptionPane.showInputDialog(f,"Enter Name or index");
    }
    public String getName() {return name;}
}

abstract class PhysicsObject{
    protected String name;
    protected int size;
    protected int StartX;
    protected int StartY;
    protected int xPos;
    protected int yPos;
    protected Color[] colors = {Color.red, Color.blue, Color.yellow, Color.green, Color.darkGray, Color.BLACK, Color.orange, Color.magenta, Color.CYAN};
    protected int rand = 0;

    public PhysicsObject(String n){
        name = n;
        size = 1;
        StartX = 0;
        StartY = 0;
        xPos = StartX;
        yPos = StartY;
        Random random = new Random();
        while (true){
            rand = random.nextInt(colors.length);
            if(rand !=0) break;
        }
    }
    public String getName() {return name;}

    public int getSize() {return size;}

    public int getStartX() {return StartX;}

    public int getStartY() {return StartY;}

    public int getxPos() {return xPos;}

    public int getyPos() {return yPos;}

    public void setName(String name) {this.name = name;}

    public void setSize(int size) {this.size = size;}

    public void setStartX(int startX) {StartX = startX;}

    public void setStartY(int startY) {StartY = startY;}

    public void setxPos(int xPos) {this.xPos = xPos;}

    public void setyPos(int yPos) {this.yPos = yPos;}
}

class MassObject extends PhysicsObject{
    TabbedPane jTP;
    protected int mass;
    protected int initialForce = 0;
    protected int force = 0;
    protected int forceDirection=0;
    protected int intialVelocity = 0;
    protected int velocity = 0;
    protected int velocityDirection=0;
    protected int direction=0;
    protected boolean hasGravity = false;
    protected double gSum = 0;
    protected double xSum = 0;
    protected double ySum = 0;

    public MassObject(String name){
        super(name);
    }
    public MassObject(String name, int m, boolean g){
        super(name);
        mass = m;
        hasGravity = g;
    }
    public MassObject(String name, int Mass, int initForce, int forceDir, boolean gravity){
        super(name);
        mass = Mass;
        initialForce = initForce;
        force = initForce;
        forceDirection = forceDir;
        hasGravity = gravity;
    }

    public MassObject(String name,boolean gravity, int Mass, int initVelocity, int velocityDir){
        super(name);
        mass = Mass;
        intialVelocity = initVelocity;
        velocity = initVelocity;
        velocityDirection = velocityDir;
        hasGravity = gravity;
    }

    public MassObject(String name, int Mass,int initForce, int forceDir, int initVelocity, int velocityDir, boolean gravity){
        super(name);
        mass = Mass;
        initialForce = initForce;
        force = initForce;
        forceDirection = forceDir;
        intialVelocity = initVelocity;
        velocity = initVelocity;
        velocityDirection = velocityDir;
        hasGravity = gravity;

    }

    public int getMass() {return mass;}
    public boolean isHasGravity() {return hasGravity;}
    public int getDirection() {return direction;}
    public int getForceDirection() {return forceDirection;}
    public int getInitialForce() {return initialForce;}
    public int getIntialVelocity() {return intialVelocity;}
    public int getVelocityDirection() {return velocityDirection;}
    public void setMass(int mass) {this.mass = mass;}
    public void setForceDirection(int forceDirection) {this.forceDirection = forceDirection;}
    public void setHasGravity(boolean hasGravity) {this.hasGravity = hasGravity;}
    public void setInitialForce(int initialForce) {this.initialForce = initialForce;}
    public void setDirection(int direction) {this.direction = direction;}
    public void setIntialVelocity(int intialVelocity) {this.intialVelocity = intialVelocity;}
    public void setVelocityDirection(int velocityDirection) {this.velocityDirection = velocityDirection;}
    public void setForce(int f){this.force = f;}

    public void setVelocity(int velocity) {this.velocity = velocity;}

    public void drawObject(Graphics g, int scale){
        g.setColor(colors[rand]);
        g.fillOval(xPos,yPos,scale*size,scale*size);
    }

    public void move(double fOfG){
        this.setxPos(this.getxPos()+getForceX()+getVelocityX());
        this.setyPos(this.getyPos()+getForceY()+getVelocityY()+getGravity(fOfG));
    }

    public int getForceX(){
        int force = this.getInitialForce();
        int mass = this.getMass();
        int forceDirection = this.getForceDirection();
        xSum+= ((double) force /mass * Math.cos(Math.toRadians(forceDirection)))/60;
        return (int) (xSum);
    }

    public int getForceY(){
        int force = this.getInitialForce();
        int mass = this.getMass();
        int forceDirection = this.getForceDirection();
        ySum = ((double) force /mass * Math.sin(Math.toRadians(forceDirection)))/60;
        return (int) (ySum);
    }
    public int getVelocityX(){
        int velocity = this.getIntialVelocity();
        int velocityDireciton = this.getVelocityDirection();
        int vX = (int) (velocity * Math.cos(Math.toRadians(velocityDireciton)));
        return vX/60;
    }
    public int  getVelocityY(){
        int startY = this.getyPos();
        int velocity = this.getIntialVelocity();
        int velocityDireciton = this.getVelocityDirection();
        int vY = (int) (velocity * Math.sin(Math.toRadians(velocityDireciton)));
        return vY/60;
    }
    public int getGravity(double fOfG){
        if(this.hasGravity) {
            gSum+=(fOfG/60);
            return (int) (gSum);
        }else{
            return 0;
        }
    }
}

class DisplayGraphics extends JPanel implements ActionListener{
    TabbedPane jTP;
    boolean gravity;
    boolean elasticity;
    public double fOfG = 0;
    int scale = 10;
    public DisplayGraphics(TabbedPane tP, boolean hasGravity,String forceOfGravity,boolean hasElasticity,String scaleNum){
        jTP = tP;
        gravity = hasGravity;
        if(isNumeric(forceOfGravity)){
            fOfG = Double.parseDouble(forceOfGravity);
        }
        elasticity = hasElasticity;
        if(isNumeric(scaleNum)){
            scale = Integer.parseInt(scaleNum);
        }
        setLayout( null );
    }
    static boolean isNumeric(String str){return str != null && str.matches("[0-9.]+");}

//    public void paint(Graphics g) {
//        setBackground(Color.WHITE);
//
//        for (MassObject MO:jTP.physicsObjectArrayList) {
//            MO.drawObject(g,scale);
//        }
//
////        Timer timer = new Timer();
////        TimerTask task = new TimerTask() {
////            boolean ting = false;
////            public void run() {
////                if(ting){
////                    g.setColor(Color.white);
////                    g.fillRect(0, 0, getWidth(), getHeight());
////                }
////                for(int i=0;i<jTP.physicsObjectArrayList.size();i++){
////                    jTP.physicsObjectArrayList.get(i).drawObject(g,scale);
////                    System.out.println("test");
////                }
////                for(int i=0;i<jTP.physicsObjectArrayList.size();i++) {
////                    jTP.physicsObjectArrayList.get(i).setxPos(jTP.physicsObjectArrayList.get(i).getxPos()+getForceX(i)+getVelocityX(i));
////                    jTP.physicsObjectArrayList.get(i).setyPos(jTP.physicsObjectArrayList.get(i).getyPos()+getForceY(i)+getVelocityY(i)+getGravity(i));
////                }
////                ting = true;
////            }
////        };
//
////        timer.scheduleAtFixedRate(task, new Date(System.currentTimeMillis()), (long) 1000.0);
//
//    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MassObject MO: jTP.physicsObjectArrayList) {
            MO.drawObject(g, scale);
        }
    }
    private void move() {
        for (MassObject MO : jTP.physicsObjectArrayList) {
            if(gravity) {
                MO.move(fOfG);
            }else{
                MO.move(0);
            }
        }
    }
    public void startAnimation() {
        Timer timer = new Timer(1000/60, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
    public Dimension getPreferredSize() {return new Dimension(1920, 1080);}
}

