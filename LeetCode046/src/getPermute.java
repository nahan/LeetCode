import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author Han
 *
 */
public class getPermute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 1) {
            return result;
        }
        System.out.println("how many results? " + this.resultSize(nums.length));
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
                result.add(copy);
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
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int resultSize(int n) {
        if (n < 2) {
            return 1;
        } else {
            return n * this.resultSize(n - 1);
        }
    }
    public void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        getPermute solution = new getPermute();
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
