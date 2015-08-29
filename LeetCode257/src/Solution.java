import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 *       1
 *     /   \
 *    2     3
 *     \
 *      5
 *
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * @author Han
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
		return null;
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode node00 = new TreeNode(2);
		TreeNode node01 = new TreeNode(3);
		TreeNode node02 = new TreeNode(5);
		
		root.left = node00;
		root.right = node01;
		node00.right = node02;
		
		System.out.println(solution.binaryTreePaths(root));
	}
}
