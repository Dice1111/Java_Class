package Lesson3;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(){
        super();
        this.height = 1;
    }

    public Cylinder(double radius){
        super(radius);
        this.height= 1;
    }
    public Cylinder(double radius, double height){
    super(radius);
    this.height = height;
    }

    public Cylinder(double radius, double height, String colour){
        super(radius,colour);
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getVolume(){
        double volume =super.getArea()*this.height;
        return volume;
    }

    public String toString(){
        return "Cylinder(radius="+getRadius()+",color="+getColour()+",height="+this.height+"]";
    }
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder(10,5,"yellow");
        System.out.println(c1.getVolume());
        System.out.println(c1);
    }
}
