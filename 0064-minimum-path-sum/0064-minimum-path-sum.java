class Solution {
    int rec(int[][] grid, int m, int n,int[][] dp){
        if(m==0 && n==0) return grid[0][0];
        if(m <0 || n<0) return 1000000000;
       
       if(dp[m][n]!=-1) return dp[m][n];
        int up=grid[m][n]+rec(grid,m-1,n,dp);
        int left=grid[m][n]+rec(grid,m,n-1,dp);

       dp[m][n]=Math.min(up,left);
        return  dp[m][n];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
         if(m==0 && n==0) return grid[0][0];
        
        int dp[][]=new int[m][n];
        for(int []row:dp) Arrays.fill(row,-1);
        return rec(grid,m-1,n-1,dp);
    }
}