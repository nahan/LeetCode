
/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 */
public class Solution {
	public int searchInsert(int[] A, int target) {
		if (A == null || target <= A[0]) {
			return 0;
		} 
		if (target >= A[A.length - 1]) {
			return A.length;
		}
		return searchTarget(A, 1, A.length - 2, target);
	}
	public int searchTarget(int[] A, int start, int end, int target) {
		if (end - start + 1 == 1) {
			return start;
		}
		int mid = (end - start + 1) / 2;
		if (A[mid] == target) {
			return mid;
		} else if (A[mid] < target) {
			return searchTarget(A, start, mid, target);
		} else {
			return searchTarget(A, mid, end - 1, target);
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a1 = {1,3,5,6};
//		int[] a2 = {1,3,5,6};
//		int[] a3 = {1,3,5,6};
//		int[] a4 = {1,3,5,6};
		System.out.println(solution.searchInsert(a1, 5));
		System.out.println(solution.searchInsert(a1, 2));
		System.out.println(solution.searchInsert(a1, 7));
		System.out.println(solution.searchInsert(a1, 0));
	}
}
