package DataStructures.Trees;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;

class Node<T extends Comparable> {
    private Node left;
    private Node<T> right;
    private T data;

    Node(Node left, Node<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Optional<Node<T>> addNodeAfter(Node<T> addNode) {
        int comparedValue = data.compareTo(addNode.getData());
        switch (comparedValue) {
            case (-1):
                this.setLeft(addNode);
                break;
            case (1):
                this.setRight(addNode);
                break;
            default:
                return Optional.empty();
        }
        return Optional.of(addNode);
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
        if (data == null) {
            out.print("<null>");
        } else {
            out.print(data.toString());
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
