import java.util.Arrays;
import java.util.List;


public class SearchProblems {
    /**************************** Word Search ****************************/
    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cell, 
     * where "adjacent" cells are those horizontally or vertically neighboring. 
     * The same letter cell may not be used more than once.
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] pos = new boolean[board.length][board[0].length];
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                if (word.indexOf(board[i][j]) != -1) {
                    pos[i][j] = true;
                }
            }
        }
        return this.backtrackExist(-1, -1, 0, pos, board, word);
    }
    
    private boolean backtrackExist(int i, int j, int k, boolean[][] pos, char[][] board, String word) {
        if (k == word.length()) {
            return true;
        }
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (this.isValid(m, n, i, j, k, pos, board, word)) {
                    pos[m][n] = false;
                    if (this.backtrackExist(m, n, k + 1, pos, board, word)) {
                        return true;
                    }
                    pos[m][n] = true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int m, int n, int i, int j, int k, boolean[][] pos, char[][] board, String word) {
        boolean flag = pos[m][n] && board[m][n] == word.charAt(k);
        if (k == 0) {
            return flag;
        }
        return flag && ((Math.abs(i - m) == 1 && j == n)||(Math.abs(j - n) == 1 && i == m));
    }

    /**************************** Main ****************************/
    public static void main(String[] args) {
        System.out.println("Hello Backtracking.");
        SearchProblems problems = new SearchProblems();
        problems.testExist();
    }
    /**************************** Testing Methods ****************************/
    public void testExist() {
        char[][] board01 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        this.print(this.exist(board01, "ABCCED"));
        this.print(this.exist(board01, "SEE"));
        this.print(this.exist(board01, "ABCB"));
        this.print(this.exist(board01, "ASFDA"));
    }
    /**************************** Printing Methods ****************************/
    public void print(boolean bool) {
        System.out.println(bool);
    }
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
    public void print(boolean[] array) {
        if (array == null) {
            return;
        }
        for (boolean item: array) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }
    public void print(char[][] array) {
        if (array == null) {
            return ;
        }
        for (int i = 0; i < array.length; i++) {
            this.print(array[i]);
        }
    }
    public void print(boolean[][] array) {
        if (array == null) {
            return ;
        }
        for (int i = 0; i < array.length; i++) {
            this.print(array[i]);
        }
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
}
