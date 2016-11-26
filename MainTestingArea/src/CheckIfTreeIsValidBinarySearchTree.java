import archive.Node;

import java.io.IOException;
import java.util.Stack;

public class CheckIfTreeIsValidBinarySearchTree {
    private static int MAX_INT = Integer.MAX_VALUE;
    private static int MIN_INT = Integer.MIN_VALUE;
    private static Stack<StackElement<Integer>> stack = new Stack<StackElement<Integer>>();

    public static void main(String[] args) throws IOException {
        Node<Integer> root = new Node<Integer>(50, null, null);
        root.setLeft(new Node<Integer>(30, new Node<Integer>(20, null, null), new Node<Integer>(60, null, null)));
        root.setRight(new Node<Integer>(80, new Node<Integer>(70, null, null), new Node<Integer>(90, null, null)));
        System.out.println(checkTreeForBalancedSearchBinaryTree(root));
        root.printTree(System.out);

        // Node<Character> rootCharacters = new Node<Character>('a', null, null);
        // rootCharacters.setLeft(new Node<Character>('p', new Node<Character>('c', null, null), new Node<Character>('k', null, null)));
        // rootCharacters.setRight(new Node<Character>('z', new Node<Character>('l', null, null), new Node<Character>('u', null, null)));
        // System.out.println(checkTreeForBalancedSearchBinaryTree(rootCharacters));
    }

    // private static MIN_INT
    private static boolean checkTreeForBalancedSearchBinaryTree(Node<Integer> root)
            throws IOException {
        stack.push(new StackElement<Integer>(root, MIN_INT, MAX_INT));
        while (!stack.isEmpty()) {
            StackElement<Integer> E = stack.pop();
            if (E.node.getData() < E.min || E.node.getData() > E.max) {
                return false;
            }
            if (E.node.getLeft() != null) {
                stack.push(new StackElement<Integer>(E.node.getLeft(), E.min, E.node.getData()));
            }

            if (E.node.getRight() != null) {
                stack.push(new StackElement<Integer>(E.node.getRight(), E.node.getData(), E.max));

            }
        }
        return true;
    }
}

class StackElement<T> {
    public StackElement(Node<T> node, int min, int max) {
        super();
        this.node = node;
        this.min = min;
        this.max = max;
    }

    Node<T> node;
    int min;
    int max;
}