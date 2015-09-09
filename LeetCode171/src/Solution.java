import java.util.HashMap;

/**
 * Given a column title as appear in an Excel sheet, 
 * return its corresponding column number.
 * 
 * For example:
 * A -> 1 
 * B -> 2 
 * C -> 3 
 * ... 
 * Z -> 26 
 * AA -> 27 
 * AB -> 28
 * 
 * @author Han
 *
 */
public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (int index = 0; index < s.length(); index++) {
            hash.put(s.charAt(index), s.charAt(index) - 64);
        }
        int count = 1;
        int result = 0;
        for (int index = s.length() - 1; index >= 0; index--) {
            result += hash.get(s.charAt(index)) * count;
            count *= 26;
        }
        return result;
    }
    public void print(char[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println("null -> " + solution.titleToNumber(null));
        System.out.println(" -> " + solution.titleToNumber(""));
        System.out.println("A -> " + solution.titleToNumber("A"));
        System.out.println("B -> " + solution.titleToNumber("B"));
        System.out.println("C -> " + solution.titleToNumber("C"));
        System.out.println("Z -> " + solution.titleToNumber("Z"));
        System.out.println("AA -> " + solution.titleToNumber("AA"));
        System.out.println("AB -> " + solution.titleToNumber("AB"));
    }
}
