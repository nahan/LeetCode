import java.util.ArrayList;
import java.util.List;

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, 
 * return the total number of distinct solutions.
 * @author Han
 *
 */
public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n < 1) {
            return result.size();
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        this.queenSolver(0, board, result);
        return result.size();
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
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 9; i++) {
            System.out.println("Solution of " + i + " Queens: ");
            System.out.println(solution.totalNQueens(i));
            System.out.println();
        }
    }
}
