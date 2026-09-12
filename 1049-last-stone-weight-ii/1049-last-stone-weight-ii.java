class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length, sum = 0;
        for (int w : stones)
            sum += w;
        int half = sum / 2;

        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int w : stones) {
            for (int j = half; j >= w; j--) {
                dp[j] = dp[j] || dp[j - w];
            }
        }

        for (int j = half; j >= 0; j--) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
        return 0;
    }
}