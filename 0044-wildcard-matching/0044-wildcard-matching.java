class Solution {
    boolean isAllStars(String p, int j) {
        for (int i = 0; i < j; i++) {
            if (p.charAt(i) != '*')
                return false;
        }
        return true;
    }

    boolean f(int i, int j, String s, String p, int[][] dp) {
        if (i == 0 && j == 0)
            return true;
        if (j == 0 && i > 0)
            return false;
        if (i== 0 && j > 0)
            return isAllStars(p, j);

        if (dp[i][j] != -1)
            return dp[i][j] == 1;
        boolean ans;
        if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
            ans = f(i - 1, j - 1, s, p, dp);

        } else if (p.charAt(j-1) == '*') {
            ans = f(i - 1, j, s, p, dp) || f(i, j - 1, s, p, dp);
        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n+1][m+1];
        for (int r[] : dp) {
            Arrays.fill(r, -1);
        }
        return f(n , m , s, p, dp);
    }
}