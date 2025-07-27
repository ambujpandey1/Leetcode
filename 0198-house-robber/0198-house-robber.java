class Solution {
    int houseRober(int[] nums, int[] dp,int n){
        if(n==0) return nums[0];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];

        int pick=nums[n]+houseRober(nums,dp,n-2);
        int notpick=houseRober(nums,dp,n-1);
       dp[n]=Math.max(pick,notpick);
        return dp[n];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        // int[] dp=new int[n];
        // Arrays.fill(dp,-1);
    //    return houseRober(nums,dp,n-1); 
       
    // dp[0]=nums[0];
    // dp[1]=Math.max(nums[0],nums[1]);
    // for(int i=2;i<n;i++){
    //     int pick=nums[i]+dp[i-2];
    //     int notpick=dp[i-1];
    //     dp[i]=Math.max(pick,notpick);
    // }
    // return dp[n-1];

     int prev2=nums[0];
    int prev=Math.max(nums[0],nums[1]);
    for(int i=2;i<n;i++){
        int pick=nums[i]+prev2;
        int notpick=prev;
        int curr=Math.max(pick,notpick);
        prev2=prev;
        prev=curr;

    }
    return  prev;
    }
}