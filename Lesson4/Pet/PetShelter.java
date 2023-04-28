package Lesson4.Pet;
import java.util.*;

public class PetShelter {
    private ArrayList<Pet> pets;

    public PetShelter(){
        pets = new ArrayList<Pet>();
    }

    public void run(){
        Pet pet1 = new Dog("Snoppy","Beagle",50,true);
        Pet pet2 = new Dog("Goldy", "Golden Retriver", 70,true);
        Pet pet3 = new Cat("Hello Kitty","Japan",20);
        Pet pet4 = new Cat("Garfield","Persian",80);
        Pet pet5 = new Dog("Scooby-Doo","Great Dane",75,false);

        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        pets.add(pet4);
        pets.add(pet5);

        for(Pet pet:pets){
            pet.sound();
            if(pet instanceof Dog){
                Dog dog = (Dog)pet;
                dog.eat(" bones");
            }
            if(pet instanceof Cat){
                Cat cat = (Cat)pet;
                cat.eat(" fish");
            }
        }
        displayStats();

    }

    public void displayStats(){
        Pet lightest = pets.get(0);
        Pet heaviest = pets.get(0);
        double total = 0;

        for (Pet pet:pets){
            if(pet.getWeight()<lightest.getWeight()){
                lightest = pet;
            }
            if(pet.getWeight()>heaviest.getWeight()){
                heaviest = pet;
            }
            total+= pet.getWeight();
        }
        System.out.println("\nlightest: "+lightest.getName());
        System.out.println("heaviest: "+heaviest.getName());
        double ave = total/pets.size();
        System.out.println("ave: "+ave);
    }

    public static void main(String[] args) {
        PetShelter app = new PetShelter();
        app.run();
    }
}
