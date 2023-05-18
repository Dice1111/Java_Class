public class InsufficientBalanceException extends Exception {

	//complete this class
	private double amount;


	public InsufficientBalanceException(double amount){
		super("Lack of $"+amount);
        this.amount = amount;
	}

	public double getInsufficientAmount() {
		//complete this
		return this.amount;
	}

}