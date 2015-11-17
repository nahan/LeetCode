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
     * use char[][] to present board.
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
     * use int[] to present board.
     * @param args
     */
    public List<int[]> nQueensSolver(int n) {
        List<int[]> result = new ArrayList<int[]>();
        int[] board = new int[n];
        Arrays.fill(board, -1);
        this.placeQueens(0, board, result);
        return result;
    }
    public void placeQueens(int i, int[] board, List<int[]> result) {
        if (i == board.length) {
            result.add(board.clone());
            return;
        }
        for (int pos = 0; pos < board.length; pos++) {
            if (available(i, pos, board)) {
                board[i] = pos;
                this.placeQueens(i + 1, board, result);
            }
        }
    }
    public boolean available(int i, int pos, int[] board) {
        for (int index = 0; index < i; index++) {
            if (board[index] == pos || (Math.abs(index - i) == Math.abs(board[index] - pos))) {
                return false;
            }
        }
        return true;
    }
    /**************************** N-Queens II ****************************/
    /**
     * N-Queens II.
     * @param args
     */
    public int totalNQueens(int n) {
        int[] board = new int[n];
        Arrays.fill(board, -1);
        return this.countNQueens(0, 0, board);
    }
    public int countNQueens(int i, int count, int[] board) {
        if (i == board.length) {
            count++;
        }
        for (int pos = 0; pos < board.length; pos++) {
            if (this.isAvailable(i, pos, board)) {
                board[i] = pos;
                count = this.countNQueens(i + 1, count, board);
            }
        }
        return count;
    }
    public boolean isAvailable(int i, int pos, int[] board) {
        for (int index = 0; index < i; index++) {
            if (board[index] == pos || (Math.abs(index - i) == Math.abs(board[index] - pos))) {
                return false;
            }
        }
        return true;
    }
    /**************************** Sudoku Solver ****************************/
    /**
     * Sudoku Solver.
     * @param args
     */
    public void solveSudoku(char[][] board) {
        boolean[][] available = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    available[i][j] = true;
                } else {
                    available[i][j] = false;
                }
            }
        }
        this.solvingSudoku(0, 0, board, available);
    }
    public boolean solvingSudoku(int i, int j, char[][] board, boolean[][] available) {
        if (j == board[0].length) {
            j = 0;
            i++;
            if (i == board.length) {
                return true;
            }
        }
        if (!available[i][j]) {
            return this.solvingSudoku(i, j + 1, board, available);
        }
        for (int value = 1; value <= board.length; value++) {
            if (this.valid(i, j, value, board)) {
                board[i][j] = this.intToChar(value);
                if (this.solvingSudoku(i, j + 1, board, available)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    public boolean valid(int i, int j, int value, char[][] board) {     
        for (int m = 0; m < board.length; m++) {
            if (m != i && board[m][j] == this.intToChar(value)) {
                return false;
            }
        }
        for (int n = 0; n < board[0].length; n++) {
            if (n != j && board[i][n] == this.intToChar(value)) {
                return false;
            }
        }
        int xLength = (int) Math.sqrt(board.length);
        int yLength = (int) Math.sqrt(board[0].length);
        int xStart = (i / xLength) * xLength;
        int yStart = (j / yLength) * yLength;
        for (int x = xStart; x < xStart + xLength; x++) {
            for (int y = yStart; y < yStart + yLength; y++) {
                if (board[x][y] == this.intToChar(value)) {
                    return false;
                }
            }
        }
        return true;
    }
    public char intToChar(int i) {
        return (char) (i + 48);
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        System.out.println("Hello Backtracking.");
        MatrixProblems problem = new MatrixProblems();
        problem.testSolverNQueens();
        problem.testNQueensSolver();
        problem.testTotalNQueens();
        problem.testSolveSudoku();
    }
    /**************************** Testing Methods ****************************/
    public void testSolverNQueens() {
        this.printMatrix(this.solveNQueens(1));
        this.printMatrix(this.solveNQueens(4));
        this.printMatrix(this.solveNQueens(8));
    }
    public void testNQueensSolver() {
        this.print(this.nQueensSolver(1));
        this.print(this.nQueensSolver(4));
        this.print(this.nQueensSolver(8));
    }
    public void testTotalNQueens() {
        this.print(this.totalNQueens(1));
        this.print(this.totalNQueens(4));
        this.print(this.totalNQueens(8));
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
        System.out.println("before:");
        this.printMatrix(board);
        this.solveSudoku(board);
        System.out.println("after:");
        this.printMatrix(board);
    }
    /**************************** Printing Methods ****************************/
    public void print(int n) {
        System.out.println(n);
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
            System.out.print(item + "\t");
        }
        System.out.println();
    }
    public void print(List<int[]> list) {
        for (int[] item: list) {
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i] + ", ");
            }
            System.out.println();
        }
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
