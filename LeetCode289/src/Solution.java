/**
 * According to the Wikipedia's article: 
 * "The Game of Life, also known simply as Life, 
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells, 
 * each cell has an initial state live (1) or dead (0). 
 * 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
 * using the following four rules (taken from the above Wikipedia article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up: 
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: 
 * You cannot update some cells first and then use their updated values to update other cells.
 * 
 * In this question, we represent the board using a 2D array. 
 * In principle, the board is infinite, 
 * which would cause problems when the active area encroaches the border of the array. 
 * How would you address these problems?
 * @author Han
 *
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int[][] state = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                state[i][j] = this.countLiveNeighbor(i, j, board.length, board[0].length, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (state[i][j] < 2 || state[i][j] > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (state[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
    public int countLiveNeighbor(int i, int j, int m, int n, int[][] board) {
        int count = 0;
        if (i - 1 >= 0 && j - 1 >= 0) {
            count += board[i - 1][j - 1];
        }
        if (i - 1 >= 0) {
            count += board[i - 1][j];
        }
        if (i - 1 >= 0 && j + 1 < n) {
            count += board[i - 1][j + 1];
        }
        if (j - 1 >= 0) {
            count += board[i][j - 1];
        }
        if (j + 1 < n) {
            count += board[i][j + 1];
        }
        if (i + 1 < m && j - 1 >= 0) {
            count += board[i + 1][j - 1];
        }
        if (i + 1 < m) {
            count += board[i + 1][j];
        }
        if (i + 1 < m && j + 1 < n) {
            count += board[i + 1][j + 1];
        }
        return count;
    }
    public void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] row00 = {0, 0, 0, 0};
        int[] row01 = {0, 1, 1, 0};
        int[] row02 = {0, 1, 1, 0};
        int[] row03 = {0, 0, 0, 0};
        int[][] board00 = new int[4][4];
        board00[0] = row00;
        board00[1] = row01;
        board00[2] = row02;
        board00[3] = row03;
        solution.printBoard(board00);
        System.out.println();
        solution.gameOfLife(board00);
        solution.printBoard(board00);
        System.out.println();
        
        int[] r00 = {0, 0, 0, 0, 0};
        int[] r01 = {0, 0, 1, 0, 0};
        int[] r02 = {0, 0, 1, 0, 0};
        int[] r03 = {0, 0, 1, 0, 0};
        int[] r04 = {0, 0, 0, 0, 0};
        int[][] board01 = new int[5][5];
        board01[0] = r00;
        board01[1] = r01;
        board01[2] = r02;
        board01[3] = r03;
        board01[4] = r04;
        solution.printBoard(board01);
        System.out.println();
        solution.gameOfLife(board01);
        solution.printBoard(board01);
        System.out.println();
        
        int[][] board02 = {{0, 0}};
        solution.printBoard(board02);
        System.out.println();
        solution.gameOfLife(board02);
        solution.printBoard(board02);
        System.out.println();
    }
}
