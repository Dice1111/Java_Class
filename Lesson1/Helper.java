package Lesson1;
import java.util.*;
public class Helper {

    public static char getChar(String msg){
        String s =getString(msg);
        char c=s.charAt(0);
        return c;
    }

    public static int getInt(String msg) {
        Scanner kb = new Scanner(System.in);
        System.out.print(msg);
        int n = kb.nextInt();
        return n;
    }

    public static double getDouble(String msg) {
        Scanner kb = new Scanner(System.in);
        System.out.print(msg);
        double d = kb.nextDouble();
        return d;
    }

    public static String getString(String msg) {
        Scanner kb = new Scanner(System.in);
        System.out.print(msg);
        String s = kb.nextLine();
        return s;
    }

    public static double roundToTwoDecimal(double value) {
        return Math.round(value*100.0)/100.0;
    }

    public static void main(String[] args) {

    }
}
