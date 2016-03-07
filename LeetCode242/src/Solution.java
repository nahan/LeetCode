import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


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
        if (s == null || t == null) {
            return s == null && t == null? true: false;
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            a[t.charAt(i) - 'a'] -= 1;
        }
        for (int i: a) {
            if (i != 0) {
                return false;
            }
        }
        return true;
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
		System.out.println(solution.isAnagram("abcdefg", "hijklmn"));
		System.out.println(solution.isAnagram("abb", "baa"));
	}
}
