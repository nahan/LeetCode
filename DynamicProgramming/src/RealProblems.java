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
    /**************************** 198. House Robber ****************************/
    public int rob(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums.length == 1? nums[0]: 0;
        }
        int[] stolen = new int[nums.length];
        stolen[0] = nums[0];
        stolen[1] = nums[0] > nums[1]? nums[0]: nums[1];
        for (int i = 2; i < nums.length; i++) {
            stolen[i] = Math.max(stolen[i - 1], stolen[i - 2] + nums[i]);
        }
        return stolen[stolen.length - 1];
    }
    /**************************** 213. House Robber II ****************************/
    public int robII(int[] nums) {
        if (nums == null || nums.length <= 2) {
            if (nums == null || nums.length == 0) {
                return 0;
            } else {
                return nums.length == 1? nums[0]: Math.max(nums[0], nums[1]);
            }
        }
        int max1 = this.robCircle(nums, 0, nums.length - 2);
        int max2 = this.robCircle(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }
    public int robCircle(int[] nums, int startAt, int endAt) {
        int[] stolen = new int[endAt - startAt + 1];
        stolen[0] = nums[startAt];
        stolen[1] = nums[startAt] > nums[startAt + 1]? nums[startAt]: nums[startAt + 1];
        for (int i = 2; i < stolen.length; i++) {
            stolen[i] = Math.max(stolen[i - 1], stolen[i - 2] + nums[i + startAt]);
        }
        return stolen[stolen.length - 1];
    }
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
    /**************************** Best Time to Buy and Sell Stock IV ****************************/
    /**************************** Dungeon Game ****************************/
    /**************************** Decode Ways ****************************/
    /**************************** Wildcard Matching ****************************/
    /**************************** Main ****************************/
    public static void main(String[] args) {
        RealProblems solution = new RealProblems();
//        solution.testMaxProfitCool();
//        solution.testClimbStairs();
//        solution.testMaxProfit();
//        solution.testRob();
//        solution.testRobII();
//        solution.testMaxCoins();
//        solution.testMaxProfitIII();
        solution.testCoinChange();
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
    public void testRob() {
        String output = "expected: %d\tresult: %d\n";
        int[] prices00 = {1, 2, 3, 0, 2};
        System.out.format(output, 6, this.rob(prices00));
        int[] prices01 = {};
        System.out.format(output, 0, this.rob(prices01));
        int[] prices02 = {1};
        System.out.format(output, 1, this.rob(prices02));
        int[] prices03 = {1, 2, 3};
        System.out.format(output, 4, this.rob(prices03));
        int[] prices04 = {1, 2, 3, 0};
        System.out.format(output, 4, this.rob(prices04));
        int[] prices05 = {1, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 11, this.rob(prices05));
        int[] prices06 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 16, this.rob(prices06));
        int[] prices07 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 31, this.rob(prices07));
    }
    public void testRobII() {
        String output = "expected: %d\tresult: %d\n";
        int[] prices00 = {1, 2, 3, 0, 2};
        System.out.format(output, 5, this.robII(prices00));
        int[] prices01 = {};
        System.out.format(output, 0, this.robII(prices01));
        int[] prices02 = {1};
        System.out.format(output, 1, this.robII(prices02));
        int[] prices03 = {1, 2, 3};
        System.out.format(output, 3, this.robII(prices03));
        int[] prices04 = {1, 2, 3, 0};
        System.out.format(output, 4, this.robII(prices04));
        int[] prices05 = {1, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 10, this.robII(prices05));
        int[] prices06 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 15, this.robII(prices06));
        int[] prices07 = {1, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2, 2, 3, 0, 2};
        System.out.format(output, 30, this.robII(prices07));
        int[] prices08 = {1, 3, 2};
        System.out.format(output, 3, this.robII(prices08));
        int[] prices09 = {1, 3, 4};
        System.out.format(output, 4, this.robII(prices09));
        int[] prices10 = {2, 3, 2};
        System.out.format(output, 3, this.robII(prices10));
        int[] prices11 = {2, 1, 1, 2};
        System.out.format(output, 3, this.robII(prices11));
        int[] prices12 = {2, 2, 4, 3, 2, 5};
        System.out.format(output, 10, this.robII(prices12));
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
