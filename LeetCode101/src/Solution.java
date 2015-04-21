
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
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 * For example, this binary tree is symmetric:
	 */
	public boolean isSymmetric(TreeNode root) {
		if ((root == null) || (root.left == null && root.right == null)) {
			return true;
		} else {
			if (root.left != null && root.right != null) {
				return isSymmetricTree(root.left, root.right);
			}
		}
		return false;
    }
	public boolean isSymmetricTree(TreeNode p, TreeNode q) {
		if ((p != null && q == null) || (p == null && q != null)) {
			return false;
		} else {
			if (p == null && q == null) {
				return true;
			}
			if (p.val == q.val) {
				return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
			} else {
				return false;
			}
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode node1 = new TreeNode(1);
		//TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(1);
		//node1.left = node2;
		node1.right = node3;
		
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		//TreeNode node6 = new TreeNode(1);
		node4.left = node5;
		//node4.right = node6;
		
		System.out.println("Is symmetric tree: " + solution.isSymmetric(node1));
		System.out.println("Is symmetric tree: " + solution.isSymmetric(node4));
	}
}
