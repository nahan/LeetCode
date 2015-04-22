
/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class Solution {
	public int removeDuplicates(int[] A) {
		if (A == null) {
			return 0;
		}
		if (A.length < 3) {
			return A.length;
		}
		int newLength = A.length;
		for (int index = 1; index < newLength - 1; index ++) {
			if (A[index] == A[index - 1] && A[index] == A[index + 1]) {
				removeItem(A, index);
				newLength --;
				index --;
			}
		}
		return newLength;
	}
	public void removeItem(int[] A, int index) {
		for (int i = index; i < A.length - 1; i ++) {
			A[i] = A[i + 1];
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] array = null;
		int[] array0 = {};
		int[] array1 = {0};
		int[] array2 = {0, 1};
		int[] array3 = {0, 0, 0};
		int[] array4 = {0, 0, 0, 1};
		int[] array5 = {0, 0, 0, 1, 1};
		int[] array6 = {0, 0, 0, 1, 1, 1};
		int[] array7 = {0, 0, 0, 1, 1, 1, 1};
		int[] array8 = {0, 0, 0, 1, 1, 1, 1, 2};
		int[] array9 = {0, 0, 0, 1, 1, 1, 2, 2, 2};
		int[] array10 = {1, 1, 1, 2, 2, 3};
		System.out.println("input: null, \t\t\t\texpected length: 0, result: " + solution.removeDuplicates(array));
		System.out.println("input: {}, \t\t\t\texpected length: 0, result: " + solution.removeDuplicates(array0));
		System.out.println("input: {0}, \t\t\t\texpected length: 1, result: " + solution.removeDuplicates(array1));
		System.out.println("input: {0, 1}, \t\t\t\texpected length: 2, result: " + solution.removeDuplicates(array2));
		System.out.println("input: {0, 0, 0}, \t\t\texpected length: 2, result: " + solution.removeDuplicates(array3));
		System.out.println("input: {0, 0, 0, 1}, \t\t\texpected length: 3, result: " + solution.removeDuplicates(array4));
		System.out.println("input: {0, 0, 0, 1, 1}, \t\texpected length: 4, result: " + solution.removeDuplicates(array5));
		System.out.println("input: {0, 0, 0, 1, 1, 1}, \t\texpected length: 4, result: " + solution.removeDuplicates(array6));
		System.out.println("input: {0, 0, 0, 1, 1, 1, 1}, \t\texpected length: 4, result: " + solution.removeDuplicates(array7));
		System.out.println("input: {0, 0, 0, 1, 1, 1, 1, 2}, \texpected length: 5, result: " + solution.removeDuplicates(array8));
		System.out.println("input: {0, 0, 0, 1, 1, 1, 2, 2, 2}, \texpected length: 6, result: " + solution.removeDuplicates(array9));
		System.out.println("input: {1, 1, 1, 2, 2, 3}, \texpected length: 6, result: " + solution.removeDuplicates(array10));
		
	}
}
