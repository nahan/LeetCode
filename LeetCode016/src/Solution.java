import java.util.Arrays;


/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return target;
		}
		Arrays.sort(nums);
		int index = 0;
		
		int closest = nums[0] + nums[1] + nums[nums.length - 1];
		int minGap;
		if (closest == target) {
			minGap = 0;
		} else if (closest > target) {
			minGap = closest - target;
		} else {
			minGap = target - closest;
		}
		
		while (index < nums.length - 2) {
			
			int front = index + 1;
			int tail = nums.length - 1;
			
			while (front < tail) {
				if (nums[index] + nums[front] + nums[tail] == target) {
					minGap = 0;
					closest = target;
					return closest;
				} else if (nums[index] + nums[front] + nums[tail] < target) {
					int temp = target - (nums[index] + nums[front] + nums[tail]);
					if (temp < minGap) {
						minGap = temp;
						closest = nums[index] + nums[front] + nums[tail];
					}
					front ++;
				} else {
					int temp = (nums[index] + nums[front] + nums[tail]) - target;
					if (temp < minGap) {
						minGap = temp;
						closest = nums[index] + nums[front] + nums[tail];
					}
					tail --;
				}
			}
			index ++;
		}
		return closest;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test00 = null;
		int[] test01 = {};
		int[] test02 = {1};
		int[] test03 = {1, 2};
		int[] test04 = {1, 2, 3};
		int[] test05 = {-1, 0, 1, 2, -1, -4};
		int[] test06 = {-1, 0, 1, 2, -1, -2};
		int[] test07 = {-5, 0, 5, 2, -1, -2};
		int[] test08 = {0, 0, 0, 0, 0, 0};		
		int[] test09 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		int[] test10 = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0,0,0};
		int[] test11 = {-2,-3,0,0,-2};
		int[] test12 = {-1, 2, 1, -4};
		int[] test13 = {1,1,1,0};
		
		System.out.println(solution.threeSumClosest(test00, 1));
		System.out.println(solution.threeSumClosest(test01, 1));
		System.out.println(solution.threeSumClosest(test02, 1));
		System.out.println(solution.threeSumClosest(test03, 1));
		System.out.println("6 : " + solution.threeSumClosest(test04, 1));
		System.out.println("1 : " + solution.threeSumClosest(test05, 1));
		System.out.println("1 : " + solution.threeSumClosest(test06, 1));
		System.out.println("1 : " + solution.threeSumClosest(test07, 1));
		System.out.println("0 : " + solution.threeSumClosest(test08, 1));
		System.out.println("0, 1 : " + solution.threeSumClosest(test09, 1));
		System.out.println("0, 1 : " + solution.threeSumClosest(test10, 1));
		System.out.println("-2 : " + solution.threeSumClosest(test11, 1));
		System.out.println("2 : " + solution.threeSumClosest(test12, 1));
		System.out.println("2 : " + solution.threeSumClosest(test13, -100));
		
	}
}
