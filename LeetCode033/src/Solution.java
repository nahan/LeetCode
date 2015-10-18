/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * @author Han
 *
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return nums == null? -1 : nums.length == 1? nums[0] == target? 0 : -1 : -1;
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
    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start == end && nums[start] != target) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
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
