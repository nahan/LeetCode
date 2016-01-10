import java.util.PriorityQueue;


public class Solution {
    /**************************** 264. Ugly Number II ****************************/
    /**
     * Write a program to find the n-th ugly number.
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
     * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
     * Note that 1 is typically treated as an ugly number.
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return n;
        }
        long[] result = new long[n];
        result[0] = 1;
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        for (int i = 1; i < n; i++) {
            long temp = result[i - 1] * 2;
            if (!queue.contains(temp) && temp > 0) {
                queue.add(temp);
            }
            temp = result[i - 1] * 3;
            if (!queue.contains(temp) && temp > 0) {
                queue.add(temp);
            }
            temp = result[i - 1] * 5;
            if (!queue.contains(temp) && temp > 0) {
                queue.add(temp);
            }
            result[i] = queue.poll();
        }
        return (int) result[n - 1];
    }
    /**************************** Method ****************************/
    /**************************** Main ****************************/
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testNthUglyNumber();
    }
    /**************************** Testing Methods ****************************/
    public void testNthUglyNumber() {
        String output = "input: %d\texpected: %d\tresult: %d\n";
        int[] expected = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12};
        for (int i = 1; i <= expected.length; i++) {
            System.out.format(output, i, expected[i - 1], this.nthUglyNumber(i));
        }
        System.out.format(output, 1407, 536870912, this.nthUglyNumber(1407));
        System.out.format(output, 1600, 1399680000, this.nthUglyNumber(1600));
    }
}
