package Lesson5;

public class NegativeAmountException extends Exception{
    private double amount;

    public NegativeAmountException(double amount){
        super("Amount cannot be negative:"+ amount);
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }
}
