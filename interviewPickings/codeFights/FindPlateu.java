package interviewPickings.codeFights;

public class FindPlateu { //clone of NumberOfIslands(leetcode)
    public int largestPlateau(int[][] grid) {
        int xAxis = grid.length;
        if (xAxis == 0) return 0;
        int yAxis = grid[0].length;
        if (yAxis == 0) return 0;
        boolean[][] visited = new boolean[xAxis][yAxis];
        int maxPlateu = 0;
        for (int i = 0; i <= xAxis - 1; i++) {
            for (int j = 0; j <= yAxis - 1; j++) {
                if (!visited[i][j]) {
                    int candidatePlateu = grindISland(i, j, grid, visited, grid[i][j], 0);
                    if (candidatePlateu > maxPlateu)
                        maxPlateu = candidatePlateu;
                }
            }
        }
        return maxPlateu;
    }

    private int grindISland(int x, int y, int[][] grid, boolean[][] visited, int currentElevation, int size) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] != currentElevation || visited[x][y])
            return 0;
        visited[x][y] = true;
        size++;
        size += grindISland(x - 1, y, grid, visited, currentElevation, 0);
        size += grindISland(x + 1, y, grid, visited, currentElevation, 0);
        size += grindISland(x, y - 1, grid, visited, currentElevation, 0);
        size += grindISland(x, y + 1, grid, visited, currentElevation, 0);
        return size;
    }

    public static void main(String[] args) {
        FindPlateu numberOFIslands = new FindPlateu();
        int[][] grid = new int[][]{ //10
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0,}
        };
        int[][] grid2 = new int[][]{ //8
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Island1 : " + numberOFIslands.largestPlateau(grid));
        System.out.println("Island2 : " + numberOFIslands.largestPlateau(grid2));

    }
}