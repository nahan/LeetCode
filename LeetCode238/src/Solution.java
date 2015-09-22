
/**
 * Given an array of n integers where n > 1, nums, return an array output such that 
 * output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * Could you solve it with constant space complexity? 
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * @author Han
 *
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            result[i] *= right;
        }
        return result;
    }
    public void printArray(int[] nums) {
        if (nums == null) {
            System.out.println("Empty array.");
            return;
        }
        for (int item: nums) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n00 = null;
        int[] n01 = {};
        int[] n02 = {1};
        int[] n03 = {1, 2};
        int[] n04 = {1, 2, 3};
        int[] n05 = {1, 2, 3, 4};
        int[] n06 = {1, 2, 3, 4, 0};
        
        solution.printArray(n00);
        solution.printArray(solution.productExceptSelf(n00));
        solution.printArray(n01);
        solution.printArray(solution.productExceptSelf(n01));
        solution.printArray(n02);
        solution.printArray(solution.productExceptSelf(n02));
        solution.printArray(n03);
        solution.printArray(solution.productExceptSelf(n03));
        solution.printArray(n04);
        solution.printArray(solution.productExceptSelf(n04));
        solution.printArray(n05);
        solution.printArray(solution.productExceptSelf(n05));
        solution.printArray(n06);
        solution.printArray(solution.productExceptSelf(n06));
    }
}
