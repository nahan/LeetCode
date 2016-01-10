import java.util.Arrays;


public class Solution {
    /**************************** 87. Scramble String ****************************/
    /**
     * Given two strings s1 and s2 of the same length, 
     * determine if s2 is a scrambled string of s1.
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) {
            return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            if (this.isScramble(s1.substring(0, i), s2.substring(0, i)) && this.isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (this.isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && this.isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testIsScramble();
    }
    /**************************** Testing Methods ****************************/
    public void testIsScramble() {
        String output = "String1: %s\tString2: %s\texpected: %s\tresult: %s\n";
        String s1 = null;
        String s2 = null;
        System.out.format(output, s1, s2, false, this.isScramble(s1, s2));
        s1 = "";
        s2 = "";
        System.out.format(output, s1, s2, false, this.isScramble(s1, s2));
        s1 = "a";
        s2 = "aa";
        System.out.format(output, s1, s2, false, this.isScramble(s1, s2));
        s1 = "great";
        s2 = "rgeat";
        System.out.format(output, s1, s2, true, this.isScramble(s1, s2));
        s1 = "great";
        s2 = "greta";
        System.out.format(output, s1, s2, true, this.isScramble(s1, s2));
        s1 = "great";
        s2 = "gerat";
        System.out.format(output, s1, s2, true, this.isScramble(s1, s2));
        s1 = "great";
        s2 = "trgae";
        System.out.format(output, s1, s2, true, this.isScramble(s1, s2));
    }
}
