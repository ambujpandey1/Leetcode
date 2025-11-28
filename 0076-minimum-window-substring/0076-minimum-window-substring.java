class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) return "";

        int[] mp = new int[256];  
        for (int i = 0; i < m; i++) {
            mp[t.charAt(i)]++;
        }

        int required = m;   // total chars we must match
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        for (int r = 0; r < n; r++) {
            char cr = s.charAt(r);

            // If this char is still needed, decrease required
            if (mp[cr] > 0) required--;

            mp[cr]--;    // reduce count

            // When all characters matched
            while (required == 0) {
                // update smallest window
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                char cl = s.charAt(l);
                mp[cl]++;      // removing from window

                // if a needed char becomes positive → window became invalid
                if (mp[cl] > 0) required++;

                l++; 
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
