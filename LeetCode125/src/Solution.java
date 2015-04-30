
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
		if (s == null || s.length() == 0) {
			return s == null ? false : true;
		}
		
		String clean = filter(s);
		
		int headIndex = 0;
		int tailIndex = clean.length() - 1;
		while (headIndex < clean.length() || tailIndex >= 0) {
			if (clean.charAt(headIndex) != clean.charAt(tailIndex)) {
				return false;
			}
			
			headIndex ++;
			tailIndex --;
		}
		return true;
	}
	public String filter(String s) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i ++) {
			if (((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57) || 
					((int)s.charAt(i) >= 65 && (int)s.charAt(i) <= 90) || 
					((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 122) ) {
				
				builder.append(s.charAt(i));
			}
		}
		return builder.toString().toLowerCase();
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
