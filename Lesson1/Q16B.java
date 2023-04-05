package Lesson1;

import java.util.ArrayList;

public class Q16B {
    private static ArrayList<Item> items;
    private static String[] itemCodes = {"X123","V343","F867","A543","G543","S654"};
    private static double[] prices = {45.7,43.9,34.5,67.4,27.4,34.8};

    public static void main(String[] args) {
        init();
        displayAveragePrice();
        
    }

    public static void init(){
        items = new ArrayList<Item>();

        for(int i=0;i<itemCodes.length;i++){
            String itemCode= itemCodes[i];
            double price = prices[i];
            Item item = new Item(itemCode,price);
            items.add(item);
        }
    }

    private static void displayAveragePrice(){
        double total = 0;
        for(double price: prices){
            total+=price;
        }
        double ave = total/prices.length;
        ave = Helper.roundToTwoDecimal(ave);
        System.out.println("Average price$"+ave);
    }

    private static double getAveragePrice(){
        double total = 0;
        for(double price:prices){
            total+=price;
        }
        double ave=total/prices.length;
        ave = Helper.roundToTwoDecimal(ave);
        return ave;
    }   
}
