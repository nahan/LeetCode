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
		
		/////////////////////////////////////////////////////////
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i ++) {
			temp.add(1);
		}
		if (rowIndex < 2) {
			System.out.println(temp);
			return triangle.get(rowIndex);
		}
		
		int mid_index = rowIndex / 2;
		int row_index = 2;
		while (row_index <= rowIndex) {
			System.out.println("\nentering current loop, the list is: " + temp);
			int left_index = 0;
			int right_index = 0;
			while (mid_index - left_index + 1 != mid_index) {
				System.out.println("first sub-loop: to calculate half.");
				temp.set(mid_index - left_index, temp.get(mid_index) + temp.get(mid_index + right_index + 1));
				left_index ++;
				right_index ++;
			}
			
			System.out.println("after half-calculate, the list is: " + temp);
			
			left_index = 0;
			right_index = 0;
			while (right_index < mid_index) {
				System.out.println("second sub-loop: to rotate.");
				if ((row_index + 1) % 2 == 0) {
					System.out.println("even row index.");
					temp.set(mid_index + right_index + 1, temp.get(mid_index - left_index));
				} else {
					System.out.println("odd row index.");
					temp.set(mid_index + right_index + 1, temp.get(mid_index - left_index - 1));
				}
				left_index ++;
				right_index ++;
			}
			
			row_index ++;
			System.out.println("during current loop, the list is: " + temp);
		}
		System.out.println(temp);
		
		
		/////////////////////////////////////////////////////////
		return triangle.get(rowIndex);
	}
	public static void main(String[] args) {
		System.out.println("Hello I am back!");
		Solution solution = new Solution();
		System.out.println(solution.getRow(4));
	}
}
