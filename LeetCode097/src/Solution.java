
public class Solution {
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
        if (l1 == 0 || l2 == 0) {
            if (l1 == 0 && l2 == 0) {
                return l3 == 0? true: false;
            } else {
                if (l1 == 0) {
                    return s2.equals(s3)? true: false;
                } else {
                    return s1.equals(s3)? true: false;
                }
            }
        }
        return this.isInterleave(s1, l1 - 1, s2, l2 - 1, s3, l3 - 1);
    }
    public boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i1 < 0 || i2 < 0) {
            if (i1 < 0 && i2 < 0) {
                return i3 < 0? true: false;
            } else {
                if (i1 < 0) {
                    if (i3 < 0) {
                        return false;
                    } else {
                        return s2.substring(0, i2 + 1).equals(s3.substring(0, i3 + 1));
                    }
                } else {
                    if (i3 < 0) {
                        return false;
                    } else {
                        return s1.substring(0, i1 + 1).equals(s3.substring(0, i3 + 1));
                    }
                }
            }
        }
        if (s1.charAt(i1) == s2.charAt(i2) && s1.charAt(i1) == s3.charAt(i3)) {
            return this.isInterleave(s1, i1 - 1, s2, i2, s3, i3 - 1) || this.isInterleave(s1, i1, s2, i2 - 1, s3, i3 - 1);
        }
        if (s1.charAt(i1) != s3.charAt(i3)) {
            return s2.charAt(i2) == s3.charAt(i3) && this.isInterleave(s1, i1, s2, i2 - 1, s3, i3 - 1);
        }
        if (s2.charAt(i2) != s3.charAt(i3)) {
            return s1.charAt(i1) == s3.charAt(i3) && this.isInterleave(s1, i1 - 1, s2, i2, s3, i3 - 1);
        }
        return false;
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testIsInterleave();
    }
    /**************************** Testing Methods ****************************/
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
}
