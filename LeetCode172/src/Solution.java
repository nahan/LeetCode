
/**
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * @author Han
 *
 */
public class Solution {
	public int trailingZeroes(int n) {
		if (n < 0) {
			return 0;
		}
		int result = 0;
		int i = 1;
		while (Math.pow(5, i) <= n) {
			result += n / Math.pow(5, i);
			i ++;
		}
		return result;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 200; i ++) {
			System.out.println(solution.trailingZeroes(i));
		}
	}
}
