package Lesson3;

public class Square  extends Rectangle{

    public Square(){
        super();
    }

    public Square(double side){
        super(side,side);

    }
    public Square(double side, String colour, boolean filled){
        super(side,side,colour,filled);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }

    public void setLength(double side){
        super.setLength(side);
        super.setWidth(side);
    }
    public void setWidth(double side){
        super.setLength(side);
        super.setWidth(side);
    }
    public static void main(String[] args) {
        Square square = new Square(5);
        System.out.println(square.getArea());
        square.setLength(10);
        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());
    }
}
