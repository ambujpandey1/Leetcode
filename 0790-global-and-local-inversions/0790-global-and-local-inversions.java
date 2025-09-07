class Solution {
    public boolean isIdealPermutation(int[] nums) {
          int n = nums.length;
        for (int i = 0; i < n; i++) {
            // if element is more than 1 position away from its correct index
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}