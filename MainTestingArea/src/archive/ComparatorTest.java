package archive;

// Test.java
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
	int c;

	public Edge(int a) {
		this.c = a;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.c == o.c)
			return 0;
		if (this.c < o.c)
			return 1;
		else
			return -1;
	}

}

public class ComparatorTest {
	public static void main(String[] args) {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(12));
		queue.add(new Edge(11));
		queue.add(new Edge(1));
		queue.add(new Edge(100));
		queue.add(new Edge(88));
		while (queue.size() != 0) {
			System.out.println(queue.remove().c);
		}
	}
}