class NumMatrix {

    int[][] prefix;

    public NumMatrix(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        prefix = new int[n][m];

        prefix[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++) {
            prefix[i][0] = prefix[i - 1][0] + matrix[i][0];
        }

        for (int j = 1; j < m; j++) {
            prefix[0][j] = prefix[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefix[i][j] =
                        prefix[i - 1][j]
                      + prefix[i][j - 1]
                      - prefix[i - 1][j - 1]
                      + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int top = (row1 > 0) ? prefix[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? prefix[row2][col1 - 1] : 0;
        int overlap = (row1 > 0 && col1 > 0) ? prefix[row1 - 1][col1 - 1] : 0;

        return prefix[row2][col2] - top - left + overlap;
    }
}
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */