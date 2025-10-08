class Solution {
    int f(int i, int j,int[] cuts,int[][]dp){
        if(i>j) return 0;
        int min=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int idx=i;idx<=j;idx++){
            int cost=cuts[j+1]-cuts[i-1]+f(i,idx-1,cuts,dp)+f(idx+1,j,cuts,dp);
            min=Math.min(cost,min);
        }
        return dp[i][j]= min;
    }
    public int minCost(int n, int[] cuts) {
        int arr[]=new int[cuts.length+2];
        arr[0]=0;
        arr[arr.length-1]=n;
        for(int i=0;i<cuts.length;i++){
           arr[i+1]=cuts[i];
        }
        Arrays.sort(arr);
        int k=arr.length;
        int[][] dp=new int[k+1][k+1];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }
        return f(1,cuts.length,arr,dp);
    }
}