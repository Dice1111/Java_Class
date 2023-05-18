package Tutorial;

import java.util.*;
import java.io.*;

public class ProcessProduct {
    public ArrayList<Product> products = new ArrayList<Product>();

    public void loadProducts(){
        try{
            File file = new File("product.csv");
            Scanner data = new Scanner(file);
            int counter=0;
            while(data.hasNextLine()){
                String line = data.nextLine();
                if(counter!=0){
                System.out.println(line);
                String[] info = line.split(",");
                String code = info[0];
                double price = Double.parseDouble(info[1]);
                Product p = new Product(code,price);
                System.out.println(p);
                products.add(p);
                }
                counter++;
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
    }

    public void run(){
        loadProducts();
        printAllProducts();
    }

    private void printAllProducts(){
        for(Product p:products){
            System.out.println(p);
        }

    }

    public static void main(String[] args) {
        new ProcessProduct().run();
    }
}
