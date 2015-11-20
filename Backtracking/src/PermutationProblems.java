import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PermutationProblems {
    /**************************** Permutations ****************************/
    /**
     * Given a collection of numbers, return all possible permutations.
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        boolean[] pos = new boolean[nums.length];
        Arrays.fill(pos, true);
        this.backtrackPermute(0, pos, nums, item, result);
        return result;
    }
    public void backtrackPermute(int i, boolean[] pos, int[] nums, List<Integer> item, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (i == 0 || pos[index]) {
                item.add(i, nums[index]);
                pos[index] = false;
                this.backtrackPermute(i + 1, pos, nums, item, result);
                item.remove(i);
                pos[index] = true;
            }
        }
    }
    /**************************** Permutations II ****************************/
    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        boolean[] pos = new boolean[nums.length];
        Arrays.fill(pos, true);
        this.backtrackPermuteUnique(0, pos, nums, item, result);
        return result;
    }
    public void backtrackPermuteUnique(int i, boolean[] pos, int[] nums, List<Integer> item, List<List<Integer>> result) {
        if (i == nums.length && !result.contains(item)) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (i == 0 || pos[index]) {
                item.add(i, nums[index]);
                pos[index] = false;
                this.backtrackPermuteUnique(i + 1, pos, nums, item, result);
                item.remove(i);
                pos[index] = true;
            }
        }
    }
    /**************************** Permutations Sequence ****************************/
    /**
     * The set [1,2,3,…,n] contains a total of n! unique permutations.
     * By listing and labeling all of the permutations in order,
     * We get the following sequence (ie, for n = 3):
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * 
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        String[] result = new String[1];
        StringBuilder builder = new StringBuilder();
        boolean[] pos = new boolean[n + 1];
        Arrays.fill(pos, true);
        this.backtrackGetPermutation(0, 0, pos, n, k, builder, result);
        return result[0];
    }
    public int backtrackGetPermutation(int i, int count, boolean[] pos, int n, int k, StringBuilder builder, String[] result) {
        if (i == n) {
            count++;
            if (count == k) {
                result[0] = builder.toString();
                return count;
            }
        }
        for (int index = 1; index <= n; index++) {
            if (i == 0 || pos[index]) {
                builder.append(index);
                pos[index] = false;
                count = this.backtrackGetPermutation(i + 1, count, pos, n, k, builder, result);
                builder.deleteCharAt(builder.length() - 1);
                pos[index] = true;
            }
        }
        return count;
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        System.out.println("Hello Backtracking.");
        PermutationProblems problems = new PermutationProblems();
        problems.testPermute();
        problems.testPermuteUnique();
        problems.testGetPermutation();
    }
    /**************************** Testing Methods ****************************/
    public void testPermute() {
        int[] nums = {1, 2, 3};
        this.print(this.permute(nums));
    }
    public void testPermuteUnique() {
        int[] nums = {1, 1, 2};
        this.print(this.permuteUnique(nums));
    }
    public void testGetPermutation() {
        this.print(this.getPermutation(3, 3));
        this.print(this.getPermutation(3, 6));
        this.print(this.getPermutation(9, 94626));
        this.print(this.getPermutation(9, 206490));
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
    public void print(String s) {
        System.out.println(s);
    }
    public void print(List<List<Integer>> list) {
        System.out.println(list);
    }
}
