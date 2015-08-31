
/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author Han
 *
 */
public class Solution {
	public boolean isPowerOfTwo(int n) {
		if (n <= 1) {
			return n == 1 ? true : false;
		} else {
			return n % 2 != 0 ? false : this.isPowerOfTwo(n / 2);
		}
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 1025; i ++) {
			System.out.println(i + ": " + solution.isPowerOfTwo(i));
		}
	}
}
