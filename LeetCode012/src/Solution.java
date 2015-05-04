
/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
	public String intToRoman(int num) {
		if (num < 1 || num > 3999) {
			return null;
		}
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
		} else if (hundred == 4) {
			builder.append("CD");
		} else if (hundred >= 0) {
			while (hundred > 0) {
				builder.append("C");
				hundred --;
			}
		}
		
		// ten
		if (ten == 9) {
			builder.append("XC");
		} else if (ten >= 5) {
			builder.append("L");
			while (ten > 5) {
				builder.append("X");
				ten --;
			}
		} else if (ten == 4) {
			builder.append("XL");
		} else if (ten >= 0) {
			while (ten > 0) {
				builder.append("X");
				ten --;
			}
		}
		
		// unit
		if (unit == 9) {
			builder.append("IX");
		} else if (unit >= 5) {
			builder.append("V");
			while (unit > 5) {
				builder.append("I");
				unit --;
			}
		} else if (unit == 4) {
			builder.append("IV");
		} else if (unit >= 0) {
			while (unit > 0) {
				builder.append("I");
				unit --;
			}
		}
		
		return builder.toString();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 1; i <= 100; i ++) {
			System.out.println(i + " is: " + solution.intToRoman(i));
		}
		System.out.println("501 is " + solution.intToRoman(501));
		System.out.println("550 is " + solution.intToRoman(550));
		System.out.println("530 is " + solution.intToRoman(530));
		System.out.println("707 is " + solution.intToRoman(707));
		System.out.println("890 is " + solution.intToRoman(890));
		System.out.println("1500 is " + solution.intToRoman(1500));
		System.out.println("1800 is " + solution.intToRoman(1800));
		System.out.println("900 is " + solution.intToRoman(900));
		System.out.println("3999 is " + solution.intToRoman(3999));
		
		System.out.println("0 is " + solution.intToRoman(0));
		System.out.println("4000 is " + solution.intToRoman(4000));
	}
}
