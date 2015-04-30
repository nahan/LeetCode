
/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution {
	public boolean isPalindrome(String s) {
		return false;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String test00 = null;
		String test01 = "";
		String test02 = " ";
		String test03 = "123";
		String test04 = "A man, a plan, a canal: Panama";
		String test05 = "race a car";
		
		System.out.println(solution.isPalindrome(test00));
		System.out.println(solution.isPalindrome(test01));
		System.out.println(solution.isPalindrome(test02));
		System.out.println(solution.isPalindrome(test03));
		System.out.println(solution.isPalindrome(test04));
		System.out.println(solution.isPalindrome(test05));
	}
}
