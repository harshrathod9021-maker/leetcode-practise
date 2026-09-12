class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        
        boolean[][] memo = new boolean[stones.length + 1][sum / 2 + 1];
        
        for (int i = 0; i <= stones.length; i++) {
            memo[i][0] = true;
        }
        
        for (int i = sum / 2; i >= 0; i--) {
            if (canMakeSum(stones, stones.length, i, memo)) {
                return sum - 2 * i;
            }
        }
        
        return 0;
    }
    
    private boolean canMakeSum(int[] stones, int i, int j, boolean[][] memo) {
        if (j == 0) return true;
        if (i == 0) return false;
        
        if (memo[i][j]) {
            return true;
        }
        
        if (stones[i - 1] <= j) {
            memo[i][j] = canMakeSum(stones, i - 1, j - stones[i - 1], memo) || 
                         canMakeSum(stones, i - 1, j, memo);
        } else {
            memo[i][j] = canMakeSum(stones, i - 1, j, memo);
        }
        
        return memo[i][j];
    }
}