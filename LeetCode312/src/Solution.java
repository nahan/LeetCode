
public class Solution {
    /**************************** 312. Burst Balloons ****************************/
    /**
     * Given n balloons, indexed from 0 to n-1. 
     * Each balloon is painted with a number on it represented by array nums. 
     * You are asked to burst all the balloons. 
     * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
     * Here left and right are adjacent indices of i. After the burst, 
     * the left and right then becomes adjacent.
     * 
     * Find the maximum coins you can collect by bursting the balloons wisely.
     * Note: 
     * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
     * (2) 0 <= n <= 500, 0 <= nums[i] <= 100
     * 
     * Example:
     * Given [3, 1, 5, 8]
     * Return 167
     * 
     * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                balloons[n++] = nums[i];
            }
        }
        balloons[0] = 1;
        balloons[n++] = 1;
        int[][] maxCoins = new int[n][n];
        for (int subLength = 2; subLength < n; subLength++) {
            for (int startAt = 0; startAt < n - subLength; startAt++) {
                int endAt = startAt + subLength;
                for (int i = startAt + 1; i < endAt; i++) {
                    int currentCoins = balloons[startAt] * balloons[i] * balloons[endAt] + maxCoins[startAt][i] + maxCoins[i][endAt];
                    maxCoins[startAt][endAt] = Math.max(maxCoins[startAt][endAt], currentCoins);
                }
            }
        }
        return maxCoins[0][n - 1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testMaxCoins();
    }
    public void testMaxCoins() {
        String output = "expected: %d\tresult: %d\n";
        int[] nums = {3, 1, 5, 8};
        System.out.format(output, 167, this.maxCoins(nums));
        int[] nums00 = {1, 2, 3, 0, 2};
        System.out.format(output, 20, this.maxCoins(nums00));
        int[] nums01 = {};
        System.out.format(output, 0, this.maxCoins(nums01));
        int[] nums02 = {1};
        System.out.format(output, 1, this.maxCoins(nums02));
        int[] nums03 = {1, 2, 3};
        System.out.format(output, 12, this.maxCoins(nums03));
        int[] nums04 = {1, 2, 3, 0};
        System.out.format(output, 12, this.maxCoins(nums04));
        int[] nums05 = {1, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 68, this.maxCoins(nums05));
        int[] nums06 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 125, this.maxCoins(nums06));
        int[] nums07 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 296, this.maxCoins(nums07));
    }
}
