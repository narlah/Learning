package interviewPickings.uber;

import archive.TreeNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
Interview Questions
    You are given a binary tree in which each node contains an integer value.
    List all paths that sum to a given target value.
    The path does not need to start or end at the root or a leaf, but it must go downwards
    (traveling only from parent nodes to child nodes).
 */
public class BinaryTreePaths {
    final static int searchFor = 25;

    public static void main(String[] args) throws IOException {
        int[] array = {2, 6, 11, 12, 1, 12, 19, 5, 45, 7, 99, 68, 8, 13, 20};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array) + "\n");

        TreeNode rootBalanced = recBalance(array, 2);
        BinaryTreePaths bp = new BinaryTreePaths();
        bp.getPaths();
        rootBalanced.printTree(System.out);
    }

    public ArrayList<Integer[]> getPaths() {

                //TreeNode end

        return new ArrayList<>();
    }

    private static TreeNode recBalance(int[] inList, int binaryBalanceFactor) {
        if (inList.length == 0)
            return null; // empty leaf , do nothing
        if (inList.length == 1)
            return new TreeNode(inList[0], null, null); // create leaf, return it

        int middleIndex = inList.length / binaryBalanceFactor;
        TreeNode tempRoot = new TreeNode(inList[middleIndex], null, null);

        int[] leftPart = new int[middleIndex];
        System.arraycopy(inList, 0, leftPart, 0, middleIndex);

        int[] rightPart = new int[inList.length - middleIndex - 1];
        System.arraycopy(inList, middleIndex + 1, rightPart, 0, inList.length - middleIndex - 1);

        tempRoot.left = recBalance(leftPart, binaryBalanceFactor);
        tempRoot.right = recBalance(rightPart, binaryBalanceFactor);

        return tempRoot;
    }

}
