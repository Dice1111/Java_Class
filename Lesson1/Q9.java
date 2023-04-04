package Lesson1;

public class Q9 {
    public static void main(String[] args) {
        double score = getScore();
        System.out.println(score);
    }

    public static double getScore() {
        boolean carryOn= true;
        double valueToReturn = 0;
        while(carryOn){
            valueToReturn = Helper.getDouble("Enter a value(0-100): ");
            if(valueToReturn>=1 && valueToReturn <= 100){
                carryOn=false;
            }else{
                System.out.println("invalid range");
            }
        }

        return valueToReturn;
    }
}
