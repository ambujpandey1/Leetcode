class Solution {
    public int climbStairs(int n) {
    //   int[] dp=new int[n+1];
    //   dp[0]=1;
    //   dp[1]=1;
    //   for(int i=2;i<=n;i++){
    //     dp[i]=dp[i-1]+dp[i-2];
    //   }  
    //   return dp[n];


    if(n==0 ||n==1) return 1;
    // return climbStairs(n-1)+climbStairs(n-2);
    int first=1;
    int second=1;
    int ans=0;
    for(int i=2;i<=n;i++){
       ans=first+second;
       second=first;
       first=ans;
      }
      return ans;
    }
}