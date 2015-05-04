
/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		return 0;
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
		
		System.out.println(solution.threeSumClosest(test00, 1));
		System.out.println(solution.threeSumClosest(test01, 1));
		System.out.println(solution.threeSumClosest(test02, 1));
		System.out.println(solution.threeSumClosest(test03, 1));
		System.out.println(solution.threeSumClosest(test04, 1));
		System.out.println(solution.threeSumClosest(test05, 1));
		System.out.println(solution.threeSumClosest(test06, 1));
		
	}
}
