
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
		float temp = (float) n;
		float result = (float) n;
		int sum = 0;
		float min = 1;
		while (temp > 1) {
			if (result % 10 == 0) {
				sum ++;
				result /= 10;
				temp /= 10;
				min /= 10;
				result = result * (temp - min);
			} else {
				result = result * (temp - min);
			}
			temp = temp - min;
		}
		System.out.print((int)result + ": ");
        return sum;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 17; i ++) {
			System.out.println(solution.trailingZeroes(i));
		}
	}
}
