
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
        int n = 0;
        int base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            n += base * (s.charAt(i) - 'A' + 1);
            base *= 26;
        }
        return n;
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
