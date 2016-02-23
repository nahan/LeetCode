import java.util.ArrayList;
import java.util.List;


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin += 1;
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd -= 1;
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd -= 1;
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
            }
            colBegin += 1;
        }
        return result;
    }
    public void printMatrix(int[][] matrix) {
        for (int[] item: matrix) {
            this.printArray(item);
        }
    }
    public void printArray(int[] array) {
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m0 = new int[5][5];
        int[] a0 = {1, 2, 3, 4, 5};
        int[] a1 = {6, 7, 8, 9, 10};
        int[] a2 = {11, 12, 13, 14, 15};
        int[] a3 = {16, 17, 18, 19, 20};
        int[] a4 = {21, 22, 23, 24, 25};
        m0[0] = a0;
        m0[1] = a1;
        m0[2] = a2;
        m0[3] = a3;
        m0[4] = a4;
//        solution.printMatrix(m0);
        System.out.println(solution.spiralOrder(m0));
    }

}
