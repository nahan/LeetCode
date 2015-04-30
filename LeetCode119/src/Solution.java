import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> initial = new ArrayList<Integer>();
		List<Integer> previous = initial;
		initial.add(1);
		triangle.add(initial);
		
		int index = 1;
		while (index <= rowIndex) {
			List<Integer> current = new ArrayList<Integer>();
			current.add(1);
			for (int i = 1; i < previous.size(); i ++) {
				current.add(previous.get(i - 1) + previous.get(i));
			}
			current.add(1);
			triangle.add(current);
			previous = current;
			index ++;
		}
		System.out.println(triangle);
		return triangle.get(rowIndex);
	}
	public static void main(String[] args) {
		System.out.println("Hello I am back!");
		Solution solution = new Solution();
		System.out.println(solution.getRow(7));
	}
}
