
public class AndroidTest {

	public static void main(String[] args) {

		try {
			Android a1 = new Android();
			System.out.println(a1.getName());
			assert a1.getName().equals("Bob1");
			Android a2 = new Android();
			System.out.println(a2.getName());
			assert a2.getName().equals("Bob2");
			Android a3 = new Android();
			System.out.println(a3.getName());
			assert a3.getName().equals("Bob3");
			Android a4 = new Android();
			System.out.println(a4.getName());
			assert a4.getName().equals("Bob5");
			Android a5 = new Android();
			System.out.println(a5.getName());
			assert a5.getName().equals("Bob7");
			System.out.println("Android test passed");
		} catch (AssertionError ae) {
			System.out.println("Android test failed");
		}

	}

}
