class Solution {
    int[] memo;
    public int numSquares(int n) {
        memo=new int[n+1];
        Arrays.fill(memo,-1);
       return helper(n);
    }

    private int helper(int n){
        if(n==0) return 0;
        int min=Integer.MAX_VALUE;
        if(memo[n]!=-1){
            return memo[n];
        }
        for(int i=1;i*i<=n;i++){
           int cur=1+helper(n-i*i);
           min=Math.min(min,cur); 
        }
        return memo[n]=min;
    }
}