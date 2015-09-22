import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * @author Han
 *
 */
public class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int item: nums) {
            if (hash.containsKey(item) == true) {
                hash.put(item, hash.get(item) + 1);
            } else {
                hash.put(item, 1);
            }
        }
        for (Entry<Integer, Integer> item: hash.entrySet()) {
            if (item.getValue() == 1) {
                return item.getKey();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n00 = {1, 2, 1, 3, 2, 5, 3, 2, 1, 3};
        System.out.println(solution.singleNumber(n00));
    }
}
