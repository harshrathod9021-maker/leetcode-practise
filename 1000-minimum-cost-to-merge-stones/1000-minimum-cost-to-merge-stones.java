class Solution {

    int[] prefix;
    int[][] dp;
    int k;

    public int mergeStones(int[] stones, int k) {

        int n = stones.length;
        this.k = k;

        // It must be possible to merge everything into 1 pile
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        // Prefix sum
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        dp = new int[n][n];

        return solve(stones, 0, n - 1);
    }

    private int solve(int[] stones, int left, int right) {

        // Already one pile
        if (left == right) {
            return 0;
        }

        // Already calculated
        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int ans = Integer.MAX_VALUE;

        // Divide into two parts
        for (int mid = left; mid < right; mid += k - 1) {

            int costLeft = solve(stones, left, mid);

            int costRight = solve(stones, mid + 1, right);

            ans = Math.min(
                ans,
                costLeft + costRight
            );
        }

        // If this range can become exactly one pile
        if ((right - left + 1 - 1) % (k - 1) == 0) {

            ans += sum(left, right);
        }

        dp[left][right] = ans;

        return ans;
    }

    // Sum of stones from left to right
    private int sum(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}