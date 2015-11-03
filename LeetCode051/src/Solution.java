import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * [".Q..",  // Solution 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *  
 * ["..Q.",  // Solution 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 * @author Han
 *
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n < 1) {
            return result;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        this.queenSolver(0, board, result);
        return result;
    }
    public boolean queenSolver(int i, char[][] board, List<List<String>> result) {
        if (i == board.length) {
            result.add(this.charBoardToList(board));
            return true;
        }
        for (int index = 0; index < board[0].length; index++) {
            if (this.available(i, index, board)) {
                board[i][index] = 'Q';
                this.queenSolver(i + 1, board, result);
                board[i][index] = '.';
            }
        }
        return false;
    }
    public List<String> charBoardToList(char[][] board) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                builder.append(board[i][j]);
            }
            list.add(builder.toString());
        }
        return list;
    }
    public boolean available(int i, int j, char[][] board) {
        for (int index = 0; index < board[0].length; index++) {
            if (index != j && board[i][index] == 'Q') {
                return false;
            }
        }
        for (int index = 0; index < board.length; index++) {
            if (index != i && board[index][j] == 'Q') {
                return false;
            }
        }
        int temp_i = i - 1;
        int temp_j = j - 1;
        while (temp_i >= 0 && temp_j >= 0) {
            if (board[temp_i][temp_j] == 'Q') {
                return false;
            }
            temp_i--;
            temp_j--;
        }
        temp_i = i + 1;
        temp_j = j + 1;
        while (temp_i < board.length && temp_j < board[0].length) {
            if (board[temp_i][temp_j] == 'Q') {
                return false;
            }
            temp_i++;
            temp_j++;
        }
        temp_i = i - 1;
        temp_j = j + 1;
        while (temp_i >= 0 && temp_j < board[0].length) {
            if (board[temp_i][temp_j] == 'Q') {
                return false;
            }
            temp_i--;
            temp_j++;
        }
        temp_i = i + 1;
        temp_j = j - 1;
        while (temp_i < board.length && temp_j >= 0) {
            if (board[temp_i][temp_j] == 'Q') {
                return false;
            }
            temp_i++;
            temp_j--;
        }
        return true;
    }
    public void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> result;
        for (int i = 0; i < 9; i++) {
            System.out.println("Solution of " + i + " Queens: ");
            result = solution.solveNQueens(i);
            System.out.println(result);
            System.out.println(result.size());
            System.out.println();
        }
        int num = 9;
        System.out.println("Solution of " + num + " Queens: ");
        result = solution.solveNQueens(num);
        System.out.println(result);
        System.out.println(result.size());
        System.out.println();
    }
}
