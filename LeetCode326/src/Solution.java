
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n == 0? false: n == Math.pow(3, Math.round(Math.log10(n) / Math.log10(3)));
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(82));
    }
}
