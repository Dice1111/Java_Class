package Lesson5;

public class InsufficientFundException extends Exception{

    private double amount;

    public InsufficientFundException(double amount){
        super("Lack of $"+amount);
        this.amount = amount;
    }

    public double getAmount(){
        return this.amount;
    }
}