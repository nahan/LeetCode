/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author Han
 *
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        result[0][0] = 1;
        this.generateRound(n, result, 0, 0);
        return result;
    }
    public void generateRound(int n, int[][] matrix, int row, int column) {
        for (int i = row; i < n - 1; i++) {
            matrix[row][i + 1] = matrix[row][i] + 1;
        }
        for (int i = row; i < n - 1; i++) {
            matrix[i + 1][n - 1] = matrix[i][n - 1] + 1; 
        }
        for (int i = n - 1; i > row; i--) {
            matrix[n - 1][i - 1] = matrix[n - 1][i] + 1;
        }
        for (int i = n - 1; i > row + 1; i--) {
            matrix[i - 1][column] = matrix[i][column] + 1;
        }
        if (n > 1 && matrix[row + 1][column + 1] == 0) {
            matrix[row + 1][column + 1] = matrix[row + 1][column] + 1;
            this.generateRound(n - 1, matrix, row + 1, column + 1);
        }
    }
    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printMatrix(solution.generateMatrix(0));
        solution.printMatrix(solution.generateMatrix(1));
        solution.printMatrix(solution.generateMatrix(2));
        solution.printMatrix(solution.generateMatrix(3));
        solution.printMatrix(solution.generateMatrix(4));
        solution.printMatrix(solution.generateMatrix(5));
        solution.printMatrix(solution.generateMatrix(10));
    }
}
