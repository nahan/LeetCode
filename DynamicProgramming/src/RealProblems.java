import java.util.List;


public class RealProblems {
    /**************************** Best Time to Buy and Sell Stock with Cooldown ****************************/
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
        return 0;
    }
    /**************************** Climbing Stairs ****************************/
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. 
     * In how many distinct ways can you climb to the top?
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return 0;
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
        return 0;
    }
    /**************************** House Robber ****************************/
    /**************************** House Robber II ****************************/
    /**************************** Burst Balloons ****************************/
    /**************************** Best Time to Buy and Sell Stock III ****************************/
    /**************************** Best Time to Buy and Sell Stock IV ****************************/
    /**************************** Dungeon Game ****************************/
    /**************************** Decode Ways ****************************/
    /**************************** Wildcard Matching ****************************/
    /**************************** Main ****************************/
    public static void main(String[] args) {
        RealProblems problems = new RealProblems();
        problems.testMaxProfitCool();
        problems.testClimbStairs();
        problems.testMaxProfit();
    }
    /**************************** Testing Methods ****************************/
    public void testMaxProfitCool() {
        int[] prices00 = {1, 2, 3, 0, 2};
        this.print(this.maxProfitCool(prices00));
    }
    public void testClimbStairs() {
        System.out.println("Hello Dynamic Programming.");
    }
    public void testMaxProfit() {
        System.out.println("Hello Dynamic Programming.");
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
    public void print(List<List<Integer>> list) {
        System.out.println(list);
    }
    public void printList(List<String> list) {
        System.out.println(list);
    }
}
