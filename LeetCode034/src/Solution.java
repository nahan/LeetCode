
public class Solution {
    public int searchFirst(int[] array, int target, int start, int end) {
        if (array[start] == target) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] >= target) {
            return start == end? array[mid] == target? start: -1: this.searchFirst(array, target, start, mid);
        } else if (array[mid] < target) {
            return this.searchFirst(array, target, mid + 1, end);
        }
        return -1;
    }
    public int searchLast(int[] array, int target, int start, int end) {
        if (array[end] == target) {
            return end;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] > target) {
            return start == end? -1: this.searchLast(array, target, start, mid - 1);
        } else if (array[mid] <= target) {
            return start == end? array[mid] == target? start: -1: this.searchLast(array, target, mid, end - 1);
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return result;
        } 
        result[0] = this.searchFirst(nums, target, 0, nums.length - 1);
        result[1] = this.searchLast(nums, target, 0, nums.length - 1);
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 8, 89};
        int[] result = solution.searchRange(array, 8);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
