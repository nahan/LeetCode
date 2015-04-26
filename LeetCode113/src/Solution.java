import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		if (root != null) {
			List<TreeNode> leafList = new ArrayList<TreeNode>();
			findLeaf(root, sum, leafList);
			for (TreeNode item: leafList) {
				Stack<Integer> path = new Stack<Integer>();
				path.push(item.val);
				
				TreeNode parent = findParent(root, item);
				if (parent != null) {
					parent = findParent(root, item);
					path.push(parent.val);
				}
				while (parent != root) {
					parent = findParent(root, parent);
					if (parent != null) {
						path.push(parent.val);
					}
				}
				
				List<Integer> list = new ArrayList<Integer>();
				while (path.empty() != true) {
					list.add(path.pop());
				}
				
				result.add(list);
			}
//			Stack<TreeNode> temp = new Stack<TreeNode>();
//			temp.push(root);
//			while (temp.empty() != true) {
//				TreeNode top = temp.pop();
//				if (top.left == null && top.right == null) {
//					List<Integer> tempList = new ArrayList<Integer>();
//					tempList.add(top.val);
//					TreeNode parent = findParent(root, top);
//					if (parent != null) {
//						tempList.add(parent.val);
//					}
//					while (parent != root) {
//						parent = findParent(root, parent);
//						if (parent != null) {
//							tempList.add(parent.val);
//						}
//					}
//					int tempSum = 0;
//					for (int item: tempList) {
//						tempSum += item;
//					}
//					if (tempSum == sum) {
//						Stack<Integer> tempResult = new Stack<Integer>();
//						for (int item: tempList) {
//							tempResult.push(item);
//						}
//						tempList.clear();
//						while (tempResult.empty() != true) {
//							tempList.add(tempResult.pop());
//						}
//						result.add(tempList);
//					}
//				}
//				if (top.right != null) {
//					temp.push(top.right);
//				}
//				if (top.left != null) 
//					temp.push(top.left);
//			}
		}
		return result;
	}
	public void findLeaf(TreeNode root, int sum, List<TreeNode> leafList) {
		if (root.val == sum) {
			if (root.left == null && root.right == null) {
				leafList.add(root);
			}
		} else {
			if (root.left != null) {
				findLeaf(root.left, sum - root.val, leafList);
			} 
			if (root.right != null) {
				findLeaf(root.right, sum - root.val, leafList);
			}
		}
	}
	public TreeNode findParent(TreeNode root, TreeNode target) {
		if (root.left == target || root.right == target) {
			return root;
		} else {
			if (root.left != null && findParent(root.left, target) != null) {
				return findParent(root.left, target);
			}
			if (root.right != null && findParent(root.right, target) != null) {
				return findParent(root.right, target);
			}
			return null;
		}
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
	public static void main(String[] args) {
		Solution solution = new Solution();
		
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
		
		node03.left = node05;
		node03.right = node06;
		
		node04.left = node07;
		node04.right = node08;
		
		node06.left = node09;
		node06.right = node10;
		
//		System.out.print("Pre-order: ");
//		solution.preOrder(node01);
//		System.out.println();
//		System.out.print("In-order: ");
//		solution.inOrder(node01);
//		System.out.println();
//		System.out.print("Post-order: ");
//		solution.postOrder(node01);
//		System.out.println();
		
		System.out.println(solution.pathSum(node01, 22));
	}
}
