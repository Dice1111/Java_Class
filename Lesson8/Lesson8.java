package Lesson8;

public class Lesson8 {
    public static void main(String[] args) {
        printToTen(5);
        System.out.println(factorial(5));
    }

    public static int fibo(int n){
        if(n<=1){
            return n;
        }else{
            return fibo(n-1)+fibo(n-2);
        }
    }

    public static int factorial(int n){
        if(n==0) return 1;
        else return factorial(n-1)*n;
    }
    public static void printToTen(int n){
        if(n!=11){
            System.out.println(n);
            printToTen(n+1);
        }
    }
}
