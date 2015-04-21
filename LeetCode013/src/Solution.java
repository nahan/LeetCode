
/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
	public int romanToInt(String s) {
		if (s == null || s.equals("") || s.equals(" ")) {
			return 0;
		}
		int[] numberList = new int[s.length()];
		for (int index = 0; index < s.length(); index ++) {
			if (s.charAt(index) == 'I') {
				numberList[index] = 1;
			}
			if (s.charAt(index) == 'V') {
				if (index != 0 && s.charAt(index - 1) == 'I') {
					numberList[index] = 3;
				} else {
					numberList[index] = 5;
				}
			}
			if (s.charAt(index) == 'X') {
				if (index != 0 && s.charAt(index - 1) == 'I') {
					numberList[index] = 8;
				} else {
					numberList[index] = 10;
				}
			}
			if (s.charAt(index) == 'L') {
				if (index != 0 && s.charAt(index - 1) == 'X') {
					numberList[index] = 30;
				} else {
					numberList[index] = 50;
				}
			}
			if (s.charAt(index) == 'C') {
				if (index != 0 && s.charAt(index - 1) == 'X') {
					numberList[index] = 80;
				} else {
					numberList[index] = 100;
				}
			}
			if (s.charAt(index) == 'D') {
				if (index != 0 && s.charAt(index - 1) == 'C') {
					numberList[index] = 300;
				} else {
					numberList[index] = 500;
				}
			}
			if (s.charAt(index) == 'M') {
				if (index != 0 && s.charAt(index - 1) == 'C') {
					numberList[index] = 800;
				} else {
					numberList[index] = 1000;
				}
			}
		}
		int result = 0;
		for (int index = 0; index < numberList.length; index ++) {
			result += numberList[index];
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String rn1 = "I";
		String rn2 = "III";
		String rn3 = "IV";
		String rn4 = "V";
		String rn5 = "XXXVIII";
		String rn6 = "IX";
		String rn7 = "X";
		String rn8 = "XLIX";
		String rn9 = "DCCCXC";
		
		System.out.println(rn1 + " = " + solution.romanToInt(rn1));
		System.out.println(rn2 + " = " + solution.romanToInt(rn2));
		System.out.println(rn3 + " = " + solution.romanToInt(rn3));
		System.out.println(rn4 + " = " + solution.romanToInt(rn4));
		System.out.println(rn5 + " = " + solution.romanToInt(rn5));
		System.out.println(rn6 + " = " + solution.romanToInt(rn6));
		System.out.println(rn7 + " = " + solution.romanToInt(rn7));
		System.out.println(rn8 + " = " + solution.romanToInt(rn8));
		System.out.println(rn9 + " = " + solution.romanToInt(rn9));
	}
}
