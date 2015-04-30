import java.util.ArrayList;
import java.util.Iterator;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
public class Solution {
	public int sumNumbers(TreeNode root) {
		int sum = 0;
		int pathSum = 0;
		ArrayList<Integer> totalSum = new ArrayList<Integer>();
		if (root != null) {
			sumNumbers(root, pathSum, totalSum);
		}
		Iterator<Integer> iterator = totalSum.iterator();
		while (iterator.hasNext()) {
			sum += iterator.next().intValue();
		}
		return sum;
	}
	public void sumNumbers(TreeNode node, int path, ArrayList<Integer> sum) {
		path = path * 10 + node.val;
		if (node.left == null && node.right == null) {
			sum.add(path);
		}
		if (node.left != null) {
			sumNumbers(node.left, path, sum);
		}
		if (node.right != null) {
			sumNumbers(node.right, path, sum);
		}
	}
	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + ", ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + ", ");
			inOrder(root.right);
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode node00 = new TreeNode(0);
		TreeNode node01 = new TreeNode(1);
		TreeNode node02 = new TreeNode(2);
		TreeNode node03 = new TreeNode(3);
		TreeNode node04 = new TreeNode(4);
		TreeNode node05 = new TreeNode(5);
		TreeNode node06 = new TreeNode(6);
		TreeNode node07 = new TreeNode(7);
		TreeNode node08 = new TreeNode(8);
		TreeNode node09 = new TreeNode(9);
		
		node00.left = node01;
		node00.right = node02;
		
		node01.left = node03;
		node01.right = node04;
		
		node02.left = node05;
		node02.right = node06;
		
		node03.left = node07;
		node03.right = node08;
		
		node04.left = node09;
		
		System.out.print("Pre-order: " );
		solution.preOrder(node00);
		System.out.println();
		
		System.out.print("In-order: " );
		solution.inOrder(node00);
		System.out.println();
		
		System.out.println(solution.sumNumbers(node00));
		
		TreeNode node10 = new TreeNode(1);
		TreeNode node11 = new TreeNode(2);
		TreeNode node12 = new TreeNode(3);
		
		node10.left = node11;
		node10.right = node12;
		System.out.println(solution.sumNumbers(node10));
		
		TreeNode nodenull = null;
		System.out.println(solution.sumNumbers(nodenull));
		
	}
}
