
public class Solution {
	/** #26 Remove Duplicates from Sorted Array
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * For example,
	 * Given input array A = [1,1,2],
	 * Your function should return length = 2, and A is now [1,2].
	 */
	
	public int removeDuplicates(int[] A) {
		if (A.length < 2) {
			return A.length;
		}
		int[] temp = new int[A.length - numOfDuplicates(A)];
		int indexA = 0;
		int indexTemp = 0;
		temp[indexTemp] = A[indexA];
		while (indexA < A.length - 1 && indexTemp < temp.length) {
			if (temp[indexTemp] != A[indexA + 1]) {
				temp[indexTemp + 1] = A[indexA + 1];
				indexTemp ++;
			}
			indexA ++;
		}
		for (int index = 0; index < temp.length; index ++) {
			A[index] = temp[index];
		}
		return temp.length;
	}
	public int numOfDuplicates(int[] A) {
		int num = 0;
		for (int index = 0; index < A.length - 1; index ++) {
			if (A[index] == A[index + 1]) {
				num ++;
			}
		}
		return num;
	}
	public void printArray(int[] A) {
		for (int index = 0; index < A.length; index ++) {
			System.out.print(A[index] + ", ");
		}
		System.out.println();
	}
	public void changeArray(int[] A) {
		int[] temp = {0, 0, 0, 0, 0, 0, 0};
		A = temp;
	}
	public static void main(String[] args) {
		int[] array0 = {};
		int[] array1 = {1, 2};
		int[] array2 = {1, 1, 1, 2, 2, 2};
		int[] array3 = {1, 1, 2};
		Solution solution = new Solution();
		solution.printArray(array0);
		System.out.println("result should be 0: " + new Solution().removeDuplicates(array0));
		solution.printArray(array0);
		
		solution.printArray(array1);
		System.out.println("result should be 1: " + new Solution().removeDuplicates(array1));
		solution.printArray(array1);
		
		solution.printArray(array2);
		System.out.println("result should be 2: " + solution.removeDuplicates(array2));
		solution.printArray(array2);
		
		solution.printArray(array3);
		System.out.println("result should be 2: " + new Solution().removeDuplicates(array3));
		solution.printArray(array3);
		
		System.out.println("End of Program.");
	}

}
