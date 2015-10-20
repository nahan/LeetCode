import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * 
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * @author Han
 *
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = this.doCombine(1, k, n);
        return result != null ? result : new ArrayList<List<Integer>>();
    }
    public List<List<Integer>> doCombine(int start, int num, int sum) {
        if (sum < this.sum(num - 1) + num * start) {
            return null;
        } else if (num == 1) {
            if (sum >= start && sum <= 9) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(sum);
                List<List<Integer>> result = new ArrayList<List<Integer>>();
                result.add(item);
                return result;
            } else {
                return null;
            }
        } else {
            List<List<Integer>> subResult = this.doCombine(start + 1, num - 1, sum - start);
            List<List<Integer>> result1 = subResult != null ? this.addHead(start, subResult) : null;
            List<List<Integer>> result2 = this.doCombine(start + 1, num, sum);
            if (result1 != null) {
                return result2 != null ? this.concatenateLists(result1, result2) : result1;
            } else {
                return result2 != null ? result2 : null;
            }
        }
    }
    public int sum(int n) {
        return (n * (n + 1)) / 2;
    }
    public List<List<Integer>> addHead(int head, List<List<Integer>> list) {
        for (List<Integer> item: list) {
            item.add(0, head);
        }
        return list;
    }
    public List<List<Integer>> concatenateLists(List<List<Integer>> list1, List<List<Integer>> list2) {
        for (List<Integer> item: list2) {
            list1.add(item);
        }
        return list1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 7));
        System.out.println(solution.combinationSum3(3, 9));
        System.out.println(solution.combinationSum3(2, 18));
    }
}
