class Solution {

    public int getMaximumGold(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxGold = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] != 0) {

                    maxGold = Math.max(maxGold,
                            dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col) {

        if (row < 0 || col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == 0)
            return 0;

        int gold = grid[row][col];

        // Mark as visited
        grid[row][col] = 0;

        int down = dfs(grid, row + 1, col);
        int up = dfs(grid, row - 1, col);
        int right = dfs(grid, row, col + 1);
        int left = dfs(grid, row, col - 1);

        // Backtrack
        grid[row][col] = gold;

        return gold + Math.max(
                Math.max(down, up),
                Math.max(left, right));
    }
}