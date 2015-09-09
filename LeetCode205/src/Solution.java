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
        if (s == null || t == null) {
            return true;
        }
        HashMap<Character, Integer> hash1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hash1.containsKey(s.charAt(i))) {
                hash1.put(s.charAt(i), hash1.get(s.charAt(i)) + 1);
            } else {
                hash1.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (hash2.containsKey(t.charAt(i))) {
                hash2.put(t.charAt(i), hash2.get(t.charAt(i)) + 1);
            } else {
                hash2.put(t.charAt(i), 1);
            }
        }
        String s1 = hash1.values().toString();
        String s2 = hash2.values().toString();
        
        System.out.println(hash1);
        System.out.println(hash2);
        
        System.out.println(s1);
        System.out.println(s2);
        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("true: " + solution.isIsomorphic("egg", "add"));
        System.out.println("false: " + solution.isIsomorphic("foo", "bar"));
        System.out.println("true: " + solution.isIsomorphic("paper", "title"));
        System.out.println("false: " + solution.isIsomorphic("aba", "baa"));
    }
}
