import java.util.ArrayList;
import java.util.List;


/**
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */
public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[] array00 = {2,3,6,7};
		int target00 = 7;
		System.out.println(solution.combinationSum(array00, target00));
		
		int[] array01 = null;
		int target01 = 7;
		System.out.println(solution.combinationSum(array01, target01));
		
		int[] array02 = {1};
		int target02 = 0;
		System.out.println(solution.combinationSum(array02, target02));
		
		int[] array03 = {};
		int target03 = 7;
		System.out.println(solution.combinationSum(array03, target03));
	}
}
