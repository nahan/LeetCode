
public class Solution {
    /**************************** 63. Unique Paths II ****************************/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[][] board = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean top = false;
        boolean left = false;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        if (obstacleGrid[i][j] == 1 || top) {
                            top = true;
                            board[i][j] = 0;
                        } else {
                            board[i][j] = 1;
                        }
                    }
                    if (j == 0) {
                        if (obstacleGrid[i][j] == 1 || left) {
                            left = true;
                            board[i][j] = 0;
                        } else {
                            board[i][j] = 1;
                        }
                    }
                } else {
                    board[i][j] = obstacleGrid[i][j] == 1? 0: board[i - 1][j] + board[i][j - 1];
                }
            }
        }
        return board[board.length - 1][board[0].length - 1];
    }
}
