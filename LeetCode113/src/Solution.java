import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 * return
		[
		   [5,4,11,2],
		   [5,8,4,5]
		]
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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root != null && hasPathSum(root, sum) == true) {
			
			List<TreeNode> nodePath = new ArrayList<TreeNode>();
			findLeaf(root, sum, nodePath, result);
		}
		return result;
	}
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
	public void findLeaf(TreeNode node, int sum, List<TreeNode> path, List<List<Integer>> result) {
		if (hasPathSum(node, sum) == true) {
			path.add(node);
			if (node.left == null && node.right == null) {
				Iterator<TreeNode> iterator = path.iterator();
				List<Integer> temp = new ArrayList<Integer>();
				while (iterator.hasNext()) {
					temp.add(iterator.next().val);
				}
				result.add(temp);
			}
			if (node.left != null) {
				findLeaf(node.left, sum - node.val, path, result);
			}
			if (node.right != null) {
				findLeaf(node.right, sum - node.val, path, result);
			}
			path.remove(path.size() - 1);
		}
	}
	
	public void printListNodeValue(List<TreeNode> list) {
		Iterator<TreeNode> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next().val + ", ");
		}
		System.out.println();
	}
	
	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + ", ");
		if (root.left != null) {
			preOrder(root.left);
		}
		if (root.right != null) {
			preOrder(root.right);
		}
	}
	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			inOrder(root.left);
		}
		System.out.print(root.val + ", ");
		if (root.right != null) {
			inOrder(root.right);
		}
	}
	public void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			postOrder(root.left);
		}
		if (root.right != null) {
			postOrder(root.right);
		}
		System.out.print(root.val + ", ");
	}
	
	public void testCase1() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Entering test case 1: ");
		TreeNode node01 = new TreeNode(5);
		TreeNode node02 = new TreeNode(4);
		TreeNode node03 = new TreeNode(8);
		TreeNode node04 = new TreeNode(11);
		TreeNode node05 = new TreeNode(13);
		TreeNode node06 = new TreeNode(4);
		TreeNode node07 = new TreeNode(7);
		TreeNode node08 = new TreeNode(2);
		TreeNode node09 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		
		node01.left = node02;
		node01.right = node03;
		
		node02.left = node04;
		node02.right = new TreeNode(13);
		
		node03.left = node05;
		node03.right = node06;
		
		node04.left = node07;
		node04.right = node08;
		
		node06.left = node09;
		node06.right = node10;
		
		System.out.print("Pre-order: ");
		preOrder(node01);
		System.out.println();
		System.out.print("In-order: ");
		inOrder(node01);
		System.out.println();
		System.out.print("Post-order: ");
		postOrder(node01);
		System.out.println();
		
		System.out.println("Output: " + pathSum(node01, 22));
		System.out.println("---------------------------------------------------------- Leaving test case 3: ");
	}
	
	public void testCase2() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Entering test case 2: ");
//		Input:	{1,-2,-3,1,3,-2,#,-1}, 2
//		Output:	[[1,-2,-2,3],[1]]
//		Expected:	[[1,-2,3]]
		
		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(-2);
		TreeNode node13 = new TreeNode(-3);
		TreeNode node14 = new TreeNode(1);
		TreeNode node15 = new TreeNode(3);
		TreeNode node16 = new TreeNode(-2);
		TreeNode node17 = new TreeNode(-1);
		
		node11.left = node12;
		node11.right = node13;
		
		node12.left = node14;
		node12.right = node15;
		
		node13.left = node16;
		
		node14.left = node17;
		node17.left = new TreeNode(-1);

		System.out.print("Pre-order: ");
		preOrder(node11);
		System.out.println();
		System.out.print("In-order: ");
		inOrder(node11);
		System.out.println();
		System.out.print("Post-order: ");
		postOrder(node11);
		System.out.println();
		
		System.out.println("Output: " + pathSum(node11, 2));
		System.out.println("---------------------------------------------------------- Leaving test case 3: ");
	}
	
	public void testCase3() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Entering test case 3: ");
//		Input:	{1,0,1,1,2,0,-1,0,1,-1,0,-1,0,1,0}, 2
//		Output:	[[1,0,1,0,0,2,-1],[1,1,0,0,1,-1,1]]
//		Expected:	[[1,0,1,0],[1,0,2,-1],[1,1,0,0],[1,1,-1,1]]
		
		TreeNode node001 = new TreeNode(1);
		TreeNode node002 = new TreeNode(0);
		TreeNode node003 = new TreeNode(1);
		TreeNode node004 = new TreeNode(1);
		TreeNode node005 = new TreeNode(2);
		TreeNode node006 = new TreeNode(0);
		TreeNode node007 = new TreeNode(-1);
		TreeNode node008 = new TreeNode(0);
		TreeNode node009 = new TreeNode(1);
		TreeNode node010 = new TreeNode(-1);
		TreeNode node011 = new TreeNode(0);
		TreeNode node012 = new TreeNode(-1);
		TreeNode node013 = new TreeNode(0);
		TreeNode node014 = new TreeNode(1);
		TreeNode node015 = new TreeNode(0);
		
		node001.left = node002;
		node001.right = node003;
		
		node002.left = node004;
		node002.right = node005;
		
		node003.left = node006;
		node003.right = node007;
		
		node004.left = node008;
		node004.right = node009;
		
		node005.left = node010;
		node005.right = node011;
		
		node006.left = node012;
		node006.right = node013;
		
		node007.left = node014;
		node007.right = node015;
		
		System.out.print("Pre-order: ");
		preOrder(node001);
		System.out.println();
		System.out.print("In-order: ");
		inOrder(node001);
		System.out.println();
		System.out.print("Post-order: ");
		postOrder(node001);
		System.out.println();

		System.out.println("Output: " + pathSum(node001, 2));
		System.out.println("---------------------------------------------------------- Leaving test case 3: ");
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.testCase1();
		solution.testCase2();
		solution.testCase3();
	}
}
