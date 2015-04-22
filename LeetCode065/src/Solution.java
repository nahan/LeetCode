
/**
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class Solution {
	public boolean isNumber(String s) {
		if (s == null) {
			return false;
		} else {
			System.out.println(s.length());
		}
		return false;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isNumber("0"));
		System.out.println(solution.isNumber(" 0.1 "));
		System.out.println(solution.isNumber("abc"));
		System.out.println(solution.isNumber("1 a"));
		System.out.println(solution.isNumber("2e10"));
	}
}
