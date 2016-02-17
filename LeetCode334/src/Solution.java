
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int head = 0;
        int mid = 1;
        int tail = 2;
        while (head < nums.length - 2 && mid < nums.length - 1 && tail < nums.length) {
            if (nums[head] < nums[mid]) {
                if (nums[mid] < nums[tail]) {
                    return true;
                } else {
                    if (tail == nums.length - 1) {
                        mid++;
                    } else {
                        tail++;
                    }
                }
            } else {
                head = mid;
                mid++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {5, 4, 3, 2, 1, 1, 2, 3};
        System.out.println(solution.increasingTriplet(a1));
        System.out.println(solution.increasingTriplet(a2));
    }
}
