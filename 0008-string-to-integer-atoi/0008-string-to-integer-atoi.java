class Solution {
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int INT_MIN = Integer.MIN_VALUE;

    public int myAtoi(String s) {
        // Step 1: Remove leading whitespaces recursively
        int start = skipSpaces(s, 0);
        if (start == s.length()) return 0;

        // Step 2: Check for sign
        int sign = 1;
        if (s.charAt(start) == '-' || s.charAt(start) == '+') {
            sign = (s.charAt(start) == '-') ? -1 : 1;
            start++;
        }

        // Step 3: Read digits recursively
        return buildNumber(s, start, 0, sign);
    }

    // Recursive function to skip spaces
    private int skipSpaces(String s, int index) {
        if (index == s.length() || s.charAt(index) != ' ')
            return index;
        return skipSpaces(s, index + 1);
    }

    // Recursive function to build number
    private int buildNumber(String s, int index, long num, int sign) {
        // Base case: if out of bounds or not a digit, return
        if (index == s.length() || !Character.isDigit(s.charAt(index))) {
            return (int) num * sign;
        }

        int digit = s.charAt(index) - '0';
        num = num * 10 + digit;

        // Step 4: Handle overflow
        long result = num * sign;
        if (result > INT_MAX) return INT_MAX;
        if (result < INT_MIN) return INT_MIN;

        // Recursive call for next digit
        return buildNumber(s, index + 1, num, sign);
    }
}
