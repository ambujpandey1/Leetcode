class Solution {

    int f(int i,int buy,int[] prices,int[][] dp){
        if(i==prices.length) return 0;
         
         if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1){ // buy the  stock
            profit=Math.max(-prices[i]+f(i+1,0,prices,dp),0+f(i+1,1,prices,dp));
        }
        else{
            profit=Math.max(prices[i]+f(i+1,1,prices,dp),0+f(i+1,0,prices,dp));
        }
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices) {
    //    int maxProfit=0;
    //    for(int i=1;i<prices.length;i++){
    //     if(prices[i]>prices[i-1]){
    //     int currentPrice=prices[i]-prices[i-1];
    //     maxProfit+=currentPrice;
    //     }
        
    //    } 
    //    return maxProfit;
    int n=prices.length;
    // int dp[][] =new int[n][2];
    // for(int[] r:dp){
    //     Arrays.fill(r,-1);
    // }
    // return f(0,1,prices,dp);


    // Tabulation
    int dp[][] =new int[n+1][2];
    dp[n][0]=dp[n][1]=0;

    for(int i=n-1;i>=0;i--){
        for(int buy=0;buy<=1;buy++){
           int profit=0;
        if(buy==1){ // buy the  stock
            profit=Math.max(-prices[i]+dp[i+1][0],0+dp[i+1][1]);
        }
        else{
            profit=Math.max(prices[i]+dp[i+1][1],0+dp[i+1][0]);
        }
         dp[i][buy]=profit;  
        }
    }
    return dp[0][1];
    }
}