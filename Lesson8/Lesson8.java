package Lesson8;

public class Lesson8 {
    public static void main(String[] args) {
        printToTen(5);
    }

    public static void printToTen(int n){
        if(n!=11){
            System.out.println(n);
            printToTen(n+1);
        }
    }
}
