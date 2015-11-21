import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationProblems {
    /**************************** Combinations ****************************/
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        this.backtrackCombine(0, 0, n, k, item, result);
        return result;
    }
    private void backtrackCombine(int i, int j, int n, int k, List<Integer> item, List<List<Integer>> result) {
        if (i == k) {
            result.add(new ArrayList<Integer>(item));
        }
        for (int index = 0; index <= n; index++) {
            if (index > j) {
                item.add(i, index);
                this.backtrackCombine(i + 1, index, n, k, item, result);
                item.remove(i);
            }
        }
    }
    /**************************** Combination Sum ****************************/
    /**
     * Given a set of candidate numbers (C) and a target number (T), 
     * find all unique combinations in C where the candidate numbers sums to T.
     * The same repeated number may be chosen from C unlimited number of times.
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        this.backtrackCombinationSum(0, 0, target, candidates, item, result);
        return result;
    }
    private void backtrackCombinationSum(int i, int sum, int target, int[] candidates, List<Integer> item, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(item));
        }
        for (int index = 0; index < candidates.length; index++) {
            if (i == 0 || (candidates[index] >= item.get(i - 1) && sum <= target)) {
                item.add(i, candidates[index]);
                this.backtrackCombinationSum(i + 1, sum + candidates[index], target, candidates, item, result);
                item.remove(i);
            }
        }
    }
    /**************************** Combination Sum II ****************************/
    /**
     * Given a collection of candidate numbers (C) and a target number (T), 
     * find all unique combinations in C where the candidate numbers sums to T.
     * Each number in C may only be used once in the combination.
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(candidates);
        this.backtrackCombinationSum2(0, 0, target, candidates, item, result);
        return result;
    }
    private void backtrackCombinationSum2(int i, int sum, int target, int[] candidates, List<Integer> item, List<List<Integer>> result) {
        if (sum == target && !result.contains(item)) {
            result.add(new ArrayList<Integer>(item));
        }
        for (int index = i; index < candidates.length; index++) {
            if (i == 0 || (target >= sum && candidates[index] >= item.get(i - 1))) {
                item.add(i, candidates[index]);
                this.backtrackCombinationSum2(i + 1, sum + candidates[index], target, candidates, item, result);
                item.remove(i);
            }
        }
    }
    /**************************** Combination Sum III ****************************/
    /**
     * Find all possible combinations of k numbers that add up to a number n, 
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * Ensure that numbers within the set are sorted in ascending order.
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        this.backtrackCombinationSum3(0, 0, 0, k, n, item, result);
        return result;
    }
    private void backtrackCombinationSum3(int i, int j, int count, int k, int n, List<Integer> item, List<List<Integer>> result) {
        if (i == k && count == n) {
            result.add(new ArrayList<Integer>(item));
        }
        for (int index = j; index <= 9; index++) {
            if (index > j && count + j <= n) {
                item.add(i, index);
                this.backtrackCombinationSum3(i + 1, index, count + index, k, n, item, result);
                item.remove(i);
            }
        }
    }
    /**************************** Letter Combinations of a Phone Number ****************************/
    /**
     * Given a digit string, return all possible letter combinations that the number could represent.
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.equals("")) {
            return result;
        }
        String[] dial = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '0' && digits.charAt(i) != '1') {
                temp.append(digits.charAt(i));
            }
        }
        digits = temp.toString();
        this.backtrackLetterCombinations(0, digits, dial, builder, result);
        return result;
    }
    private void backtrackLetterCombinations(int i, String digits, String[] dial, StringBuilder builder, List<String> result) {
        if (i == digits.length()) {
            result.add(builder.toString());
        }
        for (int index = 0; i < digits.length() && index < dial[digits.charAt(i) - 48].length(); index++) {
            builder.append(dial[digits.charAt(i) - 48].charAt(index));
            this.backtrackLetterCombinations(i + 1, digits, dial, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        System.out.println("Hello Backtracking.");
        CombinationProblems problems = new CombinationProblems();
        problems.testCombine();
        problems.testCombinationSum();
        problems.testCombinationSum2();
        problems.testCombinationSum3();
        problems.testLetterCombinations();
    }
    /**************************** Testing Methods ****************************/
    public void testCombine() {
        this.print(this.combine(4, 2));
    }
    public void testCombinationSum() {
        int[] nums = {2, 3, 6, 7};
        this.print(this.combinationSum(nums, 7));
    }
    public void testCombinationSum2() {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        this.print(this.combinationSum2(nums, 8));
    }
    public void testCombinationSum3() {
        this.print(this.combinationSum3(3, 9));
    }
    public void testLetterCombinations() {
        this.printList(this.letterCombinations("78"));
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
    public void printList(List<String> list) {
        System.out.println(list);
    }
}
