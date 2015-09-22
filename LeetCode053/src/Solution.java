/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * More practice:
 * If you have figured out the O(n) solution, 
 * try coding another solution using the divide and conquer approach, which is more subtle.
 * @author Han
 *
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums == null ? 0 : nums.length == 1 ? nums[0] : 0;
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i] > nums[i]? result[i - 1] + nums[i] : nums[i];
            max = max > result[i] ? max : result[i];
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n00 = null;
        int[] n01 = {};
        int[] n02 = {1};
        int[] n03 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(n00));
        System.out.println(solution.maxSubArray(n01));
        System.out.println(solution.maxSubArray(n02));
        System.out.println(solution.maxSubArray(n03));
        
    }
}
