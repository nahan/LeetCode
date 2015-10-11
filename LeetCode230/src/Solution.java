/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 <= k <= BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and 
 * you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
    public int kthSmallest(TreeNode root, int k) {
        if (k == this.countChildren(root.left) + 1) {
            return root.val;
        }
        if (k < this.countChildren(root.left) + 1) {
            return this.kthSmallest(root.left, k);
        }
        if (k > this.countChildren(root.left) + 1) {
            return this.kthSmallest(root.right, k - this.countChildren(root.left) - 1);
        }
        return 0;
    }
    public int countChildren(TreeNode root) {
        if (root != null) {
            return this.countChildren(root.left) + this.countChildren(root.right) + 1;
        } else {
            return 0;
        }
    }
    public void inOrder(TreeNode root) {
        if (root.left != null) {
            this.inOrder(root.left);
        }
        System.out.print(root.val + ", ");
        if (root.right != null) {
            this.inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node10 = new TreeNode(10);
        TreeNode node05 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node02 = new TreeNode(2);
        TreeNode node07 = new TreeNode(7);
        TreeNode node01 = new TreeNode(1);
        TreeNode node03 = new TreeNode(3);
        TreeNode node06 = new TreeNode(6);
        TreeNode node08 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node17 = new TreeNode(17);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node16 = new TreeNode(16);
        TreeNode node18 = new TreeNode(18);
        
        node10.left = node05;
        node10.right = node15;
        node05.left = node02;
        node05.right = node07;
        node02.left = node01;
        node02.right = node03;
        node07.left = node06;
        node07.right = node08;
        node15.left = node12;
        node15.right = node17;
        node12.left = node11;
        node12.right = node13;
        node17.left = node16;
        node17.right = node18;
        
        int test = 9;
        System.out.format("the %d th in tree is: %d.\n", test, solution.kthSmallest(node10, test));
    }
}
