package Lesson1;

public class Q4 {
    public static void main(String[] args) {
        String  s2 = "c";
        String s1 = "c";
        

        int n1=s1.compareTo(s2);

        System.out.println(n1);

        if(n1<0){
            System.out.println("s1 come before s2");
        }else if(n1>0){
            System.out.println("s1 come after s2");
        }
        else{
            System.out.println("s1 is the same as s2");
        }
    }
}
