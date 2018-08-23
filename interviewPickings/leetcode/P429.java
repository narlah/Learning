package interviewPickings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P429 {
    public static void main(String[] args) {
        P429 p = new P429();
        Node n = new Node();
        n.val = 1;
        Node[] z = new Node[]{n};
        Node root = new Node(2, Arrays.asList(z));
        System.out.println(Arrays.deepToString(p.levelOrder(root).toArray()));
    }


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> line = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i <= size - 1; i++) {
                Node f = queue.removeFirst();
                line.add(f.val);
                if (f.children != null)
                    queue.addAll(f.children);
            }
            res.add(line);
            line = new ArrayList<>();
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
