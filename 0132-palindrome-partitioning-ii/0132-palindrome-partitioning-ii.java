class Solution {
    boolean isPalindrom(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    int f(int i, String s, int n, int[] dp) {
        if (i == n)
            return 0;
        //    String temp="";
        if (dp[i] != -1)
            return dp[i];
        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            // temp+=s.charAt(j);
            if (isPalindrom(s, i, j)) {
                int cost = 1 + f(j + 1, s, n, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    public int minCut(String s) {
        // int n=s.length();
        // int dp[]=new int[n];
        // Arrays.fill(dp,-1);
        // return f(0,s,n,dp)-1;

        // tabulation 
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {

                if (isPalindrom(s, i, j)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0] - 1;
    }
}