package Tutorial;

abstract class Pet {
    private String name;
    private String breed;
    private double weight;
    

    public Pet(String name, String breed, double weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void display(){
        System.out.println("Name: "+this.name);
        System.out.println("Breed: "+this.breed);
        System.out.println("Weight: "+this.weight);
    }

    abstract public void sound();
    abstract public void eat();


    

}
