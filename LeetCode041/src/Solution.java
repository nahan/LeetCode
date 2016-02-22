
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1) {
                int temp = nums[nums[i] - 1];
                if (temp == nums[i]) {
                    break;
                } else {
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
            i++;
        }
        return i + 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = {1, 2, 0};
        int[] a1 = {3, 4, -1, 1};
        int[] a2 = null;
        int[] a3 = {1};
        int[] a4 = {6, 7, 8, 9};
        int[] a5 = {1, 1};
        System.out.println("expected: 3, result: " + solution.firstMissingPositive(a0));
        System.out.println("expected: 2, result: " + solution.firstMissingPositive(a1));
        for (int i: a1) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("expected: 1, result: " + solution.firstMissingPositive(a2));
        System.out.println("expected: 2, result: " + solution.firstMissingPositive(a3));
        System.out.println("expected: 1, result: " + solution.firstMissingPositive(a4));
        System.out.println("expected: 2, result: " + solution.firstMissingPositive(a5));
    }
}
