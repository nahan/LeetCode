
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class Solution {
//	Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
//	such that adding up all the values along the path equals the given sum.
//
//	For example:
//	Given the below binary tree and sum = 22,
//	              5
//	             / \
//	            4   8
//	           /   / \
//	          11  13  4
//	         /  \      \
//	        7    2      1
//	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if ((sum - root.val == 0) && (root.left == null && root.right == null)) {
			return true;
		} else {
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		//TreeNode node3 = new TreeNode(1);
		node1.left = node2;
		//node1.right = node3;
		
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(1);
		node4.left = node5;
		node4.right = node6;
		node5.left = node7;
		
		System.out.println("Has a root-to-leaf path: " + solution.hasPathSum(node1, 3));
		System.out.println("Has a root-to-leaf path: " + solution.hasPathSum(node4, 2));
	}
}
