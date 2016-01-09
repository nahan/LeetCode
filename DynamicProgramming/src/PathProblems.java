import java.util.List;


public class PathProblems {
    /**************************** 62. Unique Paths ****************************/
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0 || m > 100 || n > 100) {
            return 0;
        }
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 || j == 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = board[i - 1][j] + board[i][j - 1];
                }
            }
        }
        return board[m - 1][n - 1];
    }
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
    /**************************** Main ****************************/
    public static void main(String[] args) {
        PathProblems problems = new PathProblems();
        problems.uniquePaths(3, 5);
    }
    /**************************** Testing Methods ****************************/
    /**************************** Printing Methods ****************************/
    public void print(int n) {
        System.out.println(n);
    }
    public void print(char ch) {
        System.out.println(ch);
    }
    public void print(String s) {
        System.out.println(s);
    }
    public void print(int[] array) {
        if (array == null) {
            return;
        }
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(char[] array) {
        if (array == null) {
            return;
        }
        for (char item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(List<List<Integer>> list) {
        System.out.println(list);
    }
    public void printList(List<String> list) {
        System.out.println(list);
    }
}
