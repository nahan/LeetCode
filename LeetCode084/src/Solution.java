import java.util.Stack;


public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return heights == null || heights.length == 0? 0: heights[0];
        }
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.empty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.peek()];
                stack.pop();
                area = Math.max(area, height * (stack.empty()? i: i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return area;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = null;
        int[] a1 = {};
        int[] a2 = {1};
        int[] a3 = {1, 2};
        int[] a4 = {2,1,5,6,2,3};
        System.out.println("expected: 0, result: " + solution.largestRectangleArea(a0));
        System.out.println("expected: 0, result: " + solution.largestRectangleArea(a1));
        System.out.println("expected: 1, result: " + solution.largestRectangleArea(a2));
        System.out.println("expected: 2, result: " + solution.largestRectangleArea(a3));
        System.out.println("expected: 10, result: " + solution.largestRectangleArea(a4));
    }
}
