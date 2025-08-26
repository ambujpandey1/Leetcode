

class Solution {
    
    private List<Integer> findAllSums(int[] nums, int start, int end, int offset) {
        List<Integer> res = new ArrayList<>();
        int n = end - start + 1;
        
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += nums[j + offset];
                }
            }
            res.add(sum);
        }
        return res;
    }
    
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        
        if (n == 1) {
            return Math.min(Math.abs(goal), Math.abs(nums[0] - goal));
        }
        
        // Split into two halves
        List<Integer> firstHalf = findAllSums(nums, 0, n / 2 - 1, 0);
        List<Integer> secondHalf = findAllSums(nums, n / 2, n - 1, n / 2);
        
        Collections.sort(secondHalf);
        
        int res = Integer.MAX_VALUE;
        
        for (int sum1 : firstHalf) {
            int target = goal - sum1;
            
            // binary search in secondHalf
            int lb = Collections.binarySearch(secondHalf, target);
            
            if (lb < 0) lb = -(lb + 1); // insertion point
            
            if (lb > 0) {
                res = Math.min(res, Math.abs(goal - (secondHalf.get(lb - 1) + sum1)));
            }
            if (lb < secondHalf.size()) {
                res = Math.min(res, Math.abs(goal - (secondHalf.get(lb) + sum1)));
            }
        }
        
        return res;
    }
}
