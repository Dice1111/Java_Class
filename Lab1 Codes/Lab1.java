
public class Lab1 {

	// function 1
	public static double largest(double[] numbers) {
		double largest = 0;// do not change

		//you code here
		double Temp =0;
		for(int i=0;i<numbers.length;i++){
			Temp = numbers[i];
			if(Temp>=largest){
				largest = Temp;
			}else{
				System.out.println("Error");
			}
		}
		// end

		return largest;// do not change
	}

	// function 2 - assume n>m
	public static int[] intArray(int m, int n) {
		int[] intArray = new int[n - m + 1];// do not change

		int initNum=m;
		int finalNum=n;


		// you code here

		for(int i=0;i<intArray.length;i++){
			if(m<finalNum){
				intArray[i]=initNum;
				initNum++;
			}else{
				intArray[i]=finalNum;
			}

		}

		// end

		return intArray; // do not change
	}

	// function 3
	public static boolean isTriangle(int side1, int side2, int side3) {
		boolean isTriangle = false;// do not change

		if(side1+side2 > side3 && side2+side3 > side1 && side3+side1 > side2){
			isTriangle = true;
		}else{
			isTriangle = false;
		}
		// you code here

		// end

		return isTriangle;// do not change
	}

	// function 4
	public static boolean isPrime(int n) {
		boolean isPrime = false; // do not change

		// you code here
		if(n<=1){
			isPrime = false;
		}else{
			for(int i=2;i<=n;i++){
				if(i!=n && n%i==0){
					isPrime = false;	
					break;
				}else if(i == n){
					isPrime = true;
				}
			}
		}
		// end
		return isPrime; // do not change
	}

	// function 5
	public static int[] vowelCount(String s) {
		int[] vowelCount = new int[5]; // do not change

		// you code here
		String caseIgnore = s.toLowerCase();
		char[] string = caseIgnore.toCharArray();
		char[] vowel ={'a','e','i','o','u'};
		

		for(int i=0;i<vowel.length;i++){
			int count=0;
			for(int j=0;j<caseIgnore.length();j++){
				if(vowel[i]==string[j] && string[i]!=' '){
					count++;
				}
			}
			vowelCount[i]=count;	
		}
		// end
		return vowelCount; // do not change
	}

}
