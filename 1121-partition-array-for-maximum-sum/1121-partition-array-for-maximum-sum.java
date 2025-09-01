class Solution {
    int f(int idx,int[] arr,int n,int k,int[] dp){
        if(idx==n) return 0;

        int len=0;
        int maxAns=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        if(dp[idx]!=-1) return dp[idx];
        for(int j=idx;j<Math.min(n,idx+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            int sum=(len*max)+f(j+1,arr,n,k,dp);
            maxAns=Math.max(maxAns,sum);
        }
        return dp[idx]=maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // int n=arr.length;
        // int dp[]=new int[n];
        // Arrays.fill(dp,-1);
        // return f(0,arr,n,k,dp);

        int n=arr.length;
        int dp[]=new int[n+1];

        for(int idx=n-1;idx>=0;idx--){
            int len=0;
        int maxAns=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
       
        for(int j=idx;j<Math.min(n,idx+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            int sum=(len*max)+dp[j+1];
            maxAns=Math.max(maxAns,sum);
        }
        dp[idx]=maxAns;
        }

        return dp[0];
    }
}