
public class Solution {
    /**************************** 322. Coin Change ****************************/
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] result = new int[amount + 1];
        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int sub = i - coins[j];
                if ((sub > 0 && result[sub] > 0) || sub == 0) {
                    min = Math.min(min, result[sub] + 1);
                }
            }
            result[i] = min == Integer.MAX_VALUE? -1: min;
        }
        return result[amount];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testCoinChange();
    }
    public void testCoinChange() {
        String output = "coins: %s\tamout: %d\texpected: %d\tresult: %d\n";
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.format(output, this.arrayString(coins), amount, 3, this.coinChange(coins, amount));
        int[] coins1 = {2};
        amount = 3;
        System.out.format(output, this.arrayString(coins1), amount, -1, this.coinChange(coins1, amount));
        int[] coins2 = {2};
        amount = 1;
        System.out.format(output, this.arrayString(coins2), amount, -1, this.coinChange(coins2, amount));
        int[] coins3 = {186, 419, 83, 408};
        amount = 6249;
        System.out.format(output, this.arrayString(coins3), amount, 20, this.coinChange(coins3, amount));
    }
    public String arrayString(int[] array) {
        if (array == null) {
            return "null";
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append('[');
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i] + " ");
            }
            builder.append(']');
            return builder.toString();
        }
    }
}
