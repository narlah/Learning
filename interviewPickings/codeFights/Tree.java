package interviewPickings.codeFights;

public class Tree<T> {
    public Tree(T value, Tree<T> left, Tree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree() {
    }

    public Tree(T x) {
        value = x;
    }

    public T value;
    public Tree<T> left;
    public Tree<T> right;
}