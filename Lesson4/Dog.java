package Lesson4;

public class Dog extends Pet{
    private boolean microchipped;
    
    public Dog(String name, String breed, double weight,boolean microchipped){
        super(name, breed, weight);
        this.microchipped = microchipped;
    }

    @Override
    public void sound(){
        System.out.println(getName()+"woff woff");
    }
    @Override
    public void eat(){
        System.out.println(getName()+"food");
    }

    public void eat(String food){
        System.out.println(getName()+food);
    }
    public void  display(){
        super.display();
        System.out.println("Microchipped: "+this.microchipped);
    }

}
