import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubsetProblems {
    /**************************** Subsets ****************************/
    /**
     * Given a set of distinct integers, nums, 
     * return all possible subsets.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(nums);
        this.backtrackSubsets(0, nums, item, result);
        return result;
    }
    public void backtrackSubsets(int i, int[] nums, List<Integer> item, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(item));
        for (int index = 0; index < nums.length; index++) {
            if (this.valid(i, item, nums[index])) {
                item.add(i, nums[index]);
                this.backtrackSubsets(i + 1, nums, item, result);
                item.remove(i);
            }
        }
    }
    public boolean valid(int i, List<Integer> list, int value) {
        return i == 0? true: list.get(i - 1) < value? true: false;
    }
    /**************************** Subsets II ****************************/
    /**
     * Given a collection of integers that might contain duplicates, nums, 
     * return all possible subsets.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(nums);
        this.backtrackSubsetsWithDup(0, 0, nums, item, result);
        return result;
    }
    public void backtrackSubsetsWithDup(int i, int j, int[] nums, List<Integer> item, List<List<Integer>> result) {
        if (!result.contains(item)) {
            result.add(new ArrayList<Integer>(item));
        }
        for (int index = 0; index < nums.length; index++) {
            if (i == 0 || index > j) {
                item.add(i, nums[index]);
                j = index;
                this.backtrackSubsetsWithDup(i + 1, j, nums, item, result);
                item.remove(i);
            }
        }
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        System.out.println("Hello Backtracking.");
        SubsetProblems problem = new SubsetProblems();
        problem.testSubsets();
        problem.testSubsetsWithDup();
    }
    /**************************** Testing Methods ****************************/
    public void testSubsets() {
        int[] nums0 = {1, 2, 3};
        this.print(this.subsets(nums0));
    }
    public void testSubsetsWithDup() {
        int[] nums0 = {1, 2, 2};
        this.print(this.subsetsWithDup(nums0));
    }
    /**************************** Printing Methods ****************************/
    public void print(int n) {
        System.out.println(n);
    }
    public void print(int[] array) {
        if (array == null) {
            return;
        }
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(List<List<Integer>> list) {
        System.out.println(list);
    }
}
