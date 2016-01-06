
public class Solution {
    /**************************** 213. House Robber II ****************************/
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 2) {
            if (nums == null || nums.length == 0) {
                return 0;
            } else {
                return nums.length == 1? nums[0]: Math.max(nums[0], nums[1]);
            }
        }
        int max1 = this.robCircle(nums, 0, nums.length - 2);
        int max2 = this.robCircle(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }
    public int robCircle(int[] nums, int startAt, int endAt) {
        int[] stolen = new int[endAt - startAt + 1];
        stolen[0] = nums[startAt];
        stolen[1] = nums[startAt] > nums[startAt + 1]? nums[startAt]: nums[startAt + 1];
        for (int i = 2; i < stolen.length; i++) {
            stolen[i] = Math.max(stolen[i - 1], stolen[i - 2] + nums[i + startAt]);
        }
        return stolen[stolen.length - 1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testRobII();
    }
    public void testRobII() {
        String output = "expected: %d\tresult: %d\n";
        int[] prices00 = {1, 2, 3, 0, 2};
        System.out.format(output, 5, this.rob(prices00));
        int[] prices01 = {};
        System.out.format(output, 0, this.rob(prices01));
        int[] prices02 = {1};
        System.out.format(output, 1, this.rob(prices02));
        int[] prices03 = {1, 2, 3};
        System.out.format(output, 3, this.rob(prices03));
        int[] prices04 = {1, 2, 3, 0};
        System.out.format(output, 4, this.rob(prices04));
        int[] prices05 = {1, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 10, this.rob(prices05));
        int[] prices06 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 15, this.rob(prices06));
        int[] prices07 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 30, this.rob(prices07));
        int[] prices08 = {1, 3, 2};
        System.out.format(output, 3, this.rob(prices08));
        int[] prices09 = {1, 3, 4};
        System.out.format(output, 4, this.rob(prices09));
        int[] prices10 = {2, 3, 2};
        System.out.format(output, 3, this.rob(prices10));
        int[] prices11 = {2, 1, 1, 2};
        System.out.format(output, 3, this.rob(prices11));
        int[] prices12 = {2, 2, 4, 3, 2, 5};
        System.out.format(output, 10, this.rob(prices12));
    }
}
