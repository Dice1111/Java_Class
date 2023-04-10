package Lesson3;
public class Circle {

    private double radius;
    private String colour;

    public Circle(){
        this.radius = 1;
        this.colour ="red";
    }

    public Circle(double radius){
        this.radius = radius;
        this.colour = "red";
    }

    public Circle(double radius, String colour){
        this.radius = radius;
        this.colour = colour;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public String getColour(){
        return this.colour;
    }

    public double getArea(){
        double area = Math.PI * Math.pow(this.radius,2);
        return area;
    }

    public String toString(){
        return "Circle[radius="+this.radius+", colour="+this.colour+"]";
    }


    public static void main(String[] args) {
        Circle c1 = new Circle(10,"blue");
        System.out.println(c1.getArea());
        System.out.println(c1);
    }
}
