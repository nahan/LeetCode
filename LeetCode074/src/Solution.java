/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * @author Han
 *
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m00 = new int[3][4];
        int[] item0 = {1, 3, 5, 7};
        int[] item1 = {10, 11, 16, 20};
        int[] item2 = {23, 30, 34, 50};
        m00[0] = item0;
        m00[1] = item1;
        m00[2] = item2;
        System.out.println(solution.searchMatrix(m00, 35));
        
        int[][] m01 = new int[3][4];
        int[] i0 = {1,3,5,7};
        int[] i1 = {10,11,16,20};
        int[] i2 = {23,30,34,50};
        m01[0] = i0;
        m01[1] = i1;
        m01[2] = i2;
        System.out.println(solution.searchMatrix(m01, 10));
    }
}