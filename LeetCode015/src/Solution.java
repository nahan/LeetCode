import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		if (nums[0] > 0 || nums[nums.length - 1] < 0) {
			return result;
		}
		if (onlyZero(nums) == true) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(0);
			temp.add(0);
			temp.add(0);
			result.add(temp);
			return result;
		}
		int index = 0;
		while (index < nums.length - 2 && nums[index] <= 0) {
			if (result.size() != 0 && index > 0 && nums[index] == nums[index - 1]) {
				index ++;
				continue;
			}
			int front = index + 1;
			int tail = nums.length - 1;
			while (front < tail) {
				if (nums[front] + nums[tail] == nums[index] * (-1)) {
					if (result.size() != 0 && 
							result.get(result.size() - 1).get(0) == nums[index] && 
							result.get(result.size() - 1).get(1) == nums[front] && 
							result.get(result.size() - 1).get(2) == nums[tail]) {
						front ++;
						tail --;
					} else {
						List<Integer> item = new ArrayList<Integer>();
						item.add(nums[index]);
						item.add(nums[front]);
						item.add(nums[tail]);
						result.add(item);
						front ++;
						tail --;
					}
				} else if (nums[front] + nums[tail] < nums[index] * (-1)) {
					front ++;
				} else {
					tail --;
				}
			}
			index ++;
		}
		return result;
	}
	public boolean onlyZero(int[] array) {
		for (int item: array) {
			if (item != 0) {
				return false;
			}
		}
		return true;
	}
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		if (nums[0] > 0 || nums[nums.length - 1] < 0) {
			return result;
		}
		int mid = 1;
		while (mid < nums.length - 1) {
			int front = 0;
			int tail = nums.length - 1;
			while (front < mid && tail > mid) {
				if (nums[front] + nums[tail] == nums[mid] * (-1)) {
					if (result.size() != 0 && 
							result.get(result.size() - 1).get(0) == nums[front] && 
							result.get(result.size() - 1).get(1) == nums[mid] && 
							result.get(result.size() - 1).get(2) == nums[tail]) {
						break;
					}
					List<Integer> item = new ArrayList<Integer>();
					item.add(nums[front]);
					item.add(nums[mid]);
					item.add(nums[tail]);
					result.add(item);
					front ++;
					tail --;
				} else if (nums[front] + nums[tail] < nums[mid] * (-1)) {
					front ++;
				} else {
					tail --;
				}
			}
			mid ++;
		}
		return result;
	}
	public void printArray(int[] array) {
		for (int item: array) {
			System.out.print(item + ", ");
		}
		System.out.println();
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
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++ pick up first one first");
		System.out.println(solution.threeSum(test00));
		System.out.println(solution.threeSum(test01));
		System.out.println(solution.threeSum(test02));
		System.out.println(solution.threeSum(test03));
		System.out.println(solution.threeSum(test04));
		System.out.println(solution.threeSum(test05));
		System.out.println(solution.threeSum(test06));
		System.out.println(solution.threeSum(test07));
		System.out.println(solution.threeSum(test08));
		System.out.println(solution.threeSum(test09));
		System.out.println(solution.threeSum(test10));
		System.out.println(solution.threeSum(test11));

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++ pick up middle one first");
		System.out.println(solution.threeSum2(test00));
		System.out.println(solution.threeSum2(test01));
		System.out.println(solution.threeSum2(test02));
		System.out.println(solution.threeSum2(test03));
		System.out.println(solution.threeSum2(test04));
		System.out.println(solution.threeSum2(test05));
		System.out.println(solution.threeSum2(test06));
		System.out.println(solution.threeSum2(test07));
		System.out.println(solution.threeSum2(test08));
		System.out.println(solution.threeSum2(test09));
		System.out.println(solution.threeSum2(test10));
		System.out.println(solution.threeSum2(test11));
		
	}
}
