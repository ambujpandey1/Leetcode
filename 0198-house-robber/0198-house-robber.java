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
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
       return houseRober(nums,dp,n-1); 
    }
}