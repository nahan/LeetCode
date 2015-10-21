import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 * 
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                temp.add(queue.remove(0));
            }
            result.add(temp.get(temp.size() - 1).val);
            while (!temp.isEmpty()) {
                TreeNode node = temp.remove(0);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + ", ");
            this.preOrder(node.left);
            this.preOrder(node.right);
        }
    }
    public void inOrder(TreeNode node) {
        if (node != null) {
            this.inOrder(node.left);
            System.out.print(node.val + ", ");
            this.inOrder(node.right);
        }
    }
    public void postOrder(TreeNode node) {
        if (node != null) {
            this.postOrder(node.left);
            this.postOrder(node.right);
            System.out.print(node.val + ", ");
        }
    }
    public void breadthFirstPrint(TreeNode root) {
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                temp.add(queue.remove(0));
            }
            System.out.print(temp.get(temp.size() - 1).val + ", ");
            while (!temp.isEmpty()) {
                TreeNode node = temp.remove(0);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        
        node1.left = node2;
        node2.right = node5;
        node1.right = node3;
        node3.right = node4;
        
        System.out.println(solution.rightSideView(null));
        
//        solution.preOrder(node1);
//        System.out.println();
//        solution.inOrder(node1);
//        System.out.println();
//        solution.postOrder(node1);
//        System.out.println();
//        
//        solution.breadthFirstPrint(node1);
    }
}
