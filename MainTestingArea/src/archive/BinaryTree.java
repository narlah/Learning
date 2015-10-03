package archive;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

class Node {
	Integer value;
	Node left;
	Node right;

	Node(Integer i, Node left, Node right) {
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

public class BinaryTree {
	public static void main(String[] args) throws IOException {
		int[] array = { 2, 6, 9, 12, 1, 14, 19, 5, 45, 7, 99, 68 };
		Arrays.sort(array);
		Node root = recBalance(array);
		System.out.println(Arrays.toString(array));
		root.printTree(System.out);
	}

	public static Node recBalance(int[] inList) {
		if (inList.length == 0)
			return null; // empty leaf , do nothing
		if (inList.length == 1)
			return new Node(inList[0], null, null); // create leaf, return it

		int middleIndex = inList.length / 2;
		Node tempRoot = new Node(inList[middleIndex], null, null);

		int[] leftPart = new int[middleIndex];
		System.arraycopy(inList, 0, leftPart, 0, middleIndex);

		int[] rightPart = new int[inList.length - middleIndex - 1];
		System.arraycopy(inList, middleIndex + 1, rightPart, 0, inList.length - middleIndex - 1);

		tempRoot.left = recBalance(leftPart);
		tempRoot.right = recBalance(rightPart);

		return tempRoot;
	}
}