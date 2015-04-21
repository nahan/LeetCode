import java.util.HashMap;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * Each row must have the numbers 1-9 occuring just once.
 * Each column must have the numbers 1-9 occuring just once.
 * And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class Solution {
	public boolean isValidSudoku(char[][] board) {
		if (board == null) {
			return false;
		}
		for (int index = 0; index < board.length; index ++) {
			if (isValidRow(board[index]) == false) {
				return false;
			}
		}
		if (isValidColumn(board) == false) {
			return false;
		}
		for (int row = 0; row < board.length; ) {
			for (int column = 0; column < board.length; ) {
				if (isValidBox(board, row, column) == false) {
					return false;
				}
				column += 3;
			}
			row += 3;
		}
		return true;
	}
	public boolean isValidRow(char[] row) {
		if (row == null) {
			return false;
		}
		HashMap<Character, Boolean> digit = new HashMap<Character, Boolean>();
		for (int index = 0; index < row.length; index ++) {
			if (row[index] == '.') {
				continue;
			} else if ((int)row[index] < 49 || (int)row[index] > 57) {
				return false;
			} else {
				if (digit.get(row[index]) != null && digit.get(row[index]).booleanValue() == true) {
					return false;
				} else {
					digit.put(row[index], true);
				}
			}
		}
		return true;
	}
	public boolean isValidColumn(char[][] board) {
		for (int column = 0; column < board.length; column ++) {
			HashMap<Character, Boolean> digit = new HashMap<Character, Boolean>();
			for (int row = 0; row < board.length; row ++) {
				if (board[row][column] == '.') {
					continue;
				} else if ((int)board[row][column] < 49 || (int)board[row][column] > 57) {
					return false;
				} else {
					if (digit.get(board[row][column]) != null && digit.get(board[row][column]).booleanValue() == true) {
						return false;
					} else {
						digit.put(board[row][column], true);
					}
				}
			}
		}
		return true;
	}
	public boolean isValidBox(char[][] box, int startRow, int startColumn) {
		HashMap<Character, Boolean> digit = new HashMap<Character, Boolean>();
		for (int column = startColumn; column < startColumn + 3; column ++) {
			for (int row = startRow; row < startRow + 3; row ++) {
				if (box[row][column] == '.') {
					continue;
				} else if ((int)box[row][column] < 49 || (int)box[row][column] > 57) {
					return false;
				} else {
					if (digit.get(box[row][column]) != null && digit.get(box[row][column]).booleanValue() == true) {
						return false;
					} else {
						digit.put(box[row][column], true);
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board1 = new char[9][9];
		char[] box1 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] box2 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] box3 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] box4 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] box5 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] box6 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] box7 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] box8 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] box9 = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		board1[0] = box1;
		board1[1] = box2;
		board1[2] = box3;
		board1[3] = box4;
		board1[4] = box5;
		board1[5] = box6;
		board1[6] = box7;
		board1[7] = box8;
		board1[8] = box9;
		
		char[][] board2 = new char[9][9];
		char[] box11 = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
		char[] box12 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
		char[] box13 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
		char[] box14 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
		char[] box15 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
		char[] box16 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
		char[] box17 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
		char[] box18 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
		char[] box19 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
		board2[0] = box11;
		board2[1] = box12;
		board2[2] = box13;
		board2[3] = box14;
		board2[4] = box15;
		board2[5] = box16;
		board2[6] = box17;
		board2[7] = box18;
		board2[8] = box19;
		
		char[][] board3 = new char[9][9];
		char[] box21 = {'.', '.', '.', '.', '5', '.', '.', '1', '.'};
		char[] box22 = {'.', '4', '.', '3', '.', '.', '.', '.', '.'};
		char[] box23 = {'.', '.', '.', '.', '.', '3', '.', '.', '1'};
		char[] box24 = {'8', '.', '.', '.', '.', '.', '.', '2', '.'};
		char[] box25 = {'.', '.', '2', '.', '7', '.', '.', '.', '.'};
		char[] box26 = {'.', '1', '5', '.', '.', '.', '.', '.', '.'};
		char[] box27 = {'.', '.', '.', '.', '.', '2', '.', '.', '.'};
		char[] box28 = {'.', '2', '.', '9', '.', '.', '.', '.', '.'};
		char[] box29 = {'.', '.', '4', '.', '.', '.', '.', '.', '.'};
		board3[0] = box21;
		board3[1] = box22;
		board3[2] = box23;
		board3[3] = box24;
		board3[4] = box25;
		board3[5] = box26;
		board3[6] = box27;
		board3[7] = box28;
		board3[8] = box29;
		
		char[][] board4 = new char[9][9];
		char[] box31 = {'.', '8', '7', '6', '5', '4', '3', '2', '1'};
		char[] box32 = {'2', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] box33 = {'3', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] box34 = {'4', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] box35 = {'5', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] box36 = {'6', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] box37 = {'7', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] box38 = {'8', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] box39 = {'9', '.', '.', '.', '.', '.', '.', '.', '.'};
		board4[0] = box31;
		board4[1] = box32;
		board4[2] = box33;
		board4[3] = box34;
		board4[4] = box35;
		board4[5] = box36;
		board4[6] = box37;
		board4[7] = box38;
		board4[8] = box39;
		
		char[][] board5 = new char[9][9];
		char[] box41 = {'.', '.', '5', '.', '.', '.', '.', '.', '6'};
		char[] box42 = {'.', '.', '.', '.', '1', '4', '.', '.', '.'};
		char[] box43 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] box44 = {'.', '.', '.', '.', '.', '9', '2', '.', '.'};
		char[] box45 = {'5', '.', '.', '.', '.', '2', '.', '.', '.'};
		char[] box46 = {'.', '.', '.', '.', '.', '.', '.', '3', '.'};
		char[] box47 = {'.', '.', '.', '5', '4', '.', '.', '.', '.'};
		char[] box48 = {'3', '.', '.', '.', '.', '.', '4', '2', '.'};
		char[] box49 = {'.', '.', '.', '2', '7', '.', '6', '.', '.'};
		board5[0] = box41;
		board5[1] = box42;
		board5[2] = box43;
		board5[3] = box44;
		board5[4] = box45;
		board5[5] = box46;
		board5[6] = box47;
		board5[7] = box48;
		board5[8] = box49;
		
		System.out.println(solution.isValidSudoku(board1));
		System.out.println(solution.isValidSudoku(board2));
		System.out.println(solution.isValidSudoku(board3));
		System.out.println(solution.isValidSudoku(board4));
		System.out.println(solution.isValidSudoku(board5));
	}
}
