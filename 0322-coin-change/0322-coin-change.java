class Solution {
    public int countCoin(int[] coins,int idx, int t,int[][] dp){
        if(idx==0){
            if(t%coins[idx]==0) return t/coins[idx];
            else return (int)1e9;
        }
        if(dp[idx][t]!=-1) return dp[idx][t];
        int notTake=0+countCoin(coins,idx-1,t,dp);
        int take=Integer.MAX_VALUE;
        if(coins[idx]<=t){
            take=1+countCoin(coins,idx,t-coins[idx],dp);
        }
        return dp[idx][t]= Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int []d:dp){
            Arrays.fill(d,-1);
        }
        int ans= countCoin(coins,n-1,amount,dp);
        if(ans==(int)1e9) return -1;
        return ans;
    }
}