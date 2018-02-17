package interviewPickings.leetcode;

import archive.BinaryTree;
import archive.TreeNode;

import java.io.IOException;
import java.util.Arrays;

public class SameBinaryTree {

    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array) + "\n");

        TreeNode rootBalanced = BinaryTree.recBalance(array, 2);
        TreeNode rootBalanced2 = BinaryTree.recBalance(array, 3);
        SameBinaryTree sbt = new SameBinaryTree();
        rootBalanced.printTree(System.out);
        rootBalanced2.printTree(System.out);
        System.out.println(sbt.isSameTree(rootBalanced, rootBalanced2));

    }

    public boolean isSameTree(TreeNode firstTree, TreeNode secondTree) {
        if (firstTree == null || secondTree == null) {
            return firstTree == secondTree;
        }
        return (firstTree.val == secondTree.val &&
                isSameTree(firstTree.left, secondTree.left) && isSameTree(firstTree.right, secondTree.right));
    }

}
