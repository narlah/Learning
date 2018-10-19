package interviewPickings.codeFights;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InORderTraversalBSTKth {
    public static void main(String[] args) throws IOException {
        final String tree = new String(Files.readAllBytes(Paths.get("/home/narlah/tree.json")));
        ObjectMapper mapper = new ObjectMapper();
        Tree<Integer> t = null;
        try {
            t = mapper.readValue(tree, Tree.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InORderTraversalBSTKth inORderTraversalBSTKth = new InORderTraversalBSTKth();
        System.out.println(inORderTraversalBSTKth.kthSmallestInBST(t, 1689)); //100 //(new Tree<>(100), 1)
    }

    int kthSmallestInBST(Tree<Integer> t, int k) {
        ArrayList<Integer> r = new ArrayList<>(3);
        r.add(0);
        r.add(k);
        r.add(Integer.MIN_VALUE);
        helper(t, r);
        return r.get(2) > Integer.MIN_VALUE ? r.get(2) : 0;
    }

    void helper(Tree<Integer> t, ArrayList<Integer> r) {
        if (t != null) {
            if (r.get(2) > Integer.MIN_VALUE)
                return;
            helper(t.left, r);
            if (r.get(2) > Integer.MIN_VALUE)
                return;
            r.set(0, r.get(0) + 1);
            if (r.get(0).equals(r.get(1))) r.set(2, t.value);
            //if (r.get(0) == r.get(1)) r.set(2, t.value);
            //System.out.println("VAL: "+t.value + " steps : (" + r.get(0) + "\\" + r.get(1) + "):" + r.get(2) + ":" + " -> ");
            helper(t.right, r);

        }
    }
}
