
public class Solution {
	/** 
	 * Given an array and a value, remove all instances of that value in place and return the new length.
	 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	 */
	public int removeElement(int[] A, int elem) {
		if (A.length < 1) {
			return 0;
		}
		int[] temp = new int[A.length - numOfElem(A, elem)];
		if (temp.length != 0) {
			int indexA = 0;
			int indexTemp = 0;
			while (indexA < A.length && indexTemp < temp.length) {
				if (A[indexA] != elem) {
					temp[indexTemp] = A[indexA];
					indexTemp ++;
				}
				indexA ++;
			}
			for (int index = 0; index < temp.length; index ++) {
				A[index] = temp[index];
			}
		}
		return temp.length;
	}
	public int numOfElem(int[] A, int elem) {
		int num = 0;
		for (int index = 0; index < A.length; index ++) {
			if (A[index] == elem) {
				num ++;
			}
		}
		return num;
	}
	public void printArray(int[] A) {
		if (A.length > 0) {
			System.out.print("before: ");
			for (int index = 0; index < A.length; index ++) {
				System.out.print(A[index] + ", ");
			}
			System.out.println();
		}
	}
	public void printLimitedArray(int[] A, int length) {
		if (A.length > 0) {
			System.out.print("after: ");
			for (int index = 0; index < length; index ++) {
				System.out.print(A[index] + ", ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array0 = {};
		int[] array1 = {1};
		int[] array2 = {1, 2};
		int[] array3 = {1, 2, 3};
		int[] array4 = {1, 1, 1, 4};
		
		System.out.println("#0...");
		solution.printArray(array0);
		//System.out.println("new length: " + solution.removeElement(array0, 1));
		solution.printLimitedArray(array0, solution.removeElement(array0, 1));
		
		System.out.println("#1...");
		solution.printArray(array1);
		//System.out.println("new length: " + solution.removeElement(array1, 1));
		solution.printLimitedArray(array1, solution.removeElement(array1, 1));
		
		System.out.println("#2...");
		solution.printArray(array2);
		//System.out.println("new length: " + solution.removeElement(array2, 1));
		solution.printLimitedArray(array2, solution.removeElement(array2, 1));
		
		System.out.println("#3...");
		solution.printArray(array3);
		//System.out.println("new length: " + solution.removeElement(array3, 1));
		solution.printLimitedArray(array3, solution.removeElement(array3, 1));
		
		System.out.println("#4...");
		solution.printArray(array4);
		//System.out.println("new length: " + solution.removeElement(array4, 1));
		solution.printLimitedArray(array4, solution.removeElement(array4, 1));
		System.out.println("Ending");
	}
}
