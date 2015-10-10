import java.util.HashMap;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * 
 * Notes:
 * pattern contains only lower case alphabetical letters, 
 * and str contains words separated by a single space. 
 * Each word in str contains only lowercase alphabetical letters.
 * Both pattern and str do not have leading or trailing spaces.
 * Each letter in pattern must map to a word with length that is at least 1.
 * @author Han
 *
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null) {
            return str == null;
        }
        if (str == null) {
            return false;
        }
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        if (str.length() == 0) {
            return false;
        }
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        HashMap<Character, String> hash = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (hash.containsKey(ch)) {
                if (!hash.get(ch).equals(strs[i])) {
                    return false;
                }
            } else if (hash.containsValue(strs[i])) {
                return false;
            } else {
                hash.put(ch, strs[i]);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Hello world.");
        Solution solution = new Solution();
        
        String str00 = null;
        String str01 = "";
        String str02 = "dog";
        String str03 = "dog cat cat dog";
        String str04 = "dog dog dog dog";
        
        String pat00 = null;
        String pat01 = "";
        String pat02 = "a";
        String pat03 = "abba";
        String pat04 = "aaaa";
        String pat05 = "abcd";
        
        System.out.println("Expected: true, Output: " + solution.wordPattern(pat00, str00));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat00, str01));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat00, str02));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat00, str03));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat00, str04));
        System.out.println();
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat01, str00));
        System.out.println("Expected: true, Output: " + solution.wordPattern(pat01, str01));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat01, str02));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat01, str03));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat01, str04));
        System.out.println();
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat02, str00));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat02, str01));
        System.out.println("Expected: true, Output: " + solution.wordPattern(pat02, str02));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat02, str03));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat02, str04));
        System.out.println();
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat03, str00));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat03, str01));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat03, str02));
        System.out.println("Expected: true, Output: " + solution.wordPattern(pat03, str03));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat03, str04));
        System.out.println();
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat04, str00));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat04, str01));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat04, str02));
        System.out.println("Expected: false, Output: " + solution.wordPattern(pat04, str03));
        System.out.println("Expected: true, Output: " + solution.wordPattern(pat04, str04));
        System.out.println();
        System.out.println("Expected: false, false: " + solution.wordPattern(pat05, str00));
        System.out.println("Expected: false, false: " + solution.wordPattern(pat05, str01));
        System.out.println("Expected: false, false: " + solution.wordPattern(pat05, str02));
        System.out.println("Expected: false, false: " + solution.wordPattern(pat05, str03));
        System.out.println("Expected: false, false: " + solution.wordPattern(pat05, str04));
        System.out.println();
    }
}
