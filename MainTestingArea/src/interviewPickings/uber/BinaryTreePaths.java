package interviewPickings.uber;

import archive.BinaryTree;
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
    public static void main(String[] args) throws IOException {
        int[] array = {2, 6, 11, 12, 1, 12, 19, 5, 45, 7, 99, 68, 8, 13, 20};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array) + "\n");

        TreeNode rootBalanced = BinaryTree.recBalance(array, 3);
        BinaryTreePaths bp = new BinaryTreePaths();
        rootBalanced.printTree(System.out);

        ArrayList<TreeNode> rootArrayList = new ArrayList<>();
        rootArrayList.add(rootBalanced);

        ArrayList<ArrayList<TreeNode>> result = bp.getPaths(new Params(rootBalanced, 101));

        for (ArrayList<TreeNode> path : result) {
            System.out.println();
            for (TreeNode t : path) {
                System.out.print("->" + t.getValue());
            }
        }
    }

    public ArrayList<ArrayList<TreeNode>> getPaths(Params param) {  //search for 25
        if (param.getEndNode() == null)
            return param.getResult();
        param.setSumSoFar(param.getSumSoFar() + param.getEndNode().getValue());
        param.getPathSoFar().add(param.getEndNode());
        if (param.checkSum()) {
            param.getResult().add(param.getPathSoFar());
            return param.getResult(); //what if we have to continue - remove first and go on ?
        }

        if (param.getSumSoFar() < param.getSearchFor()) {
            getPaths(param.cloneToLeft());
            getPaths(param.cloneToRight());
        } else {
            TreeNode last = param.getEndNode();
            while (param.getSumSoFar() > param.getSearchFor()) {
                param.removeFirstNode();
                if (param.checkSum()) {
                    param.getResult().add(param.getPathSoFar());
                    return param.getResult(); //what if we have to continue - remove first and go on ?
                }
            }
            if (param.getPathSoFar().isEmpty()) {
                getPaths(new Params(null, last.left, 0, param.getSearchFor(), param.getResult()));
                getPaths(new Params(null, last.right, 0, param.getSearchFor(), param.getResult()));
            } else {
                getPaths(param.cloneToRight());
                getPaths(param.cloneToLeft());
            }
        }
        return param.getResult();
    }
}
