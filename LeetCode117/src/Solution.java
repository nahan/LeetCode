class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
                TreeLinkNode node = root.next;
                while (node != null) {
                    if (this.getChild(node) != null) {
                        break;
                    } else {
                        node = node.next;
                    }
                }
                root.right.next = this.getChild(node);
            } else {
                TreeLinkNode node = root.next;
                while (node != null) {
                    if (this.getChild(node) != null) {
                        break;
                    } else {
                        node = node.next;
                    }
                }
                root.left.next = this.getChild(node);
            }
        } else {
            if (root.right != null) {
                TreeLinkNode node = root.next;
                while (node != null) {
                    if (this.getChild(node) != null) {
                        break;
                    } else {
                        node = node.next;
                    }
                }
                root.right.next = this.getChild(node);
            }
        }
        if (root.right != null) {
            this.connect(root.right);
        }
        if (root.left != null) {
            this.connect(root.left);
        }
    }
    public TreeLinkNode getChild(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return node.left;
        } else {
            return node.right;
        }
    }
    public void printTreeLink(TreeLinkNode root) {
        this.printLink(root);
        if (root != null) {
            this.printTreeLink(root.left);
        }
    }
    public void printLink(TreeLinkNode node) {
        TreeLinkNode index = node;
        while (index != null) {
            System.out.print(index.val + " -> ");
            index = index.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeLinkNode node1 = new TreeLinkNode(0);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(4);
        TreeLinkNode node4 = new TreeLinkNode(1);
        TreeLinkNode node5 = new TreeLinkNode(3);
        TreeLinkNode node6 = new TreeLinkNode(-1);
        TreeLinkNode node7 = new TreeLinkNode(5);
        TreeLinkNode node8 = new TreeLinkNode(1);
        TreeLinkNode node9 = new TreeLinkNode(6);
        TreeLinkNode node10 = new TreeLinkNode(8);
        TreeLinkNode node11 = new TreeLinkNode(8);
        TreeLinkNode node12 = new TreeLinkNode(8);
        TreeLinkNode node13 = new TreeLinkNode(7);
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        node6.right = node10;
        
        solution.printTreeLink(node1);
        solution.connect(node1);
        solution.printTreeLink(node1);
        
        node1 = new TreeLinkNode(2);
        node2 = new TreeLinkNode(1);
        node3 = new TreeLinkNode(3);
        node4 = new TreeLinkNode(0);
        node5 = new TreeLinkNode(7);
        node6 = new TreeLinkNode(9);
        node7 = new TreeLinkNode(1);
        node8 = new TreeLinkNode(2);
        node9 = new TreeLinkNode(1);
        node10 = new TreeLinkNode(0);
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node5.left = node9;
        node5.right = node10;
        node7.left = node11;
        node7.right = node12;
        node12.left = node13;
        
        solution.printTreeLink(node1);
        solution.connect(node1);
        solution.printTreeLink(node1);
    }
}
