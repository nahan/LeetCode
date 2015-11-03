/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], 
 * therefore the length is 4. Note that there may be more than one LIS combination, 
 * it is only necessary for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 * @author Han
 *
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length == 0 ? 0 : 1;
        }
        int[] lis = new int[nums.length];
        int end = 0;
        lis[end] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lis[end]) {
                end++;
                lis[end] = nums[i];
            } else {
                int pos = this.findFirstLarger(lis, 0, end, nums[i]);
                lis[pos] = nums[i];
            }
        }
        return end + 1;
    }
    public int findFirstLarger(int[] nums, int start, int end, int target) {
        if (start == end) {
            return start;
        } else {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                return this.findFirstLarger(nums, mid + 1, end, target);
            } else {
                return this.findFirstLarger(nums, start, mid, target);
            }
        }
    }
    public void printArray(int[] nums) {
        if (nums == null) {
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n00 = null;
        int[] n01 = {};
        int[] n02 = {1};
        int[] n03 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] n04 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] n05 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] n06 = {1, 9, 2, 190, 3, 7, 101, 18, 19, 20, 21};
        int[] n07 = {1, 9, 2, 190, 3, 7, 101, 102, 103, 104, 105, 18, 19, 20, 21};
        int[] n08 = {1, 9, 2, 190, 3, 7, 101, 102, 103, 104, 105, 18, 19, 20, 21, 22, 23};
        int[] n09 = {3,5,6,2,5,4,19,5,6,7,12};
        
        solution.printArray(n00);
        System.out.println(solution.lengthOfLIS(n00) + "\n");
        solution.printArray(n01);
        System.out.println(solution.lengthOfLIS(n01) + "\n");
        solution.printArray(n02);
        System.out.println(solution.lengthOfLIS(n02) + "\n");
        solution.printArray(n03);
        System.out.println(solution.lengthOfLIS(n03) + "\n");
        solution.printArray(n04);
        System.out.println(solution.lengthOfLIS(n04) + "\n");
        solution.printArray(n05);
        System.out.println(solution.lengthOfLIS(n05) + "\n");
        solution.printArray(n06);
        System.out.println(solution.lengthOfLIS(n06) + "\n");
        solution.printArray(n07);
        System.out.println(solution.lengthOfLIS(n07) + "\n");
        solution.printArray(n08);
        System.out.println(solution.lengthOfLIS(n08) + "\n");
        solution.printArray(n09);
        System.out.println(solution.lengthOfLIS(n09) + "\n");
    }
}
