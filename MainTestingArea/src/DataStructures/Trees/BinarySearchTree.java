package DataStructures.Trees;


import java.io.IOException;
import java.io.PrintStream;

public class BinarySearchTree<T extends Comparable> {

    private Node root = null;

    public BinarySearchTree(Node<T> root) {
        this.root = root;
    }

    public BinarySearchTree<T> add(T data) {
        Node temp = root;
        Node prev = root;
        Node<T> newNode = new Node<>(null, null, data);
        while (temp != null) {
            int compare = temp.getData().compareTo(newNode.getData());
            prev = temp;
            if (compare == -1) { //less
                temp = temp.getLeft();
            } else if (compare == 1) {// greater
                temp = temp.getRight();
            } else {
                return this;
            }
        }
        prev.addNodeAfter(newNode);
        return this;
    }

    public void printTree(PrintStream out) throws IOException {
        root.printTree(out);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(new Node<Integer>(null, null, 12));
        tree.add(5).add(16).add(2).add(4).add(5).add(100).add(92).add(42); //the whole thing have to have a meaning :P
        try {
            tree.printTree(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

