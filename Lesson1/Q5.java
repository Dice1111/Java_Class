package Lesson1;

public class Q5 {
    public static void main(String[] args) {
        char gender ='f';
        double vo2Max = 42;
        if(gender=='m' && (vo2Max>=40 && vo2Max<= 60)){
            System.out.println("can join");
        }else if(gender=='f' && (vo2Max>=45 && vo2Max<=60)){
            System.out.println("can join");
        }else{
            System.out.println("cannot join");
        }
    }
}
