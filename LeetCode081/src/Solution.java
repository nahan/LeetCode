/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * @author Han
 *
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return nums == null? false : nums.length == 1? nums[0] == target? true : false : false;
        }
        int pivot = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                pivot = i;
                break;
            }
        }
        if (pivot == 0) {
            return this.binarySearch(nums, 0, nums.length - 1, target);
        }
        if (target >= nums[0]) {
            return this.binarySearch(nums, 0, pivot - 1, target);
        } else {
            return this.binarySearch(nums, pivot, nums.length - 1, target);
        }
    }
    public boolean binarySearch(int[] nums, int start, int end, int target) {
        if (start == end && nums[start] != target) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            return this.binarySearch(nums, mid + 1, end, target);
        } else {
            return this.binarySearch(nums, start, mid, target);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a00 = null;
        int[] a01 = {};
        int[] a02 = {1};
        int[] a03 = {4, 5, 6, 7, 0, 1, 2};
        int[] a04 = {6, 7, 0, 1, 2, 3, 4};
        int[] a05 = {1, 3, 0};
        
        System.out.println(solution.search(a00, 0));
        System.out.println(solution.search(a01, 0));
        System.out.println(solution.search(a02, 1));
        System.out.println(solution.search(a03, 0));
        System.out.println(solution.search(a04, 7));
        System.out.println(solution.search(a05, 0));
    }
}
