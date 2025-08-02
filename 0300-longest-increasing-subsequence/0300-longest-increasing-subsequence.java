class Solution {
    int lcsLen(int idx,int previdx,int[] arr,int[][] dp,int n){
     if(idx==n) return 0;
     if(dp[idx][previdx+1]!=-1) return dp[idx][previdx+1];
        int len=lcsLen(idx+1,previdx,arr,dp,n);
        if(previdx==-1 || arr[idx]>arr[previdx] ){
            len=Math.max(len,(1+lcsLen(idx+1,idx,arr,dp,n)));
        }

        return dp[idx][previdx+1]=len;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return lcsLen(0,-1,nums,dp,n);
    }
}