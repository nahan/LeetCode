import java.util.HashMap;


/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * @author Han
 *
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            if (hash.containsKey(nums[index]) == true) {
                return true;
            } else {
                hash.put(nums[index], 1);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = null;
        int[] a1 = {};
        int[] a2 = {0};
        int[] a3 = {0, 1};
        int[] a4 = {0, 0};
        int[] a5 = {0, 1, 0};
        int[] a6 = {0, 0, 0};
        int[] a7 = {1, 1, 0};
        int[] a8 = {0, 1, 1};
        int[] a9 = {0, 1, 2};
        
        System.out.println("false: " + solution.containsDuplicate(a0));
        System.out.println("false: " + solution.containsDuplicate(a1));
        System.out.println("false: " + solution.containsDuplicate(a2));
        System.out.println("false: " + solution.containsDuplicate(a3));
        System.out.println("true: " + solution.containsDuplicate(a4));
        System.out.println("true: " + solution.containsDuplicate(a5));
        System.out.println("true: " + solution.containsDuplicate(a6));
        System.out.println("true: " + solution.containsDuplicate(a7));
        System.out.println("true: " + solution.containsDuplicate(a8));
        System.out.println("false: " + solution.containsDuplicate(a9));
        
    }
}
