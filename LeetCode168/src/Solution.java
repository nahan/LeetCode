
/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * @author Han
 *
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int x = n % 26 + 64;
            if ((char)x == '@') {
                builder.append('Z');
            } else {
                builder.append((char)x);
            }
            n = n / 27;
        }
        return builder.reverse().toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 1024; i++) {
            System.out.println(solution.convertToTitle(i));
        }
//        System.out.println(solution.convertToTitle(1));
    }
}
