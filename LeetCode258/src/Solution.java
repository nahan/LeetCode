
/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * @author Han
 *
 */
public class Solution {
    public int addDigits1(int num) {
        return num == 0? 0: 1 + (num - 1) % 9;
    }
	
	public int addDigits(int num) {
		return (num - 1) % 9 + 1;
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Solution solution = new Solution();
		for (int i = 0; i <= 1024; i ++) {
			System.out.println(i + " -> " + solution.addDigits(i));
		}
	}
}
