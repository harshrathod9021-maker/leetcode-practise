// Java - Top Down DP with Memoization
class Solution {
    int[][] dp;

    // Helper to find max in range [l, h]
    private int findMax(int l, int h, int[] arr) {
        int maxi = 0;
        for (int i = l; i <= h; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    // Recursive function with memoization
    private int fun(int l, int h, int[] arr) {
        if (l == h) return dp[l][h] = 0; // single leaf
        if (l == h - 1) return dp[l][h] = arr[l] * arr[h]; // two leaves
        if (dp[l][h] != -1) return dp[l][h];

        int ans = Integer.MAX_VALUE;
        for (int i = l; i < h; i++) {
            int max1 = findMax(l, i, arr);
            int max2 = findMax(i + 1, h, arr);
            int temp = fun(l, i, arr) + fun(i + 1, h, arr);
            ans = Math.min(ans, (max1 * max2) + temp);
        }
        return dp[l][h] = ans;
    }

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }
        return fun(0, n - 1, arr);
    }
}