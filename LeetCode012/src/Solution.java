
/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
	public String intToRoman(int num) {
		StringBuilder builder = new StringBuilder();
		int temp = num;
		int[] digit = new int[4];
		int index = 3;
		while (temp != 0) {
			digit[index] = (temp % 10);
			temp /= 10;
			index --;
		}
		
		int thousand = digit[0];
		int hundred = digit[1];
		int ten = digit[2];
		int unit = digit[3];
		
		// thousand
		while (thousand > 0) {
			builder.append("M");
			thousand --;
		}
		
		// hundred
		if (hundred >= 5) {
			while (hundred > 5) {
				builder.append("C");
				hundred --;
			}
			builder.append("D");
		} else {
			builder.append("D");
			while (hundred > 0) {
				builder.append("C");
				hundred --;
			}
		}
		
		System.out.println(digit[0] + ", " + digit[1] + ", " + digit[2] + ", " + digit[3]);
		return null;
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
