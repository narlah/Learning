package DataStructures.Trees;


public class BinarySearchTree<T> {

    private Node root = null;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node<T> root) {
        this.root = root;
    }

    public void add(T data) {
        Node temp = root;
        Node newNode = new Node(null,null,data);
        while(temp != null) {
            //if (temp.data > newNode .data)
        }
    }

    public static void main(String[] args) {

    }
}

