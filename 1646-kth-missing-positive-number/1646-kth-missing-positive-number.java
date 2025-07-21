class Solution {
    public int findKthPositive(int[] arr, int k) {
         int missingCount = 0;
        int current = 1;  // Start checking from 1
        int index = 0;
        
        while (missingCount < k) {
            if (index < arr.length && arr[index] == current) {
                index++;  // Number is present in array, skip it
            } else {
                missingCount++;  // Number is missing, count it
            }
            current++;
        }
        return current - 1;  // Since current is incremented after loop
    }
}