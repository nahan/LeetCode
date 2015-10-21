import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * @author Han
 *
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            result = this.combineList(result, this.findSubsets(nums, i, 0));
        }
        result.add(new ArrayList<Integer>());
        return result;
    }
    public List<List<Integer>> findSubsets(int[] nums, int n, int start) {
        if (n == 1) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int i = start; i < nums.length; i++) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(nums[i]);
                result.add(item);
            }
            return result;
        } else if (nums.length - start == n) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> item = new ArrayList<Integer>();
            for (int i = start; i < nums.length; i++) {
                item.add(nums[i]);
            }
            result.add(item);
            return result;
        } else {
            return this.combineList(this.addHead(this.findSubsets(nums, n - 1, start + 1), nums[start]), this.findSubsets(nums, n, start + 1));
        }
    }
    public List<List<Integer>> addHead(List<List<Integer>> list, int head) {
        for (List<Integer> item: list) {
            item.add(0, head);
        }
        return list;
    }
    public List<List<Integer>> combineList(List<List<Integer>> list0, List<List<Integer>> list1) {
        for (List<Integer> item: list1) {
            list0.add(item);
        }
        list1 = null;
        return list0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n00 = null;
        int[] n01 = {};
        int[] n02 = {1, 2, 3, 4, 5};
        
        System.out.println(solution.subsets(n00));
        System.out.println(solution.subsets(n01));
        System.out.println(solution.subsets(n02));
    }
}
