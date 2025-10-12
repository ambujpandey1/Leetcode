class Solution {
    int lis(int idx,int pidx,int[] arr,int n,int[][] dp){
        if(idx==n) return 0;
        
        if(dp[idx][pidx+1]!=-1) return dp[idx][pidx+1];
        int notTake=0+lis(idx+1,pidx,arr,n,dp);
        int take=0;
        if(pidx==-1 || arr[idx]>arr[pidx]){
            take=1+lis(idx+1,idx,arr,n,dp);
        }
       int max=Math.max(take,notTake);
       return dp[idx][pidx+1]= max;
    }
    public int lengthOfLIS(int[] nums) {
      int n=nums.length;
    //   int dp[][]=new int[n+1][n+1];
    //   for(int r[]:dp){
    //     Arrays.fill(r,-1);
    //   }
    //   return  lis(0,-1,nums,n,dp);

    // Tabulation
    int dp[][]=new int[n+1][n+1];
    for(int idx=n-1;idx>=0;idx--){
        for(int pidx=n-1;pidx>=-1;pidx-- ){
        int notTake=0+dp[idx+1][pidx+1];
        int take=0;
        if(pidx==-1 || nums[idx]>nums[pidx]){
            take=1+dp[idx+1][idx+1];
        }
       int max=Math.max(take,notTake);
        dp[idx][pidx+1]= max;
        }
    }
    return dp[0][0];
    }
}