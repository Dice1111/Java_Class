package Lesson1;

public class Q16 {

    private static String[] items = {"X123","V343","F867","A543","G543","S654"};
    private static double[] prices = {45.7,43.9,34.5,67.4,27.4,34.8};
    private static double[] gstPrices;
    public static void main(String[] args) {
        displayAveragePrice();
        displayMostExpensiveItem();
        displayItemBelowAvePrice();
        generateGSTPrices();
        bubbleSortByPrice();
        
    }

    private static void bubbleSortByPrice() {
        boolean swap = true;
        while(swap){
            swap=false;
            for(int i=1;i<prices.length;i++){
                double p1=prices[i-1];
                double p2=prices[i];
                String item1= items[i-1];
                String item2= items[i];

                if(p1>p2){
                    prices[i-1] = p2;
                    prices[i] = p1;
                    items[i-1]=item2;
                    items[i]=item1;
                    swap=true;
                }
            }
        }

        printStringDoubleArray(items,prices);
    }

    private static void generateGSTPrices(){
        gstPrices=new double[prices.length];
        for(int i=0;i<prices.length;i++){
            gstPrices[i]=Helper.roundToTwoDecimal(prices[i]*1.08);
            
        }
        printStringDoubleArray(items,gstPrices);
    }

    private static void printStringDoubleArray(String[] sArray, double[] dArray) {
        for(int i=0;i<sArray.length;i++){
            System.out.println(sArray[i]+" "+dArray[i]);
        }        
    }

    private static void displayMostExpensiveItem(){
        int index = 0;
        for (int i =0;i<prices.length;i++){
            if(prices[i]>prices[index]){
                index=i;
            }
            }
            System.out.println(items[index]);
    }
    private static void displayItemBelowAvePrice() {
        System.out.println("Item below average price: ");
        double ave = getAveragePrice();
        for (int i =0;i<prices.length;i++){
            if(prices[i]>ave){
                System.out.println(items[i]);
            }
            }
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

    private static void displayAveragePrice(){
        double total = 0;
        for(double price: prices){
            total+=price;
        }
        double ave = total/prices.length;
        ave = Helper.roundToTwoDecimal(ave);
        System.out.println("Average price$"+ave);
    }
}
