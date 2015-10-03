import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author Han
 *
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 2) {
            return result;
        }
        System.out.println("how many results? " + this.resultSize(nums.length));
        HashSet<Integer> notAvailable = new HashSet<Integer>();
        int i = 0;
        List<Integer> track = new ArrayList<Integer>();
        while (i < nums.length) {
            track.add(i);
            notAvailable.add(i);
            for (int j = 0; j < nums.length; j++) {
                if (!notAvailable.contains(nums[j])) {
                    track.add(j);
                    notAvailable.add(j);
                }
            }
            
        }
        return result;
    }
    public int resultSize(int n) {
        if (n < 2) {
            return 1;
        } else {
            return n * this.resultSize(n - 1);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums00 = null;
        int[] nums01 = {};
        int[] nums02 = {1};
        int[] nums03 = {1, 2, 3};
        int[] nums04 = {1, 2, 3, 4};
        int[] nums05 = {1, 2, 3, 4, 5};
        
        System.out.println(solution.permute(nums00));
        System.out.println(solution.permute(nums01));
        System.out.println(solution.permute(nums02));
        System.out.println(solution.permute(nums03));
        System.out.println(solution.permute(nums04));
        System.out.println(solution.permute(nums05));
    }
}
