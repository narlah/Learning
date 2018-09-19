package interviewPickings.leetcode;

import archive.TreeNode;

import java.io.IOException;
import java.util.ArrayList;

public class TreeOrthogonizer_897 {
    public static void main(String[] args) throws IOException {
        TreeOrthogonizer_897 tr = new TreeOrthogonizer_897();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        //tr.increasingBST(root).printTree(System.out);
        tr.increasingBSTDirect(root).printTree(System.out);
    }


    public TreeNode increasingBSTDirect(TreeNode root) {
        TreeNode first = new TreeNode(Integer.MIN_VALUE);
        ArrayList<TreeNode> currArr = new ArrayList<>(1);
        currArr.add(first);
        extractValuesDirect(root, currArr);
        return first.right;
    }

    private void extractValuesDirect(TreeNode n, ArrayList<TreeNode> currArr) {
        if (n.left != null) {
            extractValuesDirect(n.left, currArr);
        }
        TreeNode tmp = currArr.remove(0);
        n.left = null;
        tmp.right = n;
        tmp = tmp.right;
        currArr.add(tmp);

        if (n.right != null) {
            extractValuesDirect(n.right, currArr);

        }
    }


    public TreeNode increasingBST(TreeNode root) {
        TreeNode current = new TreeNode(Integer.MIN_VALUE);
        TreeNode res = current;
        for (TreeNode n : extractValues(root)) {
            n.left = null;
            current.right = n;
            current = n;
        }
        return res.right;
    }

    private ArrayList<TreeNode> extractValues(TreeNode n) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (n.left != null) {
            result.addAll(extractValues(n.left));
        }
        result.add(n);

        if (n.right != null) {
            result.addAll(extractValues(n.right));
        }
        return result;
    }


    public TreeNode increasingBSTOfficial(TreeNode root) {
        return helper(root, null);
    }

    public TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, tail);
        return res;
    }
}
