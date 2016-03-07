
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
	 * Given two binary trees, write a function to check if they are equal or not.
	 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
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
		
		System.out.println("Is same tree: " + solution.isSameTree(node1, node4));
	}
	
}
