import java.util.HashMap;
/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than [n/2] times.
 * 
 * You may assume that the array is non-empty 
 * and the majority element always exist in the array.
 * @author Han
 *
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int result = 0;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            if (hash.containsKey(nums[index]) == true) {
                hash.put(nums[index], hash.get(nums[index]) + 1);
            } else {
                hash.put(nums[index], 1);
            }
            if (sum < hash.get(nums[index])) {
                sum = hash.get(nums[index]);
                result = nums[index];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] a00 = null;
        int[] a01 = {};
        int[] a02 = {1};
        int[] a03 = {1, 1};
        int[] a04 = {3, 2, 3};
        int[] a05 = {3, 2, 3, 3, 2, 3, 3, 2, 3, 3, 2, 3};
        
        System.out.println("Expect: 0, Output: " + solution.majorityElement(a00));
        System.out.println("Expect: 0, Output: " + solution.majorityElement(a01));
        System.out.println("Expect: 1, Output: " + solution.majorityElement(a02));
        System.out.println("Expect: 1, Output: " + solution.majorityElement(a03));
        System.out.println("Expect: 3, Output: " + solution.majorityElement(a04));
        System.out.println("Expect: 3, Output: " + solution.majorityElement(a05));
    }
}
