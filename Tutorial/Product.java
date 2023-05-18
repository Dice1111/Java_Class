package Tutorial;

public class Product {
    public String itemCode;
    private double price;

    public Product(String itemCode, double price) {
        this.itemCode = itemCode;
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return itemCode+","+price;
    }




}
