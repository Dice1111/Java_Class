
public class Test {

	public static void main(String[] args) {

		try {
			EWallet card = new EWallet("A123", 5);
			card.deductAmount(10);
			System.out.println("Test case failed");
		} catch (InsufficientBalanceException ex) {
			try {
				assert ex.getInsufficientAmount() == 5;
				System.out.println("Test case passed");
			} catch (AssertionError e) {
				System.out.println("Test case failed");
			}
		}
	}
}
