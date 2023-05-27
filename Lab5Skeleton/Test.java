import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		boolean assertEnable = false;
		assert assertEnable=true;
		
		if(!assertEnable) {
			System.out.println("Enable assertion before the test");
		}else {
			System.out.println("Assertion Enabled");
			test();
		}
	}
	
	private static void test() {
		
		int[] numArray = { 1,2,4,3,5,6,7,8,9,10 };
		
		
		try {
			ArrayList<Integer> sequence = BinarySearchSequence.binarySearchIndexSequence(1, numArray);
			
			int[] expected1 = {4,1,0};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected1)==true;
			System.out.println("\nsuccess1\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(2, numArray);
			int[] expected2 = {4,1};
			System.out.println("\nsuccess2\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(3, numArray);
			int[] expected3 = {4,1,2};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected3)==true;
			System.out.println("\nsuccess3\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(4, numArray);
			int[] expected4 = {4,1,2,3};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected4)==true;
			System.out.println("\nsuccess4\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(5, numArray);
			int[] expected5 = {4};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected5)==true;
			System.out.println("\nsuccess5\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(6, numArray);
			int[] expected6 = {4,7,5};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected6)==true;
			System.out.println("\nsuccess6\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(7, numArray);
			int[] expected7 = {4,7,5,6};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected7)==true;
			System.out.println("\nsuccess7\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(8, numArray);
			int[] expected8 = {4,7};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected8)==true;
			System.out.println("\nsuccess8\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(9, numArray);
			int[] expected9 = {4,7,8};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected9)==true;
			System.out.println("\nsuccess9\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(10, numArray);
			int[] expected10 = {4,7,8,9};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected10)==true;
			System.out.println("\nsuccess10\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(-1, numArray);
			int[] expected11 = {4,1,0,-1};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected11)==true;
			System.out.println("\nsuccess11\n");
			
			sequence = BinarySearchSequence.binarySearchIndexSequence(11, numArray);
			int[] expected12 = {4,7,8,9,-1};
			assert checkIfTwoArraysHaveTheSameContent(sequence.toArray(),expected12)==true;
			System.out.println("\nsuccess12\n");
			
			System.out.println("Test case passed");
		}catch(AssertionError ex) {
			System.out.println("Test case failed");
		}
	}

	
	private static boolean checkIfTwoArraysHaveTheSameContent(Object[] nums1, int[] nums2) {
		
		if(nums1.length!=nums2.length) {
			return false;
		}
		
		boolean isSame = true;
		for(int i=0;i<nums1.length;i++) {
			int n1 = (Integer)nums1[i];
			int n2 = nums2[i];
			if(n1!=n2) {
				isSame = false;
				break;
			}
		}
		return isSame;
	}
}
