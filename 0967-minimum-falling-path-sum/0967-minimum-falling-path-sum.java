class Solution {
    int minPath(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length)
            return (int) 1e9;
        if (i == 0)
            return matrix[0][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int d = matrix[i][j] + minPath(i - 1, j, matrix, dp);
        int ld = matrix[i][j] + minPath(i - 1, j - 1, matrix, dp);
        int rd = matrix[i][j] + minPath(i - 1, j + 1, matrix, dp);

        return dp[i][j] = Math.min(d, Math.min(ld, rd));

    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int min = (int) 1e9;

        // memoization

        // for(int[] r:dp){
        //     Arrays.fill(r,-1);
        // }
        // for (int j = 0; j < m; j++) {
        //     min = Math.min(min, minPath(n - 1, j, matrix,dp));
        // }

        // return min;
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int d = matrix[i][j] + dp[i - 1][j];
               int ld,rd;
               if(j > 0){
                 ld = matrix[i][j] + dp[i - 1][j - 1];
               }
                else{
 ld =(int) 1e9;
                } 

                if (j < m - 1){
                   rd =     matrix[i][j] + dp[i - 1][j + 1];
                }
                else{
                     rd = (int) 1e9;
                } 

                dp[i][j] = Math.min(d, Math.min(ld, rd));
            }
        }
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}