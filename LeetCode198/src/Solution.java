/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is 
 * that adjacent houses have security system connected 
 * and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * @author Han
 *
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] stolen = new int[nums.length + 1];
        stolen[0] = 0;
        stolen[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] + stolen[i - 1]) > stolen[i]) {
                stolen[i + 1] = stolen[i - 1] + nums[i];
            } else {
                stolen[i + 1] = stolen[i];
            }
        }
        return stolen[stolen.length - 1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums00 = null;
        int[] nums01 = {};
        int[] nums02 = {1};
        int[] nums03 = {1, 2};
        int[] nums04 = {1, 2, 3};
        int[] nums05 = {1, 2, 3, 4, 5, 6};
        int[] nums06 = {1, 2, 5, 3, 4, 5, 6};
        int[] nums07 = {1, 2, 5, 3, 5, 7, 6};
        System.out.println(solution.rob(nums00));
        System.out.println(solution.rob(nums01));
        System.out.println(solution.rob(nums02));
        System.out.println(solution.rob(nums03));
        System.out.println(solution.rob(nums04));
        System.out.println(solution.rob(nums05));
        System.out.println(solution.rob(nums06));
        System.out.println(solution.rob(nums07));
    }
}
