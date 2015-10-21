/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
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
    public void flatten(TreeNode root) {
        if (root != null) {
            this.doFlatten(root);
            this.switchToRight(root);
        }
    }
    public void doFlatten(TreeNode node) {
        if (node.right != null) {
            if (node.left != null) {
                this.insert(node.left, node.right);
            } else {
                node.left = node.right;
            }
            node.right = null;
        }
        if (node.left != null) {
            this.doFlatten(node.left);
        }
    }
    public void insert(TreeNode node1, TreeNode node2) {
        if (node1.right == null) {
            node1.right = node2;
        } else {
            this.insert(node1.right, node2);
        }
    }
    public void switchToRight(TreeNode node) {
        if (node.left != null) {
            node.right = node.left;
            node.left = null;
            this.switchToRight(node.right);
        }
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
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        
        solution.preOrder(node1);
        System.out.println();
        solution.inOrder(node1);
        System.out.println();
        solution.postOrder(node1);
        System.out.println();
        
        solution.flatten(node1);
        System.out.println();
        
        solution.preOrder(node1);
        System.out.println();
        solution.inOrder(node1);
        System.out.println();
        solution.postOrder(node1);
        System.out.println();
        
//        System.out.println(node1.val);
//        System.out.println(node1.left.val);
//        System.out.println(node1.left.left.val);
//        System.out.println(node1.left.left.left.val);
//        System.out.println(node1.left.left.left.left.val);
    }
}
