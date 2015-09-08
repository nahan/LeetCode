
/**
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 * @author Han
 *
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
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
        
        System.out.println("false: " + solution.containsNearbyDuplicate(a0, 1));
        System.out.println("false: " + solution.containsNearbyDuplicate(a1, 1));
        System.out.println("false: " + solution.containsNearbyDuplicate(a2, 1));
        System.out.println("false: " + solution.containsNearbyDuplicate(a3, 1));
        System.out.println("true: " + solution.containsNearbyDuplicate(a4, 1));
        System.out.println("true: " + solution.containsNearbyDuplicate(a5, 1));
        System.out.println("true: " + solution.containsNearbyDuplicate(a6, 1));
        System.out.println("true: " + solution.containsNearbyDuplicate(a7, 1));
        System.out.println("true: " + solution.containsNearbyDuplicate(a8, 1));
        System.out.println("false: " + solution.containsNearbyDuplicate(a9, 1));
    }
}
