import java.util.ArrayList;
import java.util.List;
/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * @author Han
 *
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 1) {
            return result;
        }
        result = this.getPermuteLists(nums, 0, nums.length - 1);
        return result;
    }
    public List<List<Integer>> getPermuteLists(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (start == end) {
            List<Integer> item = new ArrayList<Integer>();
            item.add(nums[start]);
            result.add(item);
        } else {
            result = concatenate(nums[start], getPermuteLists(nums, start + 1, end));
        }
        return result;
    }
    public List<List<Integer>> concatenate(int num, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> item: lists) {
            for (int i = 0; i <= item.size(); i++) {
                List<Integer> copy = this.copyList(item);
                copy.add(i, num);
                if (!result.contains(copy)) {
                    result.add(copy);
                }
            }
        }
        return result;
    }
    public List<Integer> copyList(List<Integer> list) {
        List<Integer> copy = new ArrayList<Integer>();
        for (Integer item: list) {
            copy.add(new Integer(item.intValue()));
        }
        return copy;
    }
}