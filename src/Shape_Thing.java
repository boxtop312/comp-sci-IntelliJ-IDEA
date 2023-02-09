public class Shape_Thing {
    public static void main(String[] args){
        Rectangle rect = new Rectangle(2, 2);
        RTriangle tri = new RTriangle(2,4);
        RegPolygon poly = new RegPolygon(6, 4);
        System.out.println(poly.getArea());
    }
}


abstract class Shape{
    int numSides;

    Shape(int n){
        numSides = n;
    }
    abstract double getArea();
    abstract double getPerimiter();
    public int getNumSides() {return numSides;}
}

class Rectangle extends Shape{
    double width;
    double height;
    Rectangle(double w, double h) {
        super(4);
        width=w;
        height=h;
    }

    double getArea(){
        return width*height;
    }
    double getPerimiter(){
        return (width*2)+(height*2);
    }
}

class RTriangle extends Shape{
    double width;
    double height;

    RTriangle(double w, double h) {
        super(3);
        width=w;
        height=h;
    }

    double getArea() {
        return (0.5*width*height);
    }

    double getPerimiter() {
        return width+height+Math.sqrt(Math.pow(width,2)+Math.pow(height,2));
    }
}

class RegPolygon extends Shape{
    double sideLen;
    RegPolygon(int n,double s) {
        super(n);
        sideLen=s;
    }


    double getArea(){
        double angle = 360.0/(numSides*2);
        double width = sideLen/2;
        double height = (width*(1/Math.tan(Math.toRadians(angle))));
        return (0.5*width*height)*(numSides*2);

    }


    double getPerimiter() {
        return sideLen*super.getNumSides();
    }
}