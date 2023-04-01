package Lesson1;

public class Q1{
    public static void main(String[] args){
        int a = 5;
        int b = 2;
        int c = 8;

        if (a>b){
            int temp = a;
            a = b;
            b =temp;
        }

        if (b>c){
            int temp = b;
            b = c;
            c = temp;
        }System.out.println(a+ " "+b+" "+c);


    }
}