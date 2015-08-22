
/**
 * Given a binary search tree (BST), 
 * find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
          _______6______
         /              \
     ___2__          ___8__
    /      \        /      \
    0      _4_     7        9
          /   \
         3     5
 *
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
 * Another example is LCA of nodes 2 and 4 is 2, 
 * since a node can be a descendant of itself according to the LCA definition.
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
	public void preOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + ", ");
		}
		if (node.left != null) {
			this.preOrder(node.left);
		}
		if (node.right != null) {
			this.preOrder(node.right);
		}
	}
	
	public void inOrder(TreeNode node) {
		if (node.left != null) {
			this.inOrder(node.left);
		}
		if (node != null) {
			System.out.print(node.val + ", ");
		}
		if (node.right != null) {
			this.inOrder(node.right);
		}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			if (root == null) {
				return null;
			} else if (p == null && q == null) {
				return root;
			}
			return p == null ? q : p;
		}
		
		int bigger = p.val > q.val ? p.val : q.val;
		int smaller = p.val < q.val ? p.val : q.val;
		
		if (root.val > bigger) {
			return this.lowestCommonAncestor(root.left, p, q);
		} else if (root.val < smaller) {
			return this.lowestCommonAncestor(root.right, p, q);
		} else if (root.val > smaller && root.val < bigger) {
			return root;
		} else {
			return root;
		}
    }
	
	public static void testResult(TreeNode node, String msg) {
		if (node != null) {
			System.out.println(node.val + ", " + msg);
		} else {
			System.out.println("NULL Node Returned" + ", " + msg);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello, I am back!");
		
		Solution solution = new Solution();
		
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		
		node6.left = node2;
		node6.right = node8;
		
		node2.left = node0;
		node2.right = node4;
		
		node0.right = node1;
		
		node8.left = node7;
		node8.right = node9;
		
		node4.left = node3;
		node4.right = node5;
		
		solution.preOrder(node6);
		System.out.println();
		solution.inOrder(node6);
		System.out.println();
		
		System.out.println("+++++++++++++++++++++++++++ Entering Test +++++++++++++++++++++++++++");
		testResult(solution.lowestCommonAncestor(node6, null, null), "should be 6.");
		testResult(solution.lowestCommonAncestor(node6, node0, null), "should be 0.");
		testResult(solution.lowestCommonAncestor(node6, null, node0), "should be 0.");
		testResult(solution.lowestCommonAncestor(null, node0, node0), "should be NULL.");
		testResult(solution.lowestCommonAncestor(null, node0, node0), "should be NULL.");
		testResult(solution.lowestCommonAncestor(node6, node2, node8), "should be 6.");
		testResult(solution.lowestCommonAncestor(node6, node4, node2), "should be 2.");
		testResult(solution.lowestCommonAncestor(node6, node0, node9), "should be 6.");
		testResult(solution.lowestCommonAncestor(node6, node7, node9), "should be 8.");
		testResult(solution.lowestCommonAncestor(node6, node0, node5), "should be 2.");
		testResult(solution.lowestCommonAncestor(node6, node3, node5), "should be 4.");
		testResult(solution.lowestCommonAncestor(node6, node4, node7), "should be 6.");
		System.out.println("--------------------------- Leaving Test ---------------------------");
		
	}
}
