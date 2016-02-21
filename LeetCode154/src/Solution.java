
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return this.find(nums, 0, nums.length - 1);
    }
    public int find(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        return Math.min(this.find(nums, start, mid), this.find(nums, mid + 1, end));
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] array = {4, 5, 6, 7, 0, 1, 2};
//        int[] array = {3, 3, 4, 4, 4, 1, 2, 3};
//        int[] array = {3, 3, 3, 3, 1, 2, 3};
        int[] array = {3, 4, 5, 3, 3, 3, 3};
        System.out.println(solution.findMin(array));
    }

}
