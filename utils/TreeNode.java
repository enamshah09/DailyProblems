package utils;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int data) {
        val = data;
    }

    public void printPreOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
    }

    public void printInorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorderTraversal(root.left);
        System.out.print(root.val + " ");
        printInorderTraversal(root.right);
    }

    public void printPostOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrderTraversal(root.left);
        printPostOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }
}
