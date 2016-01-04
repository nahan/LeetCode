
public class Solution {
    /**************************** 309. Best Time to Buy and Sell Stock with Cooldown ****************************/
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
     * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     * prices = [1, 2, 3, 0, 2]
     * maxProfit = 3
     * transactions = [buy, sell, cooldown, buy, sell]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy = 0 - prices[0];
        int cool = 0;
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = buy;
            buy = buy > cool - prices[i]? buy: cool - prices[i];
            cool = sell > cool? sell: cool;
            sell = sell > temp + prices[i]? sell: temp + prices[i];
        }
        return sell > cool? sell: cool;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testMaxProfit();
    }
    public void testMaxProfit() {
        String output = "expected: %d\tresult: %d\n";
        int[] prices00 = {1, 2, 3, 0, 2};
        System.out.format(output, 3, this.maxProfit(prices00));
        int[] prices01 = {};
        System.out.format(output, 0, this.maxProfit(prices01));
        int[] prices02 = {1};
        System.out.format(output, 0, this.maxProfit(prices02));
        int[] prices03 = {1, 2, 3};
        System.out.format(output, 2, this.maxProfit(prices03));
        int[] prices04 = {1, 2, 3, 0};
        System.out.format(output, 2, this.maxProfit(prices04));
        int[] prices05 = {1, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 5, this.maxProfit(prices05));
        int[] prices06 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 7, this.maxProfit(prices06));
        int[] prices07 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 13, this.maxProfit(prices07));
    }
}
