
public class TemperatureTest {

	public static void main(String[] args) {
		try {
			Temperature t = new Temperature();
			assert t.getCelsius() == 0.0;
			assert t.getFahrenheit() == 32.0;
			System.out.println(t.getCelsius());
			System.out.println(t.getFahrenheit());

			t = new Temperature('C');
			assert t.getCelsius() == 0.0;
			assert t.getFahrenheit() == 32.0;
			System.out.println(t.getCelsius());
			System.out.println(t.getFahrenheit());

			t = new Temperature('F');
			assert t.getCelsius() == -17.78;
			assert t.getFahrenheit() == 0.0;
			System.out.println(t.getCelsius());
			System.out.println(t.getFahrenheit());
			
			t = new Temperature(100, 'C');
			assert t.getCelsius() == 100.0;
			assert t.getFahrenheit() == 212.0;
			System.err.println(t.getCelsius());
			System.out.println(t.getFahrenheit());
		
			t = new Temperature(100, 'F');
			assert t.getCelsius() == 37.78;
			assert t.getFahrenheit() == 100.0;
			System.err.println(t.getCelsius());
			System.out.println(t.getFahrenheit());
		
			t.setDegree(50);
			t.setScale('C');
			assert t.getCelsius() == 50.0;
			assert t.getFahrenheit() == 122.0;
			System.err.println(t.getCelsius());
			System.out.println(t.getFahrenheit());
		
			t.setDegree(20);
			t.setScale('F');
			assert t.getCelsius() == -6.67;
			assert t.getFahrenheit() == 20.0;
			System.err.println(t.getCelsius());
			System.out.println(t.getFahrenheit());
			System.out.println("Temperature test cases pass");
		} catch (AssertionError ae) {
			System.out.println("Temperature test cases failed");
		}

	}

}
