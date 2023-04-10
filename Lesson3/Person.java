package Lesson3;

public class Person {
   private String name;
   private String address;
   
   public Person(String name, String address) {
    this.name= name;
    this.address = address;
   }
   public String getName() {
     return this.name;
   }
   public String getAddress() {
    return this.address;
   }
   public void setAddress(String address) {
    this.address = address;
   }
   public String toString(){
    return "Person{ name="+ this.name+", address="+ this.address+"}";
   }
   public static void main(String[] args) {
    Person p = new Person("Mgmg", "Singapore");
    System.out.println(p.getName());
    System.out.println(p.getAddress());
   }
}
