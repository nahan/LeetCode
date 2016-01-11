/**
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * @author Han
 *
 */
public class Solution {
    public int maxProductDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                temp = temp * nums[j];
                max = max > temp? max: temp;
            }
        }
        return max;
    }
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            max = Math.max(max, product);
            product = nums[i] == 0? 1: product;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(max, product);
            product = nums[i] == 0? 1: product;
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {2,3,-2,4};
        System.out.println(solution.maxProduct(test));
    }
}
