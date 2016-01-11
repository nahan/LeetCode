import java.util.Arrays;

/**
 * There are n bulbs that are initially off. 
 * You first turn on all the bulbs. 
 * Then, you turn off every second bulb. 
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). 
 * For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * Example:
 * Given n = 3. 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off]. 
 * So you should return 1, because there is only one bulb is on.
 * @author Han
 *
 */
public class Solution {
    public int bulbSwitch0(int n) {
        boolean[] bulb = new boolean[n];
        Arrays.fill(bulb, true);
        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                bulb[i] = !bulb[i];
            } else {
                for (int j = i; j < n; j += i + 1) {
                    bulb[j] = !bulb[j];
                }
            }
        }
        int result = 0;
        for (boolean item: bulb) {
            if (item) {
                result++;
            }
        }
        return result;
    }
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 26; i++) {
            System.out.println("intput: " + i + ", result: " + solution.bulbSwitch(i));
        }
        System.out.println(solution.bulbSwitch(9999999));
    }
}
