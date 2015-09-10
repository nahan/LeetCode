
/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
 * is rotated to [5,6,7,1,2,3,4].
 * @author Han
 *
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k % nums.length == 0) {
            return;
        }
        int len = k % nums.length;
        for (int i = 1; i <= len; i++) {
            this.rotate(nums);
        }
    }
    public void rotate(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = temp;
        }
    }
    public void print(int[] a) {
        if (a == null) {
            System.out.println("null.");
            return ;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }
    public void test(int[] nums, int k) {
        System.out.print("Before: ");
        this.print(nums);
        this.rotate(nums, k);
        System.out.print("After: ");
        this.print(nums);
    }
    public static void main(String[] args) {
        
        Solution solution = new Solution();
        int[] a00 = null;
        int[] a01 = {};
        int[] a02 = {1};
        int[] a03 = {1, 2};
        int[] a04 = {1, 2, 3};
        int[] a05 = {1, 2, 3, 4};
        int[] a06 = {1, 2, 3, 4, 5, 6};
        int[] a07 = {1, 2, 3, 4, 5, 6, 7};
        
        solution.test(a00, 1);
        solution.test(a01, 1);
        solution.test(a02, 1);
        solution.test(a03, 0);
        solution.test(a04, 1);
        solution.test(a05, 3);
        solution.test(a06, 6);
        solution.test(a07, 1332);
    }
}
