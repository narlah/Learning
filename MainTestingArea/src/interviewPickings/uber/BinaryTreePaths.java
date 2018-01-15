package interviewPickings.uber;

import archive.BinaryTree;
import archive.TreeNode;

import javax.persistence.criteria.CriteriaBuilder;
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

        getPaths(new Params(rootBalanced, 20));

        System.out.println("\nAllPaths:");
        getAllPaths(new Params(rootBalanced, Integer.MAX_VALUE));
        for (TreeNode keyTreeNode : allPathsPerNode.keySet()) {
            System.out.println("\n->      " + keyTreeNode.getValue());
            for (ArrayList<TreeNode> paths : allPathsPerNode.get(keyTreeNode)) {
                System.out.println(Arrays.toString(paths.stream().map(TreeNode::getValue).collect(Collectors.toCollection(ArrayList::new)).toArray()));
            }
        }
        System.out.println("\nSimple?");
        getAllPathSimple(rootBalanced, new ArrayList<>());
    }

    public static void getAllPathSimple(TreeNode end, ArrayList<Integer> pathSoFar) {
        if (end == null) return;
        pathSoFar.add(end.getValue());
        System.out.println(Arrays.deepToString(pathSoFar.toArray()));
        if (end.left != null) {
            getAllPathSimple(end.left, pathSoFar);
        }
        if (end.right != null) {
            getAllPathSimple(end.right, pathSoFar);
        }
        for (int i = 1; i <= pathSoFar.size() - 1; i++) {
            System.out.println(Arrays.toString(pathSoFar.subList(i, pathSoFar.size()).toArray()));
        }
        pathSoFar.remove(pathSoFar.size() - 1);
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