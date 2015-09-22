/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * @author Han
 *
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int buy = i - 1;
            int sell = i;
            if (prices[sell] - prices[buy] > 0) {
                result += prices[sell] - prices[buy];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p00 = null;
        int[] p01 = {};
        int[] p02 = {1};
        int[] p03 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] p04 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] p05 = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        int[] p06 = {1, 7, 2, 5, 3};
        int[] p07 = {1, 2, 3, 4, 5, 6};
        System.out.format("Max Profit: %d\n", solution.maxProfit(p00));
        System.out.format("Max Profit: %d\n", solution.maxProfit(p01));
        System.out.format("Max Profit: %d\n", solution.maxProfit(p02));
        System.out.format("Max Profit: %d\n", solution.maxProfit(p03));
        System.out.format("Max Profit: %d\n", solution.maxProfit(p04));
        System.out.format("Max Profit: %d\n", solution.maxProfit(p05));
        System.out.format("Max Profit: %d\n", solution.maxProfit(p06));
        System.out.format("Max Profit: %d\n", solution.maxProfit(p07));
    }
}
