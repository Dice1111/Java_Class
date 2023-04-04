
public class Test {

	// Auto marking
	public static void main(String[] args) {

		int score = 0;

		// function 1
		try {
			double[] numbers = { 0, 1, 2, 3 };
			double n = Lab1.largest(numbers);
			assert n == 3;
			score += 1;
			System.out.println("Function 1 passed");
		} catch (AssertionError ae) {
			System.out.println("Function 1 failed");
		}

		// function 2
		try {
			int m = 3;
			int n = 10;
			int[] numbers = Lab1.intArray(m, n);
			// check length
			assert numbers.length == n - m + 1;

			int indexCount = 0;
			for (int i = m; i <= n; i++) {
				assert numbers[indexCount++] == i;
			}
			score += 1;
			System.out.println("Function 2 passed");
		} catch (AssertionError ae) {
			System.out.println("Function 2 failed");
		}

		// function 3
		try {
			int side1 = 1;
			int side2 = 1;
			int side3 = 100;

			boolean isTriangle = Lab1.isTriangle(side1, side2, side3);
			assert isTriangle == false;

			side1 = 4;
			side2 = 5;
			side3 = 6;

			isTriangle = Lab1.isTriangle(side1, side2, side3);
			assert isTriangle == true;

			score += 1;
			System.out.println("Function 3 passed");

		} catch (AssertionError ae) {
			System.out.println("Function 3 failed");
		}

		// function 4
		try {
			int n = 8;
			boolean isPrime = Lab1.isPrime(n);
			assert isPrime == false;

			n = 7;
			isPrime = Lab1.isPrime(n);
			assert isPrime == true;

			score += 1;
			System.out.println("Function 4 passed");

		} catch (AssertionError ae) {
			System.out.println("Function 4 failed");
		}

		// function 5
		try {
			String s1 = "bcdfghjklmnpqrstvwxyz";
			int[] vowelCount1 = Lab1.vowelCount(s1);
			assert vowelCount1[0] == 0;
			assert vowelCount1[1] == 0;
			assert vowelCount1[2] == 0;
			assert vowelCount1[3] == 0;
			assert vowelCount1[4] == 0;
			
			String s2 = "aeiouAEIOU";
			int[] vowelCount2 = Lab1.vowelCount(s2);
			assert vowelCount2[0] == 2;
			assert vowelCount2[1] == 2;
			assert vowelCount2[2] == 2;
			assert vowelCount2[3] == 2;
			assert vowelCount2[4] == 2;
			
			score += 1;
			System.out.println("Function 5 passed");

		} catch (AssertionError ae) {
			System.out.println("Function 5 failed");
		}

		System.out.println(score);
	}
}
