
public class EWallet {

	private String id;
	private double balance;

	//complete this
	public EWallet(String id, double balance) {
		this.id=id;
		this.balance = balance;

	}

	//complete this
	public void deductAmount(double amount) throws InsufficientBalanceException {
		if(this.balance>=amount){
            this.balance -= amount;
        }else{
            double insufficientBalance = amount - this.balance;
            throw new InsufficientBalanceException(insufficientBalance);
        }
		
	}
}
