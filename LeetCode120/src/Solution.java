import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
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
        int[] sums = new int[triangle.size()];
        Arrays.fill(sums, Integer.MAX_VALUE);
        sums[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length - 1; i++) {
            int buff = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int temp = sums[j];
                sums[j] = Math.min(buff, sums[j] + triangle.get(i + 1).get(j));
                if (j == triangle.get(i).size() - 1) {
                    sums[j + 1] = temp + triangle.get(i + 1).get(j + 1);
                } else {
                    buff = temp + triangle.get(i + 1).get(j + 1);
                }
            }
        }
        for (int i = 0; i < sums.length; i++) {
            min = Math.min(min, sums[i]);
        }
        return min;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testMinimumTotal();
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
}
