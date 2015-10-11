/**
 * Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place.
 * @author Han
 *
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int[] zeroOnCol = new int[matrix[0].length];
        int[] zeroOnRow = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroOnRow[i] = 1;
                    zeroOnCol[j] = 1;
                }
            }
        }
        for (int i = 0; i < zeroOnRow.length; i++) {
            if (zeroOnRow[i] == 1) {
                this.setRowZero(matrix, i);
            }
        }
        for (int i = 0; i < zeroOnCol.length; i++) {
            if (zeroOnCol[i] == 1) {
                this.setColZero(matrix, i);
            }
        }
    }
    public void setRowZero(int[][] matrix, int index) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[index][i] = 0;
        }
    }
    public void setColZero(int[][] matrix, int index) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][index] = 0;
        }
    }
    public void setZero(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
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
    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m = {{0,1,2,3}, {1,1,0,3}, {1,1,2,0}};
        solution.printMatrix(m);
        solution.setZeroes(m);
        solution.printMatrix(m);
        
        int[][] m1 = {{0,1,2,3}};
        solution.printMatrix(m1);
        solution.setZeroes(m1);
        solution.printMatrix(m1);
        
        int[][] m2 = {{0,0,0,5}, {4,3,1,4}, {0,1,1,4}, {1,2,1,3}, {0,0,1,1}};
        solution.printMatrix(m2);
        solution.setZeroes(m2);
        solution.printMatrix(m2);
    }
    
}
