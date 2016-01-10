import java.util.Arrays;
import java.util.List;


public class StringProblems {
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
    /**************************** 72. Edit Distance ****************************/
    /**
     * Given two words word1 and word2, 
     * find the minimum number of steps required to convert word1 to word2. 
     * (each operation is counted as 1 step.)
     * You have the following 3 operations permitted on a word:
     * a) Insert a character
     * b) Delete a character
     * c) Replace a character
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            if (word1 == null) {
                return word2 == null? 0: word2.length();
            } else {
                return word1.length();
            }
        }
        int m = word1.length();
        int n = word2.length();
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            table[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            table[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int diff = word1.charAt(i - 1) == word2.charAt(j - 1)? 0: 1;
                table[i][j] = this.min(table[i - 1][j] + 1, table[i][j - 1] + 1, table[i - 1][j - 1] + diff);
            }
        }
        return table[m][n];
    }
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    /**************************** 115. Distinct Subsequences ****************************/
    /**
     * Given a string S and a string T, count the number of distinct subsequences of T in S.
     * A subsequence of a string is a new string which is formed from the original string 
     * by deleting some (can be none) of the characters 
     * without disturbing the relative positions of the remaining characters. 
     * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
     * 
     * Here is an example:
     * S = "rabbbit", T = "rabbit"
     * Return 3.
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        if (s.length() == 0 || t.length() == 0) {
            return 1;
        }
        int[][] dp = new int[t.length()][s.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0)? 1: 0;
        for (int i = 0; i < t.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (i == 0) {
                    if (j != 0) {
                        dp[i][j] = t.charAt(i) == s.charAt(j)? dp[i][j - 1] + 1: dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = t.charAt(i) == s.charAt(j)? dp[i][j - 1] + dp[i - 1][j - 1]: dp[i][j - 1];
                }
            }
        }
        return dp[t.length() - 1][s.length() - 1];
    }
    /**************************** 97. Interleaving String ****************************/
    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
     * 
     * For example,
     * Given:
     * s1 = "aabcc",
     * s2 = "dbbca",
     * When s3 = "aadbbcbcac", return true.
     * When s3 = "aadbbbaccc", return false.
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null) {
            if (s1 == null && s2 == null) {
                return s3 == null? true: false;
            } else {
                if (s1 == null) {
                    return s2.equals(s3)? true: false;
                } else {
                    return s1.equals(s3)? true: false;
                }
            }
        } else if (s3 == null) {
            return false;
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 0; i < l1; i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1][0] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < l2; i++) {
            if (s2.charAt(i) == s3.charAt(i)) {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                boolean flag1 = dp[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1);
                boolean flag2 = dp[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1);
                dp[i + 1][j + 1] = flag1 || flag2;
            }
        }
        return dp[l1][l2];
    }
    /**************************** Method ****************************/
    /**************************** Main ****************************/
    public static void main(String[] args) {
        StringProblems solution = new StringProblems();
        solution.testIsScramble();
//        solution.testEditDistance();
//        solution.testNumDistinct();
//        solution.testIsInterleave();
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
    public void testEditDistance() {
        String output = "String1: %s\tString2: %s\texpected: %d\tresult: %d\n";
        String s1 = null;
        String s2 = null;
        System.out.format(output, s1, s2, 0, this.minDistance(s1, s2));
        s1 = "";
        s2 = "";
        System.out.format(output, s1, s2, 0, this.minDistance(s1, s2));
        s1 = "a";
        s2 = "aa";
        System.out.format(output, s1, s2, 1, this.minDistance(s1, s2));
        s1 = "great";
        s2 = "rgeat";
        System.out.format(output, s1, s2, 2, this.minDistance(s1, s2));
        s1 = "great";
        s2 = "greta";
        System.out.format(output, s1, s2, 2, this.minDistance(s1, s2));
        s1 = "great";
        s2 = "gerat";
        System.out.format(output, s1, s2, 2, this.minDistance(s1, s2));
        s1 = "great";
        s2 = "trgae";
        System.out.format(output, s1, s2, 3, this.minDistance(s1, s2));
        s1 = "abcdefg";
        s2 = "defg";
        System.out.format(output, s1, s2, 3, this.minDistance(s1, s2));
        s1 = "thou shalt not";
        s2 = "you should not";
        System.out.format(output, s1, s2, 5, this.minDistance(s1, s2));
        s1 = "exponential";
        s2 = "polynomial";
        System.out.format(output, s1, s2, 6, this.minDistance(s1, s2));
    }
    public void testNumDistinct() {
        String output = "String S: %s\tString T: %s\tExpected: %d\tResult: %d\n";
        String s = null;
        String t = null;
        System.out.format(output, s, t, 0, this.numDistinct(s, t));
        s = "";
        t = "";
        System.out.format(output, s, t, 1, this.numDistinct(s, t));
        s = "rabbbit";
        t = "rabbit";
        System.out.format(output, s, t, 3, this.numDistinct(s, t));
        s = "";
        t = "a";
        System.out.format(output, s, t, 0, this.numDistinct(s, t));
        s = "rabbbbit";
        t = "rabbit";
        System.out.format(output, s, t, 6, this.numDistinct(s, t));
        s = "rabbbt";
        t = "rabbit";
        System.out.format(output, s, t, 0, this.numDistinct(s, t));
        s = "rabbit";
        t = "rabbit";
        System.out.format(output, s, t, 1, this.numDistinct(s, t));
        s = "a";
        t = "aa";
        System.out.format(output, s, t, 0, this.numDistinct(s, t));
        s = "aaa";
        t = "aa";
        System.out.format(output, s, t, 3, this.numDistinct(s, t));
    }
    public void testIsInterleave() {
        String output = "String1: %s\tString2: %s\tInput: %s\tExpected: %s\tResult: %s\n";
        String s1 = null;
        String s2 = null;
        String s3 = null;
        System.out.format(output, s1, s2, s3, true, this.isInterleave(s1, s2, s3));
        s1 = "";
        s2 = "";
        s3 = "";
        System.out.format(output, s1, s2, s3, true, this.isInterleave(s1, s2, s3));
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbcbcac";
        System.out.format(output, s1, s2, s3, true, this.isInterleave(s1, s2, s3));
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.format(output, s1, s2, s3, false, this.isInterleave(s1, s2, s3));
        s1 = "gtaa";
        s2 = "atc";
        s3 = "gattaca";
        System.out.format(output, s1, s2, s3, true, this.isInterleave(s1, s2, s3));
        s1 = "gtaa";
        s2 = "atc";
        s3 = "gtataac";
        System.out.format(output, s1, s2, s3, true, this.isInterleave(s1, s2, s3));
        s1 = "gtaa";
        s2 = "atc";
        s3 = "gatacta";
        System.out.format(output, s1, s2, s3, false, this.isInterleave(s1, s2, s3));
        s1 = "baababbabbababbaaababbbbbbbbbbbaabaabaaaabaaabbaaabaaaababaabaaabaabbbbaabbaabaabbbbabbbababbaaaabab";
        s2 = "aababaaabbbababababaabbbababaababbababbbbabbbbbababbbabaaaaabaaabbabbaaabbababbaaaababaababbbbabbbbb";
        s3 = "babbabbabbababbaaababbbbaababbaabbbbabbbbbaaabbabaababaabaaabaabbbaaaabbabbaaaaabbabbaabaaaabbbbababbbababbabaabababbababaaaaaabbababaaabbaabbbbaaaaabbbaaabbbabbbbaaabaababbaabababbbbababbaaabbbabbbab";
        System.out.format(output, s1, s2, s3, false, this.isInterleave(s1, s2, s3));
    }
    /**************************** Printing Methods ****************************/
    public void print(int n) {
        System.out.println(n);
    }
    public void print(char ch) {
        System.out.println(ch);
    }
    public void print(String s) {
        System.out.println(s);
    }
    public void print(int[] array) {
        if (array == null) {
            return;
        }
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(char[] array) {
        if (array == null) {
            return;
        }
        for (char item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(List<List<Integer>> list) {
        System.out.println(list);
    }
    public void printList(List<String> list) {
        System.out.println(list);
    }
}
