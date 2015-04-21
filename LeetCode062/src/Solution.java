
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * d(x, y) = [d(x - 1, y) + d(x - 1, y - 1) + d(x - 1, y - 2) + ... + d(x - 1, 1) + d(x - 1, 0)]
 */
public class Solution {
	public int uniquePathsRec(int m, int n) {
		if (m == 0 || n == 0 || m > 100 || n > 100) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		if (m == 2) {
			return n;
		}
		if (n == 2) {
			return m;
		}
		int sum = 0;
		while (n > 0) {
			sum += uniquePathsRec(m - 1, n);
			n --;
		}
		return sum;
	}
	public int uniquePathsRec2(int m, int n) {
		if (m == 0 || n == 0 || m > 100 || n > 100) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		if (m == 2) {
			return n;
		}
		if (n == 2) {
			return m;
		}
		return uniquePathsRec2(m - 1, n) + uniquePathsRec2(m, n - 1);
	}
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0 || m > 100 || n > 100) {
			return 0;
		}
		for (int i = 1; i < m; i ++) {
			for (int j = 1; j < n; j ++) {
				
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println("test 1 should be 0, output: " + solution.uniquePaths(0, 0));
//		System.out.println("test 2 should be 0, output: " + solution.uniquePaths(0, 1));
//		System.out.println("test 3 should be 0, output: " + solution.uniquePaths(1, 0));
//		System.out.println("test 4 should be 1, output: " + solution.uniquePaths(1, 1));
//		System.out.println("test 5 should be 1, output: " + solution.uniquePaths(1, 2));
//		System.out.println("test 6 should be 1, output: " + solution.uniquePaths(1, 5));
//		System.out.println("test 7 should be 0, output: " + solution.uniquePaths(2, 0));
//		System.out.println("test 8 should be 1, output: " + solution.uniquePaths(2, 1));
//		System.out.println("test 9 should be 2, output: " + solution.uniquePaths(2, 2));
//		System.out.println("test 10 should be 3, output: " + solution.uniquePaths(2, 3));
//		System.out.println("test 11 should be 0, output: " + solution.uniquePaths(3, 0));
//		System.out.println("test 12 should be 1, output: " + solution.uniquePaths(3, 1));
//		System.out.println("test 13 should be 3, output: " + solution.uniquePaths(3, 2));
//		System.out.println("test 14 should be 6, output: " + solution.uniquePaths(3, 3));
//		System.out.println("test 15 should be 10, output: " + solution.uniquePaths(3, 4));
//		System.out.println("test 16 should be 15, output: " + solution.uniquePaths(3, 5));
//		System.out.println("test 18 should be 28, output: " + solution.uniquePaths(3, 7));
//		System.out.println("test 17 should be 21, output: " + solution.uniquePaths(3, 6));
//		System.out.println("test 18 should be ?, output: " + solution.uniquePaths(19, 13));
//		System.out.println("test 19 should be ?, output: " + solution.uniquePaths(51, 9));

		System.out.println("test 19 should be ?, output: " + solution.uniquePathsRec(51, 9));
	}
}
