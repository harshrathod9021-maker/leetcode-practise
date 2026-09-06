class Solution {
    int[][] nums, moves;
    Integer[][] dp;

    public int minPathCost(int[][] grid, int[][] moveCost) {
        nums = grid;
        moves = moveCost;
        dp = new Integer[nums.length][nums[0].length];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums[0].length; i++) {
            ans = Math.min(ans, f(0, i));
        }
        return ans;
    }

    int f(int r, int c) {
        if (r == nums.length - 1) return nums[r][c];
        if (dp[r][c] != null) return dp[r][c];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums[0].length; i++) {
            int move = moves[nums[r][c]][i];
            min = Math.min(min, move + f(r + 1, i));
        }
        return dp[r][c] = nums[r][c] + min;
    }
}