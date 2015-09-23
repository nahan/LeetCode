/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] != num[i+1], 
 * find a peak element and return its index.
 * 
 * The array may contain multiple peaks, 
 * in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -...
 * 
 * For example, in array [1, 2, 3, 1], 
 * 3 is a peak element and your function should return the index number 2.
 * @author Han
 *
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return this.doFind(nums, 0, nums.length - 1, nums.length);
    }
    public int doFind(int[] nums, int start, int end, int length) {
        int mid = start + (end - start) / 2;
        if (mid <= 0) {
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                return this.doFind(nums, mid + 1, end, length);
            }
        } else if (mid >= length - 1) {
            if (nums[mid] > nums[mid - 1]) {
                return mid;
            } else {
                return this.doFind(nums, start, mid - 1, length);
            }
        } else {
            if (nums[mid] > nums[mid + 1]) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    return this.doFind(nums, start, mid - 1, length);
                }
            } else {
                return this.doFind(nums, mid + 1, end, length);
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t00 = {1, 2};
        System.out.println(solution.findPeakElement(t00));
    }
}
