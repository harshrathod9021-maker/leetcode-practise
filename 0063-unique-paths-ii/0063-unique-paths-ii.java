// class Solution {

//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[][] dp = new int[m][n];
        
//         for(int row = 0; row<m; row++){
//             for(int col = 0; col<n; col++){
//                 if(obstacleGrid[row][col] == 1) dp[row][col] = 0;
//                 else if(row == 0 && col == 0)  dp[row][col] = 1;
//                 else dp[row][col] = (row>0 ? dp[row-1][col] : 0) + 
//                 (col>0 ? dp[row][col-1] : 0);
//             }
//         }

//         return dp[m-1][n-1];
//     }
// }










class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        
        for(int row = 0; row<m; row++){
            for(int i = 0; i<n; i++){
                if(obstacleGrid[row][i] == 1) dp[i] = 0;
                else if(row == 0 && i == 0)  dp[i] = 1;
                else{
                    int left = i>0 ? dp[i-1] : 0;
                    int up = row > 0 ? dp[i] : 0;
                    dp[i] = left + up;
                }
            }
        }

        return dp[n-1];
    }
}