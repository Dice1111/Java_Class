package Lesson5;

public class BankDemo {
    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount(101);
        
        try{
            System.out.println("Depositing $500...");
            c.deposit(500.00);
            System.out.println("\nWithdrawing $100..."); 
            c.withdraw(100.00);
            System.out.println("\nWithdrawing $600...");
            c.withdraw(600.00);
        }catch(InsufficientFundException e){
            System.out.println("Sorry, but you are short $"+ e.getAmount());
        }catch(NegativeAmountException e){
            System.out.println(e.getMessage());
        }
    }
}
