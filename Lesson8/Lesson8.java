package Lesson8;

public class Lesson8 {
    public static void main(String[] args) {
        // printToTen(5);
        System.out.println(factorial(5));
        System.out.println(fibo(5));
        // for(int i = 1; i <= 10; i++) {
        //     System.out.println(i + " " + square(i));
        // }
        // for(int i = 1; i <= 10; i++) {
        //     System.out.println(i + " " + cube(i));
        // }

        // for(int i = 1; i <= 10; i++) {
        //     System.out.println(i + " " + square(i));
        // }

        // for(int i = 1; i <= 10; i++) {
        //     System.out.println(mult(5,i));
        // }

        // for(int i = 1; i <= 10; i++) {
        //     System.out.println(power(5,i));
        // }

        syracuse(158);
    }

    public static void syracuse(int n){
        System.out.println(n);

        if(n!=1){
            if(n%2==0){
            syracuse(n/2);
            }else{
            syracuse(3*n+1);
            }
        }
    }

    public static int power(int n, int m) {
        if(m == 0) {
            return 1;
        }else {        
            return n * power(n, m-1);
        }
    }

    public static int mult(int n,int m) {
        if(m == 0) {
            return 0;
        }else {
            return n + mult(n,m-1);
        }
    }

    public static int cube(int n) {
        if(n == 1) {
            return n;
        }else {
            return cube(n-1) + mult(3,(square(n)))- mult(3,n) + 1;
        }


    }

    

    public static int square(int n) {
        if(n == 1) {
            return n;
        }else {
            return square(n-1) + mult(2,n)-1;
        }
    }

    public static int factorial (int n) {
        if(n == 0) return 1;
        else return factorial(n-1)* n;
    }

    public static int fibo(int n) {
        if(n <= 1) {
            return n;
        }else {
            return fibo(n-1) + fibo(n-2);
        }
    }

    public static void printToTen(int n) {
        if(n != 11) {
            System.out.println(n);
            printToTen(n+1);
        }
    }
    
}