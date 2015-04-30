
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum 
 */
public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxProfit = prices[0] - prices[0];
		int minPrice = prices[0];
		for (int i = 0; i < prices.length; i ++) {
			minPrice = prices[i] < minPrice ? prices[i] : minPrice;
			maxProfit = (prices[i] - minPrice) > maxProfit ? (prices[i] - minPrice) : maxProfit;
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test01 = {1, 7, 6, 5, 4, 10};
		int[] test02 = {};
		System.out.println(solution.maxProfit(test01));
		System.out.println(solution.maxProfit(test02));
	}
}
