
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
		if (a.length() < b.length()) {
			return addBinary(b, a);
		}
		int indexA = a.length() - 1;
		int indexB = b.length() - 1;
		int[] digitArray = new int[a.length() + 1];
		int indexDigit = digitArray.length - 1;
		
		while (indexA >= 0 && indexB >= 0) {
			digitArray[indexDigit] = (int)a.charAt(indexA) - 48 + (int)b.charAt(indexB) - 48;
			indexA --;
			indexB --;
			indexDigit --;
		}
		while (indexA >= 0) {
			digitArray[indexDigit] = (int)a.charAt(indexA) - 48;
			indexA --;
			indexDigit --;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = digitArray.length - 1; i >= 0; i --) {
			if (digitArray[i] >= 2) {
				digitArray[i - 1] += digitArray[i] / 2;
				digitArray[i] = digitArray[i] % 2;
			}
			if (i == 0 && digitArray[i] == 0) {
				continue;
			} else {
				builder.append(digitArray[i]);
			}
		}
		return builder.reverse().toString();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.addBinary("1111", "11"));
	}
}