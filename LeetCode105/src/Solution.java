class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        return this.build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 == end1 && start2 == end2 && preorder[start1] == inorder[start2]) {
            return new TreeNode(preorder[start1]);
        }
        int nodeValue = preorder[start1];
        TreeNode node = new TreeNode(nodeValue);
        int nodeIndex = 0;
        for (int i = start2; i <= end2; i++) {
            if (inorder[i] == nodeValue) {
                nodeIndex = i;
                break;
            }
        }
        if (nodeIndex > start2) {
            int leftLength = nodeIndex - start2;
            node.left = this.build(preorder, start1 + 1, start1 + leftLength, inorder, start2, nodeIndex - 1);
        }
        if (nodeIndex < end2) {
            int rightLength = end2 - nodeIndex;
            node.right = this.build(preorder, end1 - rightLength + 1, end1, inorder, nodeIndex + 1, end2);
        }
        return node;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        
        node5.left = node3;
        node5.right = node7;
        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        node7.left = node6;
        
        solution.inOrderPrint(node5);
        System.out.println();
        
        solution.preOrderPrint(node5);
        System.out.println();
        
        System.out.println("#################################");
        int[] pre = {5, 3, 1, 2, 4, 7, 6};
        int[] in = {1, 2, 3, 4, 5, 6, 7};
        TreeNode tree = solution.buildTree(pre, in);
        solution.inOrderPrint(tree);
        System.out.println();
        solution.preOrderPrint(tree);
        System.out.println();
    }
    public void inOrderPrint(TreeNode node) {
        if (node.left != null) {
            this.inOrderPrint(node.left);
        }
        System.out.print(node.val + ", ");
        if (node.right != null) {
            this.inOrderPrint(node.right);
        }
    }
    public void preOrderPrint(TreeNode node) {
        System.out.print(node.val + ", ");
        if (node.left != null) {
            this.preOrderPrint(node.left);
        }
        if (node.right != null) {
            this.preOrderPrint(node.right);
        }
    }
    public void print(int[] a) {
        for (int i: a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
