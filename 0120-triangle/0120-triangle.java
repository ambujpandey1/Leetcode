class Solution {
    int minPath(int i, int j,List<List<Integer>> triangle,int n,int[][] dp ){
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int d=triangle.get(i).get(j)+minPath(i+1,j,triangle,n,dp);
        int dd=triangle.get(i).get(j)+minPath(i+1,j+1,triangle,n,dp);

        return dp[i][j]= Math.min(d,dd);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        // Memoization
    //     for(int[] r:dp){
    //         Arrays.fill(r,-1);
    //     }
    //   return  minPath(0,0,triangle,n,dp);


    // Tabulation
    // base case
    for(int j=0;j<n;j++){
        dp[n-1][j]=triangle.get(n-1).get(j);
    }
    for(int i=n-2;i>=0;i--){
        for(int j=0;j<=i;j++){
        
        int d=triangle.get(i).get(j)+dp[i+1][j];
        int dd=triangle.get(i).get(j)+dp[i+1][j+1];

       dp[i][j]= Math.min(d,dd);
        }
    }
    return dp[0][0];
    }
}