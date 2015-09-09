
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
        int count = 1;
        int result = 0;
        for (int index = s.length() - 1; index >= 0; index--) {
            result += (s.charAt(index) - 64) * count;
            count *= 26;
        }
        return result;
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
