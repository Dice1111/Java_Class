
package Lesson3;

public class Shape {
    
    private String colour;
    private boolean filled;

    public Shape(){
        this.colour = "red";
        this.filled = true;
    }

    public Shape(String colour, boolean filled){
        this.colour = colour;
        this.filled = filled;
    }

    public String getColour(){
        return this.colour;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public boolean isFilled(){
        return this.filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public String toString(){
        return "Shape[colour="+this.colour+",filled="+this.filled+"]";
        
    }
}
