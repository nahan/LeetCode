
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int jump = 0;
        int curEnd = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if (i == curEnd) {
                jump += 1;
                curEnd = curMax;
            }
            if (curEnd >= nums.length - 1) {
                break;
            }
        }
        return jump;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = null;
        int[] a1 = {};
        int[] a2 = {1};
        int[] a3 = {1, 2};
        int[] a4 = {1, 2, 3};
        int[] a5 = {2, 3, 1, 1, 4};
        System.out.println("expected: 0, result: " + solution.jump(a0));
        System.out.println("expected: 0, result: " + solution.jump(a1));
        System.out.println("expected: 0, result: " + solution.jump(a2));
        System.out.println("expected: 1, result: " + solution.jump(a3));
        System.out.println("expected: 2, result: " + solution.jump(a4));
        System.out.println("expected: 2, result: " + solution.jump(a5));
    }

}
