public class Solution {
    public boolean isSelfCrossing(int[] s) {
        if (s == null || s.length < 4) {
            return false;
        }
        for (int i = 0; i < s.length - 3; i++) {
            if (s[i + 2] <= s[i] && s[i + 3] >= s[i + 1]) {
                System.out.println("1. got: " + i);
                return true;
            }
            if (s.length >= 5 && i < s.length - 4 && s[i + 1] == s[i + 3] && s[i + 4] >= s[i + 2] - s[i]) {
                System.out.println("2. got: " + i);
                return true;
            }
            if (s.length >= 6 && i < s.length - 5 && s[i + 3] > s[i + 1] && s[i + 2] >= s[i] && s[i + 4] >= s[i + 2] - s[i] && s[i + 4] <= s[i + 2] && s[i + 5] >= s[i + 3] - s[i + 1]) {
                System.out.println("3. got: " + i);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = {1,2,2,2};
        int[] a1 = {1,1,2,1,1};
        int[] a2 = {1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1};
        System.out.println("false, " + solution.isSelfCrossing(a0));
        System.out.println("true, " + solution.isSelfCrossing(a1));
        System.out.println("false, " + solution.isSelfCrossing(a2));
    }
}
