package archive;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Stack;

public class BinaryTree {
    private static int max_depth = 0;

    public static void main(String[] args) throws IOException {
        int[] array = {2, 6, 9, 12, 1, 14, 19, 5, 45, 7, 99, 68, 17, 13, 25};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array) + "\n");

        TreeNode rootBalanced = recBalance(array, 2);
        rootBalanced.printTree(System.out);
        System.out.println(checkSuperBalancedIte(rootBalanced));
        System.out.println(checkSuperBalancedRec(rootBalanced));

        TreeNode rootUnbalanced = recBalance(array, 3);
        rootUnbalanced.printTree(System.out);
        System.out.println(checkSuperBalancedRec(rootUnbalanced));
        System.out.println(checkSuperBalancedIte(rootUnbalanced));
    }

    public static TreeNode recBalance(int[] inList, int binaryBalanceFactor) {
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

    public static String checkSuperBalancedRec(TreeNode root) {
        max_depth = 0;
        return checkSuperBalancedInner(root, 0) ? "REC Not Balanced" : "REC Balanced";

    }

    private static boolean checkSuperBalancedInner(TreeNode root, int current_depth) {
        if (root == null) {
            if (max_depth == 0) {
                max_depth = current_depth;
            }
            if (Math.abs(current_depth - max_depth) > 1) {
                return true;
            } else
                return false;
        }
        boolean left = checkSuperBalancedInner(root.left, current_depth + 1);
        boolean right = checkSuperBalancedInner(root.right, current_depth + 1);
        return (left || right);
    }

    public static String checkSuperBalancedIte(TreeNode root) {

        int maxDepth = 0;
        Stack<StackNode> stack = new Stack<StackNode>();
        stack.add(new StackNode(root, 0));
        while (!stack.isEmpty()) {
            StackNode temp = stack.pop();
            if (temp.node.left == null && temp.node.right == null) {
                if (maxDepth == 0)
                    maxDepth = temp.depth;
                if (Math.abs(maxDepth - temp.depth) > 1)
                    return "ITE not Super balanced";
            } else {
                if (temp.node.left != null)
                    stack.add(new StackNode(temp.node.left, temp.depth + 1));
                if (temp.node.right != null)
                    stack.add(new StackNode(temp.node.right, temp.depth + 1));
            }
        }
        return "ITE balanced";
    }
}

class StackNode {
    public StackNode(TreeNode node, int depth) {
        super();
        this.node = node;
        this.depth = depth;
    }

    TreeNode node;
    int depth;
}

class TreeNode {
    Integer value;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer i, TreeNode left, TreeNode right) {
        this.value = i;
        this.left = left;
        this.right = right;
    }

    public void printTree(PrintStream out) throws IOException {
        if (right != null) {
            right.printTree(out, true, "");
        }
        printNodeValue(out);
        if (left != null) {
            left.printTree(out, false, "");
        }
    }

    private void printNodeValue(PrintStream out) throws IOException {
        if (value == null) {
            out.print("<null>");
        } else {
            out.print(value.toString());
        }
        out.write('\n');
    }

    private void printTree(PrintStream out, boolean isRight, String indent) throws IOException {
        if (right != null) {
            right.printTree(out, true, indent + (isRight ? "        " : " |      "));
        }
        out.print(indent);
        if (isRight) {
            out.print(" /");
        } else {
            out.print(" \\");
        }
        out.print("----- ");
        printNodeValue(out);
        if (left != null) {
            left.printTree(out, false, indent + (isRight ? " |      " : "        "));
        }
    }

}