class Solution {

    int n;
    int[][] dp;

    int solve(int[] nums, int i, int P) {

        if (i >= n) {
            return 0;
        }

        // If already calculated
        if (dp[i][P + 1] != -1) {
            return dp[i][P + 1];
        }

        // Option 1: Take
        int take = 0;

        if (P == -1 || nums[i] > nums[P]) {
            take = 1 + solve(nums, i + 1, i);
        }

        // Option 2: Skip
        int skip = solve(nums, i + 1, P);

        // Store answer
        dp[i][P + 1] = Math.max(take, skip);

        return dp[i][P + 1];
    }

    public int lengthOfLIS(int[] nums) {

        n = nums.length;

        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0, -1);
    }
}