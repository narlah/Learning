package interviewPickings.leetcode;

import archive.BinaryTree;
import archive.TreeNode;
import interviewPickings.uber.BinaryTreePaths;

import java.io.IOException;
import java.util.Arrays;

public class PrintBinaryTreeAsArray {

    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,100};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array) + "\n");

        TreeNode rootBalanced = BinaryTree.recBalance(array, 2);
        BinaryTreePaths bp = new BinaryTreePaths();
        rootBalanced.printTree(System.out);
    }




}
