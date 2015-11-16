import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A practice of backtracking.
 * @author Han
 *
 */
public class MatrixProblems {
    /**************************** N-Queens 1 ****************************/
    /**
     * N-Queens.
     * @param args
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        this.placeQueens(0, board, result);
        return result;
    }
    public void placeQueens(int i, char[][] board, List<List<String>> result) {
        if (i == board.length) {
            this.addToResult(board, result);
            return;
        }
        for (int index = 0; index < board[0].length; index++) {
            if (this.available(i, index, board)) {
                board[i][index] = 'Q';
                this.placeQueens(i + 1, board, result);
                board[i][index] = '.';
            }
        }
    }
    public boolean available(int i, int j, char[][] board) {
        for (int m = 0; m < board.length; m++) {
            if (board[m][j] == 'Q') {
                return false;
            }
        }
        for (int n = 0; n < board[0].length; n++) {
            if (board[i][n] == 'Q') {
                return false;
            }
        }
        for (int m = i, n = j; m >= 0 && n >= 0; m--, n--) {
            if (board[m][n] == 'Q') {
                return false;
            }
        }
        for (int m = i, n = j; m < board.length && n < board[0].length; m++, n++) {
            if (board[m][n] == 'Q') {
                return false;
            }
        }
        for (int m = i, n = j; m >= 0 && n < board[0].length; m--, n++) {
            if (board[m][n] == 'Q') {
                return false;
            }
        }
        for (int m = i, n = j; m < board.length && n >= 0; m++, n--) {
            if (board[m][n] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public void addToResult(char[][] board, List<List<String>> result) {
        List<String> solution = new ArrayList<String>();
        for (int m = 0; m < board.length; m++) {
            StringBuilder builder = new StringBuilder();
            for (int n = 0; n < board[0].length; n++) {
                builder.append(board[m][n]);
            }
            solution.add(builder.toString());
        }
        result.add(solution);
    }
    /**************************** N-Queens 2 ****************************/
    /**
     * N-Queens.
     * another
     * @param args
     */
    public List<int[]> nQueensSolver(int n) {
        List<int[]> result = new ArrayList<int[]>();
        return result;
    }
    /**************************** N-Queens II ****************************/
    /**
     * N-Queens II.
     * @param args
     */
    public int totalNQueens(int n) {
        return 0;
    }
    /**************************** Sudoku Solver ****************************/
    /**
     * Sudoku Solver.
     * @param args
     */
    public void solveSudoku(char[][] board) {
        
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        System.out.println("Hello Backtracking.");
        MatrixProblems problem = new MatrixProblems();
        problem.testSolverNQueens();
    }
    /**************************** Testing Methods ****************************/
    public void testSolverNQueens() {
        this.printMatrix(this.solveNQueens(1));
        this.printMatrix(this.solveNQueens(4));
        this.printMatrix(this.solveNQueens(8));
    }
    public void testNQueensSolver() {
        System.out.println(this.nQueensSolver(8));
    }
    public void testTotalNQueens() {
        System.out.println(this.totalNQueens(8));
    }
    public void testSolveSudoku() {
        char[][] board = new char[9][9];
        char[] row0 = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row1 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] row2 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] row3 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] row4 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] row5 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] row6 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] row7 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] row8 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        board[0] = row0;
        board[1] = row1;
        board[2] = row2;
        board[3] = row3;
        board[4] = row4;
        board[5] = row5;
        board[6] = row6;
        board[7] = row7;
        board[8] = row8;
        this.solveSudoku(board);
        this.printMatrix(board);
    }
    /**************************** Printing Methods ****************************/
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
            System.out.print(item + "\t");
        }
        System.out.println();
    }
    public void printList(List<String> list) {
        System.out.println(list);
    }
    public void printMatrix(List<List<String>> matrix) {
        System.out.println(matrix);
    }
    public void printMatrix(char[][] matrix) {
        for (char[] item: matrix) {
            this.print(item);
        }
    }
}
