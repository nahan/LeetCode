/**
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 
 * 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * @author Han
 *
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        this.doSort(nums, 0, nums.length - 1);
    }
    public void doSort(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        int mid = start + (end - start) / 2;
        int first = start;
        int second = end;
        
        if (start != end) {
            this.doSort(nums, start, mid);
            this.doSort(nums, mid + 1, end);
        }
        
        while (first != mid && second != mid) {
            if (nums[first] <= nums[mid] && nums[mid] <= nums[second]) {
                first++;
                second--;
                continue;
            }
            if (nums[first] <= nums[mid] && nums[mid] >= nums[second]) {
                if (nums[first] < nums[second]) {
                    this.swap(nums, mid, second);
                    second--;
                } else {
                    this.swap(nums, first, second);
                    this.swap(nums, mid, second);
                    first++;
                    second--;
                }
                continue;
            }
            if (nums[first] >= nums[mid] && nums[mid] <= nums[second]) {
                if (nums[first] < nums[second]) {
                    this.swap(nums, mid, first);
                    first++;
                } else {
                    this.swap(nums, first, second);
                    this.swap(nums, mid, first);
                    first++;
                    second--;
                }
                continue;
            }
            if (nums[first] >= nums[mid] && nums[mid] >= nums[second]) {
                this.swap(nums, first, second);
                first++;
                second--;
                continue;
            }
        }
        
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
    public void print(String s, int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("Empty array.");
            return;
        }
        System.out.print(s);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n00 = null;
        int[] n01 = {};
        int[] n02 = {1};
        int[] n03 = {0, 1, 2, 0, 2, 1, 0, 2};
        
        solution.print("before: ", n00);
        solution.sortColors(n00);
        solution.print("after: ", n00);
        
        solution.print("before: ", n01);
        solution.sortColors(n01);
        solution.print("after: ", n01);
        
        solution.print("before: ", n02);
        solution.sortColors(n02);
        solution.print("after: ", n02);
        
        solution.print("before: ", n03);
        solution.sortColors(n03);
        solution.print("after: ", n03);
    }
}
