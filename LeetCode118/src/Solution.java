
import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		for (int row = 0; row < numRows; row ++) {
			triangle.add(new ArrayList<Integer>());
			List<Integer> current = triangle.get(row);
			current.add(1);
			if (row > 0) {
				List<Integer> previous = triangle.get(row - 1);
				int index = 0;
				while (index < row - 1) {
					current.add(previous.get(index) + previous.get(index + 1));
					index ++;
				}
				current.add(1);
			}
		}
		return triangle;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generate(0));
		System.out.println(solution.generate(1));
		System.out.println(solution.generate(2));
		System.out.println(solution.generate(3));
		System.out.println(solution.generate(4));
		System.out.println(solution.generate(5));
		System.out.println(solution.generate(10));
	}

}
