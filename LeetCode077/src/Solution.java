import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @author Han
 *
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return new ArrayList<List<Integer>>();
        }
        return doCombine(1, n, k);
    }
    public List<List<Integer>> doCombine(int head, int n, int k) {
        if (k == 0) {
            List<Integer> item = new ArrayList<Integer>();
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(item);
            return result;
        }
        if (k == 1) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int i = head; i <= n; i++) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(i);
                result.add(item);
            }
            return result;
        } else if (k == (n - head + 1)) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> item = new ArrayList<Integer>();
            for (int i = head; i <=n; i++) {
                item.add(i);
            }
            result.add(item);
            return result;
        } else {
            return this.concatenateList(this.addHead(head, this.doCombine(head + 1, n, k - 1)), this.doCombine(head + 1, n, k));
        }
    }
    public List<List<Integer>> addHead(int head, List<List<Integer>> list) {
        for (List<Integer> item: list) {
            item.add(0, head);
        }
        return list;
    }
    public List<List<Integer>> concatenateList(List<List<Integer>> list1, List<List<Integer>> list2) {
        for (List<Integer> item: list2) {
            list1.add(item);
        }
        return list1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("\nfinal result: " + solution.combine(5, 4));
    }
}
