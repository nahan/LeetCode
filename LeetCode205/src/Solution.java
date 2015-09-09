import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced 
 * with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * @author Han
 *
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() <= 1 || s.length() <= 1) {
            return true;
        }
        HashMap<Character, Character> hash = new HashMap<Character, Character>();
        
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (hash.containsKey(s.charAt(i)) == true) {
                if (hash.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (hash.containsValue(t.charAt(i)) == true) {
                    return false;
                } else {
                    hash.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("true: " + solution.isIsomorphic(null, null));
        System.out.println("true: " + solution.isIsomorphic("", ""));
        System.out.println("true: " + solution.isIsomorphic("e", "a"));
        System.out.println("true: " + solution.isIsomorphic("gg", "dd"));
        System.out.println("true: " + solution.isIsomorphic("egg", "add"));
        System.out.println("false: " + solution.isIsomorphic("foo", "bar"));
        System.out.println("true: " + solution.isIsomorphic("paper", "title"));
        System.out.println("false: " + solution.isIsomorphic("aba", "baa"));
        System.out.println("false: " + solution.isIsomorphic("ab", "aa"));
    }
}
