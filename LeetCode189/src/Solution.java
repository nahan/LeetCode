
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
        int[] temp = new int[nums.length];
        int k1 = k % nums.length;
        for (int i = nums.length - k1; i < nums.length; i++) {
            temp[i - (nums.length - k1)] = nums[i];
        }
        for (int i = 0; i < nums.length - k1; i ++) {
            temp[i + k1] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
    public void rotate0(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k % nums.length == 0) {
            return;
        }
        int index = 0;
        int pre = nums[index];
        int temp = 0;
        for (int i = 1; i <= nums.length; i++) {
            int next = (index + k) % nums.length;
            temp = nums[next];
            nums[next] = pre;
            pre = temp;
            index = next;
            this.print(nums);
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
        System.out.print("Original: ");
        this.print(nums);
        this.rotate(nums, k);
        System.out.print("Output: ");
        this.print(nums);
        System.out.println();
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
        int[] a08 = {1, 2, 3, 4, 5, 6};
        
        System.out.println("Expect: null");
        solution.test(a00, 1);
        
        System.out.println("Expect: ");
        solution.test(a01, 1);
        
        System.out.println("Expect: 1, ");
        solution.test(a02, 1);
        
        System.out.println("Expect: 1, 2");
        solution.test(a03, 0);
        
        System.out.println("Expect: 3, 1, 2");
        solution.test(a04, 1);
        
        System.out.println("Expect: 2, 3, 4, 1");
        solution.test(a05, 3);
        
        System.out.println("Expect: 1, 2, 3, 4, 5, 6");
        solution.test(a06, 6);
//        
        System.out.println("Expect: 5, 6, 7, 1, 2, 3, 4");
        solution.test(a07, 3);
        
        System.out.println("Expect: 5, 6, 1, 2, 3, 4");
        solution.test(a08, 2);
    }
}
