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
		return null;
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
