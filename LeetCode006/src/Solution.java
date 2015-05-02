
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
	public String convert(String s, int numRows) {
		if (s == null) {
			return null;
		}
		if (s.length() <= numRows || numRows == 1) {
			return s;
		}
		
		char[][] matrix = buildMatrix(numRows, s.length() / numRows);
		printMatrix(matrix);
		
		int index = 0;
		for (int column = 0; column < matrix.length; column ++) {
			for (int row = 0; row < matrix[column].length; row += column + 2 * (numRows - 2)) {
				matrix[row][column] = '#';
				index ++;
			}
//			index += ;
			if (index >= s.length()) {
				break;
			}
		}
		
		return null;
	}
	public char[][] buildMatrix(int row, int column) {
		char[][] matrix = new char[row][column + column * (row - 2)];
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = 0; j < matrix[i].length; j ++) {
				matrix[i][j] = '*';
			}
		}
		return matrix;
	}
	public void printMatrix(char[][] matrix) {
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = 0; j < matrix[i].length; j ++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String test00 = null;
		int num00 = 0;
		
		String test01 = "0123456789";
		int num01 = 1;
		
		String test02 = "0123456789";
		int num02 = 2;
		
		String test03 = "0123456789";
		int num03 = 3;
		
		String test04 = "0123456789";
		int num04 = 4;
		
		String test05 = "0123456789";
		int num05 = 5;
		
		System.out.println(solution.convert(test00, num00));
		System.out.println(solution.convert(test01, num01));
		System.out.println(solution.convert(test02, num02));
		System.out.println(solution.convert(test03, num03));
		System.out.println(solution.convert(test04, num04));
		System.out.println(solution.convert(test05, num05));
	}
}
