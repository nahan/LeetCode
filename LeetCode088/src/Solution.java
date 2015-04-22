
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
		int indexA = m - 1;
		int indexB = n - 1;
		for (int index = m + n - 1; index >= 0; index --) {
			A[index] = A[indexA] > B[indexB] ? A[indexA] : B[indexB];
			if (A[indexA] > B[indexB]) {
				indexA --;
			} else {
				indexB --;
			}
			System.out.println("index a: " + indexA + ", index b: " + indexB + ", index will be: " + (index - 1));
			printArray(A);
		}
	}
	public void printArray(int[] A) {
		for (int item: A) {
			System.out.print(item + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array1 = new int[20];
		int[] array2 = new int[10];
		
		array1[0] = 1;
		array1[1] = 3;
		array1[2] = 5;
		array1[3] = 7;
		array1[4] = 9;
		
		array2[0] = 0;
		array2[1] = 2;
		array2[2] = 4;
		array2[3] = 6;
		array2[4] = 8;
		array2[5] = 10;
		
		solution.printArray(array1);
		solution.printArray(array2);
		
		solution.merge(array1, 5, array2, 6);
		
		solution.printArray(array1);
		solution.printArray(array2);
	}
}
