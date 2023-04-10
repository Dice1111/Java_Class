package Lesson3;

public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(double width, double length){
        super();
        this.width = width;
        this.length = length;
    }
    public Rectangle(){
        super();
        this.width = 1;
        this.length = 1;
    }
    public Rectangle (double width, double length, String colour, boolean filled){
        super(colour,filled);
        this.width = width;
        this.length = length;

    }

    public double getWidth(){
        return this.width;
    }

    public void  setWidth(double width){
        this.width = width;
    }

    public double getLength(){
        return this.length;
    }
    public void setLength(double length){
        this.length = length;
    }
    public double getArea(){
        return this.width*this.length;
    }

    public double getPerimeter(){
        return 2*(this.length+this.width);
    }

    public String toString(){
        return "Rectangle"+ super.toString()+",width="+this.width+",height="+this.length+"]";
        
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10,5,"blue",false);
        System.out.println(r1);
    }
}
