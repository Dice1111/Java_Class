package Lesson1;

import java.util.ArrayList;

public class Q16B {
    private static ArrayList<Item> items;
    private static String[] itemCodes = {"X123","V343","F867","A543","G543","S654"};
    private static double[] prices = {45.7,43.9,34.5,67.4,27.4,34.8};

    public static void main(String[] args) {
        init();
        displayall();
        displayAveragePrice();
        displaymostExpensiveItem();
        displayBelowAveragePrice();
        displayItemPrice();
        bubbleSort();
        System.out.println("After bubble sort:");
        displayall();
        
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

    public static void displayall(){
        for(Item item: items){
            item.display();
        }
    }

    private static void displayAveragePrice(){
        // double total = 0;
        // for(double price: prices){
        //     total+=price;
        // }
        // double ave = total/prices.length;
        double ave = Helper.roundToTwoDecimal(getAveragePrice());
        System.out.println("Average price: "+ave);
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
    
    private static void displaymostExpensiveItem(){
        Item mostExpensive = items.get(0);
        for(Item item:items){
            if(item.isMoreExpensive(mostExpensive)){
                mostExpensive = item;
            }
        }
        System.out.println("Most expensive item: ");
        mostExpensive.display();
    }

    private static void displayBelowAveragePrice(){
        System.out.println("Below ave price item:");
        double ave = getAveragePrice();
        for(Item item: items){
            if(item.isBelowPrice(ave)){
                item.display();
            }
        }
    }

    private static void displayItemPrice() {
        System.out.println("Display Item Price:");
        String itemCodeToSearch = "G543";
        boolean found =false;
        for(Item item:items){
            if(item.isItemCode(itemCodeToSearch)){
                item.display();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Item not found.");
        }
    }

    private static void bubbleSort() {
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i=1;i<items.size();i++){
                Item item1 = items.get(i-1);
                Item item2 = items.get(i);
                if(item1.isMoreExpensive(item2)){
                    items.set(i-1,item2);
                    items.set(i,item1);
                    swap=true;
                }
            }
        }
    }

}
