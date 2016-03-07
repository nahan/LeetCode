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
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count += 1;
            } else if (count == 0) {
                major = nums[i];
                count = 1;
            } else {
                count -= 1;
            }
        }
        return major;
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
