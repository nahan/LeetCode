
public class Solution {
    /**************************** 123. Best Time to Buy and Sell Stock III ****************************/
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most TWO transactions.
     * Note:
     * You may not engage in multiple transactions at the same time 
     * (ie, you must sell the stock before you buy again).
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] first = new int[prices.length];
        int[] second = new int[prices.length];
        int minPrice = prices[0];
        int maxPrice = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            minPrice = minPrice < prices[i]? minPrice: prices[i];
            first[i] = first[i - 1] > prices[i] - minPrice? first[i - 1]: prices[i] - minPrice;
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            maxPrice = maxPrice > prices[i]? maxPrice: prices[i];
            second[i] = second[i + 1] > maxPrice - prices[i]? second[i + 1]: maxPrice - prices[i];
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = maxProfit > first[i] + second[i]? maxProfit: first[i] + second[i];
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testMaxProfit();
    }
    public void testMaxProfit() {
        int[] prices00 = {1, 2, 3, 0, 2};
        this.print(this.maxProfit(prices00));
        int[] prices01 = {};
        this.print(this.maxProfit(prices01));
        int[] prices02 = {1};
        this.print(this.maxProfit(prices02));
        int[] prices03 = {1, 2, 3};
        this.print(this.maxProfit(prices03));
        int[] prices04 = {1, 2, 3, 0};
        this.print(this.maxProfit(prices04));
        int[] prices05 = {6, 1, 3, 2, 4, 7};
        this.print(this.maxProfit(prices05));
    }
    public void print(int n) {
        System.out.println(n);
    }
}
