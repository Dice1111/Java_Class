package Lesson1;

public class Item{
    private String itemCode;
    private double price;
    private static double GST = 8;

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

    public double getGSTPrice() {
        return roundToTwoDecimal(this.price*(1+GST/100));
    }
    public static void setGST(double newGST){
        GST = newGST;
    }

    public void display(){
        System.out.println(itemCode+" "+price+" "+getGSTPrice());
    }

    public boolean isMoreExpensive(Item item){
        boolean isMoreExpensive = false;
        if(this.price>item.getPrice()){
            isMoreExpensive = true;
        }
        return isMoreExpensive;
    }

    
    public boolean isBelowPrice(double price){
        boolean isBelowPrice = false;
        if(this.price<price){
            isBelowPrice = true;
        }
        return isBelowPrice;
    }

    public boolean isItemCode(String itemCode){
        return this.itemCode.equals(itemCode);
    }

    public static double roundToTwoDecimal(double value) {
        return Math.round(value*100.0)/100.0;
    }

}