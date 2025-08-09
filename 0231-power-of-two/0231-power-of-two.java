public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        for (int i = 0;Math.pow(2,i) <= n; i++) { 
            if ((int)Math.pow(2,i) == n) return true;
        }
        return false;
    }
}
