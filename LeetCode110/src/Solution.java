
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
	 * Given a binary tree, determine if it is height-balanced.
	 * For this problem, a height-balanced binary tree is defined as a binary tree 
	 * in which the depth of the two subtrees of every node never differ by more than 1.
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if ((maxDepth(root.left) - maxDepth(root.right) > 1) || (maxDepth(root.right) - maxDepth(root.left) > 1)){
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
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
		
		System.out.println("Is balanced tree: " + solution.isBalanced(node1));
		System.out.println("Is balanced tree: " + solution.isBalanced(node4));
	}
}
