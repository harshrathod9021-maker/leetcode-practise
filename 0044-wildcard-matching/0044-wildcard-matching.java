class Solution {

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(n - 1, m - 1, s, p, dp);
    }

    private boolean solve(int i, int j, String s, String p, int[][] dp) {

        // Base Cases
        if (i < 0 && j < 0)
            return true;

        if (i >= 0 && j < 0)
            return false;

        if (i < 0 && j >= 0)
            return isAllStars(p, j);

        // Already computed
        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean ans;

        // Current characters match or '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = solve(i - 1, j - 1, s, p, dp);
        }
        // Current pattern character is '*'
        else if (p.charAt(j) == '*') {
            ans = solve(i - 1, j, s, p, dp) ||
                  solve(i, j - 1, s, p, dp);
        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    private boolean isAllStars(String p, int j) {
        for (int k = 0; k <= j; k++) {
            if (p.charAt(k) != '*')
                return false;
        }
        return true;
    }
}






























// class Solution {

//     public boolean isMatch(String s, String p) {

//         int n = s.length();
//         int m = p.length();

//         boolean[][] dp = new boolean[n + 1][m + 1];

//         // Base Case
//         dp[0][0] = true;

//         // Pattern vs Empty String
//         for (int j = 1; j <= m; j++) {
//             dp[0][j] = isAllStars(p, j);
//         }

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {

//                 // Current characters match or '?'
//                 if (s.charAt(i - 1) == p.charAt(j - 1) ||
//                     p.charAt(j - 1) == '?') {

//                     dp[i][j] = dp[i - 1][j - 1];
//                 }

//                 // Current pattern character is '*'
//                 else if (p.charAt(j - 1) == '*') {

//                     dp[i][j] = dp[i - 1][j] ||
//                                dp[i][j - 1];
//                 }

//                 else {
//                     dp[i][j] = false;
//                 }
//             }
//         }

//         return dp[n][m];
//     }

//     private boolean isAllStars(String p, int len) {
//         for (int i = 0; i < len; i++) {
//             if (p.charAt(i) != '*')
//                 return false;
//         }
//         return true;
//     }
// }