package archiver;

public class Node implements Comparable<Node> {

	private final int freq;
	private final char letter;
	Node left, right;

	public Node(int freq, char letter, Node left, Node right) {
		this.freq = freq;
		this.letter = letter;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf() {
		assert (left == null && right == null) || (left != null && right != null);
		return (left == null && right == null);
	}

	// compare, based on frequency
	public int compareTo(Node that) {
		if (this.freq == that.freq)
			return 0;
		if (this.freq < that.freq)
			return -1;
		else
			return 1;

	}

	public int getFreq() {
		return freq;
	}

	public char getLetter() {
		return letter;
	}
}