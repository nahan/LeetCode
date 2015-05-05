import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) {
			return null;
		}
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int front = 0;
		int tail = nums.length - 1;
		while (front + 1 != tail) {
			int target = (-1) * (nums[front] + nums[tail]);
			if (target > nums[tail]) {
				front ++;
			} else if (target < nums[front]) {
				tail --;
			}
			if (hasTarget(nums, front + 1, tail - 1, target) == true) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(nums[front]);
				temp.add(target);
				temp.add(nums[tail]);
				result.add(temp);
			}
		}
		return null;
	}
	public boolean hasTarget(int[] array, int start, int end, int target) {
		int mid = start + (end - start) / 2;
		if (start > end) {
			return false;
		}
		if (array[mid] == target) {
			return true;
		} else if (array[mid] > target) {
			return hasTarget(array, start, mid - 1, target);
		} else {
			return hasTarget(array, mid + 1, end, target);
		}
	}
	public int searchInt(int[] array, int start, int end, int target) {
		return 0;
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
		
		System.out.println(solution.threeSum(test00));
		System.out.println(solution.threeSum(test01));
		System.out.println(solution.threeSum(test02));
		System.out.println(solution.threeSum(test03));
		System.out.println(solution.threeSum(test04));
		System.out.println(solution.threeSum(test05));
		
	}
}
