class Solution {
    // recursion solution
    // int lcsCount(int idx1,int idx2, String s1, String s2){
    //     if(idx1<0 || idx2<0) return 0;
         
    //     if(s1.charAt(idx1)==s2.charAt(idx2)){
    //         return 1+lcsCount(idx1-1,idx2-1,s1,s2);
    //     }

    //     return Math.max(lcsCount(idx1-1,idx2,s1,s2),lcsCount(idx1,idx2-1,s1,s2));
    // }

    // memoization solution
     int lcsCount(int idx1,int idx2, String s1, String s2,int [][]dp){
        if(idx1<0 || idx2<0) return 0;
        
        if(dp[idx1][idx2]!=-1)return dp[idx1][idx2];
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            dp[idx1][idx2]= 1+lcsCount(idx1-1,idx2-1,s1,s2,dp);
        }else{
           dp[idx1][idx2]= Math.max(lcsCount(idx1-1,idx2,s1,s2,dp),lcsCount(idx1,idx2-1,s1,s2,dp));
        }

        return dp[idx1][idx2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1=text1.length()-1;
        int idx2=text2.length()-1;
        int dp[][]=new int[idx1+1][idx2+2];
        for(int[] row:dp){
        Arrays.fill(row,-1);
        }
      return  lcsCount(idx1,idx2,text1,text2,dp);
    }
}