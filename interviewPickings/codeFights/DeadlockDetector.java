package interviewPickings.codeFights;

public class DeadlockDetector {

    public static void main(String[] args) {
        DeadlockDetector dd = new DeadlockDetector();
        int[][] arr = new int[][]{{1, 2},
                {2},
                {},
                {4},
                {3}};
        System.out.println(dd.hasDeadlock(arr));
    }

    boolean hasDeadlock(int[][] connections) {
        boolean[] visited = new boolean[connections.length];
        boolean flag = false;
        for (int i = 0; i < connections.length; i++) {
            if (!visited[i]) {
                boolean[] bo = new boolean[connections.length];
                flag = flag || helper(connections, i, bo, visited);
            }
        }
        return flag;
    }

    boolean helper(int[][] connections, int currentNode, boolean[] bo, boolean[] visited) {
        visited[currentNode] = true;
        if (bo[currentNode] == true)
            return true;
        boolean flag = false;
        for (int i : connections[currentNode]) {
            boolean[] nBO = new boolean[bo.length];
            System.arraycopy(bo, 0, nBO, 0, bo.length);
            nBO[currentNode] = true;
            flag = flag || helper(connections, i, nBO, visited);
        }
        return flag;
    }

}