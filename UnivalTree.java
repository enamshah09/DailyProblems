import utils.TreeNode;

/**
 * Date: 15th Sept, 2018
 * @author enamshah09
 */

/**
 * This problem was asked by Google.
 * 
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * 
 * Given the root to a binary tree, count the number of unival subtrees.
 * 
 * For example, the following tree has 5 unival subtrees:
 * 
 *    0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 *  
 */

public class UnivalTree {
    static int count = 0;
    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1); // Return 5
        
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(5); // Return 4
        
        UnivalTreeHelper(root);
        System.out.println(count);
        count = 0;
        UnivalTreeHelper(root1);
        System.out.println(count);
    }

    private static boolean UnivalTreeHelper(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftUnival = UnivalTreeHelper(root.left);
        boolean rightUnival = UnivalTreeHelper(root.right);
        
        if(leftUnival == false || rightUnival == false) {
            return false;
        }
        
        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        
        count++;
        return true;
    }
}
