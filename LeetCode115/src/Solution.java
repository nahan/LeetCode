
public class Solution {
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
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testNumDistinct();
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
}
