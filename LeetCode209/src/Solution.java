
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= s? 1: 0;
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = nums[start];
        while (start < nums.length && end < nums.length) {
            if (sum == s) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start += 1;
                end += 1;
                if (end < nums.length) {
                    sum += nums[end];
                }
            } else if (sum < s) {
                end += 1;
                if (end < nums.length) {
                    sum += nums[end];
                }
            } else {
                min = Math.min(min, end - start + 1);
                if (start < end) {
                    sum -= nums[start];
                    start += 1;
                } else {
                    end += 1;
                    if (end < nums.length) {
                        sum += nums[end];
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE? 0: min;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(11, a));
    }
}
