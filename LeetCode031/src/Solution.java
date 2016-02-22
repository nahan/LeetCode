public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0) {
                if (nums[j] > nums[i]) {
                    break;
                }
                j--;
            }
            this.swap(nums, i, j);
            this.reverse(nums, i + 1, nums.length - 1);
        } else {
            this.reverse(nums, 0, nums.length - 1);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start, int end) {
        if (start < end) {
            this.swap(nums, start, end);
            this.reverse(nums, start + 1, end - 1);
        }
    }
    public void print(int[] nums) {
        for (int item: nums) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = {1, 2, 3};
        int[] a1 = {3, 2, 1};
        int[] a2 = {1, 1, 5};
        solution.print(a0);
        solution.print(a1);
        solution.print(a2);
        System.out.println("**********************");
        solution.nextPermutation(a0);
        solution.nextPermutation(a1);
        solution.nextPermutation(a2);
        solution.print(a0);
        solution.print(a1);
        solution.print(a2);
        System.out.println("**********************");
        solution.nextPermutation(a0);
        solution.nextPermutation(a1);
        solution.nextPermutation(a2);
        solution.print(a0);
        solution.print(a1);
        solution.print(a2);
        System.out.println("**********************");
    }
}
