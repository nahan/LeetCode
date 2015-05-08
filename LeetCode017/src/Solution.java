import java.util.ArrayList;
import java.util.List;


/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0 || (digits.length() == 1 && (digits.charAt(0) == '0' || digits.charAt(0) == '1'))) {
			return result;
		}
		String[][] board = new String[10][];
		board[0] = null;
		board[1] = null;
		board[2] = new String[] {"a", "b", "c"};
		board[3] = new String[] {"d", "e", "f"};
		board[4] = new String[] {"g", "h", "i"};
		board[5] = new String[] {"j", "k", "l"};
		board[6] = new String[] {"m", "n", "o"};
		board[7] = new String[] {"p", "q", "r", "s"};
		board[8] = new String[] {"t", "u", "v"};
		board[9] = new String[] {"w", "x", "y", "z"};
		
		int length = digits.length();
		for (int i = 0; i < digits.length(); i ++) {
			if (digits.charAt(i) == '0' || digits.charAt(i) == '1') {
				length --;
			}
		}
		String[][] input = new String[length][];
		int rowIndex = 0;
		int digitsIndex = 0;
		while (rowIndex < input.length && digitsIndex < digits.length()) {
			if (digits.charAt(digitsIndex) == '0' || digits.charAt(digitsIndex) == '1')	{
				digitsIndex ++;
			} else {
				input[rowIndex] = board[(int)digits.charAt(digitsIndex) - 48];
				digitsIndex ++;
				rowIndex ++;
			}
		}
		if (input.length == 1) {
			for (int i = 0; i < input[0].length; i ++) {
				result.add(input[0][i]);
			}
			return result;
		}
		String[] temp = matrixCombin(input[0], input[1]);
		for (int i = 2; i < input.length; i ++) {
			temp = matrixCombin(temp, input[i]);
		}
		
		for (int i = 0; i < temp.length; i ++) {
			result.add(temp[i]);
		}
		return result;
	}
	public String[] matrixCombin(String[] matrix1, String[] matrix2) {
		String[] result = new String[matrix1.length * matrix2.length];
		int resultIndex = 0;
		while (resultIndex < result.length) {
			int matrixIndex1 = 0;
			while (matrixIndex1 < matrix1.length) {
				int matrixIndex2 = 0;
				while (matrixIndex2 < matrix2.length) {
					result[resultIndex] = matrix1[matrixIndex1] + matrix2[matrixIndex2];
					resultIndex ++;
					matrixIndex2 ++;
				}
				matrixIndex1 ++;
			}
		}
		return result;
	}
	public void printMatrix(String[][] matrix) {
		for (String[] item: matrix) {
			printArray(item);
		}
	}
	public void printArray(String[] array) {
		for (String item: array) {
			System.out.print(item + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String test00 = null;
		String test01 = "";
		String test02 = "1";
		String test03 = "2";
		String test04 = "12";
		String test05 = "123";
		String test06 = "23";
		String test07 = "234";
		String test08 = "23456789";
		
		System.out.println(solution.letterCombinations(test00));
		System.out.println(solution.letterCombinations(test01));
		System.out.println(solution.letterCombinations(test02));
		System.out.println(solution.letterCombinations(test03));
		System.out.println(solution.letterCombinations(test04));
		System.out.println(solution.letterCombinations(test05));
		System.out.println(solution.letterCombinations(test06));
		System.out.println(solution.letterCombinations(test07));
		System.out.println(solution.letterCombinations(test08));
		
	}
}
