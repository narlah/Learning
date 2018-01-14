package interviewPickings.uber;

import archive.BinaryTree;
import archive.TreeNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/*
Interview Questions
    You are given a binary tree in which each node contains an integer value.
    List all paths that sum to a given target value.
    The path does not need to start or end at the root or a leaf, but it must go downwards
    (traveling only from parent nodes to child nodes).
 */
public class BinaryTreePaths {
    public static void main(String[] args) throws IOException {
        int[] array = {2, 6, 11, 12, 1, 12, 12, 23, 12, 19, 5, 45, 7, 99, 68, 8, 13, 20};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array) + "\n");

        TreeNode rootBalanced = BinaryTree.recBalance(array, 3);
        BinaryTreePaths bp = new BinaryTreePaths();
        rootBalanced.printTree(System.out);

        bp.getPaths(new Params(rootBalanced, 23)); // HashMap<TreeNode, ArrayList<ArrayList<TreeNode>>> allPathsPerNode =
//        for (TreeNode keyTreeNode : allPathsPerNode.keySet()) {
//            System.out.println("\n->      " + keyTreeNode.getValue());
//            for (ArrayList<TreeNode> paths : allPathsPerNode.get(keyTreeNode)) {
//                System.out.println(Arrays.toString(paths.stream().map(TreeNode::getValue).collect(Collectors.toCollection(ArrayList::new)).toArray()));
//            }
//        }
    }

    void getPaths(Params param) { //HashMap<TreeNode, ArrayList<ArrayList<TreeNode>>>
        if (param.getEndNode() == null)
            return; //null
        param.setSumSoFar(param.getSumSoFar() + param.getEndNode().getValue());
        param.getPathSoFar().add(param.getEndNode());
        TreeNode last = param.getEndNode();
//        param.getPathsPerNode().get(param.getFirstNode()).add(param.getPathSoFar());
        if (param.checkSum()) {
            System.out.println(param.getPathSoFarAsString());
            param.removeFirstNode();
        }
        if (param.getSumSoFar() > param.getSearchFor()) {
            while (param.getSumSoFar() > param.getSearchFor()) {
                param.removeFirstNode();
//                if (param.getSumSoFar()>0)
//                    param.getPathsPerNode().get(param.getFirstNode()).add(param.getPathSoFar());
                if (param.checkSum()) {
                    System.out.println(param.getPathSoFarAsString());
                }
            }
        }
        if (param.getPathSoFar().isEmpty()) {
            getPaths(new Params(null, last.left, 0, param.getSearchFor())); //, param.getPathsPerNode()
            getPaths(new Params(null, last.right, 0, param.getSearchFor())); //,,param.getPathsPerNode())
        } else {
            getPaths(param.cloneToRight());
            getPaths(param.cloneToLeft());
        }
        //return param.getPathsPerNode();

    }
}