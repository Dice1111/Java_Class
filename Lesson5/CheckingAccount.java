package Lesson5;

public class CheckingAccount {
    private double balance;
    private int number;

    public CheckingAccount(int number){
        this.number = number;
        this.balance = 0;
    }

    public double getBalance(){
        return balance;
    }

    public int getNumber(){
        return number;
    }

    public void deposit(double amount) throws NegativeAmountException{
        checkNegativeAmount(amount);
        this.balance += amount; //no error check if amount is negative
    }

    public void checkNegativeAmount(double amount) throws NegativeAmountException{
        if(amount<0){
            throw new NegativeAmountException(amount);
        }
    }

    public void withdraw(double amount)throws InsufficientFundException,NegativeAmountException{
        checkNegativeAmount(amount);
        if(this.balance>=amount){
            this.balance -= amount;
        }else{
            double insufficientAmount = amount - this.balance;
            throw new InsufficientFundException(insufficientAmount);
        }
    }
}
