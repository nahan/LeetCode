
/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
	public String intToRoman(int num) {
		StringBuilder builder = new StringBuilder();
		int temp = num;
		while (temp != 0) {
			builder.append(temp % 10);
			temp /= 10;
		}
		return builder.reverse().toString();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int test00 = 1;
		int test01 = 5;
		int test02 = 10;
		int test03 = 3999;
		
		System.out.println(test00 + " is: " + solution.intToRoman(test00));
		System.out.println(test01 + " is: " + solution.intToRoman(test01));
		System.out.println(test02 + " is: " + solution.intToRoman(test02));
		System.out.println(test03 + " is: " + solution.intToRoman(test03));
	}
}
