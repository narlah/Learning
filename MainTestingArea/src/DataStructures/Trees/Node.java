package DataStructures.Trees;

class Node<T> {
    Node left;
    Node right;
    T data;

    public Node(Node left, Node right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
