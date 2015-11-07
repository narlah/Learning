package archive;

import java.io.IOException;
import java.io.PrintStream;

public class Node<T> {
	private Node<T> left;
	private Node<T> right;
	private T data;

	public Node(T data, Node<T> left, Node<T> right) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

	public T getData() {
		return data;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public void setData(T data) {
		this.data = data;
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