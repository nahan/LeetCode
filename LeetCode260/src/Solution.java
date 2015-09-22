import java.util.HashSet;

/**
 * Given an array of numbers nums, 
 * in which exactly two elements appear only once 
 * and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.
 * 
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note:
 * The order of the result is not important. 
 * So in the above example, [5, 3] is also correct.
 * 
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant space complexity?
 * @author Han
 *
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hash = new HashSet<Integer>();
        for (int item: nums) {
            if (hash.contains(item) == true) {
                hash.remove(item);
            } else {
                hash.add(item);
            }
        }
        int[] result = new int[2];
        int index = 0;
        for (Integer item: hash) {
            result[index] = item;
            index++;
        }
        return result;
    }
    public void print(int[] nums) {
        if (nums == null) return;
        for (int item: nums) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n00 = {1, 2, 1, 3, 2, 5};
        solution.print(solution.singleNumber(n00));
    }
}
