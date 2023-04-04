package Lesson1;

public class Q15 {
    public static void main(String[] args) {
        int[] tenIntegers = new int[10];
        int evenSum = 0;
        int oddSum = 0;

        for (int i=0; i<tenIntegers.length;i++){
            int n = Helper.getInt("Enter n: ");
            tenIntegers[i]=n;
        }

        for (int n: tenIntegers){
            if(n%2==0){
                evenSum+=n;
            }else{
                oddSum+=n;
            }
        }
        if (evenSum>oddSum){
            System.out.println("Even sum is greater than odd sum");
        }else if(oddSum>evenSum){
            System.out.println("Odd sum is greater than even sum");
        }else{
            System.out.println("Even sum equals to odd sum");
        }
    }
}
