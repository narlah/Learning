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
    public static HashMap<TreeNode, ArrayList<ArrayList<TreeNode>>> allPathsPerNode = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int[] array = {2, 6, 11, 12, 1, 23, 19, 5, 45, 7, 99, 68, 8, 13, 20, 25, 14, 15, 16, 66, 31, 991};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array) + "\n");

        TreeNode rootBalanced = BinaryTree.recBalance(array, 3);
        rootBalanced.printTree(System.out);

        //finds all paths are sums to that number
        getPaths(new Params(rootBalanced, 20));


        //Things get harder - we find all the paths going down through the root
        getAllPaths(new Params(rootBalanced, Integer.MAX_VALUE));
        System.out.println("\nAllPaths DOWNSTREAM ----------------------------------------- :");

        for (TreeNode keyTreeNode : allPathsPerNode.keySet()) {
            System.out.println("\n->      " + keyTreeNode.getValue());
            ArrayList<ArrayList<TreeNode>> pathsForThatNode = allPathsPerNode.get(keyTreeNode);
            for (ArrayList<TreeNode> path : pathsForThatNode) {
                System.out.println(Arrays.toString(path.stream().map(TreeNode::getValue).collect(Collectors.toCollection(ArrayList::new)).toArray()));
            }
        }

        System.out.println("\n All paths SIDEWAYS ----------------------------------------- : ");
        //Now to the hard stuff - find all paths SIDEWAYS
        for (TreeNode keyTreeNode : allPathsPerNode.keySet()) {
            System.out.println("\n = " + keyTreeNode.getValue() + " = ");
            ArrayList<ArrayList<TreeNode>> pathsForThatNode = allPathsPerNode.get(keyTreeNode);

            //find the middle point - where the tho paths divide - the left portion and the right portion and then n^2
            // them to get all the paths to the left combined with all the paths on the right
            int indexOfChange = pathsForThatNode.size();
            int valueOfChange = pathsForThatNode.get(0).get(0).getValue();
            for (int i = 0; i < pathsForThatNode.size(); i++) {
                if (pathsForThatNode.get(i).get(0).getValue() != valueOfChange) {
                    indexOfChange = i;
                    break;
                }
            }

            if (indexOfChange < pathsForThatNode.size()) {
                for (int i = 0; i < indexOfChange; i++) {
                    for (int j = indexOfChange; j < pathsForThatNode.size(); j++) {
                        System.out.print(Arrays.toString(pathsForThatNode.get(i).stream().map(TreeNode::getValue).collect(Collectors.toCollection(ArrayList::new)).toArray()) + "  -> " + keyTreeNode.getValue() + " -> ");
                        System.out.println(Arrays.toString(pathsForThatNode.get(j).stream().map(TreeNode::getValue).collect(Collectors.toCollection(ArrayList::new)).toArray()));
                    }

                }
            }
        }
    }

    public static void getAllPaths(Params param) {
        if (param.getEndNode() == null)
            return;
        param.getPathSoFar().add(param.getEndNode());
        if (param.getPathSoFar().size() > 1)
            allPathsPerNode.get(getFirstNode(param)).add(param.cloneThePath());
        getAllPaths(param.cloneToLeft());
        getAllPaths(param.cloneToRight());
        param.removeFirstNode();
        while (param.getPathSoFar().size() > 1) {
            allPathsPerNode.get(getFirstNode(param)).add(param.cloneThePath());
            param.removeFirstNode();
        }
    }

    public static void getPaths(Params param) {
        if (param.getEndNode() == null)
            return;
        param.setSumSoFar(param.getSumSoFar() + param.getEndNode().getValue());
        param.getPathSoFar().add(param.getEndNode());
        TreeNode last = param.getEndNode();

        while (param.getSumSoFar() >= param.getSearchFor()) {
            if (param.checkSum())
                System.out.println(param.getPathSoFarAsString());
            param.removeFirstNode();
        }

        if (param.getPathSoFar().isEmpty()) {
            getPaths(new Params(null, last.left, 0, param.getSearchFor()));
            getPaths(new Params(null, last.right, 0, param.getSearchFor()));
        } else {
            getPaths(param.cloneToRight());
            getPaths(param.cloneToLeft());
        }
    }

    public static TreeNode getFirstNode(Params param) {
        TreeNode first = param.getPathSoFar().get(0);
        if (!allPathsPerNode.containsKey(first)) {
            allPathsPerNode.put(first, new ArrayList<>());
        }
        return first;
    }
}