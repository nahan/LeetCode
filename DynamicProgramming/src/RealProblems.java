import java.util.List;


public class RealProblems {
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
    public int maxProfitCool(int[] prices) {
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
    /**************************** 70. Climbing Stairs ****************************/
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. 
     * In how many distinct ways can you climb to the top?
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
    /**************************** Best Time to Buy and Sell Stock ****************************/
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction 
     * (ie, buy one and sell one share of the stock), 
     * design an algorithm to find the maximum profit.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = prices[0] - prices[0];
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minPrice = prices[i] < minPrice? prices[i]: minPrice;
            maxProfit = prices[i] - minPrice > maxProfit? prices[i] - minPrice: maxProfit;
        }
        return maxProfit;
    }
    /**************************** House Robber ****************************/
    /**************************** House Robber II ****************************/
    /**************************** 312. Burst Balloons ****************************/
    /**
     * Given n balloons, indexed from 0 to n-1. 
     * Each balloon is painted with a number on it represented by array nums. 
     * You are asked to burst all the balloons. 
     * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
     * Here left and right are adjacent indices of i. After the burst, 
     * the left and right then becomes adjacent.
     * 
     * Find the maximum coins you can collect by bursting the balloons wisely.
     * Note: 
     * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
     * (2) 0 <= n <= 500, 0 <= nums[i] <= 100
     * 
     * Example:
     * Given [3, 1, 5, 8]
     * Return 167
     * 
     * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                balloons[n++] = nums[i];
            }
        }
        balloons[0] = 1;
        balloons[n++] = 1;
        int[][] maxCoins = new int[n][n];
        for (int subLength = 2; subLength < n; subLength++) {
            for (int startAt = 0; startAt < n - subLength; startAt++) {
                int endAt = startAt + subLength;
                for (int i = startAt + 1; i < endAt; i++) {
                    int currentCoins = balloons[startAt] * balloons[i] * balloons[endAt] + maxCoins[startAt][i] + maxCoins[i][endAt];
                    maxCoins[startAt][endAt] = Math.max(maxCoins[startAt][endAt], currentCoins);
                }
            }
        }
        return maxCoins[0][n - 1];
    }
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
    public int maxProfitIII(int[] prices) {
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
    /**************************** Best Time to Buy and Sell Stock IV ****************************/
    /**************************** Dungeon Game ****************************/
    /**************************** Decode Ways ****************************/
    /**************************** Wildcard Matching ****************************/
    /**************************** Main ****************************/
    public static void main(String[] args) {
        RealProblems problems = new RealProblems();
//        problems.testMaxProfitCool();
//        problems.testClimbStairs();
//        problems.testMaxProfit();
        problems.testMaxCoins();
//        problems.testMaxProfitIII();
    }
    /**************************** Testing Methods ****************************/
    public void testMaxProfitCool() {
        String output = "expected: %d\tresult: %d\n";
        int[] prices00 = {1, 2, 3, 0, 2};
        System.out.format(output, 3, this.maxProfitCool(prices00));
        int[] prices01 = {};
        System.out.format(output, 0, this.maxProfitCool(prices01));
        int[] prices02 = {1};
        System.out.format(output, 0, this.maxProfitCool(prices02));
        int[] prices03 = {1, 2, 3};
        System.out.format(output, 2, this.maxProfitCool(prices03));
        int[] prices04 = {1, 2, 3, 0};
        System.out.format(output, 2, this.maxProfitCool(prices04));
        int[] prices05 = {1, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 5, this.maxProfitCool(prices05));
        int[] prices06 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 7, this.maxProfitCool(prices06));
        int[] prices07 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 13, this.maxProfitCool(prices07));
    }
    public void testClimbStairs() {
        for (int i = 0; i < 46; i++) {
            System.out.println(i + " steps, " + this.climbStairs(i) + " ways to climb.");
        }
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
    }
    public void testMaxCoins() {
        String output = "expected: %d\tresult: %d\n";
        int[] nums = {3, 1, 5, 8};
        System.out.format(output, 167, this.maxCoins(nums));
        int[] nums00 = {1, 2, 3, 0, 2};
        System.out.format(output, 20, this.maxCoins(nums00));
        int[] nums01 = {};
        System.out.format(output, 0, this.maxCoins(nums01));
        int[] nums02 = {1};
        System.out.format(output, 1, this.maxCoins(nums02));
        int[] nums03 = {1, 2, 3};
        System.out.format(output, 12, this.maxCoins(nums03));
        int[] nums04 = {1, 2, 3, 0};
        System.out.format(output, 12, this.maxCoins(nums04));
        int[] nums05 = {1, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 68, this.maxCoins(nums05));
        int[] nums06 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 125, this.maxCoins(nums06));
        int[] nums07 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 296, this.maxCoins(nums07));
    }
    public void testMaxProfitIII() {
        int[] prices00 = {1, 2, 3, 0, 2};
        this.print(this.maxProfitIII(prices00));
        int[] prices01 = {};
        this.print(this.maxProfitIII(prices01));
        int[] prices02 = {1};
        this.print(this.maxProfitIII(prices02));
        int[] prices03 = {1, 2, 3};
        this.print(this.maxProfitIII(prices03));
        int[] prices04 = {1, 2, 3, 0};
        this.print(this.maxProfitIII(prices04));
        int[] prices05 = {6, 1, 3, 2, 4, 7};
        this.print(this.maxProfitIII(prices05));
    }
    /**************************** Printing Methods ****************************/
    public void print(int n) {
        System.out.println(n);
    }
    public void print(char ch) {
        System.out.println(ch);
    }
    public void print(String s) {
        System.out.println(s);
    }
    public void print(int[] array) {
        if (array == null) {
            return;
        }
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(char[] array) {
        if (array == null) {
            return;
        }
        for (char item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(boolean[] array) {
        if (array == null) {
            return;
        }
        for (boolean item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(List<List<Integer>> list) {
        System.out.println(list);
    }
    public void printList(List<String> list) {
        System.out.println(list);
    }
}
