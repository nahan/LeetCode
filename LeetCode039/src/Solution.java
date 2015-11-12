import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */
public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) {
		    return new ArrayList<List<Integer>>();
		}
		Arrays.sort(candidates);
		return this.doCombine(candidates, target, 0);
	}
	public List<List<Integer>> doCombine(int[] candidates, int target, int start) {
	    if (start >= candidates.length || candidates[start] > target) {
	        return new ArrayList<List<Integer>>();
	    } else if (candidates[start] == target) {
	        List<Integer> subResult = new ArrayList<Integer>();
	        subResult.add(candidates[start]);
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        result.add(subResult);
	        return result;
	    } else {
	        List<List<Integer>> result1 = this.doCombine(candidates, target - candidates[start], start);
	        List<List<Integer>> result2 = this.doCombine(candidates, target, start + 1);
	        if (result1.size() != 0) {
	            this.addHead(result1, candidates[start]);
	        }
	        return this.merge(result1, result2);
	    }
	}
	public void addHead(List<List<Integer>> list, int item) {
	    Iterator<List<Integer>> it = list.iterator();
	    while (it.hasNext()) {
	        List<Integer> cur = it.next();
	        cur.add(0, item);
	    }
	}
	public List<List<Integer>> merge(List<List<Integer>> list1, List<List<Integer>> list2) {
	    if (list1.size() == 0 || list2.size() == 0) {
	        if (list1.size() == 0 && list2.size() == 0) {
	            return new ArrayList<List<Integer>>();
	        }
	        return list1.size() == 0? list2: list1;
	    }
	    list1.addAll(list2);
	    return list1;
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
