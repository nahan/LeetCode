/**
 * Given a 2D matrix matrix, 
 * find the sum of the elements inside the rectangle 
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 <= row2 and col1 <= col2.
 * @author Han
 *
 */
public class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix.length == 0? 0: matrix[0].length;
        this.dp = new int[m][n];
        if (m != 0 && n != 0) {
            this.dp[0][0] = matrix[0][0];
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i][j] - dp[i - 1][j - 1];
                }
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return this.dp[row2][col2];
        }
        if (row1 == 0 && col1 != 0) {
            return this.dp[row2][col2] - dp[row2][col1 - 1];
        }
        if (row1 != 0 && col1 == 0) {
            return this.dp[row2][col2] - dp[row1 - 1][col2];
        }
        return this.dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + this.dp[row1 - 1][col1 - 1];
    }
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        numMatrix.printMatrix(matrix);
        System.out.println(numMatrix.sumRegion(0, 1, 2, 3));
        System.out.println(numMatrix.sumRegion(1, 2, 3, 4));
        System.out.println("expected: 8\tresult: " + numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println("expected: 11\tresult: " + numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println("expected: 12\tresult: " + numMatrix.sumRegion(1, 2, 2, 4));
    }
    public void print(int[] array) {
        if (array == null) {
            return;
        }
        for (int item: array) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }
    public void printMatrix(int[][] matrix) {
        for (int[] item: matrix) {
            this.print(item);
        }
    }
}
// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);