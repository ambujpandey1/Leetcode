class Solution {
    int maxC(int i, int j, int[] nums,int[][] dp) {
        if (i > j) return 0;  // base case

        int ans = Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for (int idx = i; idx <= j; idx++) {
            int cost = nums[i - 1] * nums[idx] * nums[j + 1]
                     + maxC(i, idx - 1, nums,dp)
                     + maxC(idx + 1, j, nums,dp);
            ans = Math.max(ans, cost);
        }
        return dp[i][j]=ans;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        // copy original nums into arr starting at index 1
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        
        // int[][] dp=new int[arr.length+1][arr.length+1];
        // for(int r[]:dp){
        //     Arrays.fill(r,-1);
        // }
        // return maxC(1, n, arr,dp);

        // Tabulation
      
      int[][] dp=new int[arr.length+2][arr.length+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                 int ans = Integer.MIN_VALUE;
                for (int idx = i; idx <= j; idx++) {
                  int cost = arr[i - 1] * arr[idx] * arr[j + 1]
                     + dp[i][ idx - 1]
                     + dp[idx + 1][ j];
            ans = Math.max(ans, cost);
            
            }
            dp[i][j]=ans;
            }
        }
        return dp[1][n];
    }
}
