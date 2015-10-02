/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * @author Han
 *
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        System.out.println("before: ");
        this.print(matrix);
        
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int head = 0;
            int tail = n - 1;
            while (head < tail) {
                int temp = matrix[i][head];
                matrix[i][head] = matrix[i][tail];
                matrix[i][tail] = temp;
                head++;
                tail--;
            }
        }
        
        System.out.println("after: ");
        this.print(matrix);
    }
    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] row0 = {1, 2, 3};
        int[] row1 = {4, 5, 6};
        int[] row2 = {7, 8, 9};
        int[][] matrix = new int[3][3];
        matrix[0] = row0;
        matrix[1] = row1;
        matrix[2] = row2;
        
        solution.rotate(matrix);
        
        int[] row00 = {1, 2};
        int[] row01 = {4, 5};
        int[][] matrix0 = new int[2][2];
        matrix0[0] = row00;
        matrix0[1] = row01;
        
        solution.rotate(matrix0);
    }
}
