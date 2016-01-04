
public class Solution {
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
    public static void main(String[] args) {
        System.out.println("Hello Dynamic Programming.");
        Solution solution = new Solution();
        solution.testEditDistance();
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
}
