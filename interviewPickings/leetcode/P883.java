package interviewPickings.leetcode;

//883. Projection Area of 3D Shapes
public class P883 {
    public static void main(String[] args) {
        P883 p = new P883();
        int[][] arr = new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(p.projectionArea(arr));
    }

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int maxX = 0;
            int maxY = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0)
                    ans++;
                maxX = Math.max(grid[i][j], maxX);
                maxY = Math.max(grid[j][i], maxY);
            }
            ans += maxX + maxY;
        }
        return ans;
    }
}
