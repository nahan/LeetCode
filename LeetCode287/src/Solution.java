
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        System.out.println(solution.findDuplicate(input));
    }
}
