package interviewPickings.leetcode;

import archive.BinaryTree;
import archive.TreeNode;
import interviewPickings.uber.BinaryTreePaths;

import java.io.IOException;
import java.util.Arrays;

public class InvertBinaryTree {

    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array) + "\n");

        TreeNode rootBalanced = BinaryTree.recBalance(array, 2);
        BinaryTreePaths bp = new BinaryTreePaths();
        rootBalanced.printTree(System.out);

        invertTree(rootBalanced).printTree(System.out);
    }

    private static TreeNode invertTree(TreeNode current) {
        if (current == null)
            return current;

        TreeNode left = invertTree(current.left);
        TreeNode right = invertTree(current.right);
        current.left = right;
        current.right = left;

        return current;
    }

    public TreeNode invertTreeTheirs(TreeNode root) {

        if (root == null || (root.right == null && root.left == null)) {
            return root;
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            root.right = invertTree(root.right);
            return root;
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
            root.left = invertTree(root.left);
            return root;
        } else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            root.left = invertTree(root.left);
            root.right = invertTree(root.right);

            return root;
        }

    }


}
