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
	public boolean isAnagram1(String s, String t) {
		if (s == null || t == null) {
			return (s == null && t == null) ? true : false;
		}
		if (s.equals(t)) {
			return true;
		}
		if (s.length() != t.length()) {
			return false;
		}
		
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		
		Arrays.sort(s.toCharArray());
		Arrays.sort(t.toCharArray());
		
		return  new String(s1).equals(new String(t1)) ? true : false;
    }
	
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null) {
			return (s == null && t == null) ? true : false;
		}
		if (s.equals(t)) {
			return true;
		}
		if (s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		for (int index = 0; index < s.length(); index ++) {
			if (hash.containsKey(s.charAt(index))) {
				hash.put(s.charAt(index), hash.get(s.charAt(index)) + 1);
			} else {
				hash.put(s.charAt(index), 1);
			}
		}
		for (int index = 0; index < t.length(); index ++) {
			if (hash.containsKey(t.charAt(index))) {
				hash.put(t.charAt(index), hash.get(t.charAt(index)) - 1);
			} else {
				return false;
			}
		}
		
		Iterator<Integer> it = hash.values().iterator();
		while (it.hasNext()) {
			if (it.next() != 0) {
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
