/**
 * Date: 10th Sept, 2018
 * @author enashah
 */

/**
 * This problem was asked by Google.
 * 
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 */

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

public class SerializeandDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("Input Tree");
        root.printInorderTraversal(root);
        System.out.println();

        System.out.println("Serialize Tree");
        String serializeTree = serialize(root);
        System.out.println(serializeTree);

        System.out.println("Deserialize Tree");
        TreeNode deserializeRoot = deserialize(serializeTree);
        deserializeRoot.printInorderTraversal(deserializeRoot);
    }

    private static TreeNode deserialize(String serializeTree) {

        if (serializeTree == null) {
            return null;
        }
        String arr[] = serializeTree.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1, j = 0; i < arr.length; j++) {
            if (!arr[j].equals("#")) {
                TreeNode node = q.poll();
                if (!arr[i].equals("#")) {
                    node.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(node.left);
                }
                i++;

                if (!arr[i].equals("#")) {
                    node.right = new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder serializeTree = new StringBuilder();
        q.offer(root);

        serializeTree.append(root.val + " ");

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    serializeTree.append(node.left.val + " ");
                    q.offer(node.left);
                } else {
                    serializeTree.append("# ");
                }

                if (node.right != null) {
                    serializeTree.append(node.right.val + " ");
                    q.offer(node.right);
                } else {
                    serializeTree.append("# ");
                }
            }
        }
        return serializeTree.substring(0, serializeTree.length() - 1).toString();
    }
}
