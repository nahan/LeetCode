import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ShapeProblems {
    /**************************** 279. Perfect Squares ****************************/
    /**
     * Given a positive integer n, find the least number of perfect square numbers 
     * (for example, 1, 4, 9, 16, ...) which sum to n.
     * 
     * For example, 
     * given n = 12, return 3 because 12 = 4 + 4 + 4; 
     * given n = 13, return 2 because 13 = 4 + 9.
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n < 2) {
            return n;
        }
        int[] squares = new int[n + 1];
        squares[0] = 0;
        squares[1] = 1;
        for (int i = 2; i <= n; i++) {
            squares[i] = i;
            int r = 1;
            int s = 1;
            while (s <= i) {
                s = (int) Math.pow(++r, 2);
                squares[i] = Math.min(squares[i], i / s + squares[i % s]);
            }
        }
        return squares[n];
    }
    /**************************** 120. Triangle ****************************/
    /**
     * Given a triangle, find the minimum path sum from top to bottom. 
     * Each step you may move to adjacent numbers on the row below.
     * 
     * For example, given the following triangle
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 2) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            } else {
                return triangle.get(0).get(0);
            }
        }
        int[][] total = new int[triangle.size()][triangle.size()];
        for (int[] item: total) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        total[0][0] = triangle.get(0).get(0);
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < total.length - 1; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                total[i + 1][j] = Math.min(total[i + 1][j], total[i][j] + triangle.get(i + 1).get(j));
                total[i + 1][j + 1] = Math.min(total[i + 1][j + 1], total[i][j] + triangle.get(i + 1).get(j + 1));
            }
        }
        for (int i = 0; i < total.length; i++) {
            sum = Math.min(sum, total[total.length - 1][i]);
        }
        return sum;
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        ShapeProblems solution = new ShapeProblems();
//        solution.testNumSquares();
        solution.testMinimumTotal();
    }
    /**************************** Testing Methods ****************************/
    public void testNumSquares() {
        String output = "input: %d\texpected: %d\tresult: %d\n";
        System.out.format(output, 0, 0, this.numSquares(0));
        System.out.format(output, 1, 1, this.numSquares(1));
        System.out.format(output, 2, 2, this.numSquares(2));
        System.out.format(output, 3, 3, this.numSquares(3));
        System.out.format(output, 4, 1, this.numSquares(4));
        System.out.format(output, 5, 2, this.numSquares(5));
        System.out.format(output, 6, 3, this.numSquares(6));
        System.out.format(output, 7, 4, this.numSquares(7));
        System.out.format(output, 8, 2, this.numSquares(8));
        System.out.format(output, 9, 1, this.numSquares(9));
        System.out.format(output, 10, 2, this.numSquares(10));
        System.out.format(output, 11, 3, this.numSquares(11));
        System.out.format(output, 12, 3, this.numSquares(12));
        System.out.format(output, 13, 2, this.numSquares(13));
        System.out.format(output, 14, 3, this.numSquares(14));
        System.out.format(output, 15, 4, this.numSquares(15));
        System.out.format(output, 16, 1, this.numSquares(16));
        System.out.format(output, 17, 2, this.numSquares(17));
        System.out.format(output, 18, 2, this.numSquares(18));
        System.out.format(output, 19, 3, this.numSquares(19));
        System.out.format(output, 20, 2, this.numSquares(20));
        System.out.format(output, 777, 3, this.numSquares(777));
        System.out.format(output, 1024, 1, this.numSquares(1024));
        System.out.format(output, 1204, 3, this.numSquares(1204));
    }
    public void testMinimumTotal() {
        String output = "input: %s\texpected: %d\tresult: %d\n";
        List<Integer> item1 = new ArrayList<Integer>();
        item1.add(2);
        List<Integer> item2 = new ArrayList<Integer>();
        item2.add(3);
        item2.add(4);
        List<Integer> item3 = new ArrayList<Integer>();
        item3.add(6);
        item3.add(5);
        item3.add(7);
        List<Integer> item4 = new ArrayList<Integer>();
        item4.add(4);
        item4.add(1);
        item4.add(8);
        item4.add(3);
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(item1);
        input.add(item2);
        input.add(item3);
        input.add(item4);
        System.out.format(output, input, 11, this.minimumTotal(input));
        List<List<Integer>> input2 = new ArrayList<List<Integer>>();
        System.out.format(output, input2, 0, this.minimumTotal(input2));
        List<List<Integer>> input3 = new ArrayList<List<Integer>>();
        input3.add(item1);
        System.out.format(output, input3, 0, this.minimumTotal(input3));
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
