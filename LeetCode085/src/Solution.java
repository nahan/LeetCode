import java.util.Stack;


public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] heights = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    if (matrix[i][j] == '1') {
                        heights[i][j] = 1;
                    } else {
                        heights[i][j] = 0;
                    }
                } else {
                    if (matrix[i][j] == '1') {
                        heights[i][j] = heights[i - 1][j] + 1;
                    } else {
                        heights[i][j] = 0;
                    }
                }
            }
            max = Math.max(max, this.largestRectangleArea(heights[i]));
        }
        return max;
    }
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
        char[][] m = {{'0','0'}};
        System.out.println(solution.maximalRectangle(m));
    }
}
