package Lesson1;

public class Q6 {
    public static void main(String[] args) {
        double weight =  78.5;
        double height = 1.72;
        double bmi = weight/(height*height);

        String bmiStatus = "";
        if (bmi<18.5){
            bmiStatus = "underweight";
        }else if (bmi<25){
            bmiStatus = "Normal Weight";
        }else if (bmi<30){
            bmiStatus = "Overweight";
        }else{
            bmiStatus = "obesity";
        }
        System.out.println(bmiStatus);
    }
}
