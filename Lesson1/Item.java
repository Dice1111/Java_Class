package Lesson1;

public class Item{
    private String itemCode;
    private double price;

    public Item(String itemCode,double price){
        this.itemCode = itemCode;
        this.price = price;
    }

    public String getItemCode(){
        return itemCode;
    }

    public double getPrice(){
        return price;
    }

    public void display(){
        System.out.println(itemCode+" "+price);
    }

}