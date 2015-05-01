
/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		return 0;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String test00 = null;
		String test01 = "";
		String test02 = " ";
		String test03 = "Hello World!";
		String test04 = "HelloHello";
		String test05 = "bbbbbbb";
		
		System.out.println(solution.lengthOfLongestSubstring(test00));
		System.out.println(solution.lengthOfLongestSubstring(test01));
		System.out.println(solution.lengthOfLongestSubstring(test02));
		System.out.println(solution.lengthOfLongestSubstring(test03));
		System.out.println(solution.lengthOfLongestSubstring(test04));
		System.out.println(solution.lengthOfLongestSubstring(test05));
	}
}
