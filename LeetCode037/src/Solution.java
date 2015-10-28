/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * @author Han
 *
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
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
        this.sudokuSolver(0, 0, board, available);
    }
    public boolean sudokuSolver(int i, int j, char[][] board, boolean[][] available) {
        if (j == board[0].length) {
            j = 0;
            i++;
            if (i == board.length) {
                return true;
            }
        }
        if (!available[i][j]) {
            return this.sudokuSolver(i, j + 1, board, available);
        }
        for (int num = 1; num <= board.length; num++) {
            if (this.isValid(board, i, j, this.intToChar(num))) {
                board[i][j] = this.intToChar(num);
                if (this.sudokuSolver(i, j + 1, board, available)) {
                    return true;
                }
            }
        }
        board[i][j] = '.';
        return false;
    }
    public char intToChar(int i) {
        return (char) (i + 48);
    }
    public int charToInt(char i) {
        return (int) (i - 48);
    }
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!isValid(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int i, int j, char value) {
        for (int index = 0; index < board[0].length; index++) {
            if (index != j) {
                if (board[i][index] != '.' && board[i][index] == value) {
                    return false;
                }
            }
        }
        for (int index = 0; index < board.length; index++) {
            if (index != i) {
                if (board[index][j] != '.' && board[index][j] == value) {
                    return false;
                }
            }
        }
        int size = (int) Math.sqrt(board.length);
        int iStart = i / size;
        int jStart = j / size;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int curI = iStart * size + row;
                int curJ = jStart * size + col;
                if (curI != i && curJ != j) {
                    char cur = board[curI][curJ];
                    if (cur != '.' && cur == value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public int[] previousAvailable(int i, int j, boolean[][] available) {
        int a = i;
        int b = j - 1;
        if (b == -1) {
            b = 8;
            a--;
            if (a == -1) {
                int[] nearest = {-1, -1};
                return nearest;
            }
        }
        if (available[a][b]) {
            int[] nearest = {a, b};
            return nearest;
        } else {
            return this.previousAvailable(a, b, available);
        }
    }
    public int[] nextAvailable(int i, int j, boolean[][] available) {
        int a = i;
        int b = j + 1;
        if (b == 9) {
            b = 0;
            a++;
            if (a == 9) {
                int[] nearest = {-1, -1};
                return nearest;
            }
        }
        if (available[a][b]) {
            int[] nearest = {a, b};
            return nearest;
        } else {
            return this.nextAvailable(a, b, available);
        }
    }
    public void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board00 = null;
        char[][] board01 = {};
        char[][] board02 = new char[9][9];
        char[][] board03 = new char[9][9];
        
        char[] row00 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row01 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row02 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row03 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row04 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row05 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row06 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row07 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row08 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        board02[0] = row00;
        board02[1] = row01;
        board02[2] = row02;
        board02[3] = row03;
        board02[4] = row04;
        board02[5] = row05;
        board02[6] = row06;
        board02[7] = row07;
        board02[8] = row08;

        char[] row0 = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row1 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] row2 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] row3 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] row4 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] row5 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] row6 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] row7 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] row8 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        board03[0] = row0;
        board03[1] = row1;
        board03[2] = row2;
        board03[3] = row3;
        board03[4] = row4;
        board03[5] = row5;
        board03[6] = row6;
        board03[7] = row7;
        board03[8] = row8;
        
//        System.out.println(solution.charToInt('1'));
//        System.out.println(solution.intToChar(3));
        
        solution.solveSudoku(board00);
        solution.solveSudoku(board01);
        
        solution.printBoard(board02);
        solution.solveSudoku(board02);
        solution.printBoard(board02);
        
        solution.printBoard(board03);
        solution.solveSudoku(board03);
        solution.printBoard(board03);
        
    }
}
