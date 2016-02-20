class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return this.build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (start1 == end1 && start2 == end2 && inorder[start1] == postorder[start2]) {
            return new TreeNode(inorder[start1]);
        }
        int nodeValue = postorder[end2];
        TreeNode node = new TreeNode(nodeValue);
        int nodeIndex = 0;
        for (int i = start1; i <= end1; i++) {
            if (inorder[i] == nodeValue) {
                nodeIndex = i;
                break;
            }
        }
        if (nodeIndex > start1) {
            int inLength = nodeIndex - start1;
            node.left = this.build(inorder, start1, nodeIndex - 1, postorder, start2, start2 + inLength - 1);
        }
        if (nodeIndex < end1) {
            int postLength = end1 - nodeIndex;
            node.right = this.build(inorder, nodeIndex + 1, end1, postorder, end2 - postLength, end2 - 1);
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
        
        solution.postOrderPrint(node5);
        System.out.println();
        
        System.out.println("#################################");
        int[] in = {1, 2, 3, 4, 5, 6, 7};
        int[] post = {2, 1, 4, 3, 6, 7, 5};
        TreeNode tree = solution.buildTree(in, post);
        solution.inOrderPrint(tree);
        System.out.println();
        solution.postOrderPrint(tree);
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
    public void postOrderPrint(TreeNode node) {
        if (node.left != null) {
            this.postOrderPrint(node.left);
        }
        if (node.right != null) {
            this.postOrderPrint(node.right);
        }
        System.out.print(node.val + ", ");
    }
    public void print(int[] a) {
        for (int i: a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
