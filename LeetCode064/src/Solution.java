/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * @author Han
 *
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int sum[] = new int[n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        sum[j] = grid[i][j];
                    } else {
                        sum[j] = sum[j - 1] + grid[i][j];
                    }
                } else if (j == 0) {
                    sum[j] = sum[j] + grid[i][j];
                } else {
                    sum[j] = Math.min(sum[j - 1], sum[j]) + grid[i][j];
                }
            }
        }
        return sum[n - 1];
    }
    public int minPathSum0(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum[][] = new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        sum[i][j] = grid[i][j];
                    } else {
                        sum[i][j] = sum[i][j - 1] + grid[i][j];
                    }
                } else if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + grid[i][j];
                } else {
                    sum[i][j] = Math.min(sum[i][j - 1], sum[i - 1][j]) + grid[i][j];
                }
            }
        }
        return sum[m - 1][n - 1];
    }
    
}
