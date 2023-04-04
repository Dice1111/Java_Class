package Lesson1;

public class Q11 {
    public static void main(String[] args) {
        int evenSum = 0;
        int oddSum = 0;
        boolean carryOn = true;

        while(carryOn){
            int n = Helper.getInt("Enter an int:");
            if(n==-1){
                carryOn = false;
            }else{
                if(n%2==0){
                    evenSum+=n;
                }else{
                    oddSum+=n;
                }
            }
        }
        System.out.println("Even Sum:"+evenSum);
        System.out.println("Odd Sum:"+oddSum);
    }
}
