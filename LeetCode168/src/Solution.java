
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
            if (n % 26 == 0) {
                builder.append('Z');
                n = n / 26 - 1;
            } else {
                int x = n % 26 + 64;
                builder.append((char)x);
                n = n / 26;
            }
        }
        return builder.reverse().toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 1024; i++) {
            System.out.println(solution.convertToTitle(i));
      }
        System.out.println("A -> Z...");
        System.out.println("Expect: A, Output: " + solution.convertToTitle(1));
        System.out.println("Expect: B, Output: " + solution.convertToTitle(2));
        System.out.println("Expect: C, Output: " + solution.convertToTitle(3));
        System.out.println("Expect: D, Output: " + solution.convertToTitle(4));
        System.out.println("Expect: E, Output: " + solution.convertToTitle(5));
        System.out.println("...");
        System.out.println("Expect: X, Output: " + solution.convertToTitle(24));
        System.out.println("Expect: Y, Output: " + solution.convertToTitle(25));
        System.out.println("Expect: Z, Output: " + solution.convertToTitle(26));
        
        System.out.println("\nAA -> AZ...");
        System.out.println("Expect: AA, Output: " + solution.convertToTitle(27));
        System.out.println("Expect: AB, Output: " + solution.convertToTitle(28));
        System.out.println("Expect: AC, Output: " + solution.convertToTitle(29));
        System.out.println("Expect: AD, Output: " + solution.convertToTitle(30));
        System.out.println("Expect: AE, Output: " + solution.convertToTitle(31));
        System.out.println("...");
        System.out.println("Expect: AX, Output: " + solution.convertToTitle(50));
        System.out.println("Expect: AY, Output: " + solution.convertToTitle(51));
        System.out.println("Expect: AZ, Output: " + solution.convertToTitle(52));
        
        System.out.println("\nBA -> BZ...");
        System.out.println("Expect: BA, Output: " + solution.convertToTitle(53));
        System.out.println("Expect: BB, Output: " + solution.convertToTitle(54));
        System.out.println("Expect: BC, Output: " + solution.convertToTitle(55));
        System.out.println("Expect: BD, Output: " + solution.convertToTitle(56));
        System.out.println("Expect: BE, Output: " + solution.convertToTitle(57));
        System.out.println("...");
        System.out.println("Expect: BX, Output: " + solution.convertToTitle(76));
        System.out.println("Expect: BY, Output: " + solution.convertToTitle(77));
        System.out.println("Expect: BZ, Output: " + solution.convertToTitle(78));
        
        System.out.println("\nCA -> CZ...");
        System.out.println("Expect: CA, Output: " + solution.convertToTitle(79));
        System.out.println("Expect: CB, Output: " + solution.convertToTitle(80));
        System.out.println("Expect: CC, Output: " + solution.convertToTitle(81));
        System.out.println("Expect: CD, Output: " + solution.convertToTitle(82));
        System.out.println("Expect: CE, Output: " + solution.convertToTitle(83));
        System.out.println("...");
        System.out.println("Expect: CX, Output: " + solution.convertToTitle(102));
        System.out.println("Expect: CY, Output: " + solution.convertToTitle(103));
        System.out.println("Expect: CZ, Output: " + solution.convertToTitle(104));
    }
}
