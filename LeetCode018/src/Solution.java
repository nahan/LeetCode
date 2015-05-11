import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i ++) {
			for (int j = i + 1; j < nums.length - 2; j ++) {
				int head = j + 1;
				int tail = nums.length - 1;
				while (head < tail) {
					int tempSum = nums[i] + nums[j] + nums[head] + nums[tail];
					if (tempSum == target) {
						List<Integer> item = new ArrayList<Integer>();
						item.add(nums[i]);
						item.add(nums[j]);
						item.add(nums[head]);
						item.add(nums[tail]);
						if (result.contains(item) == false) {
							result.add(item);
						} 
						head ++;
						tail --;
					} else if (tempSum < target) {
						head ++;
					} else {
						tail --;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test00 = null;
		int[] test01 = {};
		int[] test02 = {1};
		int[] test03 = {1, 2};
		int[] test04 = {1, 2, 3};
		int[] test05 = {-1, 0, 1, 2, -1, -4};
		int[] test06 = {-1, 2, 1, -4};
		int[] test07 = {1, 0, -1, 0, -2, 2};
		int[] test08 = {-3,-2,-1,0,0,1,2,3};
		int[] test09 = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
		
		System.out.println(solution.fourSum(test00, 1));
		System.out.println(solution.fourSum(test01, 1));
		System.out.println(solution.fourSum(test02, 1));
		System.out.println(solution.fourSum(test03, 1));
		System.out.println(solution.fourSum(test04, 1));
		System.out.println(solution.fourSum(test05, 1));
		System.out.println(solution.fourSum(test06, 1));
		System.out.println(solution.fourSum(test07, 0));
		System.out.println(solution.fourSum(test08, 0));
		System.out.println(solution.fourSum(test09, 0));
	}
}
