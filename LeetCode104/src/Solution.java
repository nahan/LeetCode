
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class Solution {
	/**
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(1);
		node4.left = node5;
		node4.right = node6;
		node5.left = node7;
		
		System.out.println("The max depth: " + solution.maxDepth(node1));
		System.out.println("Is max depth: " + solution.maxDepth(node4));
	}
}
