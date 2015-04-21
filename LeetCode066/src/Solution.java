
public class Solution {
	/**
	 * Given a non-negative number represented as an array of digits, plus one to the number.
	 * The digits are stored such that the most significant digit is at the head of the list.
	 */
	public int[] plusOne(int[] digits) {
		if (needOneMoreSpace(digits) == true) {
			int[] temp = new int[digits.length + 1];
			temp[0] = 0;
			for (int index = 1; index < temp.length; index ++) {
				temp[index] = digits[index - 1];
			}
			return doPlusOne(temp);
		} else {
			return doPlusOne(digits);
		}
    }
	public boolean needOneMoreSpace(int[] digits) {
		if (digits.length == 0) {
			return true;
		}
		for (int index = 0; index < digits.length; index ++) {
			if (digits[index] != 9) {
				return false;
			}
		}
		return true;
	}
	public int[] doPlusOne(int[] digits) {
		digits[digits.length - 1] += 1;
		for (int index = digits.length - 1; index >= 0; index --) {
			if (digits[index] >= 10) {
				digits[index] = digits[index] % 10;
				digits[index - 1] += 1;
			}
		}
		return digits;
	}
	public void printDigits(int[] digits) {
		for (int index = 0; index < digits.length; index ++) {
			System.out.print(digits[index]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] digits1 = {9};
		int[] digits2 = {1, 9};
		int[] digits3 = {1, 9, 9};
		int[] digits4 = {9, 1, 1, 9};
		int[] digits5 = {1};
		int[] digits6 = {1, 2};
		int[] digits7 = {1, 2, 3};
		int[] digits8 = {2, 1, 1, 4};
		int[] digits9 = {9, 9, 9, 9};
		
		
//		System.out.println("need space? " + solution.needOneMoreSpace(digits1));
//		System.out.println("need space? " + solution.needOneMoreSpace(digits2));
//		System.out.println("need space? " + solution.needOneMoreSpace(digits3));
//		System.out.println("need space? " + solution.needOneMoreSpace(digits4));
//		System.out.println("need space? " + solution.needOneMoreSpace(digits5));
//		System.out.println("need space? " + solution.needOneMoreSpace(digits6));
//		System.out.println("need space? " + solution.needOneMoreSpace(digits7));
//		System.out.println("need space? " + solution.needOneMoreSpace(digits8));
//		System.out.println("need space? " + solution.needOneMoreSpace(digits9));
		
		solution.printDigits(digits1);
		digits1 = solution.plusOne(digits1);
		solution.printDigits(digits1);
		
		solution.printDigits(digits2);
		digits2 = solution.plusOne(digits2);
		solution.printDigits(digits2);
		
		solution.printDigits(digits3);
		digits3 = solution.plusOne(digits3);
		solution.printDigits(digits3);
		
		solution.printDigits(digits4);
		digits4 = solution.plusOne(digits4);
		solution.printDigits(digits4);
		
		solution.printDigits(digits5);
		digits5 = solution.plusOne(digits5);
		solution.printDigits(digits5);
		
		solution.printDigits(digits6);
		digits6 = solution.plusOne(digits6);
		solution.printDigits(digits6);
		
		solution.printDigits(digits7);
		digits7 = solution.plusOne(digits7);
		solution.printDigits(digits7);
		
		solution.printDigits(digits8);
		digits8 = solution.plusOne(digits8);
		solution.printDigits(digits8);
		
		solution.printDigits(digits9);
		digits9 = solution.plusOne(digits9);
		solution.printDigits(digits9);
	}
}
