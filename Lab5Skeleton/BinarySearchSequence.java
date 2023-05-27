import java.util.*;

public class BinarySearchSequence {
	
	public static ArrayList<Integer> binarySearchIndexSequence(int num, int[] numArray) {
	
		ArrayList<Integer> sequence = new ArrayList<Integer>();//do not change

		Arrays.sort(numArray);

		int low = 0;
		int high = numArray.length-1;
		
		
		while (low<=high){
			int middleIndex = (low+high)/2;
			// System.out.println(middleIndex);
			sequence.add(middleIndex);
			int middleNum = numArray[middleIndex];

			if(num == middleNum){
				return sequence;

			}

			if(num < middleNum){
				high = middleIndex -1;
			}

			if(num> middleIndex){
				low = middleIndex + 1;
			}
			
		};

		sequence.add(-1);
		
	
		//complete your code here
		
		
		return sequence;//do not change
	}
	
	
}
