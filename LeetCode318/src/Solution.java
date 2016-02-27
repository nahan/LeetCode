
public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        int[] bit = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bit[i] = val;
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bit[i] & bit[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] a0 = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        String[] a1 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        String[] a2 = {"a", "aa", "aaa", "aaaa"};
        System.out.println(solution.maxProduct(a0));
        System.out.println(solution.maxProduct(a1));
        System.out.println(solution.maxProduct(a2));
    }
}
