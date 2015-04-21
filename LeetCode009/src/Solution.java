//Determine whether an integer is a palindrome. 
//Do this without extra space.
public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int length = 0;
		int temp = x;
		while (temp > 0) {
			length ++;
			temp = temp / 10;
		}
		int i = length - 1;
		int j = 0;
		while (i >= 0 && j < length) {
			if ((int) ((x / Math.pow(10, i)) % 10) == (int) ((x / Math.pow(10, j)) % 10)) {
				i --;
				j ++;
			} else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("1 is palindrome: " + solution.isPalindrome(1));
		System.out.println("12 is palindrome: " + solution.isPalindrome(12));
		System.out.println("121 is palindrome: " + solution.isPalindrome(121));
		System.out.println("1212 is palindrome: " + solution.isPalindrome(1212));
		System.out.println("12321 is palindrome: " + solution.isPalindrome(12321));
		System.out.println("123456 is palindrome: " + solution.isPalindrome(123456));
		System.out.println("1234321 is palindrome: " + solution.isPalindrome(1234321));
	}
}
