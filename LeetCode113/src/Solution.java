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
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode index = root;
		stack.push(index);
		List<TreeNode> visited = new ArrayList<TreeNode>();
		while (stack.empty() == false) {
			
			// push all nodes through a path from root.
			TreeNode child = index;
			System.out.println("index: " + index.val);
			while (child != null && !visited.contains(index)) {
				child = index.left;
				if (child != null && !visited.contains(child)) {
					stack.push(child);
					index = child;
				} else {
					child = index.right;
					if (child != null && !visited.contains(child)) {
						stack.push(child);
						index = child;
					}
				}
			}
			printNodeStack(stack);
			
			TreeNode top;
			// check if this path is qualified to get the sum.
			top = stack.peek();
			if (hasPath(stack, sum) == true) {
				visited.add(top);
				List<Integer> path = new ArrayList<Integer>();
				for (TreeNode item: stack) {
					path.add(item.val);
					if (item.left != null && item.right != null && visited.contains(item.left) && visited.contains(item.left)) {
						visited.add(item);
					} else if (item.left != null && item.right == null && visited.contains(item.left)) {
						visited.add(item);
					}
				}
				result.add(path);
				stack.clear();
				
				// add root if all of it's children has not been visited yet.
				if (!visited.contains(root)) {
					index = root;
					stack.add(index);
				}
			} else {
				if (top.left == null && top.right == null) {
					visited.add(stack.pop());
					index = stack.peek();
				} else if (top.left == null && top.right != null) {
					if (visited.contains(top.right)) {
						visited.add(stack.pop());
					}
					index = stack.peek();
				}
//				stack.pop();
//				stack.clear();
			}		
//			stack.clear();
		}
		return result;
	}
	public void printNodeStack(Stack<TreeNode> stack) {
		for (TreeNode item: stack) {
			System.out.print(item.val + ", ");
		}
		System.out.println();
	}
	public boolean hasPath(Stack<TreeNode> stack, int sum) {
		int temp = 0;
		for (TreeNode item: stack) {
			temp += item.val;
		}
		return temp == sum && stack.peek().left == null && stack.peek().right == null? true : false;
	}
	
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root != null && hasPathSum(root, sum) == true) {
//			Stack<Integer> temp = new Stack<Integer>();
//			findPath(root, sum, temp);
//			System.out.println(temp);
			
			List<TreeNode> nodePath = new ArrayList<TreeNode>();
//			findNodePath(root, sum, nodePath);
//			findLeafPath(root, root, sum, nodePath);
			findLeaf(root, sum, nodePath);
//			System.out.println(nodePath);
			for (TreeNode node: nodePath) {
				System.out.print(node.val + ", ");
			}
			System.out.println();
			
			List<Integer> indexPath = null;
			for (int index = 0; index < nodePath.size(); index ++) {
				if (nodePath.get(index) == root) {
					List<Integer> tempPath = new ArrayList<Integer>();
					indexPath = tempPath;
					result.add(indexPath);
				}
				indexPath.add(nodePath.get(index).val);
			}
			
			
//			List<TreeNode> leafList = new ArrayList<TreeNode>();
//			findLeaf(root, sum, leafList);
//			for (TreeNode item: leafList) {
//				Stack<Integer> path = new Stack<Integer>();
//				path.push(item.val);
//				
//				TreeNode parent = findParent(root, item);
//				if (parent != null) {
//					parent = findParent(root, item);
//					path.push(parent.val);
//				}
//				while (parent != root) {
//					parent = findParent(root, parent);
//					if (parent != null) {
//						path.push(parent.val);
//					}
//				}
//				
//				List<Integer> list = new ArrayList<Integer>();
//				while (path.empty() != true) {
//					list.add(path.pop());
//				}
//				
//				result.add(list);
//			}
			
			
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
//	public void findLeaf(TreeNode root, int sum, List<TreeNode> leafList) {
//		if (root.val == sum) {
//			if (root.left == null && root.right == null) {
//				leafList.add(root);
//			}
//		} else {
//			if (root.left != null) {
//				findLeaf(root.left, sum - root.val, leafList);
//			}
//			if (root.right != null) {
//				findLeaf(root.right, sum - root.val, leafList);
//			}
//		}
//	}
//	public void findPath(TreeNode node, int sum, Stack<Integer> path) {
//		if (node.val != sum) {
//			if (node.left != null) {
//				path.push(node.val);
//				findPath(node.left, sum - node.val, path);
//			}
//			if (node.right != null) {
//				path.push(node.val);
//				findPath(node.right, sum - node.val, path);
//			}
//			if (node.left == null && node.right == null) {
//				path.pop();
//			}
//		} else {
//			if (node.left == null && node.right == null) {
//				path.push(node.val);
//			}
//			if (node.left != null) {
//				path.push(node.val);
//				findPath(node.left, sum - node.val, path);
//			}
//			if (node.right != null) {
//				path.push(node.val);
//				findPath(node.right, sum - node.val, path);
//			}
//		}
//	}
	public void findNodePath(TreeNode node, int sum, List<TreeNode> path) {
		if (node.val != sum) {
			if (node.left != null) {
				findNodePath(node.left, sum - node.val, path);
			}
			if (node.right != null) {
				findNodePath(node.right, sum - node.val, path);
			}
			if (node.left == null && node.right == null) {
				path.remove(path.size() - 1);
			}
		} else {
			if (node.left == null && node.right == null) {
				path.add(node);
			}
//			if (node.left != null) {
//				path.add(node);
//				findNodePath(node.left, sum - node.val, path);
//			}
//			if (node.right != null) {
//				path.add(node);
//				findNodePath(node.right, sum - node.val, path);
//			}
		}
	}
	public void findLeafPath(TreeNode root, TreeNode node, int sum, List<TreeNode> path) {
		if (hasPathSum(node, sum) == true) {
			if (node.left == null && node.right == null) {
				path.add(node);
				path.add(root);
			}
			if (node.left != null && node.right == null) {
				path.add(node);
				findLeafPath(root, node.left, sum - node.val, path);
			}
			if (node.right != null && node.left == null) {
				path.add(node);
				findLeafPath(root, node.right, sum - node.val, path);
			}
			if (node.left != null && node.right != null) {
				path.add(node);
				findLeafPath(root, node.left, sum - node.val, path);
				path.add(node);
				findLeafPath(root, node.right, sum - node.val, path);
			}
		} else {
//			if (path.get(path.size() - 1) != root) {
//				path.remove(path.size() - 1);
//			}
			path.remove(path.size() - 1);
		}
	}
	
	public void findLeaf(TreeNode node, int sum, List<TreeNode> path) {
		if (hasPathSum(node, sum) == true) {
			if (node.left == null && node.right == null) {
				path.add(node);
				return;
			}
			if (node.left != null) {
				path.add(node);
				findLeaf(node.left, sum - node.val, path);
			}
			if (node.right != null) {
				path.add(node);
				findLeaf(node.right, sum - node.val, path);
			}
			
		} else {
			path.remove(path.size() - 1);
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
	public void testCase1() {
//		test case 1 ************************************************************************** entering
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
		
//		TreeNode node100 = new TreeNode(100);
//		node07.right = node100;
//		TreeNode node200 = new TreeNode(200);
//		node100.right = node200;
		
//		System.out.print("Pre-order: ");
//		solution.preOrder(node01);
//		System.out.println();
//		System.out.print("In-order: ");
//		solution.inOrder(node01);
//		System.out.println();
//		System.out.print("Post-order: ");
//		solution.postOrder(node01);
//		System.out.println();
		
		System.out.println(pathSum(node01, 22));
//		test case 1 ************************************************************************** leaving
	}
	public void testCase2() {
//		test case 2 ************************************************************************** entering
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

//		System.out.print("Pre-order: ");
//		solution.preOrder(node11);
//		System.out.println();
//		System.out.print("In-order: ");
//		solution.inOrder(node11);
//		System.out.println();
//		System.out.print("Post-order: ");
//		solution.postOrder(node11);
//		System.out.println();
		
		System.out.println(pathSum(node11, 2));
//		test case 2 ************************************************************************** leaving
	}
	public void testCase3() {
//		test case 3 ************************************************************************** entering
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
		TreeNode node009 = new TreeNode(0);
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
		
//		System.out.print("Pre-order: ");
//		solution.preOrder(node001);
//		System.out.println();
//		System.out.print("In-order: ");
//		solution.inOrder(node001);
//		System.out.println();
//		System.out.print("Post-order: ");
//		solution.postOrder(node001);
//		System.out.println();

		System.out.println(pathSum(node001, 2));
//		test case 3 ************************************************************************** leaving
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		solution.testCase1();
//		solution.testCase2();
		solution.testCase3();
	}
}
