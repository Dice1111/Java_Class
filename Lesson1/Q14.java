package Lesson1;

public class Q14 {
    public static void main(String[] args) {
        int n=5;

        int fibo1=0;
        int fibo2=1;

        for (int i=0;i<=n-1;i++){
            int fibo = fibo1+fibo2;
            System.out.println(fibo);
            fibo1 = fibo2;
            fibo2 = fibo;
        }
    }
}
