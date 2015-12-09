public class BinarySearchTree {
    public void delete(TreeNode node, int value) {
        this.deleteAux(node, value);
    }
    public TreeNode deleteAux(TreeNode node, int value) {
        if (node != null) {
            if (node.value < value) {
                node.right = this.deleteAux(node.right, value);
            } else if (node.value > value) {
                node.left = this.deleteAux(node.left, value);
            } else {
                if (node.left == null && node.right == null) {
                    node = null;
                } else if (node.left != null && node.right == null) {
                    node = node.left;
                } else if (node.left == null && node.right != null) {
                    node = node.right;
                } else {
                    TreeNode temp = this.lowestNode(node.right);
                    node.value = temp.value;
                    node.right = this.deleteAux(node.right, temp.value);
                }
            }
        }
        return node;
    }
    public TreeNode lowestNode(TreeNode node) {
        return node.left != null? this.lowestNode(node.left): node;
    }
    public TreeNode highestNode(TreeNode node) {
        return node.right != null? this.highestNode(node.right): node;
    }
    public int lowest(TreeNode node) {
        if (node.left != null) {
            return this.lowest(node.left);
        } else {
            return node.value;
        }
    }
    public int highest(TreeNode node) {
        if (node.right != null) {
            return this.highest(node.right);
        } else {
            return node.value;
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = (new ArrayToBST()).sortedArrayToBST(nums);
        bst.print(root);
        
        bst.delete(root, 10);
        bst.print(root);
        bst.delete(root, -10);
        bst.print(root);
        bst.delete(root, 2);
        bst.print(root);
        bst.delete(root, 3);
        bst.print(root);
        bst.delete(root, 1);
        bst.print(root);
    }
    public void print(TreeNode node) {
        this.preOrderPrint(node);
        System.out.println();
        this.inOrderPrint(node);
        System.out.println();
        this.postOrderPrint(node);
        System.out.println("\n");
    }
    public void preOrderPrint(TreeNode node) {
        System.out.print(node.value);
        if (node.left != null) {
            this.preOrderPrint(node.left);
        }
        if (node.right != null) {
            this.preOrderPrint(node.right);
        }
    }
    public void inOrderPrint(TreeNode node) {
        if (node.left != null) {
            this.inOrderPrint(node.left);
        }
        System.out.print(node.value);
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
        System.out.print(node.value);
    }
}
