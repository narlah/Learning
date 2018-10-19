package interviewPickings.codeFights;

public class CheckIfSubtree {

    boolean flag = false;

    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null && t2 != null)
            return false;
        if (t2 == null)
            return true;
        helper(t1, t2);
        return flag;
    }

    void helper(Tree<Integer> t1, Tree<Integer> t2) {
        if (flag) return;
        if (t1.left != null)
            helper(t1.left, t2);
        if (t1.value.equals(t2.value) && checkTrees(t1, t2))
            flag = true;
        if (t1.right != null)
            helper(t1.right, t2);
    }

    boolean checkTrees(Tree<Integer> t1, Tree<Integer> t2) {
        return
                ((t1 == null) && (t2 == null)) ||
                        ((t1 != null && t2 != null) &&
                                t1.value.equals(t2.value) &&
                                checkTrees(t1.left, t2.left) &&
                                checkTrees(t1.right, t2.right));

    }
}
