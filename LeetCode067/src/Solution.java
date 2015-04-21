
/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class Solution {
	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return a == null ? b : a;
		}
		if (a.equals("") || b.equals("")) {
			return a.equals("") ? b : a;
		}
		int length = a.length() > b.length() ? a.length() : b.length();
		StringBuilder builder = new StringBuilder();
		
		return null;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.addBinary("1", "111"));
	}
}