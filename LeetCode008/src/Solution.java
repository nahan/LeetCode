/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 */
public class Solution {
	public int atoi(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		int startIndex = 0;
		while (str.charAt(startIndex) == ' ') {
			startIndex ++;
		}
		if (str.equals("+") || str.equals("-")) {
			return 0;
		}
		boolean isNegative = false;
		if (str.charAt(startIndex) == '+' || str.charAt(startIndex) == '-') {
			isNegative = str.charAt(startIndex) == '+'? false : true;
			startIndex ++;
		}
		int endIndex = str.length() - 1;
		for (int index = startIndex; index < str.length(); index ++) {
			if ((int)str.charAt(index) < 48 || (int)str.charAt(index) > 57) {
				endIndex = index - 1;
				break;
			}
		}
		int[] digitList = new int[endIndex - startIndex + 1];
		if (digitList.length == 0) {
			return 0;
		}
		int stringIndex = startIndex;
		int digitIndex = 0;
		while (stringIndex <= endIndex && digitIndex < digitList.length) {
			digitList[digitIndex] = (int)str.charAt(stringIndex) - 48;
			stringIndex ++;
			digitIndex ++;
		}
		long result = 0;
		for (int index = digitList.length - 1; index >= 0; index --) {
			result = (long) (result + digitList[index] * Math.pow(10, digitList.length - 1 - index));
		}
		if (isNegative == true) {
			result *= (-1);
		}
		if (result >= Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		} else if (result <= Integer.MIN_VALUE) {
			result = Integer.MIN_VALUE;
		}
		return (int)result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String str0 = "";
		String str1 = "Hello World";
		String str2 = "0";
		String str3 = "1234567";
		String str4 = "Hello 123";
		String str5 = "-01234";
		String str6 = "-123-4567";
		String str7 = "     +4567";
		String str8 = "  -0012a42";
		
		System.out.println("Input: " + str0 + ", Output: " + solution.atoi(str0));
		System.out.println("Input: " + str1 + ", Output: " + solution.atoi(str1));
		System.out.println("Input: " + str2 + ", Output: " + solution.atoi(str2));
		System.out.println("Input: " + str3 + ", Output: " + solution.atoi(str3));
		System.out.println("Input: " + str4 + ", Output: " + solution.atoi(str4));
		System.out.println("Input: " + str5 + ", Output: " + solution.atoi(str5));
		System.out.println("Input: " + str6 + ", Output: " + solution.atoi(str6));
		System.out.println("Input: " + str7 + ", Output: " + solution.atoi(str7));
		System.out.println("Input: " + str8 + ", Output: " + solution.atoi(str8));
	}
}
