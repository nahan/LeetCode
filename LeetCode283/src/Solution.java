/**
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], 
 * after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * @author Han
 *
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                num++;
                continue;
            }
            nums[i - num] = nums[i];
        }
        for (int i = 1; i <= num; i++) {
            nums[nums.length - i] = 0;
        }
    }
    public void print(int[] nums) {
        for (int i = 0; nums != null && i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a00 = null;
        int[] a01 = {1};
        int[] a02 = {1, 0};
        int[] a03 = {0, 1};
        int[] a04 = {0, 1, 0, 3, 12};
        int[] a05 = {1, 0, 3, 12};
        int[] a06 = {0, 1, 3, 12};
        int[] a07 = {0, 0, 0, 1};
        
        solution.print(a00);
        solution.moveZeroes(a00);
        solution.print(a00);
        
        solution.print(a01);
        solution.moveZeroes(a01);
        solution.print(a01);
        
        solution.print(a02);
        solution.moveZeroes(a02);
        solution.print(a02);
        
        solution.print(a03);
        solution.moveZeroes(a03);
        solution.print(a03);
        
        solution.print(a04);
        solution.moveZeroes(a04);
        solution.print(a04);
        
        solution.print(a05);
        solution.moveZeroes(a05);
        solution.print(a05);
        
        solution.print(a06);
        solution.moveZeroes(a06);
        solution.print(a06);
        
        solution.print(a07);
        solution.moveZeroes(a07);
        solution.print(a07);
    }
}
