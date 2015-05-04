
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
		if (hundred == 9) {
			builder.append("CM");
		} else if (hundred >= 5) {
			builder.append("D");
			while (hundred > 5) {
				builder.append("C");
				hundred --;
			}
		} else {
			if (hundred > 3) {
				builder.append("D");
			}
			while (hundred > 0) {
				builder.append("C");
				hundred --;
			}
		}
		
		// ten
		if (ten == 9) {
			builder.append("XC");
		} else if (ten >= 5) {
			while (ten > 5) {
				builder.append("X");
				ten --;
			}
			builder.append("L");
		} else {
			if (ten > 3) {
				builder.append("L");
			}
			while (ten > 0) {
				builder.append("X");
				ten --;
			}
		}
		
		// unit
		if (unit == 9) {
			builder.append("XI");
		} else if (unit >= 5) {
			while (unit > 5) {
				builder.append("I");
				unit --;
			}
			builder.append("V");
		} else {
			if (unit > 3) {
				builder.append("V");
			}
			while (unit > 0) {
				builder.append("I");
				unit --;
			}
		}
		
//		System.out.println(digit[0] + ", " + digit[1] + ", " + digit[2] + ", " + digit[3]);
		return builder.toString();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 1; i <= 100; i ++) {
			System.out.println(i + " is: " + solution.intToRoman(i));
		}
		
	}
}
