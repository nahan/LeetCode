
/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * @author Han
 *
 */
public class Solution {
	public boolean isAnagram(String s, String t) {
        return false;
    }
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Solution solution = new Solution();
		
		System.out.println(solution.isAnagram(null, null));
		System.out.println(solution.isAnagram("", ""));
		System.out.println(solution.isAnagram("abc", null));
		System.out.println(solution.isAnagram(null, "abc"));
		System.out.println(solution.isAnagram("abc", "abc"));
		System.out.println(solution.isAnagram("anagram", "nagaram"));
		System.out.println(solution.isAnagram("rat", "car"));
	}
}
