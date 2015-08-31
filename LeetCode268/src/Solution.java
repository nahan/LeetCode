import java.util.Arrays;


/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 * @author Han
 *
 */
public class Solution {
	public int missingNumber(int[] nums) {
		if (nums == null) {
			return 0;
		}
		Arrays.sort(nums);
		int pre = nums[0];
		for (int i = 1; i < nums.length; i ++) {
			if (nums[i] - pre != 1) {
				return pre + 1;
			} else {
				pre = nums[i];
			}
		}
        return nums[0] == 0 ? nums[nums.length - 1] + 1 : 0;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test = new int[100];
		
		for (int i = 0; i < test.length; i ++) {
			if (i < 50) {
				test[i] = i;
			} else {
				test[i] = i + 1;
			}
		}
		
		for (int i = 0; i < test.length; i ++) {
			System.out.print(test[i] + ", ");
		}
		System.out.println();
		
		System.out.println(solution.missingNumber(test));
	}
}
