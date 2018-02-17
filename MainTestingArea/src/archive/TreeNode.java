package archive;

import java.io.IOException;
import java.io.PrintStream;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public Integer val;

    public TreeNode(Integer i, TreeNode left, TreeNode right) {
        this.val = i;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer val) {
        this.val = val;
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
        if (val == null) {
            out.print("<null>");
        } else {
            out.print(val.toString());
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

    public Integer getValue() {
        return val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}