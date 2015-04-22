
/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 */
public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		if (A == null || B == null) {
			A = A == null ? B : A;
		}

	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array1 = new int[1];
		int[] array2 = new int[2];
		solution.merge(array1, array1.length, array2, array2.length);
	}
}
