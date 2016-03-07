
/**
 * Invert a binary tree.
		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
	to
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
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
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
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
		System.out.println("Hello World!");
		Solution solution = new Solution();
		
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node9 = new TreeNode(9);
		
		node4.left = node2;
		node4.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node9;
		
		solution.preOrder(node4);
		System.out.println();
		solution.inOrder(node4);
		System.out.println();
		
		node4 = solution.invertTree(node4);
		
		solution.preOrder(node4);
		System.out.println();
		solution.inOrder(node4);
		System.out.println();
	}
}
