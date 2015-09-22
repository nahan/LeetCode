/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * @author Han
 *
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        return this.findMin(nums, 0, nums.length - 1);
    }
    public int findMin(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[end]) {
            return this.findMin(nums, mid + 1, end);
        } else if (nums[mid] < nums[end]){
            return this.findMin(nums, start, mid);
        } else {
            return nums[mid];
        }
    }
    public int findMin0(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums == null ? 0 : nums.length == 1 ? nums[0] : 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n00 = null;
        int[] n01 = {};
        int[] n02 = {1};
        int[] n03 = {4, 5, 6, 7, 0, 1, 2};
        int[] n04 = {-2, 1, 2, 3, 4, 5, 6};
        System.out.println(solution.findMin(n00));
        System.out.println(solution.findMin(n01));
        System.out.println(solution.findMin(n02));
        System.out.println(solution.findMin(n03));
        System.out.println(solution.findMin(n04));
    }
}
