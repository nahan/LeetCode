/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * @author Han
 *
 */
public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (Math.pow(mid, 2) > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = -1; i < 150; i++) {
            System.out.println(i + " -> " + solution.mySqrt(i));
        }
        System.out.println(2147395599 + " -> " + solution.mySqrt(2147395599));
    }
}
