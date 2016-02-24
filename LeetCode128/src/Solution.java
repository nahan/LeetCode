import java.util.HashMap;


public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int item: nums) {
            if (!map.containsKey(item)) {
                int left = map.containsKey(item - 1)? map.get(item - 1): 0;
                int right = map.containsKey(item + 1)? map.get(item + 1): 0;
                int sum = left + right + 1;
                map.put(item, sum);
                length = Math.max(length, sum);
                map.put(item - left, sum);
                map.put(item + right, sum);
            }
        }
        return length;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = null;
        int[] a1 = {};
        int[] a2 = {1};
        int[] a3 = {1, 2};
        int[] a4 = {1, 1};
        int[] a5 = {1, 2, 1};
        System.out.println("expected: 0, result: " + solution.longestConsecutive(a0));
        System.out.println("expected: 0, result: " + solution.longestConsecutive(a1));
        System.out.println("expected: 1, result: " + solution.longestConsecutive(a2));
        System.out.println("expected: 2, result: " + solution.longestConsecutive(a3));
        System.out.println("expected: 1, result: " + solution.longestConsecutive(a4));
        System.out.println("expected: 2, result: " + solution.longestConsecutive(a5));
    }

}
