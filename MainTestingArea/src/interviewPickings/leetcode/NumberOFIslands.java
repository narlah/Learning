package interviewPickings.leetcode;

public class NumberOFIslands {
    public int numIslands(char[][] grid) {
        int xAxis = grid.length;
        if (xAxis == 0) return 0;
        int yAxis = grid[0].length;
        if (yAxis == 0) return 0;
        boolean[][] visited = new boolean[xAxis][yAxis];
        int islandCounter = 0;
        for (int i = 0; i <= xAxis - 1; i++) {
            for (int j = 0; j <= yAxis - 1; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCounter++;
                    grindISland(i, j, grid, visited);
                }
            }
        }
        return islandCounter;
    }

    private void printVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            System.out.println();
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print((visited[i][j] ? 1 : 0) + ",");
            }
        }
        System.out.println("\n");
    }

    private void grindISland(int x, int y, char[][] grid, boolean[][] visited) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] == '0' || visited[x][y])
            return;
        visited[x][y] = true;
        grindISland(x - 1, y, grid, visited);
        grindISland(x + 1, y, grid, visited);
        grindISland(x, y - 1, grid, visited);
        grindISland(x, y + 1, grid, visited);


    }

    public static void main(String[] args) {
        NumberOFIslands numberOFIslands = new NumberOFIslands();
        char[][] grid = new char[][]{ //1
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0',}
        };
        char[][] grid2 = new char[][]{ //3
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Island1 : " + numberOFIslands.numIslands(grid));
        System.out.println("Island2 : " + numberOFIslands.numIslands(grid2));

    }
}
